package dominoes;
import javax.swing.*;
import java.awt.*;
/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 21/02/13
 * Time: 23:18
 */

// OK, I think this bit should be a singleton but can't work out how to do it and still run the constructor inherited from the parent class.

public class Artist extends Container {
    private static Artist instance = getInstance();
    int windowWidth = 1400;
    int windowHeight = 800;
    int size = 120;     //domino size
    JFrame frame;
    private Graphics graphics;

    public static Artist getInstance(){
        if (instance == null){
            instance = new Artist();
            instance.setupTable();
        }
        return instance;
    }

    public void drawDashes(int x, int y){
        for (int i=0;i<5;i=i+2){
            graphics.setColor(Color.black);
            graphics.fillRoundRect(10+x+20*i,y,20,5,2,2);

        }
    }

    private void setupTable(){
        frame = new JFrame("Awesome Dominoes");
        frame.setSize(windowWidth, windowHeight);
        //TODO EXIT will close entire application. We want to add in a popup "Are you sure?" window, I reckon
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(instance);
        frame.setVisible(true);
        graphics = getGraphics();

    }

    public void clearTable(){
        graphics.setColor(Color.gray);
        graphics.fillRect(0, 0, windowWidth, windowHeight);

    }

    public void drawBone(int x,int y,Bone bone, String playerType){
        if (playerType == "Player") {
            drawBone(x,y,bone);
        } else {
            //TODO drawHiddenBone; //will replace below line when ready
            drawBone(x,y,bone);
        }
    }

    public void drawBone(int x,int y,Bone bone){
        graphics.setColor(Color.black);
        graphics.fillRoundRect(x, y, size,size/2,size/20,size/20);
        drawPips(bone.left(),x,y,size);
        graphics.setColor(Color.white);
        graphics.drawLine(x+size/2, y, x+size/2, y+size/2);
        drawPips(bone.right(),x+size/2,y,size);
    }


    private void drawPips(int num,int x,int y,int size){
        switch(num){
            case 1:drawOne(x,y,size);
                break;
            case 2:drawTwo(x,y,size);
                break;
            case 3:drawThree(x,y,size);
                break;
            case 4:drawFour(x,y,size);
                break;
            case 5:drawFive(x,y,size);
                break;
            case 6:drawSix(x,y,size);
                break;
        }
    }


    private void drawOne(int x,int y,int size){
        graphics.setColor(Color.green);
        graphics.fillOval(x+25, y+25, size/12, size/12);
    }

    private void drawTwo(int x,int y,int size){
        graphics.setColor(Color.blue);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawThree(int x,int y,int size){
        graphics.setColor(Color.pink);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+25, y+25, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawFour(int x,int y,int size){
        graphics.setColor(Color.red);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawFive(int x,int y,int size){
        graphics.setColor(Color.cyan);
        graphics.fillOval(x+25, y+25, size/12, size/12);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawSix(int x,int y,int size){
        graphics.setColor(Color.yellow);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+25, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+25, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }




}
