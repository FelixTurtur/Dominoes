package dominoes;

import com.sun.media.jfxmedia.events.PlayerStateEvent;

import javax.swing.*;
import java.awt.*;
import dominoes.players.DominoPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 10/03/13
 * Time: 20:08
 */
public class InfoPanel extends JPanel{
    private DominoPlayer[] players;
    private Font font;
    private BoneYard boneYard;
    private static int size=120;
    private DominoPlayer winner=null;

    //TODO - work out how to centre all text output

    InfoPanel(FlowLayout flowLayout){
        super(flowLayout);
        font = new Font("Arial", Font.BOLD, 36);

    }

    public void setPlayers(DominoPlayer[] p){
        players=p;
    }

    public void setBoneYard(BoneYard by){
        boneYard=by;
    }

    public void setWinner(DominoPlayer w){
        winner=w;
    }


    public void paint(Graphics graphics){
        super.paint(graphics);
        displayScore(graphics);
        drawBoneYard(graphics);
        if (winner!=null){
            displayWinner(graphics);
            winner=null;
        }
    }

    private void displayWinner(Graphics graphics){
        graphics.setColor(Color.yellow);
        graphics.fill3DRect(this.getWidth() / 4, 10, getWidth() / 2, getHeight() - 20,true);
        graphics.setColor(Color.black);
        graphics.setFont(new Font("Arial", Font.BOLD, 50));
        graphics.drawString(winner.getName() + " wins the round!", this.getWidth()/2-300, this.getHeight() / 2+20);
    }


    private void displayScore(Graphics graphics){
        graphics.setFont(font);
        graphics.setColor(Color.blue);
        for (int i=0; i<players.length;i++){
            graphics.drawString(players[i].getPoints() + "    " ,this.getWidth()-300,this.getHeight()*(i+1)/3);
            graphics.drawString(players[i].getName(),this.getWidth()-230,this.getHeight()*(i+1)/3);

        }
    }

    private void drawBoneYard(Graphics graphics){
        graphics.setColor(Color.black);
        graphics.fillRoundRect(40, this.getHeight()/2-60, size /2, size, size / 20, size / 20);
        graphics.setColor(Color.white);
        String s="";
        if (boneYard.size()<10) s=" ";
        graphics.drawString(s+boneYard.size(),50,this.getHeight()/2+10);
    }

}
