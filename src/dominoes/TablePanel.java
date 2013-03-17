package dominoes;

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
    //TODO - size needs to be only be set in one class not all of them! Relate it to window size?
    int boneSize = 120;
    int boneSpacing = 5;

    public TablePanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, boneSpacing, 5));
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
            if (bones.length > maxBones) {
                // Draw elipsis in middle
                for (int i = 0; i < maxBones / 2; i++) {
                    this.add(new BoneWidget(bones[i], "", boneSize));
                }
                this.add(new ElipsisWidget(boneSize));
                for (int i = bones.length - maxBones / 2; i < bones.length; i++) {
                    this.add(new BoneWidget(bones[i], "", boneSize));
                }
            } else {
                // Just draw them all
                for (int i = 0; i < bones.length; i++) {
                    this.add(new BoneWidget(bones[i], "", boneSize));
                }
            }
        }
        this.validate();
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
    }
}
