package game;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Board implements IBoard {

    private char board[][];

    public Board(){
        board = new char[Constants.ROWS][Constants.COLUMNS];
        initBoard();
    }

    @Override
    public char[][] getBoard() {
        return board;
    }

    @Override
    public void setBoard(char[][] board) {
        this.board = board;
    }

    @Override
    public void clearSquare(int r, int c) {
        board[r][c] = Constants.EMPTY;
    }

    @Override
    public void setDisk(IDisk disk) {
        board[disk.getR()][disk.getC()] = disk.getColor();
    }

    @Override
    public char getSquare(int r, int c) {
        return board[r][c];
    }

    @Override
    public void setSquare(int r, int c, char ch) {
        board[r][c] = ch;
    }

    @Override
    public boolean isEmpty(int r, int c) {
        if(board[r][c]==' '){
            return true;
        }
        return false;
    }

    @Override
    public void printBoard() {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print("|" +board[i][j]+ "|");
            }
            System.out.println();
        }
    }

    @Override
    public void initBoard(){
        for(char[] l : board){
            Arrays.fill(l, Constants.EMPTY);
        }
    }

    @Override
    public boolean isAllEmpty() {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] != Constants.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.length;i++){
            sb.append("|");
            for(int j=0;j<board[i].length;j++){
                sb.append(board[i][j]+ "|");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
