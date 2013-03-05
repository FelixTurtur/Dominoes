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

    // TODO sort out repeated code - eg. size variable and the drawPips method
    // TODO Make a class to derive TablePanel and PlayerHandPanel from!!!!!!!!!!


    DominoPlayer player;
    static int size=120;

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
            drawBone(10+130*i,40,bones[i], player.getClass().getName(),graphics);
            System.out.print(" ");


        }
    }


 /*   public void drawBone(int x,int y,Bone bone, String playerType,Graphics graphics){
        if (playerType == "Player") {
            drawBone(x,y,bone,graphics);
        } else {
            //TODO drawHiddenBone; //will replace below line when ready
            drawBone(x,y,bone,graphics);
        }
    }
   */

    public void drawBone(int x,int y,Bone bone,String playerType,Graphics graphics){

        //TODO get it to draw something else for non human player type
        graphics.setColor(Color.black);
        graphics.fillRoundRect(x, y, size,size/2,size/20,size/20);
        drawPips(bone.left(),x,y,graphics);
        graphics.setColor(Color.white);
        graphics.drawLine(x+size/2, y, x+size/2, y+size/2);
        drawPips(bone.right(),x+size/2,y,graphics);
    }



    private void drawPips(int num,int x,int y,Graphics graphics){

        switch(num){
            case 1:
                graphics.setColor(Color.green);
                graphics.fillOval(x+25, y+25, size/12, size/12);
                break;
            case 2:
                graphics.setColor(Color.blue);
                graphics.fillOval(x+10, y+10, size/12, size/12);
                graphics.fillOval(x+40, y+40, size/12, size/12);
                break;
            case 3:
                graphics.setColor(Color.pink);
                graphics.fillOval(x+10, y+10, size/12, size/12);
                graphics.fillOval(x+25, y+25, size/12, size/12);
                graphics.fillOval(x+40, y+40, size/12, size/12);
                break;
            case 4:
                graphics.setColor(Color.red);
                graphics.fillOval(x+10, y+10, size/12, size/12);
                graphics.fillOval(x+40, y+10, size/12, size/12);
                graphics.fillOval(x+10, y+40, size/12, size/12);
                graphics.fillOval(x+40, y+40, size/12, size/12);
                break;
            case 5:
                graphics.setColor(Color.cyan);
                graphics.fillOval(x+25, y+25, size/12, size/12);
                graphics.fillOval(x+10, y+10, size/12, size/12);
                graphics.fillOval(x+40, y+10, size/12, size/12);
                graphics.fillOval(x+10, y+40, size/12, size/12);
                graphics.fillOval(x+40, y+40, size/12, size/12);
                break;
            case 6:
                graphics.setColor(Color.yellow);
                graphics.fillOval(x+10, y+10, size/12, size/12);
                graphics.fillOval(x+25, y+10, size/12, size/12);
                graphics.fillOval(x+40, y+10, size/12, size/12);
                graphics.fillOval(x+10, y+40, size/12, size/12);
                graphics.fillOval(x+25, y+40, size/12, size/12);
                graphics.fillOval(x+40, y+40, size/12, size/12);
                break;
        }
    }





}
