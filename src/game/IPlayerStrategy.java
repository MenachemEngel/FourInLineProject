package game;

import game.IBoard;

public interface IPlayerStrategy {
    public void doOperation(IBoard board ,ViewsSubject viewsSubject);
    public void draw(IBoard board);
    public int getCol();
    public int getRow();
    public void setDiskColor(char color);
    public IDisk getDiskColor();
    public void resetMoves();
    public void setCol(int c);
    public void setRow(int r);
}
