package game;

public class ContextPlayer implements IContextPlayer{

    private IPlayerStrategy playerStrategy;

    public ContextPlayer(IPlayerStrategy playerStrategy){
        this.playerStrategy = playerStrategy;
    }

    @Override
    public void executeOperation(IBoard board ,ViewsSubject viewsSubject){
        //Controller.start = System.currentTimeMillis();
        playerStrategy.doOperation(board, viewsSubject);
        playerStrategy.draw(board);
    }

    @Override
    public void setPlayerStrategy(IPlayerStrategy playerStrategy){
        this.playerStrategy = playerStrategy;
    }

    @Override
    public IPlayerStrategy getPlayerStrategy(){
        return playerStrategy;
    }

}
