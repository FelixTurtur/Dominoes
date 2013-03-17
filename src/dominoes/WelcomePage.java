package dominoes;

import dominoes.players.DominoPlayer;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 10/03/13
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class WelcomePage extends JFrame implements ActionListener {

    //These are the items that will be configured on this welcome page
    //and then passed to Controller to begin the game.
    DominoPlayer p1;
    DominoPlayer p2;
    int ScoreTarget = 50;
    JPanel titlePanel;
    JPanel p1Panel;
    JPanel p2Panel;
    ButtonGroup p1Options;
    ButtonGroup p2Options;
    JTextField p1NameBox;
    JTextField p2NameBox;
    JPanel targetScore;
    JTextField scoreBox;
    JPanel gameButtons;
    JButton newGame;
    JButton exitGame;
    PopupFactory popMaker = PopupFactory.getSharedInstance();

    public WelcomePage() {
        super("Awesome Dominoes");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(800, 800);
        setBackground(Color.BLUE);
        addTitlePanel();
        addTargetScorePanel();
        addPlayerChoicePanels();
        addButtonsPanel();
        super.setVisible(true);
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
        }
    }

    private void addTitlePanel() {
        //To change body of created methods use File | Settings | File Templates.
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
//        newGame.setBackground(Color.BLUE);
//        newGame.setForeground(Color.WHITE);
//        newGame.setActionCommand("newGame");
        exitGame = new OptionButton("Leave Dominoes", "Exit");
//        exitGame.setBackground(Color.BLUE);
//        exitGame.setForeground(Color.WHITE);
//        exitGame.setActionCommand("Exit");
        newGame.addActionListener(this);
        exitGame.addActionListener(this);
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
        JToggleButton tb1 = new JToggleButton("Human");
        p1Options.add(tb1);
        JToggleButton tb2 = new JToggleButton("Computer");
        p1Options.add(tb2);
        p1Panel.add(tb1);
        p1Panel.add(tb2);
        p1Panel.add(new JLabel("Player 1 Name:"));
        //getPlayerChoicePanel(eb1, "Player 1", p1Options);
        p1Panel.setSize(800,10);
        p1NameBox = new JTextField();
        p1NameBox.setColumns(20);
        p1Panel.add(p1NameBox);
        p2Panel = getPlayerChoicePanel(eb1, "Player 2 Type", p2Options);
        p2Panel.setSize(800,10);
        p2NameBox = new JTextField();
        p2NameBox.setColumns(20);
        p2Panel.add(p2NameBox);
        add(p1Panel);
        add(p2Panel);
   }

   private JPanel getPlayerChoicePanel(EtchedBorder eb1, String label, ButtonGroup bg1) {
        JPanel panel = new JPanel();
        panel.setBorder(eb1);
        panel.add(new JLabel(label));
        bg1 = new ButtonGroup();
        JToggleButton tb1 = new JToggleButton("Human");
        bg1.add(tb1);
        JToggleButton tb2 = new JToggleButton("Computer");
        bg1.add(tb2);
        panel.add(tb1);
        panel.add(tb2);
        panel.add(new JLabel(label + " Name:"));
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Exit")) {
            //Are you sure you want to quit?
            Object[] options = {"Yes, sorry", "No, whoops!"};
            int x = JOptionPane.showOptionDialog(new JFrame(), "Are you sure you want to quit?",
                    "Leaving so soon?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options,  options[1]);
            if (x == 1) {
                System.out.println("Knew you wouldn't leave");
            }
            else {
                //TODO Actually close the program
                System.out.println("Closing...");
                this.setVisible(false);
                return;
            }
        }
        else if (evt.getActionCommand().equals("newGame")) {
            //TODO Validate options are legit?
            String[] args = {};
            Boolean parseError = false;
            try {
                //might need to switch out ButtonGroup for something else
                if (p1Options.getSelection().isSelected()) {
                    args[0] = p1Options.getSelection().toString();
                }
                args[1] = p2Options.getSelection().toString();
                args[2] = p1NameBox.getText();
                args[3] = p2NameBox.getText();
                args[4] = Integer.toString(ScoreTarget);
            } catch (Exception e){
                //TODO Did you enter all fields?
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        "Unable to start Game. Please ensure all fields are populated",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                parseError = true;
                //TODO Return control to frame
            }
            if (!parseError) {
                this.setVisible(false);
                Controller.main(args);
            }

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
