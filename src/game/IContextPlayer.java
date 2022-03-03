package game;

public interface IContextPlayer {
    public void executeOperation(IBoard board ,ViewsSubject viewsSubject);
    public void setPlayerStrategy(IPlayerStrategy playerStrategy);
    public IPlayerStrategy getPlayerStrategy();
}
