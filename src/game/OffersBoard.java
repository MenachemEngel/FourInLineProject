package game;

import java.util.Arrays;

public class OffersBoard extends BoardDecorator{


    private String background;

    public OffersBoard(IBoard decoratorBoard) {
        super(decoratorBoard);
        initBoard();
        background = "gray";
    }

    @Override
    public boolean isEmpty(int r, int c) {
        return decoratorBoard.isEmpty(r,c);
    }

    @Override
    public void printBoard() {
        decoratorBoard.printBoard();
    }

    @Override
    public char[][] getBoard() {
        return decoratorBoard.getBoard();
    }

    @Override
    public void setBoard(char[][] board) {
        decoratorBoard.setBoard(board);
        setBorder(board.length,board[0].length);
    }

    @Override
    public void clearSquare(int r, int c) {
        decoratorBoard.clearSquare(r,c);
    }

    @Override
    public void setDisk(IDisk disk) {
        decoratorBoard.setDisk(disk);
    }

    @Override
    public char getSquare(int r, int c) {
        return decoratorBoard.getSquare(r,c);
    }

    @Override
    public void setSquare(int r, int c, char ch) {
        decoratorBoard.setSquare(r,c,ch);
    }

    public void setBorder(int rows, int columns){
        char [][] oldBoard = getBoard();
        decoratorBoard.setBoard(new char[rows][columns]);
        initBoard();
        int minCol = Math.min(decoratorBoard.getBoard()[0].length, oldBoard[0].length);
        int minRow = Math.min(decoratorBoard.getBoard().length, oldBoard.length);
        for(int i =0; i<minRow;i++){
            for(int j =0; j<minCol;j++){
                if(oldBoard[i][j] == 0){
                    setSquare(i,j,Constants.EMPTY);
                }else{
                    setSquare(i,j,oldBoard[i][j]);
                }
            }
        }

    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Override
    public void initBoard(){
        decoratorBoard.initBoard();
    }

    @Override
    public boolean isAllEmpty() {
        return decoratorBoard.isAllEmpty();
    }

    @Override
    public String toString() {
        return "Background Color " + background + "\n" + decoratorBoard.toString();
    }
}
