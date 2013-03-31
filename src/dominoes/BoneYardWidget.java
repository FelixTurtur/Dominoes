package dominoes;

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
    private final int size = 120;

    private Color background = Color.black;
    private Color foreground = Color.white;

    public BoneYardWidget() {
        setSize(size / 2, size);
    }

    public void paint(Graphics g) {
        drawBackground(g);
        drawForeground(g);
    }

    private void drawForeground(Graphics g) {
        g.setColor(foreground);
        if (this.boneYard != null) {
            String s = "";
            if (this.boneYard.size() < 10) s = " ";
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString(s + this.boneYard.size(), 0, size / 2 + 15);
        }
    }

    private void drawBackground(Graphics g) {
        g.setColor(background);
        g.fillRoundRect(0, 0, size / 2, size, size / 20, size / 20);
    }

    public void setBoneYard(BoneYard boneYard) {
        this.boneYard = boneYard;
        repaint();
    }

    public BoneYard getBoneYard() {
        return this.boneYard;
    }

}
