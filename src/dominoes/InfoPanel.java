package dominoes;

import dominoes.players.DominoPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 10/03/13
 * Time: 20:08
 */
public class InfoPanel extends JPanel {

    private final BoneYardWidget boneYardWidget;
    private boolean interactive;
    private UI turnCoordinator;
    private final ScoreBoard scoreBoard;
    private final JButton boneYardButton;
    private final JLabel warningText;
    private Color warningColour = Color.yellow;
    private Color gameWinColour = Color.blue;
    private Color roundWinColour = Color.green;
    private Color normalColour = Color.lightGray;
    private Color paleText = Color.white;
    private Font font = new Font("Arial", Font.BOLD, 18);

    public InfoPanel(UI turnCoordinator) {
        this.turnCoordinator = turnCoordinator;
        Dimension infoPanelSize = new Dimension(turnCoordinator.getWidth(), 140);
        super.setBackground(normalColour);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel boneYardLabel = new JLabel(" Boneyard ");
        boneYardLabel.setBackground(normalColour);
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.0;
        this.add(boneYardLabel, c);
        boneYardWidget = new BoneYardWidget();
        c.gridx = 1;
        c.gridheight = 3;
        c.gridy = 0;
        c.weightx = 0.0;
        this.add(boneYardWidget, c);
        boneYardButton = new JButton("Draw");
        boneYardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (interactive) {
                    buttonDraw();
                }
            }
        });
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 1;
        c.weighty = 0.8;
        this.add(boneYardButton, c);
        JPanel textPanel = new JPanel();
        warningText = new JLabel("", JLabel.CENTER);
        warningText.setFont(font);
        textPanel.add(warningText, JPanel.CENTER_ALIGNMENT);
        textPanel.setBackground(this.normalColour);
        c.weightx = 0.8;
        c.weighty = 0.0;
        c.gridwidth = 5;
        c.gridx = 3;
        c.gridy = 0;
        c.gridheight = 2;
        this.add(textPanel, c);
        scoreBoard = new ScoreBoard();
        c.weightx = 0.2;
        c.gridwidth = 3;
        c.gridy = 0;
        c.gridx = 8;
        c.gridheight = 3;
        c.weighty = 0.8;
        this.add(scoreBoard, c);
        this.setMaximumSize(infoPanelSize);
        this.setMinimumSize(infoPanelSize);
    }

    private void buttonDraw() {
        turnCoordinator.drawOrPass();
    }

    public void setPlayers(DominoPlayer[] p) {
        this.scoreBoard.setPlayers(p);
    }

    public void updateInfoPanel(BoneYard boneYard) {
        this.boneYardWidget.setBoneYard(boneYard);
        this.warningText.setText("");
        if (boneYard.size() == 0) {
            boneYardButton.setText("Pass");
        }
        validate();
    }

    public void roundWinner(DominoPlayer dominoPlayer) {
        this.scoreBoard.incrementRound();
        if (dominoPlayer == null) {
            this.warningText.setText("This round was a draw.");
            this.warningText.getParent().setBackground(this.warningColour);
            JOptionPane.showMessageDialog(new JFrame(), "This round was a draw.",
                    "Round Over", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.warningText.setText(dominoPlayer.getName() + " wins the round!");
            this.warningText.getParent().setBackground(this.roundWinColour);
            JOptionPane.showMessageDialog(new JFrame(), dominoPlayer.getName() + " wins the round!",
                    "Round Over", JOptionPane.INFORMATION_MESSAGE);
        }
        warningText.setText("");
        warningText.getParent().setBackground(this.normalColour);
    }

    public void gameWinner(DominoPlayer dominoPlayer) {
        this.scoreBoard.gameEnd();
        this.warningText.getParent().setBackground(this.gameWinColour);
        this.warningText.setForeground(this.paleText);
        this.warningText.setText(dominoPlayer.getName() + " has won the game with " + dominoPlayer.getPoints() + " points!");
        JOptionPane.showMessageDialog(new JFrame(), dominoPlayer.getName() + " wins the game!",
                "Game Over", JOptionPane.INFORMATION_MESSAGE);
        int x = JOptionPane.showOptionDialog(new JFrame(), "Would you like to play again?",
                "More?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (x == 0) {
            this.turnCoordinator.nextGame();
        }
    }

    public void invalidMove(DominoPlayer dominoPlayer) {
        this.warningText.setText("Sorry, " + dominoPlayer.getName() + ", that was not a valid move. Please try again.");
        this.warningText.setBackground(this.warningColour);
    }

    public boolean mouseUp(Event e, int x, int y) {
        // If click was on bone yard, and we are in a stage of play which allows interaction with the boneyard...
        if (interactive) {
            if (e.target == this.boneYardWidget || e.target == this.boneYardButton) {
                turnCoordinator.drawOrPass();
            }
        }
        // Container should not see event
        return true;
    }

    public void allowBoneYard() {
        this.interactive = true;
    }

    public void denyBoneYard() {
        this.interactive = false;
    }
}
