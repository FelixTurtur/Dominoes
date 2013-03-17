package dominoes;

import dominoes.players.DominoPlayer;
import dominoes.players.PlayerType;

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

    DominoPlayer player;
    private PlayerType playerType;
    int size = 120;
    int boneSpacing = 30;

    public PlayerHandPanel(PlayerType playerType) {
        this.playerType = playerType;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, boneSpacing, 5));
    }

    private void setUpBones() {
        this.removeAll();
        if (player != null) {
            Bone[] bones = player.bonesInHand();
            for (int i = 0; i < bones.length; i++) {
                this.add(new BoneWidget(bones[i], this.playerType, 120));
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
        Component[] components = this.getComponents();
        for (int i = 0; i < components.length; i++) {
            // TODO this is bad, should not be using a cast
            if (e.target != components[i] && components[i].getClass() == BoneWidget.class) {
                ((BoneWidget)components[i]).eventDeselected();
            }
        }
        // Container should not see event
        return true;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
    }
}
