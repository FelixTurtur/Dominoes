/*
 * Dominoes implementation by Timothy Baldock, Abbie James and Nick Mackin
 * MSc Computer Science
 * Submitted 31st March 2013
 */

package dominoes;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 16/03/2013
 * Time: 21:10
 */

public class ElipsisWidget extends Canvas {
    private int boneSize = 120;

    public ElipsisWidget(int size) {
        this.boneSize = size;
        reshape(0, 0, this.boneSize, this.boneSize / 2);
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRoundRect(0,0,boneSize,boneSize/2,boneSize/20,boneSize/20);
        g.setColor(Color.white);
        for (int i = 0; i < 5; i = i + 2) {
            g.fillRoundRect(10 + 20 * i, this.boneSize/4-3, 20, 6, 2, 2);
        }

    }
}
