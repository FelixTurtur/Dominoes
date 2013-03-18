package dominoes;

import dominoes.players.PlayerType;

import java.util.List;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;

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

    // Indicator for play positions and click targets
    PlayPositionWidget leftPlayPosition = new PlayPositionWidget(boneSize);
    PlayPositionWidget rightPlayPosition = new PlayPositionWidget(boneSize);

    public TablePanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, boneSpacing, 5));
        this.validate();
    }

    public void setTable(Table t) {
        table = t;
        setUpBones();
    }

    private void setUpBones() {
        // Number of displayed bones depends on size of containing panel
        // Truncate in the middle by displaying elipsis
        this.removeAll();
        if (table != null) {
            Bone[] bones = table.layout();
            // Max number of bones = width of display area divided by bone size + spacing
            int maxBones = this.getSize().width / (boneSize + boneSpacing) - 2;

            this.add(this.leftPlayPosition);
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
            this.add(this.rightPlayPosition);
        }
        this.validate();
    }

    public boolean mouseUp(Event e, int x, int y) {
        // If bone selected matches either the left or right position send event to UI
        // Container should not see event
        if (e.target == this.leftPlayPosition) {
            // Send left play event
        } else if (e.target == this.rightPlayPosition) {
            // Send right play event
        }
        return true;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
    }
}
