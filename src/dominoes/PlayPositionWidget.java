package dominoes;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 18/03/2013
 * Time: 14:36
 * Description: Widget displayed to indicate possible play locations to interactive player
 */
public class PlayPositionWidget extends Canvas {
    private int size = 120;

    public PlayPositionWidget(int size) {
        this.size = size;
        reshape(0, 0, this.size / 2, this.size / 2);
    }

    public void paint(Graphics g) {
        g.setColor(Color.gray);
        g.fillRoundRect(0, 0, size / 2, size / 2, size / 20, size / 20);
    }

    public boolean mouseUp(Event e, int x, int y) {
        // Container should see event
        return false;
    }
}
