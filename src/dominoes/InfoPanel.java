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
public class InfoPanel extends JPanel{
    private Font font;
    private static int size=120;
    private DominoPlayer winner=null;

    private final BoneYardWidget boneYardWidget;
    private boolean interactive;
    private TurnCoordinator turnCoordinator;
    private final JButton newGameButton;
    private final ScoreBoard scoreBoard;

    //TODO - work out how to centre all text output

    public InfoPanel(TurnCoordinator turnCoordinator) {
        this.turnCoordinator = turnCoordinator;
        this.font = new Font("Arial", Font.BOLD, 36);

        this.boneYardWidget = new BoneYardWidget(this.size);
        this.newGameButton = new JButton("New Game");
        this.scoreBoard = new ScoreBoard();

        this.add(this.newGameButton);
        this.add(this.boneYardWidget);
        this.add(this.scoreBoard);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    public void setPlayers(DominoPlayer[] p) {
        this.scoreBoard.setPlayers(p);
    }

    public void setBoneYard(BoneYard boneYard) {
        this.boneYardWidget.setBoneYard(boneYard);
    }

    public void setWinner(DominoPlayer w) {
        this.winner = w;
    }


    public void paint(Graphics graphics){
        super.paint(graphics);
        if (winner!=null){
            displayWinner(graphics);
            winner=null;
        }
    }

    public boolean mouseUp(Event e, int x, int y) {
        // If click was on bone yard, and we are in a stage of play which allows interaction with the boneyard...
        if (interactive) {
            if (e.target == this.boneYardWidget) {
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

    private void displayWinner(Graphics graphics){
        graphics.setColor(Color.yellow);
        graphics.fill3DRect(this.getWidth() / 4, 10, getWidth() / 2, getHeight() - 20,true);
        graphics.setColor(Color.black);
        graphics.setFont(new Font("Arial", Font.BOLD, 50));
        graphics.drawString(winner.getName() + " wins the round!", this.getWidth()/2-300, this.getHeight() / 2+20);
    }
}
