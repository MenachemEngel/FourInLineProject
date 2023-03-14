package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements IPlayerStrategy {

    private int col, row;
    private IDisk disk;

    public HumanPlayer(){
        setDiskColor(Constants.OPLAYER);
        col = -1;
        row = -1;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void doOperation(IBoard board ,ViewsSubject viewsSubject) {
        while(!Utilities.isRealCol(board, col, row ,viewsSubject)) {
            //try{
                col = Controller.input.getInput(viewsSubject);
            //}catch (InputMismatchException e){
            //    viewsSubject.setState("You have to to choose number.");
            //    input.nextLine();
            //    continue;
            //}
            if(col == 0) {
                col-=2;
            }else{
                col--;
            }
        }
    }

    @Override
    public void draw(IBoard board) {
        row = Utilities.firstEmptyRow(board, col);
        board.getBoard()[row][col] = disk.getColor();
    }

    @Override
    public void setDiskColor(char color) {
        disk = DiskFlyweightFactory.getDisk(color);
    }

    @Override
    public IDisk getDiskColor() {
        return disk;
    }

    @Override
    public void resetMoves() {
        col = -1;
        row = -1;
    }

}
