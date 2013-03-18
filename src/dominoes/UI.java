package dominoes;


import dominoes.players.ComputerPlayer;
import dominoes.players.DominoPlayer;
import dominoes.players.Player;
import dominoes.players.PlayerType;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 22:57
 */

//TODO - terminate program if window is closed


// TODO - add an interface to contain the turn interface stuff which UI can implement
public class UI extends JFrame implements ActionListener, DominoUI, TurnCoordinator {
    MenuBar menuBar;
    PlayerHandPanel player1Hand;
    PlayerHandPanel player2Hand;
    InfoPanel infoPanel;
    TablePanel tableArea;
    JPanel infoText;
    static UI instance;
    int windowWidth=1400;
    int windowHeight=800;
    int size=120; //size of bones
    BoneYard boneYard;

    int maxpips = 6;  //graphics output currently can not cope with higher than 6

    private PlayerType player1Type = PlayerType.None;
    private PlayerType player2Type = PlayerType.None;
    private int targetScore = 50;
    private Player player1;
    private Player player2;
    private CubbyHole nextMove;
    private Bone nextMoveBone;

    public UI() {
        super("Awesome Dominoes");

        setSize(windowWidth, windowHeight);
        setPreferredSize(new Dimension(windowWidth, windowHeight));
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        EtchedBorder eb1 = new EtchedBorder(EtchedBorder.RAISED);

        //add items in order top -> bottom
        setupMenuBar(eb1, windowWidth, windowHeight/10);

        infoPanel = new InfoPanel(new FlowLayout());
        setupScorePanel(infoPanel, eb1);
        player1Hand = new PlayerHandPanel(player1Type, this);
        setupPlayerHand(player1Hand, eb1);

        tableArea = new TablePanel(this);
        setupTableArea(eb1);

        player2Hand = new PlayerHandPanel(player2Type, this);
        setupPlayerHand(player2Hand, eb1);

        this.validate();
        this.setVisible(true);
    }

    private void setupTableArea(EtchedBorder eb1) {
        tableArea.setBackground(Color.orange);
        tableArea.setSize(windowWidth, windowHeight / 3);
        tableArea.setPreferredSize(new Dimension(windowWidth, windowHeight / 3));
        tableArea.setBorder(eb1);
        tableArea.validate();
        add(tableArea);
    }

    private void setupPlayerHand(PlayerHandPanel panel, EtchedBorder eb1) {
        panel.setBackground(Color.lightGray);
        panel.setSize(windowWidth, windowHeight / 3);
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
        menuBar = new MenuBar();
        this.setMenuBar(menuBar);
        Menu dom = new Menu("Dominoes");
        menuBar.add(dom);
        Menu about = new Menu("About");
        menuBar.add(about);
        MenuItem newGame = new MenuItem("New Game", new MenuShortcut(KeyEvent.VK_N));
        MenuItem exitGame = new MenuItem("Exit Dominoes", new MenuShortcut(KeyEvent.VK_X));
        MenuItem aboutItem = new MenuItem("About AD", new MenuShortcut(KeyEvent.VK_A));
        newGame.setActionCommand("NewGame"); // set the command
        exitGame.setActionCommand("Exit"); // set the command
        newGame.addActionListener(this);
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {exitOption();}
        });
        dom.add(newGame);
        dom.add(exitGame);
        aboutItem.setActionCommand("About");
        aboutItem.addActionListener(this);
        about.add(aboutItem);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("NewGame")) {
            //TODO: If game not over: "Leave this game?"
            super.setVisible(false);
            Controller.main(new String[] {});
        } else if (evt.getActionCommand().equals("About")) {
            //TODO Pause game
            String aboutTxt = "Awesome Dominoes was written by:\nAbbie James\nNick Mackin\nTimothy Baldock";
            JOptionPane.showMessageDialog(new JFrame(), aboutTxt, "About Awesome Dominoes",
                    JOptionPane.INFORMATION_MESSAGE);
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

    public void paint(Graphics graphics) {
        super.paint(graphics);
    }

    /*public static UI getInstance(){
        if (instance == null){
            instance = new UI();
        }
        return instance;
    }*/

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

    public void setPlayer1Type(PlayerType type) {
        this.player1Type = type;
        this.player1Hand.setPlayerType(type);
    }

    public void setPlayer2Type(PlayerType type) {
        this.player2Type = type;
        this.player2Hand.setPlayerType(type);
    }

    public PlayerType getPlayer1Type() {
        return this.player1Type;
    }

    public PlayerType getPlayer2Type() {
        return this.player2Type;
    }

    private Player createPlayer(PlayerType type, String name) {
        if (type == PlayerType.Computer) {
            return new ComputerPlayer(name);
        } else if (type == PlayerType.Human) {
            return new Player(name, this);
        }
        throw new IllegalArgumentException("type was not a valid createable player type");
    }

    public Player[] showNewGameDialog() {
        //To change body of created methods use File | Settings | File Templates.
        WelcomePage welcomePage = new WelcomePage(this, "Welcome to Dominoes - start a new game", this);
        welcomePage.setModal(true);
        welcomePage.setVisible(true);

        // Should now be done showing the dialog and can collect results
        System.out.println("targetScore is: " + welcomePage.targetScore);

        this.setPlayer1Type(welcomePage.player1Type);
        this.setPlayer2Type(welcomePage.player2Type);
        this.setTargetScore(welcomePage.targetScore);

        this.setPlayer1(createPlayer(welcomePage.player1Type, welcomePage.player1Name));
        this.setPlayer2(createPlayer(welcomePage.player2Type, welcomePage.player2Name));

        return new Player[]{this.player1, this.player2};
    }

    public void setTargetScore(int targetScore) {
        this.targetScore = targetScore;
    }

    public int getTargetScore() {
        return targetScore;
    }

    public int getMaxpips() {
        return maxpips;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer2() {
        return player2;
    }


    // DominoUI implementation
    public void display ( DominoPlayer[] dominoPlayers, Table table,BoneYard boneYard) {
        //TODO we should not need to set these every time!

        this.setTable(table);
        this.setDominoPlayers(dominoPlayers);
        this.setBoneYard(boneYard);

        this.validate();
    }

    public void displayRoundWinner(DominoPlayer dominoPlayer){
        infoPanel.setWinner(dominoPlayer);
        //TODO - technically possible in a test situation that table, dominoPlayers, etc are null which would break at this point
        this.validate();
    }

    public void displayInvalidPlay(dominoes.players.DominoPlayer dominoPlayer){
        //TODO - make graphics version of this. Need unit test or human interaction first to ensure it works
        System.out.println("%%%%% Invalid Play %%%%%");
        this.validate();
    }


    // TurnCoordinator implementation
    // Called by PlayerHandPanel when player selects a bone to play
    public void nextMoveBoneSelected(Bone bone) {
        this.nextMoveBone = bone;
        this.tableArea.showPlayIndicators();
    }

    // Called by TablePanel when player selects play position
    public void nextMovePosition(int position) {
        this.tableArea.hidePlayIndicators();
        this.nextMove.put(new Play(this.nextMoveBone, position));
    }

    // Called by Player when it requires a move from the UI
    public void getPlayerMove(Player player, CubbyHole nextMove) {
        this.nextMove = nextMove;
        if (player == this.player1) {
            this.getPlayer1Move();
        } else if (player == this.player2) {
            this.getPlayer2Move();
        }
    }

    // Set UI to indicate player 1 should make their move
    private void getPlayer1Move() {
        player1Hand.yourMove();
    }

    // Set UI to indicate player 2 should make their move
    private void getPlayer2Move() {
        player2Hand.yourMove();
    }

}
