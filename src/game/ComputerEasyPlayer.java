package game;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ComputerEasyPlayer implements IPlayerStrategy {

    private int col, row;
    private IDisk idisk;
    private Random random;

    public ComputerEasyPlayer(){
        col = -1;
        row = -1;
        setDiskColor(Constants.XPLAYER);
        random = new Random();
    }

    @Override
    public void doOperation(IBoard board ,ViewsSubject viewsSubject) {
        while(!Utilities.isRealCol(board, col, row ,viewsSubject)){
            col = random.nextInt(7);
        }
    }

    @Override
    public void draw(IBoard board) {
        row = Utilities.firstEmptyRow(board,col);
        board.getBoard()[row][col] = idisk.getColor();
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
    public void setDiskColor(char color) {
        idisk = DiskFlyweightFactory.getDisk(color);
    }

    @Override
    public IDisk getDiskColor() {
        return idisk;
    }

    @Override
    public void resetMoves() {
        col = -1;
        row = -1;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }
}
