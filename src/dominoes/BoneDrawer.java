package dominoes;

import java.awt.*;

public class BoneDrawer {

    private Bone bone;

    private int size = 120;

    public BoneDrawer(Bone bone) {
        this.bone = bone;
    }

    public void drawBone(int x, int y, Graphics graphics) {
        //TODO get it to draw something else for non human player type
        drawBackground(x, y, graphics);
        drawPips(bone.left(), x, y, graphics);
        drawMidLine(x, y, graphics);
        drawPips(bone.right(), x + size / 2, y, graphics);
    }

    private void drawBackground(int x, int y, Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRoundRect(x, y, size, size / 2, size / 20, size / 20);
    }

    private void drawMidLine(int x, int y, Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(x + size / 2, y, x + size / 2, y + size / 2);
    }

    private void drawPips(int num, int x, int y, Graphics graphics) {
        switch(num) {
            case 1: drawOnePip(x, y, graphics);    break;
            case 2: drawTwoPips(x, y, graphics);   break;
            case 3: drawThreePips(x, y, graphics); break;
            case 4: drawFourPips(x, y, graphics);  break;
            case 5: drawFivePips(x, y, graphics);  break;
            case 6: drawSixPips(x, y, graphics);   break;
        }
    }

    private void drawOnePip(int x, int y, Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillOval(x+25, y+25, size/12, size/12);
    }

    private void drawTwoPips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }

    private void drawThreePips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.pink);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+25, y+25, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
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

    private void drawSixPips(int x, int y, Graphics graphics) {
        graphics.setColor(Color.yellow);
        graphics.fillOval(x+10, y+10, size/12, size/12);
        graphics.fillOval(x+25, y+10, size/12, size/12);
        graphics.fillOval(x+40, y+10, size/12, size/12);
        graphics.fillOval(x+10, y+40, size/12, size/12);
        graphics.fillOval(x+25, y+40, size/12, size/12);
        graphics.fillOval(x+40, y+40, size/12, size/12);
    }
}
