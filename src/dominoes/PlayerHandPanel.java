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
        //Within each human hand, in order for the dominoes to be selectable, they will need to sit in a frame
        //This frame can glow when mouse-over events happen and playBone when clicked.
        Bone[] bones=player.bonesInHand();
        int xStart=this.getWidth()/2-(size/2+boneGap)*(bones.length/2)-size/4;
        int y=getHeight()/2-size/2;
        for (int i=0; i<bones.length;i++){
            BoneDrawer boneDrawer = new BoneDrawer(bones[i], player.getClass().getName());
            boneDrawer.drawBone(xStart + (size/2+boneGap) * i, y, graphics);
            System.out.print(" ");
        }
    }
}
