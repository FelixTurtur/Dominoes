package dominoes;

import dominoes.Widgets.BoneYardWidget;
import dominoes.players.DominoPlayer;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 10/03/13
 * Time: 20:08
 */
public class InfoPanel extends JPanel {
    private Font font;
    private static int size = 120;

    private final BoneYardWidget boneYardWidget;
    private boolean interactive;
    private TurnCoordinator turnCoordinator;
    private final JButton newGameButton;
    private final ScoreBoard scoreBoard;
    private final JButton boneYardButton;
    private final JPanel lowerPanel;
    private final JLabel warningText;
    private Color warningColour = Color.yellow;
    private Color gameWinColour = Color.blue;
    private Color roundWinColour = Color.green;

    public InfoPanel(TurnCoordinator turnCoordinator) {
        this.turnCoordinator = turnCoordinator;
        this.font = new Font("Arial", Font.BOLD, 36);

        JPanel boneYardPanel = new JPanel();
        boneYardPanel.setLayout(new BoxLayout(boneYardPanel, BoxLayout.Y_AXIS));
        JLabel boneYardDescription = new JLabel();
        boneYardDescription.setText("Boneyard");
        boneYardPanel.add(boneYardDescription);
        this.boneYardWidget = new BoneYardWidget(this.size);
        boneYardPanel.add(boneYardWidget);
        this.boneYardButton = new JButton();
        this.boneYardButton.setText("Draw");
        boneYardPanel.add(this.boneYardButton);

        this.newGameButton = new JButton("New Game");
        this.scoreBoard = new ScoreBoard();

        this.lowerPanel = new JPanel();
        this.lowerPanel.add(this.newGameButton);
        this.lowerPanel.add(boneYardPanel);
        this.lowerPanel.add(this.scoreBoard);
        this.lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));

        this.warningText = new JLabel();

        this.add(this.warningText);
        this.add(this.lowerPanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void setPlayers(DominoPlayer[] p) {
        this.scoreBoard.setPlayers(p);
    }

    public void setBoneYard(BoneYard boneYard) {
        this.boneYardWidget.setBoneYard(boneYard);
        validate();
    }

    public void roundWinner(DominoPlayer dominoPlayer) {
        this.scoreBoard.incrementRound();
        this.warningText.setText(dominoPlayer.getName() + " has won the round!");
        this.warningText.setBackground(this.roundWinColour);
    }

    public void gameWinner(DominoPlayer dominoPlayer) {
        //this.scoreBoard.finalScore();
        this.warningText.setText(dominoPlayer.getName() + " has won the game with " + dominoPlayer.getPoints() + " points!");
        this.warningText.setBackground(this.gameWinColour);
    }

    public void invalidMove(DominoPlayer dominoPlayer) {
        this.warningText.setText("Sorry " + dominoPlayer.getName() + " that was not a valid move. Please try again.");
        this.warningText.setBackground(this.warningColour);
    }

    public boolean mouseUp(Event e, int x, int y) {
        // If click was on bone yard, and we are in a stage of play which allows interaction with the boneyard...
        if (interactive) {
            if (e.target == this.boneYardWidget) {
                // TODO - also do this on events from the draw/pass button
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
