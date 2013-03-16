package dominoes;


import dominoes.players.DominoPlayer;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 22:57
 */

//TODO - terminate program if window is closed


public class UI extends JFrame implements ActionListener, DominoUI {

    JPanel menuBar;
    PlayerHandPanel player1Hand;
    PlayerHandPanel player2Hand;
    InfoPanel infoPanel;
    TablePanel tableArea;
    JPanel infoText;
    JButton newGame;
    JButton exitGame;
    static UI instance;
    int windowWidth=1400;
    int windowHeight=800;
    int size=120; //size of bones
    BoneYard boneYard;

    private UI() {
        super("Awesome Dominoes");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(windowWidth, windowHeight);
        EtchedBorder eb1 = new EtchedBorder(EtchedBorder.RAISED);
        setupMenuBar(eb1, windowWidth, windowHeight/10);
        infoPanel =new InfoPanel(new FlowLayout());
        setupScorePanel(infoPanel,eb1);
        tableArea = new TablePanel(new FlowLayout());
        setupTableArea(eb1);

        player1Hand = new PlayerHandPanel(new FlowLayout());
        setupPlayerHand(player1Hand, eb1);
        player2Hand = new PlayerHandPanel(new FlowLayout());
        setupPlayerHand(player2Hand, eb1);
        this.setVisible(true);

    }



    private void setupTableArea(EtchedBorder eb1) {
        tableArea.setBackground(Color.orange);
        tableArea.setSize(windowWidth, windowHeight / 3);
        tableArea.setBorder(eb1);
        add(tableArea);
    }

    private void setupPlayerHand(PlayerHandPanel panel, EtchedBorder eb1) {
        panel.setBackground(Color.lightGray);
        panel.setSize(windowWidth,windowHeight/3);
        panel.setBorder(eb1);
        add(panel);
    }

    private void setupScorePanel(InfoPanel panel, EtchedBorder eb1) {
        panel.setBackground(Color.lightGray);
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
            exitOption();
        }
        else if (evt.getActionCommand().equals("NewGame")) {
            //TODO: If game not over: "Leave this game?"
            super.setVisible(false);
            Controller.main();
        }
    }

    public void windowClosing(WindowEvent e) {exitOption();}
    public void exitOption() {
        Object[] options = {"Yes, sorry", "No, whoops!"};
        int x = JOptionPane.showOptionDialog(new JFrame(), "Are you sure you want to quit?",
                "Leaving so soon?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options,  options[1]);
        if (x == 1) {
            System.out.println("Knew you wouldn't leave");
        }
        else {
            System.out.println("Closing...");
            this.setVisible(false);
            System.exit(0);
        }
    }
    public void paint(Graphics graphics){
        super.paint(graphics);

    }

    public static DominoUI getInstance(){
        if (instance == null){
            instance = new UI();
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

    // Update state of UI prior to redraw
    public void display ( DominoPlayer[] dominoPlayers, Table table,BoneYard boneYard) {
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

    public void displayInvalidPlay(dominoes.players.DominoPlayer dominoPlayer){

        //TODO - make graphics version of this. Need unit test or human interaction first to ensure it works
        System.out.println("%%%%% Invalid Play %%%%%");
    }




}
