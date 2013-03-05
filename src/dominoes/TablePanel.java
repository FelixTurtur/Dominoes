package dominoes;

import dominoes.players.DominoPlayer;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 05/03/13
 * Time: 01:08
 */
public class TablePanel extends JPanel {

    // TODO sort out repeated code - eg. size variable and the drawPips method
    // TODO Make a class to derive TablePanel and PlayerHandPanel from!!!!!!!!!!
    Table table;

    public TablePanel(FlowLayout flowLayout){
        super(flowLayout);

    }

    public void setTable(Table t){
        table=t;
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        drawTable(graphics);

    }

    private void drawTable(Graphics graphics){
        //Draws the line of dominoes that have so far been played this round.
        //Includes ellipse in the middle to limit the total number to a viewable amount
        //TODO Put this into a frame central within the master frame.
        Bone[] bones = table.layout();
        int y=40; //y position of domino line
        System.out.println("");
        for (int i=0,n=0; i<bones.length;i++,n++){

            if ((i>3) && (i<bones.length-4)){
                i=bones.length-5;
                drawDashes(10 + 130 * n, y + 30, graphics);
            }
            else{
                BoneDrawer boneDrawer = new BoneDrawer(bones[i]);
                boneDrawer.drawBone(10 + 130 * n, y, graphics);
            }
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("");
    }

    private void drawDashes(int x, int y,Graphics graphics){
        for (int i=0;i<5;i=i+2){
            graphics.setColor(Color.black);
            graphics.fillRoundRect(10+x+20*i,y,20,5,2,2);

        }
    }
}
