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
    static int size=120;


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
                drawBone(10 + 130 * n, y, bones[i], graphics);
            }
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void drawBone(int x,int y,Bone bone,Graphics graphics){

        //TODO get it to draw something else for non human player type
        graphics.setColor(Color.black);
        graphics.fillRoundRect(x, y, size,size/2,size/20,size/20);
        drawPips(bone.left(),x,y,graphics);
        graphics.setColor(Color.white);
        graphics.drawLine(x+size/2, y, x+size/2, y+size/2);
        drawPips(bone.right(),x+size/2,y,graphics);
    }




    private void drawDashes(int x, int y,Graphics graphics){
        for (int i=0;i<5;i=i+2){
            graphics.setColor(Color.black);
            graphics.fillRoundRect(10+x+20*i,y,20,5,2,2);

        }
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
