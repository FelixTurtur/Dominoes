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

    public InfoPanel(TurnCoordinator turnCoordinator) {
        this.turnCoordinator = turnCoordinator;
        this.font = new Font("Arial", Font.BOLD, 36);

        JPanel boneYardPanel = new JPanel();
        boneYardPanel.setLayout(new BoxLayout(boneYardPanel, BoxLayout.Y_AXIS));
        JTextPane boneYardDescription = new JTextPane();
        boneYardDescription.setText("Boneyard");
        boneYardPanel.add(boneYardDescription);
        this.boneYardWidget = new BoneYardWidget(this.size);
        boneYardPanel.add(boneYardWidget);
        this.boneYardButton = new JButton();
        this.boneYardButton.setText("Draw");
        boneYardPanel.add(this.boneYardButton);

        this.newGameButton = new JButton("New Game");
        this.scoreBoard = new ScoreBoard();

        this.add(this.newGameButton);
        this.add(boneYardPanel);
        this.add(this.scoreBoard);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    public void setPlayers(DominoPlayer[] p) {
        this.scoreBoard.setPlayers(p);
    }

    public void setBoneYard(BoneYard boneYard) {
        this.boneYardWidget.setBoneYard(boneYard);
    }

    public void roundWinner(DominoPlayer dominoPlayer) {
        // TODO display round winner message
        this.scoreBoard.incrementRound();
    }

    public void gameWinner(DominoPlayer dominoPlayer) {
        // TODO display game winner message
        //this.scoreBoard.finalScore();
    }

    public void invalidMove(DominoPlayer dominoPlayer) {
        // TODO display invalid move message
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
