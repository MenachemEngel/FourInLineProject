package game;

import game.Disk;

public interface IBoard {
    public boolean isEmpty(int r, int c);
    public void printBoard();
    public char[][] getBoard();
    public void setBoard(char[][] board);
    public void clearSquare(int r, int c);
    public void setDisk(IDisk disk);
    public char getSquare(int r, int c);
    public void setSquare(int r, int c, char ch);
    public void initBoard();
    public boolean isAllEmpty();
}
