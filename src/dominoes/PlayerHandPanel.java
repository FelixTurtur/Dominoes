package dominoes;

import dominoes.players.DominoPlayer;

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
    int size=120;
    int boneGap=30;

    public PlayerHandPanel(FlowLayout flowLayout){
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    }

    private void setUpBones() {
        this.removeAll();
        if (player != null) {
            Bone[] bones = player.bonesInHand();
            for (int i = 0; i < bones.length; i++){
                this.add(new BoneWidget(bones[i], player.getClass().getName(), 120));
            }
        }
        this.validate();
    }

    public void setPlayer(DominoPlayer dp){
        player=dp;
        setUpBones();
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
    }
}
