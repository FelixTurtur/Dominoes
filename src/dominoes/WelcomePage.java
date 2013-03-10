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
    String p1Name = "";
    String p2Name = "";
    int ScoreTarget = 5;

    public WelcomePage() {
        super("Awesome Dominoes");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setBackground(Color.BLUE);
        addTitlePanel();
        addPlayerChoicePanels();
        addTargetScorePanel();
        addButtonsPanel();
        super.setVisible(true);
    }

    private void addTitlePanel() {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void addButtonsPanel() {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void addTargetScorePanel() {
        JPanel target = new JPanel();
        target.add(new JLabel("Score goal to reach:"));
        target.add(new JTextField("50"));
        add(target);
    }

    private void addPlayerChoicePanels() {
        //TODO add toggles for human/computer for each player
        //TODO If Human is selected, provide a JTextField to collect player name
        EtchedBorder eb1 = new EtchedBorder(Color.white, Color.cyan);
        JPanel p1Panel = getPlayerChoicePanel(eb1, "Player 1");
        JPanel p2Panel = getPlayerChoicePanel(eb1, "Player 2");
        add(p1Panel);
        add(p2Panel);
   }

   private JPanel getPlayerChoicePanel(EtchedBorder eb1, String label) {
        JPanel panel = new JPanel();
        panel.setBorder(eb1);
        panel.add(new JLabel("Player 1"));
        ButtonGroup p1Options = new ButtonGroup();
        JToggleButton tb1 = new JToggleButton("Human");
        p1Options.add(tb1);
        JToggleButton tb2 = new JToggleButton("Computer");
        p1Options.add(tb2);
        panel.add(tb1, tb2);
        return panel;  //To change body of created methods use File | Settings | File Templates.
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Exit")) {
            //Are you sure you want to quit?
        }
        else if (evt.getActionCommand().equals("NewGame")) {
            //Are you sure you want to start a new game?
        }
    }
}
