package dominoes;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 16/03/2013
 * Time: 19:27
 */
public class BoneWidget extends Canvas {
    private Bone bone;
    private String playerType;
    private int size = 120;
    private static boolean hideComputerHand=true;
    private boolean portraitOrientation = false;
    private boolean hidden = false;

    private Color background = Color.black;

    long	entered = 0;
    long	inComponent = 0;

    public BoneWidget(Bone bone, String playerType, int size) {
        this.bone = bone;
        this.playerType = playerType;
        this.size = size;

        // Orientation depends on playerType
        if (this.playerType == "dominoes.players.Player" || this.playerType == "dominoes.players.ComputerPlayer") {
            portraitOrientation = true;
            reshape(0, 0, size / 2, size);
            if (this.playerType == "dominoes.players.ComputerPlayer") {
                hidden = true;
            }
        } else {
            reshape(0, 0, size, size / 2);
        }
    }

    public boolean mouseEnter(Event e, int x, int y) {
        entered = e.when;
        background = Color.red;
        repaint();
        return true;
    }

    public boolean mouseExit(Event e, int x, int y) {
        inComponent = e.when - entered;
        background = Color.black;
        repaint();
        return true;
    }

    public void paint(Graphics g) {
        drawBackground(g);
        drawForeground(g);
    }

    private void drawForeground(Graphics g) {
        if (hidden) {
            drawForegroundHidden(g);
        } else {
            drawForegroundPips(g);
        }
    }

    private void drawForegroundPips(Graphics g) {
        drawLeftPips(bone.left(), g);
        drawRightPips(bone.right(), g);
    }

    private void drawRightPips(int num, Graphics g) {
        if (portraitOrientation) {
            // Bottom
            switch(num) {
                case 1: drawOnePip(0, size / 2, g);    break;
                case 2: drawPortraitTwoPips(0, size / 2, g);   break;
                case 3: drawPortraitThreePips(0, size / 2, g); break;
                case 4: drawFourPips(0, size / 2, g);  break;
                case 5: drawFivePips(0, size / 2, g);  break;
                case 6: drawPortraitSixPips(0, size / 2, g);   break;
            }
        } else {
            // Right
            switch(num) {
                case 1: drawOnePip(size / 2, 0, g);    break;
                case 2: drawLandscapeTwoPips(size / 2, 0, g);   break;
                case 3: drawLandscapeThreePips(size / 2, 0, g); break;
                case 4: drawFourPips(size / 2, 0, g);  break;
                case 5: drawFivePips(size / 2, 0, g);  break;
                case 6: drawLandscapeSixPips(size / 2, 0, g);   break;
            }
        }
    }

    private void drawLeftPips(int num, Graphics g) {
        if (portraitOrientation) {
            // Top
            switch(num) {
                case 1: drawOnePip(0, 0, g);    break;
                case 2: drawPortraitTwoPips(0, 0, g);   break;
                case 3: drawPortraitThreePips(0, 0, g); break;
                case 4: drawFourPips(0, 0, g);  break;
                case 5: drawFivePips(0, 0, g);  break;
                case 6: drawPortraitSixPips(0, 0, g);   break;
            }
        } else {
            // Left
            switch(num) {
                case 1: drawOnePip(0, 0, g);    break;
                case 2: drawLandscapeTwoPips(0, 0, g);   break;
                case 3: drawLandscapeThreePips(0, 0, g); break;
                case 4: drawFourPips(0, 0, g);  break;
                case 5: drawFivePips(0, 0, g);  break;
                case 6: drawLandscapeSixPips(0, 0, g);   break;
            }
        }
    }

    private void drawForegroundHidden(Graphics g) {
        g.setColor(Color.white);
        int xpoints[] = { size/4, size * 3 / 8, size / 4, size / 8 };
        int ypoints[] = { size * 3 / 8, size / 2, size * 5 / 8, size / 2 };
        g.fillPolygon( xpoints, ypoints, 4);
    }

    private void drawBackground(Graphics g) {
        g.setColor(background);
        if (portraitOrientation) {
            g.fillRoundRect(0, 0, size /2, size, size / 20, size / 20);
        } else {
            g.fillRoundRect(0, 0, size, size / 2, size / 20, size / 20);
        }
        g.setColor(Color.white);
        if (portraitOrientation) {
            g.drawLine(0, size / 2, size / 2, size / 2);
        } else {
            g.drawLine(0 + size / 2, 0, size / 2, size / 2);
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
