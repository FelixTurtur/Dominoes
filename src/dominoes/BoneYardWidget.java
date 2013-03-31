/*
 * Dominoes implementation by Timothy Baldock, Abbie James and Nick Mackin
 * MSc Computer Science
 * Submitted 31st March 2013
 */

package dominoes;

import dominoes.BoneYard;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 20/03/2013
 * Time: 12:37
 * Description: Widget representing boneyard from which players can draw bones if they can't play
 */
public class BoneYardWidget extends Canvas {
    private BoneYard boneYard;
    private final int boneSize = 120;

    private Color background = Color.black;
    private Color foreground = Color.white;

    public BoneYardWidget() {
        setSize(boneSize / 2, boneSize);
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
            g.drawString(s + this.boneYard.size(), 0, boneSize / 2 + 15);
        }
    }

    private void drawBackground(Graphics g) {
        g.setColor(background);
        g.fillRoundRect(0, 0, boneSize / 2, boneSize, boneSize / 20, boneSize / 20);
    }

    public void setBoneYard(BoneYard boneYard) {
        this.boneYard = boneYard;
        repaint();
    }

    public BoneYard getBoneYard() {
        return this.boneYard;
    }
}
