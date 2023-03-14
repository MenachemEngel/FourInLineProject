package game;

import proxy.AspectGameLog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    public static Input input;

    private IBoard board;
    private ViewsSubject viewsSubject;
    private ViewsObserver viewsObserver;
    private IPlayerStrategy player1, player2;
    private IContextPlayer contextPlayer;
    private IMenu menu;

    int choice, row, col;
    boolean badchoice = true;
    public boolean gameover = false;
    public boolean computerplays = false;

    public Controller() {

        viewsSubject = new ViewsSubject();
        player1 = PlayerFactory.getPlayer(HumanPlayer.class.getName());
        contextPlayer = new ContextPlayer(player1);//(IContextPlayer) ProxyContextPlayer.newInstance(new ContextPlayer(player1));

    }

    public void play(String view){
        if(view.equalsIgnoreCase(TextualView.class.getName())){
            viewsObserver = new TextualView(viewsSubject);
            input = new TerminalInput();
        }else{
            viewsObserver = new GraphicalView(viewsSubject);
            input = new TextFieldInput();
        }
        viewsSubject.setState("Welcome to Four in a Line!\n");
        // each loop is a new game
        while (true) {

            do {
                badchoice = false;
                menu = MenuFactory.getMenu(StartMenu.class.getName());
                viewsSubject.setState(menu.getMenu());
                //try {
                    choice = input.getInput(viewsSubject);
                //}catch (InputMismatchException e){
                //    viewsSubject.setState("You need to choose number.");
                //    terminalInput.nextLine();
                //    choice = -1;
                //}
                badchoice = choice<0 || choice>2;
                if (badchoice) viewsSubject.setState("Input incorrect!\n    Please try again.");
            } while (badchoice);

            // 0: quit the game
            if (choice==0) {
                viewsSubject.setState("Bye bye!");
                input.close();
                return;
            }
            if(choice==2) {
                do {
                    badchoice = false;
                    menu = MenuFactory.getMenu(LevelMenu.class.getName());
                    viewsSubject.setState(menu.getMenu());
                    //try {
                        choice = input.getInput(viewsSubject);
                    //}catch (InputMismatchException e){
                    //    viewsSubject.setState("You need to choose number.");
                    //    terminalInput.nextLine();
                    //    choice = -1;
                    //}
                    badchoice = choice <= 0 || choice > 2;
                    if (badchoice) viewsSubject.setState("Input incorrect!\n    Please try again.");
                } while (badchoice);
                if(choice == 1){
                    player2 = PlayerFactory.getPlayer(ComputerEasyPlayer.class.getName());
                }else {
                    player2 = PlayerFactory.getPlayer(ComputerHardPlayer.class.getName());
                }
            }else {
                player2 = PlayerFactory.getPlayer(HumanPlayer.class.getName());
                player2.setDiskColor(Constants.XPLAYER);
            }

            do {
                badchoice = false;
                menu = MenuFactory.getMenu(BoardMenu.class.getName());
                viewsSubject.setState(menu.getMenu());
                //try {
                    choice = input.getInput(viewsSubject);
                //}catch (InputMismatchException e){
                //    viewsSubject.setState("You need to choose number.");
                //    terminalInput.nextLine();
                //    choice = -1;
                //}
                badchoice = choice <= 0 || choice > 2;
                if (badchoice) viewsSubject.setState("Input incorrect!\n    Please try again.");
            } while (badchoice);

            board = new Board();
            if(choice==2){
                do {
                    badchoice = false;
                    viewsSubject.setState("Please enter two numbers\n   between 4 to 10:");
                    //try {
                        row = input.getInput(viewsSubject);
                        col = input.getInput(viewsSubject);
                    //}catch (InputMismatchException e){
                    //    viewsSubject.setState("You need to enter numbers.");
                    //    terminalInput.nextLine();
                    //    row = -1;
                    //    col = -1;
                    //}
                    badchoice = (row <= 4 || row > 10) || (col <= 4 || col > 10);
                    if (badchoice) viewsSubject.setState("Input incorrect!\n    Please try again.");
                } while (badchoice);
                board = new OffersBoard(board);
                board.setBoard(new char[row][col]);
            }

            // start the game
            System.out.println();

            printBoard(board.toString(),""); // empty board
            viewsSubject.setState("Starting a game of\n    'Four in a Line'.");

            gameover = false;
            computerplays = false;
            if (!player2.getClass().getName().equalsIgnoreCase(HumanPlayer.class.getName())) computerplays = true;

            do {
                // loop as long as the chosen column is full
                // we request the player to enter a column which is not full
                if (contextPlayer.getPlayerStrategy().getClass().getName().equalsIgnoreCase(HumanPlayer.class.getName())){
                    viewsSubject.setState("Player " + playerNum(contextPlayer.getPlayerStrategy().getDiskColor().getColor()) + ", choose a column: ");
                }
                AspectGameLog.start = System.currentTimeMillis();
                contextPlayer.executeOperation(board, viewsSubject);
                if (computerplays && contextPlayer.getPlayerStrategy().getDiskColor().getColor()==Constants.XPLAYER) {
                    col = player2.getCol()+1;
                    viewsSubject.setState("Computer put a disk in\n    column "+ col);
                }

                // in any case we print the board
                printBoard(board.toString(), "Player " + playerNum(contextPlayer.getPlayerStrategy().getDiskColor().getColor()));


                if (Utilities.winningDisk(board, contextPlayer.getPlayerStrategy().getRow(), contextPlayer.getPlayerStrategy().getCol())) {
                    gameover = true;
                    showWinner(contextPlayer.getPlayerStrategy().getDiskColor().getColor(),computerplays);
                } else
                if (Utilities.boardIsFull(board)) {
                    gameover = true;
                    showWinner(Constants.EMPTY,computerplays); // tie
                }
                // switch to next player
                player1.resetMoves();
                player2.resetMoves();
                changePlayer(contextPlayer);

            } while (!gameover);
            //terminalInput.reset();
        }
    }

    private void changePlayer(IContextPlayer cp) {
        if (cp.getPlayerStrategy().getDiskColor().getColor() == Constants.OPLAYER)
            cp.setPlayerStrategy(player2);
        else
            cp.setPlayerStrategy(player1);
    }

    private void showWinner(char winner,boolean isComp) {
        if (winner == Constants.EMPTY)
            viewsSubject.setState("Board is full!\n    game has ended with a tie!");
        else
        if (isComp && playerNum(winner)==2)
            viewsSubject.setState("Game has ended!\n    The computer won!");
        else
            viewsSubject.setState("Game has ended! Player " + playerNum(winner) + " won!");
        viewsSubject.setState("\n");
    }

    private int playerNum (char c) {
        if (c==Constants.XPLAYER) return 2; else return 1;
    }

    public void printBoard(String board, String player){
        viewsSubject.setState("Board:\n" + board);
    }
}
