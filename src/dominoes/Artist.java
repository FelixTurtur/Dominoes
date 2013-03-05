package dominoes;
import com.sun.media.jfxmedia.events.PlayerStateEvent;
import dominoes.players.Player;
import dominoes.players.DominoPlayer;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 21/02/13
 * Time: 23:18
 */


public class Artist extends JFrame implements ActionListener {

    JPanel menuBar;
    PlayerHandPanel player2Hand;
    TablePanel tableArea;
    JPanel infoText;
    PlayerHandPanel player1Hand;
    JButton newGame;
    JButton exitGame;
    static Artist instance;
    int windowWidth=1400;
    int windowHeight=800;
    int size=120; //size of bones
    Table table;
    BoneYard boneYard;
    DominoPlayer[] dominoPlayers;

    private Artist() {
        super("Awesome Dominoes");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(windowWidth, windowHeight);
        EtchedBorder eb1 = new EtchedBorder(EtchedBorder.RAISED);
        setMenuBar(eb1, windowWidth, windowHeight/5);
        player2Hand = new PlayerHandPanel(new FlowLayout());
        player2Hand.setBackground(Color.lightGray);
        player2Hand.setSize(windowWidth,windowHeight/5);
        player2Hand.setBorder(eb1);
        add(player2Hand);
        tableArea = new TablePanel(new FlowLayout());
        tableArea.setBackground(Color.gray);
        tableArea.setSize(windowWidth,windowHeight/4);
        tableArea.setBorder(eb1);
        add(tableArea);
        infoText = new JPanel(new FlowLayout());
        infoText.setBackground(Color.lightGray);
        infoText.setSize(windowWidth,windowHeight*3/20);
        infoText.setBorder(eb1);
        add(infoText);
        player1Hand = new PlayerHandPanel(new FlowLayout());
        player1Hand.setBackground(Color.gray);
        player1Hand.setSize(windowWidth,windowHeight/5);
        player1Hand.setBorder(eb1);
        add(player1Hand);
    }

    public void setTable(Table t){
        table=t;
    }

    public void setDominoPlayers(dominoes.players.DominoPlayer[] dp){
            dominoPlayers=dp;
    }
    public void setBoneYard(BoneYard by){
            boneYard=by;
    }


    private void setMenuBar(EtchedBorder eb, int x, int y) {
        //Creates menu bar with chosen settings and all components required
        menuBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuBar.setBackground(Color.gray);
        menuBar.setSize(x,y);
        menuBar.setBorder(eb);
        newGame = new JButton("New Game");
        exitGame = new JButton("Exit");
        newGame.setActionCommand("NewGame");   // set the command
        exitGame.setActionCommand("Exit"); // set the command
        newGame.addActionListener(this);
        exitGame.addActionListener(this);
        menuBar.add(newGame);
        menuBar.add(exitGame);
        add(menuBar);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Exit")) {
            //Are you sure you want to quit?
        }
        else if (evt.getActionCommand().equals("NewGame")) {
            //Are you sure you want to start a new game?
        }
    }

    public void paint(Graphics graphics){

        //TODO work out how to set this up better so that we are not setting this on each run of this method!
        player1Hand.setPlayer(dominoPlayers[0]);
        player2Hand.setPlayer(dominoPlayers[1]);
        tableArea.setTable(table);
        super.paint(graphics);

    }

    public static Artist getInstance(){
        if (instance == null){
            instance = new Artist();
            //instance.setupTable();
        }
        return instance;
    }



}




/*



public class Artist extends Canvas {
    private static Artist instance = getInstance();
    int windowWidth = 1400;
    int windowHeight = 800;
    int size = 120;     //domino size
    FramePanels frame;
    private Graphics graphics;

    public static Artist getInstance(){
        if (instance == null){
            instance = new Artist();
            instance.setupTable();
        }
        return instance;
    }

    public void drawDashes(int x, int y){
        for (int i=0;i<5;i=i+2){
            graphics.setColor(Color.black);
            graphics.fillRoundRect(10+x+20*i,y,20,5,2,2);

        }
    }

    private void setupTable(){
        frame = new FramePanels("Awesome Dominoes", windowWidth, windowHeight);
        frame.tableArea.add(instance);
        graphics = getGraphics();
    }

    public void clearTable(){
        graphics.setColor(Color.gray);
        graphics.fillRect(0, 0, windowWidth, windowHeight);
        frame.tableArea.update(graphics);

    }

    public void drawBone(int x,int y,Bone bone, String playerType){
        if (playerType == "Player") {
            drawBone(x,y,bone);
        } else {
            //TODO drawHiddenBone; //will replace below line when ready
            drawBone(x,y,bone);
        }
    }

    public void drawBone(int x,int y,Bone bone){
        graphics.setColor(Color.black);
        graphics.fillRoundRect(x, y, size,size/2,size/20,size/20);
        drawPips(bone.left(),x,y,size);
        graphics.setColor(Color.white);
        graphics.drawLine(x+size/2, y, x+size/2, y+size/2);
        drawPips(bone.right(),x+size/2,y,size);
    }


    private void drawPips(int num,int x,int y,int size){
        switch(num){
            case 1:drawOne(x,y,size);
                break;
            case 2:drawTwo(x,y,size);
                break;
            case 3:drawThree(x,y,size);
                break;
            case 4:drawFour(x,y,size);
                break;
            case 5:drawFive(x,y,size);
                break;
            case 6:drawSix(x,y,size);
                break;
        }
    }


    private void drawOne(int x,int y,int size){
        graphics.setColor(Color.green);
        graphics.fillOval(x+25, y+25, size/12, size/12);
    }

    private void drawTwo(int x,int y,int size){
        graphics.setColor(Color.blue);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawThree(int x,int y,int size){
        graphics.setColor(Color.pink);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+25, y+25, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawFour(int x,int y,int size){
        graphics.setColor(Color.red);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawFive(int x,int y,int size){
        graphics.setColor(Color.cyan);
        graphics.fillOval(x+25, y+25, size/12, size/12);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawSix(int x,int y,int size){
        graphics.setColor(Color.yellow);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+25, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+25, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }




}

*/