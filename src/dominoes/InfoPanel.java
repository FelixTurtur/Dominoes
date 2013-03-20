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
    private DominoPlayer[] players;
    private Font font;
    private static int size=120;
    private DominoPlayer winner=null;

    private final BoneYardWidget boneYardWidget;
    private boolean interactive;
    private TurnCoordinator turnCoordinator;

    //TODO - work out how to centre all text output

    public InfoPanel(TurnCoordinator turnCoordinator) {
        this.turnCoordinator = turnCoordinator;
        this.font = new Font("Arial", Font.BOLD, 36);

        this.boneYardWidget = new BoneYardWidget(this.size);

        this.add(this.boneYardWidget);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    public void setPlayers(DominoPlayer[] p) {
        this.players = p;
    }

    public void setBoneYard(BoneYard boneYard) {
        this.boneYardWidget.setBoneYard(boneYard);
    }

    public void setWinner(DominoPlayer w) {
        this.winner = w;
    }


    public void paint(Graphics graphics){
        super.paint(graphics);
        displayScore(graphics);
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


    private void displayScore(Graphics graphics){
        graphics.setFont(font);
        graphics.setColor(Color.blue);
        if (players != null) { //on first paint call players will not be set up
            for (int i=0; i<players.length;i++){
                graphics.drawString(players[i].getPoints() + "    " ,this.getWidth()-300,this.getHeight()*(i+1)/3);
                graphics.drawString(players[i].getName(),this.getWidth()-230,this.getHeight()*(i+1)/3);
            }
        }
    }
}
