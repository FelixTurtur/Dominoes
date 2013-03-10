package dominoes;

import java.awt.*;

public class BoneDrawer {

    private Bone bone;

    private String playerType;

    private int size = 120;

    public BoneDrawer(Bone bone, String playerType) {
        this.bone = bone;
        this.playerType = playerType;
    }

    public void drawBone(int x, int y, Graphics graphics) {
        if (playerType == "dominoes.players.Player") {
            drawPlayerBone(x, y, graphics);
        } else if (playerType=="dominoes.players.ComputerPlayer"){
            drawHiddenBone(x, y, graphics);
        }
        else {
           drawTableBone(x,y,graphics);
        }
    }

    private void drawHiddenBone(int x, int y, Graphics graphics) {
        // TODO - implement this method to do something different
        drawPlayerBone(x, y, graphics);
    }

    private void drawPlayerBone(int x, int y, Graphics graphics) {
        drawPortraitBackground(x, y, graphics);
        drawPortraitPips(bone.left(), x, y, graphics);
        drawPortraitPips(bone.right(), x, y+size/2, graphics);
    }

    private void drawTableBone(int x, int y, Graphics graphics) {
        drawLandscapeBackground(x, y, graphics);
        drawLandscapePips(bone.left(), x, y, graphics);
        drawLandscapePips(bone.right(), x + size / 2, y, graphics);
    }



    private void drawPortraitBackground(int x, int y, Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRoundRect(x, y, size /2, size, size / 20, size / 20);
        graphics.setColor(Color.white);
        graphics.drawLine(x, y+size/2, x + size/2 , y + size / 2);
    }


    private void drawLandscapeBackground(int x, int y, Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRoundRect(x, y, size, size / 2, size / 20, size / 20);
        graphics.setColor(Color.white);
        graphics.drawLine(x + size / 2, y, x + size / 2, y + size / 2);
    }



    private void drawLandscapePips(int num, int x, int y, Graphics graphics) {
        switch(num) {
            case 1: drawOnePip(x, y, graphics);    break;
            case 2: drawLandscapeTwoPips(x, y, graphics);   break;
            case 3: drawLandscapeThreePips(x, y, graphics); break;
            case 4: drawFourPips(x, y, graphics);  break;
            case 5: drawFivePips(x, y, graphics);  break;
            case 6: drawLandscapeSixPips(x, y, graphics);   break;
        }
    }

    private void drawPortraitPips(int num, int x, int y, Graphics graphics) {
        switch(num) {
            case 1: drawOnePip(x, y, graphics);    break;
            case 2: drawPortraitTwoPips(x, y, graphics);   break;
            case 3: drawPortraitThreePips(x, y, graphics); break;
            case 4: drawFourPips(x, y, graphics);  break;
            case 5: drawFivePips(x, y, graphics);  break;
            case 6: drawPortraitSixPips(x, y, graphics);   break;
        }
    }


    private void drawOnePip(int x, int y, Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillOval(x+25, y+25, size/12, size/12);
    }

    private void drawLandscapeTwoPips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawPortraitTwoPips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
    }

    private void drawLandscapeThreePips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.pink);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+25, y+25, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawPortraitThreePips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.pink);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+25, y+25, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
    }

    private void drawFourPips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawFivePips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.cyan);
        graphics.fillOval(x+25, y+25, size/12, size/12);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }



    private void drawLandscapeSixPips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.yellow);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+25, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+25, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawPortraitSixPips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.yellow);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+25, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+25, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

}
