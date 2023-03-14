package game;

public class Utilities {

    public static boolean isColumnFull(IBoard board, int colIndex){
        for (int i = 0; i < board.getBoard().length; i++) {
            if (board.getSquare(i,colIndex) == Constants.EMPTY)
                return false;
        }
        return true;
    }

    // returns the ROW index of the first empty cell in the COLUMN rowIndex. -1 if all full
    public static int firstEmptyRow(IBoard board, int colIndex) {
        for (int i = board.getBoard().length-1; i >=0; i--) {
            if (board.getSquare(i,colIndex) == Constants.EMPTY) return i;
        }
        return -1;
    }

    // is the disc at board[rowIndex][colIndex] winning?
    public static boolean winningDisk(IBoard board, int rowIndex, int colIndex){
        char c = board.getSquare(rowIndex,colIndex);
        int count = 1;

        // horizontal right
        for (int i = colIndex+1; i < board.getBoard()[0].length; i++) {
            if (board.getSquare(rowIndex,i)==c)
                count++;
            else break;
        }
        if (count >= Constants.WIN) return true; // won horizontally
        // keep counting horizontal left
        for (int i=colIndex-1; i >=0; i--) {
            if (board.getSquare(rowIndex,i)==c)
                count++;
            else break;
        }
        if (count >= Constants.WIN) return true; // won horizontally

        count = 1;
        // vertical down
        for (int i = rowIndex+1; i < board.getBoard().length; i++) {
            if (board.getSquare(i,colIndex)==c)
                count++;
            else break;
        }
        if (count >= Constants.WIN) return true; // won vertical
        // keep counting vertical up
        for (int i=rowIndex-1; i >=0; i--) {
            if (board.getSquare(i,colIndex)==c)
                count++;
            else
                break;
        }
        if (count >= Constants.WIN) return true; // won vertical

        // first diagonal:  /
        count = 1;
        // up
        int kol = colIndex+1;
        for (int i=rowIndex-1; i >= 0; i--) {
            if (kol>= board.getBoard()[0].length) break; // we reached the end of the board right side
            if (board.getSquare(i,kol)==c)
                count++;
            else
                break;
            kol++;
        }
        if (count >= Constants.WIN) return true;
        // keep counting down
        kol = colIndex-1;
        for (int i = rowIndex+1; i < board.getBoard().length; i++) {
            if (kol<0) break; // we reached the end of the board left side
            if (board.getSquare(i,kol)==c)
                count++;
            else
                break;
            kol--;
        }
        if (count >= Constants.WIN) return true; // won diagonal "/"

        // second diagonal : \
        count = 1;
        // up
        kol = colIndex-1;
        for (int i=rowIndex-1; i >= 0; i--) {
            if (kol<0) break; // we reached the end of the board left side
            if (board.getSquare(i,kol)==c)
                count++;
            else
                break;
            kol--;
        }
        if (count >= Constants.WIN) return true; // won diagonal "\"
        // keep counting down
        kol = colIndex+1;
        for (int i = rowIndex+1; i < board.getBoard().length; i++) {
            if (kol>= board.getBoard()[0].length) break; // we reached the end of the board right side
            if (board.getSquare(i,kol)==c)
                count++;
            else
                break;
            kol++;
        }
        if (count >= Constants.WIN) return true; // won diagonal "\"

        return false;
    }

    public static boolean isRealCol(IBoard board, int col, int row ,ViewsSubject viewsSubject) {
        // is this really a column number?
        if (col < 0 || col >= board.getBoard()[0].length){
            if(col != -1)
                viewsSubject.setState("Illegal column number,\n    try again");
            return false;
        }else {
            // find the row and check if winning
            if (!isColumnFull(board, col)) {
                row = firstEmptyRow(board, col);
                viewsSubject.setState("\n");
                return true;
            } else {
                // column is full, try again
                viewsSubject.setState("Column is full, try again");
                return false;
            }
        }
    }

    public static boolean boardIsFull(IBoard board) {
        // it's enough to check top row
        for (int i=0; i<board.getBoard()[0].length; i++)
            if (board.getBoard()[0][i]==Constants.EMPTY) return false;
        return true;
    }
}
