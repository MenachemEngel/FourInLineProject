package game;

public abstract class BoardDecorator implements IBoard{

    protected IBoard decoratorBoard;

    public BoardDecorator(IBoard decoratorBoard) {
        this.decoratorBoard = decoratorBoard;
    }


}
