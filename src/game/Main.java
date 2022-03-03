package game;

import proxy.AspectGameLog;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();
        /*if(args.length == 0){
            controller.play(GraphicalView.class.getName());
        }else {
            if(args[0].equalsIgnoreCase("T")){
                controller.play(TextualView.class.getName());
            }else if(args[0].equalsIgnoreCase("G")){
                controller.play(GraphicalView.class.getName());
            }else{
                System.out.println("Cannot resolve " + args[0]);
            }
        }*/

        controller.play(TextualView.class.getName());

        //ProxyContextPlayer.close();

        AspectGameLog.close();
    }
}
