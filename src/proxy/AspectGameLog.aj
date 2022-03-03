package proxy;

import game.ContextPlayer;
import game.IBoard;
import game.ViewsSubject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public aspect AspectGameLog {
    public static long start;
    public static PrintWriter pw;

    public AspectGameLog() {
        try {
            pw = new PrintWriter("AspectLog");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        AspectGameLog.pw.close();
    }

    pointcut moveTime(String s, String p): execution (public void game.Controller.printBoard(String,String)) && args(s, p);
    after(String s, String p): moveTime(s, p){
        start = System.currentTimeMillis() - start;
        pw.println(p + ", Time for move: " + start + " milliseconds.");
        pw.println(s);
    }
}
