package game;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import tp.TextPrompt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.PrivateKey;

public class GraphicalView extends ViewsObserver {

    private JFrame frame;
    private JPanel panel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    //private JLabel label;
    private JEditorPane editorPane;
    private JScrollPane editorScrollPane;
    private String text = "";
    private Shapes shapes;
    private JTextField textField;
    private TextPrompt placeHolder;
    private JButton button;
    private static String input = "";

    public GraphicalView(ViewsSubject viewsSubject){
        this.viewsSubject = viewsSubject;
        viewsSubject.attach(this);
        init();
    }

    @Override
    public void update() {
        if(viewsSubject.getState().startsWith("Board")){
            String tBoard = viewsSubject.getState();
            String color;
            if(tBoard.contains("Background")) {
                color = StringUtils.substringBetween(viewsSubject.getState(), "Background Color ", "\n");
                tBoard = tBoard.substring(tBoard.indexOf('\n')+1);
                tBoard = tBoard.substring(tBoard.indexOf('\n')+1);
            }else{
                color = "gray";
                tBoard = tBoard.substring(tBoard.indexOf('\n')+1);
            }
            tBoard = tBoard.replaceAll("\\|","");
            String []splitedBoard = tBoard.split("\n");
            shapes.setBoard(splitedBoard, Constants.colorList.get(color));
            shapes.repaint();
            System.out.println(viewsSubject.getState());
        }else {
            text = text + "\n" + viewsSubject.getState();
            editorPane.setText(text);
            System.out.println(text);
        }

    }
    public void initFrame(){
        frame = new JFrame("Four In The Line");
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void initPanels(){
        panel = new JPanel();
        rightPanel = new JPanel();
        bottomPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(500,1000));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        panel.add(shapes);
        rightPanel.add(editorScrollPane);
        bottomPanel.add(textField);
        bottomPanel.add(button);
        rightPanel.add(bottomPanel);
        panel.add(rightPanel);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setPreferredSize(new Dimension(1550,1200));
    }

    public void initInstructions(){
        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        editorPane.setFont(new Font("Serif",Font.PLAIN,40));
        editorPane.setText(" ");
        editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(500, 1000));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));
        editorScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });
    }

    public void initInput(){
        textField = new JTextField();
        button = new JButton("OK");
        textField.setFont(new Font("Serif",Font.PLAIN,60));
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });
        button.setFont(new Font("Serif",Font.PLAIN,60));
        placeHolder = new TextPrompt("Input Here", textField);
        placeHolder.changeAlpha(0.5f);
        button.setMargin(new Insets(50,10,50,10));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = textField.getText();
                clearTextField();
            }
        });
    }

    public void initShapes(){
        shapes = new Shapes();
        shapes.setPreferredSize(new Dimension(1050,1000));
    }

    private void init(){
        initInstructions();
        initInput();
        initShapes();
        initPanels();
        initFrame();
    }

    public static String getInput(){
        return input;
    }

    public void clearTextField(){
        textField.setText("");
    }

    public static void clearInput(){
        input = "";
    }

    private class Shapes extends JPanel{

        private String []board;
        private Color color;

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if(board != null) {
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length(); j++) {
                        if (board[i].charAt(j) != '|') {
                            g.setColor(color);
                            g.fillRect(j * 100, i * 100, 100, 100);
                            if (board[i].charAt(j) == Constants.EMPTY) {
                                g.setColor(Color.WHITE);
                                g.fillOval(j * 100 + 10, i * 100 + 10, 80, 80);
                            } else if (board[i].charAt(j) == Constants.XPLAYER) {
                                g.setColor(Color.RED);
                                g.fillOval(j * 100 + 10, i * 100 + 10, 80, 80);
                            } else if (board[i].charAt(j) == Constants.OPLAYER) {
                                g.setColor(Color.BLUE);
                                g.fillOval(j * 100 + 10, i * 100 + 10, 80, 80);
                            }
                            g.setColor(Color.BLACK);
                            g.drawOval(j * 100 + 10, i * 100 + 10, 80, 80);
                        }
                    }
                }
            }
        }

        public void setBoard(String []board, Color color){
            this.board = board;
            this.color = color;
        }
    }



}
