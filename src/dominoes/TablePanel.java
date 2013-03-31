package dominoes;

import dominoes.players.PlayerType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 05/03/13
 * Time: 01:08
 */
public class TablePanel extends JPanel {
    Table table;
    int boneSize = 120;
    int boneSpacing = 5;

    BufferedImage img=null;


    // Indicator for play positions and click targets
    PlayPositionWidget leftPlayPosition = new PlayPositionWidget(boneSize);
    PlayPositionWidget rightPlayPosition = new PlayPositionWidget(boneSize);
    private boolean showPlays = false;
    private UI turnCoordinator;

    public TablePanel(UI turnCoordinator) {
        this.setMinimumSize(new Dimension(turnCoordinator.getWidth(), (int)(boneSize * 1.5 + 10)));
        this.setMaximumSize(new Dimension(turnCoordinator.getWidth(),(int)(boneSize * 1.5 + 10)));
        this.setSize(new Dimension(0, boneSize / 2 + 10));
        this.turnCoordinator = turnCoordinator;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, boneSpacing, this.getHeight() / 2 + boneSize / 4));
        this.validate();

        URL backImgFile=this.getClass().getResource("Images/back.png");

        try{img=ImageIO.read(backImgFile);
        } catch(IOException e){
            System.out.println("Image file failed to load");
        }
    }

    public void setTable(Table t) {
        table = t;
        setUpBones();
    }

    private void setUpBones() {
        // Number of displayed bones depends on boneSize of containing panel
        // Truncate in the middle by displaying elipsis
        this.removeAll();
        if (table != null) {
            Bone[] bones = table.layout();
            // Max number of bones = width of display area divided by bone boneSize + spacing
            int maxBones = this.getSize().width / (boneSize + boneSpacing) - 2;

            if (this.showPlays) {
                this.add(this.leftPlayPosition);
            }
            if (bones.length > maxBones) {
                // Draw elipsis in middle
                for (int i = 0; i < maxBones / 2; i++) {
                    this.add(new BoneWidget(bones[i], PlayerType.None, boneSize));
                }
                this.add(new ElipsisWidget(boneSize));
                for (int i = bones.length - maxBones / 2; i < bones.length; i++) {
                    this.add(new BoneWidget(bones[i], PlayerType.None, boneSize));
                }
            } else {
                // Just draw them all
                for (int i = 0; i < bones.length; i++) {
                    this.add(new BoneWidget(bones[i], PlayerType.None, boneSize));
                }
            }
            if (this.showPlays) {
                this.add(this.rightPlayPosition);
            }
        }
        this.validate();
    }

    public boolean mouseUp(Event e, int x, int y) {
        // If bone selected matches either the left or right position send event to UI
        // Container should not see event
        if (e.target == this.leftPlayPosition) {
            // Send left play event
            turnCoordinator.nextMovePosition(Play.LEFT);
        } else if (e.target == this.rightPlayPosition) {
            // Send right play event
            turnCoordinator.nextMovePosition(Play.RIGHT);
        }
        return true;
    }

    // Used by observer to indicate whether play indicators should be shown or hidden at the current time
    public void showPlayIndicators() {
        this.showPlays = true;
        setUpBones();
    }

    public void hidePlayIndicators() {
        this.showPlays = false;
        setUpBones();
    }

    public void paint(Graphics graphics) {
            super.paint(graphics);
     }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawImage(img,0,0,getWidth(),getHeight(),this);

    }
}
