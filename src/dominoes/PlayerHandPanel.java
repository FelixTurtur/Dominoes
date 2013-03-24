package dominoes;

import dominoes.Widgets.BoneWidget;
import dominoes.players.DominoPlayer;
import dominoes.players.PlayerType;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 05/03/13
 * Time: 00:39
 */
public class PlayerHandPanel extends JPanel {
    JPanel bonePanel;
    JLabel turnText;

    DominoPlayer player;
    private PlayerType playerType;
    private TurnCoordinator turnCoordinator;
    int boneSize = 120;
    int boneSpacing = 30;

    List<BoneWidget> boneWidgets = new LinkedList<BoneWidget>();
    private boolean ourTurn = false;
    private boolean interactive;

    public PlayerHandPanel(PlayerType playerType, TurnCoordinator turnCoordinator) {
        this.playerType = playerType;
        this.turnCoordinator = turnCoordinator;
        this.turnText = new JLabel();
        this.turnText.setText(" ");
        this.bonePanel = new JPanel();
        this.bonePanel.setLayout(new FlowLayout(FlowLayout.CENTER, boneSpacing, 30));

        this.add(this.turnText);
        this.add(this.bonePanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void setUpBones() {
        // TODO - flicker on redraw is caused because you can't tell AWT to sync redrawing all these components
        // with the screen redrawing - I don't know how to fix this.
        this.bonePanel.removeAll();
        this.boneWidgets.clear();
        if (player != null) {
            Bone[] bones = player.bonesInHand();
            for (Bone b : bones) {
                BoneWidget boneWidget = new BoneWidget(b, this.playerType, boneSize);
                this.boneWidgets.add(boneWidget);
                this.bonePanel.add(boneWidget);
            }
        }
        this.validate();
    }

    public void setPlayer(DominoPlayer dp) {
        player = dp;
        setUpBones();
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public boolean mouseUp(Event e, int x, int y) {
        // Update all bones except the one clicked on to tell them they are inactive
        if (interactive) {
            for (BoneWidget bw : boneWidgets) {
                if (e.target != bw) {
                    bw.eventDeselected();
                } else {
                    bw.eventSelected();
                    // indicate bone selected for play
                    turnCoordinator.nextMoveBoneSelected(bw.getBone());
                }
            }
        }
        // Container should not see event
        return true;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
    }

    public void yourMove() {
        // Indicate that it is this player's move, and then use synchronised cubby hole to indicate move taken
        if (this.playerType == PlayerType.Human) {
            this.turnText.setText("It's your turn!");
            this.interactive = true;
        } else {
            this.turnText.setText(player.getName() + " is taking their turn...");
        }
        this.ourTurn = true;
    }

    public void notYourMove() {
        this.turnText.setText(" ");
        this.ourTurn = false;
        this.interactive = false;
    }
}
