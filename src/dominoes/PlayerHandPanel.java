package dominoes;

import dominoes.Widgets.BoneWidget;
import dominoes.players.DominoPlayer;
import dominoes.players.PlayerType;

import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 05/03/13
 * Time: 00:39
 */
public class PlayerHandPanel extends JPanel {

    // TODO Make a class to derive TablePanel and PlayerHandPanel from!!!!!!!!!!

    //TODO use this.getWidth() and this.getHeight to place everthing in case we resize the window
    JPanel bonePanel;
    JLabel turnText;

    DominoPlayer player;
    private PlayerType playerType;
    int size = 120;
    int boneSpacing = 30;

    List<BoneWidget> boneWidgets = new LinkedList<BoneWidget>();
    private boolean ourTurn = false;

    public PlayerHandPanel(PlayerType playerType) {
        this.playerType = playerType;
        this.turnText = new JLabel();
        this.bonePanel = new JPanel();
        this.bonePanel.setLayout(new FlowLayout(FlowLayout.CENTER, boneSpacing, 5));

        this.add(this.turnText);
        this.add(this.bonePanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void setUpBones() {
        this.bonePanel.removeAll();
        this.boneWidgets.clear();
        if (player != null) {
            Bone[] bones = player.bonesInHand();
            for (int i = 0; i < bones.length; i++) {
                BoneWidget boneWidget = new BoneWidget(bones[i], this.playerType, 120);
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
        if (ourTurn) {
            Component[] components = this.bonePanel.getComponents();
            for (int i = 0; i < boneWidgets.size(); i++) {
                if (e.target != boneWidgets.get(i)) {
                    boneWidgets.get(i).eventDeselected();
                } else {
                    boneWidgets.get(i).eventSelected();
                    // Send event to indicate that the bone in question has been selected for play
                    System.out.println("Bone has been selected for play: " + boneWidgets.get(i).getBone().toString());
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
        this.turnText.setText("It's your turn!");
        this.ourTurn = true;
    }
}
