package dominoes;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

// Frame which contains game UI implemented in UI class
public class UIFrame extends JFrame implements ActionListener {
    MenuBar menuBar;
    int windowWidth = 1400;
    int windowHeight = 800;
    private UI ui;

    public UIFrame() {
        super("Awesome Dominoes");

        setSize(windowWidth, windowHeight);
        setPreferredSize(new Dimension(windowWidth, windowHeight));

        EtchedBorder eb1 = new EtchedBorder(EtchedBorder.RAISED);

        setupMenuBar(eb1, windowWidth, windowHeight / 10);

        this.validate();
        this.setVisible(true);
    }

    // Creates menu bar with chosen settings and all components required
    private void setupMenuBar(EtchedBorder eb, int x, int y) {
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
            this.showNewGameDialog();
        } else if (evt.getActionCommand().equals("About")) {
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
        NewGameDialog dialog = new NewGameDialog(this, "Welcome to Dominoes - start a new game", this);
        dialog.setModal(true);
        dialog.setVisible(true);

        if (this.ui != null) {
            this.remove(this.ui);
        }

        // Collect results from new game dialog and use them to create new UI panel with game in it
        this.ui = new UI(dialog.player1Type, dialog.player1Name, dialog.player2Type, dialog.player2Name, dialog.targetScore);

        this.add(this.ui);
        this.validate();
    }
}
