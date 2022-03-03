package game;

public class ComputerHardPlayer implements IPlayerStrategy {

    private int col, row;
    private IDisk iDisk;

    public ComputerHardPlayer(){
        col = -1;
        row = -1;
        setDiskColor(Constants.XPLAYER);
    }

    @Override
    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void doOperation(IBoard board ,ViewsSubject viewsSubject) {
        while(!Utilities.isRealCol(board, col, row,viewsSubject)) {
            int emptyrow = 0;
            // first check if a move can win
            for (int i = 0; i < board.getBoard()[0].length; i++) {
                if (!Utilities.isColumnFull(board, i)) {
                    emptyrow = Utilities.firstEmptyRow(board, i);
                    iDisk = DiskFlyweightFactory.getDisk(iDisk.getColor());
                    iDisk.setC(i);
                    iDisk.setR(emptyrow);
                    board.setDisk(iDisk);
                    if (Utilities.winningDisk(board, emptyrow, i)) {
                        board.clearSquare(emptyrow, i); // reset
                        col = i;
                        return;
                    }
                    board.clearSquare(emptyrow, i); // reset
                }
            }
            // otherwise then pick up any move that will prevent other player to win
            // in case there is a win on next turn
            int counter = 0; // i count other player possible winnings
            int chosenrow = 0;
            for (int i = 0; i< board.getBoard()[0].length; i++) {
                if (!Utilities.isColumnFull(board,i)) {
                    emptyrow = Utilities.firstEmptyRow(board,i);
                    IDisk oDisk = DiskFlyweightFactory.getDisk(Constants.OPLAYER);
                    oDisk.setC(i);
                    oDisk.setR(emptyrow);
                    board.setDisk(oDisk/*new Disk(Constants.OPLAYER, emptyrow, i)*/); // assume the other player does this
                    if (Utilities.winningDisk(board, emptyrow, i)) {
                        board.clearSquare(emptyrow, i); // reset
                        counter++; // we found a winning disc
                        chosenrow = i; // remember the row
                    }
                    board.clearSquare(emptyrow, i); // reset

                }
            }
            // we block the player if there is exactly one winning disc
            if (counter == 1) {
                col = chosenrow;
                return;
            }

            // else if other player wins no matter what, pick up first non full column
            for (int i = 0; i < board.getBoard()[0].length; i++)
                if (!Utilities.isColumnFull(board, i)) {
                    col = i;
                    return;
                }
            col = -1;
        }
    }

    @Override
    public void draw(IBoard board) {
        row = Utilities.firstEmptyRow(board,col);
        board.getBoard()[row][col] = iDisk.getColor();
    }

    @Override
    public void setDiskColor(char color) {
        iDisk = DiskFlyweightFactory.getDisk(color);
    }

    @Override
    public IDisk getDiskColor() {
        return iDisk;
    }

    @Override
    public void resetMoves() {
        col = -1;
        row = -1;
    }

}
