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
public class NewGameDialog extends JDialog implements ActionListener {
    //region Parameters
    //A whole tonne of parameters
    DominoPlayer p1, p2;
    JPanel titlePanel, p1Panel, p2Panel, targetScorePanel, gameButtons;
    JToggleButton p1H, p1C, p2H, p2C;
    ButtonGroup p1Options, p2Options;
    JTextField p1NameBox, p2NameBox, scoreBox;
    JButton newGame, exitGame;
    //endregion

    int targetScore = 50;
    PlayerType player1Type;
    PlayerType player2Type;
    String player1Name = "Player 1";
    String player2Name = "Player 2";

    public NewGameDialog(Frame aFrame, UIFrame parent) {
        super(aFrame, true);
        super.setTitle("Let's play Dominoes!");

        this.player1Type = PlayerType.Computer;
        this.player2Type = PlayerType.Computer;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        addTargetScorePanel();
        addPlayer1ChoicePanel();
        addPlayer2ChoicePanel();
        addButtonsPanel();
        this.pack();

        super.setLocationRelativeTo(parent);

        newGame.addActionListener(this);
        exitGame.addActionListener(this);
    }

    private void addButtonsPanel() {
        gameButtons = new JPanel();
        gameButtons.setSize(800, 50);
        newGame = new OptionButton("Begin Game", "newGame");
        exitGame = new OptionButton("Leave Dominoes", "Exit");
        gameButtons.add(newGame);
        gameButtons.add(exitGame);
        this.getRootPane().setDefaultButton(newGame);
        add(gameButtons);
    }

    private void addTargetScorePanel() {
        targetScorePanel = new JPanel();
        targetScorePanel.setSize(800, 10);
        targetScorePanel.add(new JLabel("Score goal to reach:"));
        scoreBox = new JTextField();
        scoreBox.setText(Integer.toString(targetScore));
        scoreBox.setSize(100, 50);
        scoreBox.setBorder(new EtchedBorder());
        scoreBox.setColumns(3);
        targetScorePanel.add(scoreBox);
        add(targetScorePanel);
    }

    private void addPlayer1ChoicePanel() {
        p1Panel = new JPanel();
        p1Panel.add(new JLabel("Player 1 - Type:"));
        p1Options = new ButtonGroup();
        p1H = new JRadioButton("Human");
        p1Options.add(p1H);
        p1C = new JRadioButton("Computer", true);
        p1Options.add(p1C);
        p1Panel.add(p1H);
        p1Panel.add(p1C);
        p1Panel.add(new JLabel("Name:"));
        //getPlayerChoicePanel(eb1, "Player 1", p1Options);
        p1Panel.setSize(800,10);
        p1NameBox = new JTextField();
        p1NameBox.setColumns(20);
        p1NameBox.setText(this.player1Name);
        p1Panel.add(p1NameBox);
        add(p1Panel);
    }

    private void addPlayer2ChoicePanel() {
        p2Panel = new JPanel();
        p2Panel.add(new JLabel("Player 2 - Type:"));
        p2Options = new ButtonGroup();
        p2H = new JRadioButton("Human");
        p2Options.add(p2H);
        p2C = new JRadioButton("Computer", true);
        p2Options.add(p2C);
        p2Panel.add(p2H);
        p2Panel.add(p2C);
        p2Panel.add(new JLabel("Name:"));
        p2Panel.setSize(800, 10);
        p2NameBox = new JTextField();
        p2NameBox.setColumns(20);
        p2NameBox.setText(this.player2Name);
        p2Panel.add(p2NameBox);
        add(p2Panel);
   }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Exit")) {
            exitOption();
        }
         else if (evt.getActionCommand().equals("newGame")) {
            //Validate game options
            player1Type = p1H.isSelected() ? PlayerType.Human : p1C.isSelected() ? PlayerType.Computer : PlayerType.None;
            player2Type = p2H.isSelected() ? PlayerType.Human : p2C.isSelected() ? PlayerType.Computer : PlayerType.None;
            player1Name = p1NameBox.getText();
            player2Name = p2NameBox.getText();
            targetScore = parseInt(scoreBox.getText());

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

            super.setVisible(false);
        }
    }

    public void windowClosing(WindowEvent e) {
        exitOption();
    }

    public void exitOption() {
        Object[] options = {"Yes, goodbye.", "No, take me back!"};
        int x = JOptionPane.showOptionDialog(new JFrame(), "Are you sure you want to quit?",
                "Leaving so soon?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options,  options[1]);
        if (x==0){
            this.setVisible(false);
            System.exit(0);
        }
    }

    private class OptionButton extends JButton {
         private OptionButton(String label, String action) {
             super(label);
             this.setActionCommand(action);
         }
    }
}
