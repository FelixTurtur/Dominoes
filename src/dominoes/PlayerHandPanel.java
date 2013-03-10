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

    public PlayerHandPanel(FlowLayout flowLayout){
        super(flowLayout);

    }

    public void setPlayer(DominoPlayer dp){
        player=dp;
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        drawHand(graphics);

    }

    private void drawHand(Graphics graphics){
        //Represent the domino hands each player has.
        //Consider visible/not visible to human player
        //TODO Put each into a frame above and below the central table frame within parent frame
        //Within each human hand, in order for the dominoes to be selectable, they will need to sit in a frame
        //This frame can glow when mouse-over events happen and playBone when clicked.
        Bone[] bones=player.bonesInHand();
        for (int i=0; i<bones.length;i++){
            BoneDrawer boneDrawer = new BoneDrawer(bones[i], player.getClass().getName());
            boneDrawer.drawBone(10 + 80 * i, 10, graphics);
            System.out.print(" ");
        }
    }
}
