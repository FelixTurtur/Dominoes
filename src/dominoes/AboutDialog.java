package dominoes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 16/03/13
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class AboutDialog extends Dialog{
    protected Button button;

    public AboutDialog(final Frame parent, String title, Boolean modal) {
        super(parent, title, modal);
        this.add(new Label("Awesome Dominoes was written by:\nAbbie James\nNick Mackin\nTimothy Baldock"));
        button = new Button("OK");
        this.pack();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.dispose();
            }
        });

    }

}
