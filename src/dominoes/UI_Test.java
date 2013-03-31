package dominoes;

import dominoes.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 16/03/13
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */

public class UI_Test {
    static int targetScore = 1;
    static int maxpips = 6;
    static int windowWidth = 1400;
    static int windowHeight = 800;
    static UI ui;

    public static void main(String[] args) {

        JFrame testFrame = new JFrame();
        testFrame.setTitle("Awesome Dominoes");
        testFrame.setSize(windowWidth, windowHeight);
        testFrame.setPreferredSize(new Dimension(windowWidth, windowHeight));
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui = new UI();

        testFrame.add(ui);
        testFrame.validate();
        testFrame.setVisible(true);
    }

}
