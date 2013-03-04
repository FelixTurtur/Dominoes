package dominoes;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 04/03/13
 * Time: 16:32
 * To change this template use File | Settings | File Templates.
 */
public class FramePanels extends JFrame implements ActionListener {

    JPanel menuBar;
    JPanel player2Hand;
    JPanel tableArea;
    JPanel infoText;
    JPanel player1Hand;
    JButton newGame;
    JButton exitGame;


    public FramePanels(String title, int windowWidth, int windowHeight) {
        super(title);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(windowWidth, windowHeight);
        EtchedBorder eb1 = new EtchedBorder(EtchedBorder.RAISED);
        setMenuBar(eb1, windowWidth, windowHeight/5);
        player2Hand = new JPanel(new FlowLayout());
        player2Hand.setBackground(Color.lightGray);
        player2Hand.setSize(windowWidth,windowHeight/5);
        player2Hand.setBorder(eb1);
        add(player2Hand);
        tableArea = new JPanel(new FlowLayout());
        tableArea.setBackground(Color.gray);
        tableArea.setSize(windowWidth,windowHeight/4);
        tableArea.setBorder(eb1);
        add(tableArea);
        infoText = new JPanel(new FlowLayout());
        infoText.setBackground(Color.lightGray);
        infoText.setSize(windowWidth,windowHeight*3/20);
        infoText.setBorder(eb1);
        add(infoText);
        player1Hand = new JPanel(new FlowLayout());
        player1Hand.setBackground(Color.gray);
        player1Hand.setSize(windowWidth,windowHeight/5);
        player1Hand.setBorder(eb1);
        add(player1Hand);
    }

    private void setMenuBar(EtchedBorder eb, int x, int y) {
        //Creates menu bar with chosen settings and all components required
        menuBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuBar.setBackground(Color.gray);
        menuBar.setSize(x,y);
        menuBar.setBorder(eb);
        newGame = new JButton("New Game");
        exitGame = new JButton("Exit");
        newGame.setActionCommand("New");   // set the command
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

    public static void main(String[] args) {
        FramePanels myFrame = new FramePanels("Awesome Dominoes", 800, 600);
        myFrame.setVisible(true);
    }

}
