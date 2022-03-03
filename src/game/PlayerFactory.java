package game;

public class PlayerFactory {

    public static IPlayerStrategy getPlayer(String playerType){
        if(playerType == null){
            return null;
        }
        if(playerType.equalsIgnoreCase(HumanPlayer.class.getName())){
            return new HumanPlayer();
        }else if(playerType.equalsIgnoreCase(ComputerEasyPlayer.class.getName())){
            return new ComputerEasyPlayer();
        }else if(playerType.equalsIgnoreCase(ComputerHardPlayer.class.getName())){
            return new ComputerHardPlayer();
        }
        return null;
    }

}
