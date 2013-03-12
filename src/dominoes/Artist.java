package dominoes;
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
    PlayerHandPanel player1Hand;
    PlayerHandPanel player2Hand;
    InfoPanel infoPanel;
    TablePanel tableArea;
    JPanel infoText;
    JButton newGame;
    JButton exitGame;
    static Artist instance;
    int windowWidth=1400;
    int windowHeight=800;
    int size=120; //size of bones
    BoneYard boneYard;

    private Artist() {
        super("Awesome Dominoes");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(windowWidth, windowHeight);
        EtchedBorder eb1 = new EtchedBorder(EtchedBorder.RAISED);
        setupMenuBar(eb1, windowWidth, windowHeight/2);
        infoPanel =new InfoPanel(new FlowLayout());
        setupScorePanel(infoPanel,eb1);
        tableArea = new TablePanel(new FlowLayout());
        setupTableArea(eb1);

        player1Hand = new PlayerHandPanel(new FlowLayout());
        setupPlayerHand(player1Hand, eb1);
        player2Hand = new PlayerHandPanel(new FlowLayout());
        setupPlayerHand(player2Hand, eb1);

    }



    private void setupTableArea(EtchedBorder eb1) {
        tableArea.setBackground(Color.gray);
        tableArea.setSize(windowWidth, windowHeight / 4);
        tableArea.setBorder(eb1);
        add(tableArea);
    }

    private void setupPlayerHand(PlayerHandPanel panel, EtchedBorder eb1) {
        panel.setBackground(Color.gray);
        panel.setSize(windowWidth,windowHeight/4);
        panel.setBorder(eb1);
        add(panel);
    }

    private void setupScorePanel(InfoPanel panel, EtchedBorder eb1) {
        panel.setBackground(Color.gray);
        panel.setSize(windowWidth,windowHeight/5);
        panel.setBorder(eb1);
        add(panel);
    }

    private void setupMenuBar(EtchedBorder eb, int x, int y) {
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
        super.paint(graphics);

    }

    public static Artist getInstance(){
        if (instance == null){
            instance = new Artist();
        }
        return instance;
    }

    private void setTable(Table table){
        tableArea.setTable(table);
    }

    private void setDominoPlayers(dominoes.players.DominoPlayer[] dominoPlayers){
        player1Hand.setPlayer(dominoPlayers[0]);
        player2Hand.setPlayer(dominoPlayers[1]);
        infoPanel.setPlayers(dominoPlayers);
    }

    private void setBoneYard(BoneYard boneYard){
        this.boneYard = boneYard;
        infoPanel.setBoneYard(boneYard);
    }

    // Update state of Artist prior to redraw
    public void updateScreen(Table table, DominoPlayer[] dominoPlayers, BoneYard boneYard) {
       //TODO we should not need to set these every time!

        this.setTable(table);
        this.setDominoPlayers(dominoPlayers);
        this.setBoneYard(boneYard);

        this.repaint();
    }

    public void displayRoundWinner(DominoPlayer dominoPlayer){
        infoPanel.setWinner(dominoPlayer);
        //TODO - technically possible in a test situation that table, dominoPlayers, etc are null which would break at this point
        this.repaint();

    }


}


