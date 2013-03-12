package dominoes;

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
    //TODO - size needs to be only be set in one class not all of them! Relate it to window size?
    int size=120; //size of bone

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
        int y=this.getHeight()/2-size/4; //y position of domino line
        int i=(bones.length/2)-1;
        int j=bones.length/2;
        int n=0;
        if (bones.length > 9){
            drawDashes(this.getWidth()/2-size/2, y + size/4, graphics);
            i=3;
            j=bones.length-4;
            n=1;
        }

        for ( ; j<bones.length;j++,n++){
            BoneDrawer boneDrawer = new BoneDrawer(bones[j], "");
            boneDrawer.drawBone(this.getWidth()/2-size/2 + (size+10) * n, y, graphics);
        }

        for (n=1 ; i>=0;i--,n++){
            BoneDrawer boneDrawer = new BoneDrawer(bones[i], "");
            boneDrawer.drawBone(this.getWidth()/2-size/2 - (size+10) * n, y, graphics);
        }


    }

    private void drawDashes(int x, int y,Graphics graphics){
        for (int i=0;i<5;i=i+2){
            graphics.setColor(Color.black);
            graphics.fillRoundRect(10+x+20*i,y,20,5,2,2);

        }
    }
}
