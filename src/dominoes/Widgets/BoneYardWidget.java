package dominoes.Widgets;

import dominoes.BoneYard;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 20/03/2013
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public class BoneYardWidget extends Canvas {
    private BoneYard boneYard;
    private int size = 120;

    private Color background = Color.black;
    private Color foreground = Color.white;

    public BoneYardWidget(int size) {
        this.size = size;

        reshape(0, 0, size / 2, size);
    }

    public boolean mouseUp(Event e, int x, int y) {
        // Container should see event
        return false;
    }

    public void paint(Graphics g) {
        drawBackground(g);
        drawForeground(g);
    }

    private void drawForeground(Graphics g) {
        g.setColor(foreground);
        if (this.boneYard != null) {
            String s = "";
            if (boneYard.size() < 10) s = " ";
            g.drawString(s + boneYard.size(), 50, this.getHeight() / 2 + 10);
        }
    }

    private void drawBackground(Graphics g) {
        g.setColor(background);
        g.fillRoundRect(0, 0, size / 2, size, size / 20, size / 20);
    }

    public void setBoneYard(BoneYard boneYard) {
        this.boneYard = boneYard;
        validate();
    }

    public BoneYard getBoneYard() {
        return boneYard;
    }
}
