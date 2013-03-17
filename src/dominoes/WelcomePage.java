package dominoes;

import dominoes.players.DominoPlayer;
import dominoes.players.PlayerType;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 10/03/13
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class WelcomePage extends JFrame implements ActionListener {


    //region Parameters
    //A whole tonne of parameters
    DominoPlayer p1, p2;
    String ScoreTarget = "50"; //Textfield is string, resulting args is string
    JPanel titlePanel, p1Panel, p2Panel, targetScore, gameButtons;
    JToggleButton p1H, p1C, p2H, p2C;
    ButtonGroup p1Options, p2Options;
    JTextField p1NameBox, p2NameBox, scoreBox;
    JButton newGame, exitGame;
    //endregion

    public WelcomePage() {
        super("Awesome Dominoes");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addTitlePanel();
        addTargetScorePanel();
        addPlayerChoicePanels();
        addButtonsPanel();
        this.pack();
    }

    public void setUpGame() {
        //TODO reset controls
        super.setVisible(true);
        newGame.addActionListener(this);
        exitGame.addActionListener(this);
    }

    private void addTitlePanel() {
        //Draw a background square
        titlePanel = new JPanel();
        titlePanel.add(new JLabel("DOMINOES!"));
        titlePanel.setSize(800,10);
        add(titlePanel);
    }

    private void addButtonsPanel() {
        gameButtons = new JPanel();
        gameButtons.setSize(800,50);
        EtchedBorder eb1 = new EtchedBorder(Color.white, Color.cyan);
        gameButtons.setBorder(eb1);
        newGame = new OptionButton("Begin Game!", "newGame");
        exitGame = new OptionButton("Leave Dominoes", "Exit");
//        newGame.addActionListener(this);
//        exitGame.addActionListener(this);
        gameButtons.setBackground(Color.green);
        gameButtons.add(newGame);
        gameButtons.add(exitGame);
        add(gameButtons);
    }

    private void addTargetScorePanel() {
        targetScore = new JPanel();
        targetScore.setSize(800, 10);
        targetScore.add(new JLabel("Score goal to reach:"));
        scoreBox = new JTextField(ScoreTarget);
        scoreBox.setText(ScoreTarget);
        scoreBox.setSize(100, 50);
        scoreBox.setBorder(new EtchedBorder());
        scoreBox.setColumns(3);
        targetScore.add(scoreBox);
        add(targetScore);
    }

    private void addPlayerChoicePanels() {
        //TODO add toggles for human/computer for each player
        //TODO If Human is selected, provide a JTextField to collect player name
        EtchedBorder eb1 = new EtchedBorder(Color.white, Color.cyan);
        p1Panel = new JPanel();
        p1Panel.setBorder(eb1);
        p1Panel.add(new JLabel("Player 1 Type:"));
        p1Options = new ButtonGroup();
        p1H = new JToggleButton("Human");
        p1Options.add(p1H);
        p1C = new JToggleButton("Computer");
        p1Options.add(p1C);
        p1Panel.add(p1H);
        p1Panel.add(p1C);
        p1Panel.add(new JLabel("Player 1 Name:"));
        //getPlayerChoicePanel(eb1, "Player 1", p1Options);
        p1Panel.setSize(800,10);
        p1NameBox = new JTextField();
        p1NameBox.setColumns(20);
        p1Panel.add(p1NameBox);
        p2Panel = new JPanel();
        p2Panel.setBorder(eb1);
        p2Panel.add(new JLabel("Player 2 Type:"));
        p2Options = new ButtonGroup();
        p2H = new JToggleButton("Human");
        p2Options.add(p2H);
        p2C = new JToggleButton("Computer");
        p2Options.add(p2C);
        p2Panel.add(p2H);
        p2Panel.add(p2C);
        p2Panel.add(new JLabel("Player 2 Name:"));
        p2Panel.setSize(800,10);
        p2NameBox = new JTextField();
        p2NameBox.setColumns(20);
        p2Panel.add(p2NameBox);
        add(p1Panel);
        add(p2Panel);
   }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Exit")) {
            exitOption();
        }
         else if (evt.getActionCommand().equals("newGame")) {
            //Validate game options
            PlayerType player1Type = p1H.isSelected() ? PlayerType.Human : p1C.isSelected() ? PlayerType.Computer : PlayerType.None;
            PlayerType player2Type = p2H.isSelected() ? PlayerType.Human : p2C.isSelected() ? PlayerType.Computer : PlayerType.None;
            String player1Name = p1NameBox.getText();
            String player2Name = p2NameBox.getText();
            int targetScore = parseInt(scoreBox.getText());

            // Validate fields
            if (player1Type == PlayerType.None || player2Type == PlayerType.None) {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        "Unable to start Game. Please select a type for players 1 and 2.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            if (player1Name.isEmpty() || player2Name.isEmpty()) {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        "Unable to start Game. Please select a name for players 1 and 2.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            if (targetScore == 0) {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        "Unable to start Game. Please enter a target score.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            //start game
            this.dispose();
            Controller.runGame(player1Type, player2Type, player1Name, player2Name, targetScore);
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
    private class OptionButton extends JButton {
         private OptionButton(String label, String action) {
             super(label);
             this.setBackground(Color.BLUE);
             this.setForeground(Color.WHITE);
             this.setActionCommand(action);
         }
    }
}
