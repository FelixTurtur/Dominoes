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

// This is the frame which contains the game UI
public class UIFrame extends JFrame implements ActionListener {
    MenuBar menuBar;
    JPanel infoText;
    int windowWidth = 1400;
    int windowHeight = 800;

    // Game window implementation
    private UI ui;

    public UIFrame() {
        super("Awesome Dominoes");

        setSize(windowWidth, windowHeight);
        setPreferredSize(new Dimension(windowWidth, windowHeight));
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        EtchedBorder eb1 = new EtchedBorder(EtchedBorder.RAISED);

        //add items in order top -> bottom
        setupMenuBar(eb1, windowWidth, windowHeight / 10);

        this.validate();
        this.setVisible(true);
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
            public void actionPerformed(ActionEvent e) {
                exitOption();
            }
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
            // this.ui.pauseGame(); // Requires self-contained thread TODO
            this.showNewGameDialog();
        } else if (evt.getActionCommand().equals("About")) {
            // this.ui.pauseGame(); // Requires self-contained thread TODO
            String aboutTxt = "Awesome Dominoes was written by:\nAbbie James\nNick Mackin\nTimothy Baldock";
            JOptionPane.showMessageDialog(new JFrame(), aboutTxt, "About Awesome Dominoes",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void windowClosing(WindowEvent e) {
        exitOption();
    }

    public void exitOption() {
        Object[] options = {"Yes, sorry", "No, whoops!"};
        int x = JOptionPane.showOptionDialog(new JFrame(), "Are you sure you want to quit?",
                "Leaving so soon?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[1]);
        if (x == 1) {
            System.out.println("Knew you wouldn't leave");
        } else {
            System.out.println("Closing...");
            this.setVisible(false);
            System.exit(0);
        }
    }

    public void showNewGameDialog() {
        //To change body of created methods use File | Settings | File Templates.
        WelcomePage page = new WelcomePage(this, "Welcome to Dominoes - start a new game", this);
        page.setModal(true);
        page.setVisible(true);

        // Should now be done showing the dialog and can collect results
        System.out.println("targetScore is: " + page.targetScore);

        if (this.ui != null) {
            this.remove(this.ui);
        }

        this.ui = new UI(page.player1Type, page.player1Name, page.player2Type, page.player2Name, page.targetScore);

        this.add(this.ui);
        this.validate();
    }
}
