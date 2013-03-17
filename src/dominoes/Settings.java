package dominoes;

import dominoes.players.ComputerPlayer;
import dominoes.players.DominoPlayer;
import dominoes.players.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 17/03/13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
public class Settings implements ActionListener{

    //all the things
    DominoPlayer p1;
    DominoPlayer p2;
    Integer score;
    WelcomePage wp;

    public void getSettings() {
        wp = new WelcomePage();
        wp.setUpGame(this);
    }

    public void setSettings(String[] args) {
        //synchronized (this) {
            wp.repaint();
            p1 = setPlayerType(args[0]);
            p1.setName(args[2]);
            p2 = setPlayerType(args[1]);
            p2.setName(args[3]);
            score = Integer.parseInt(args[4]);
           // notifyAll();
        //}
    }

    private static Player setPlayerType(String type) {
        if (type.equals("Human")) {
            return new Player();
        }
        return new ComputerPlayer();
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("newGame")) {
            //Validate game options
            String[] args = {"","","","",""};
            try {
                if (wp.p1H.isSelected()) {
                    args[0] = wp.p1H.getText();
                }
                else args[0] = wp.p1C.getText();
                if (wp.p2H.isSelected()) {
                    args[1] = wp.p2H.getText();
                }
                else args[1] = wp.p2C.getText();
                args[2] = wp.p1NameBox.getText();
                args[3] = wp.p2NameBox.getText();
                args[4] = wp.scoreBox.getText();
                for (String s : args) {
                    if (s.length() == 0) {
                        throw new Exception("Missing value");
                    }
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        "Unable to start Game. Please ensure all fields are populated",
                        e.getMessage(),
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            //back to settings command
            wp.setVisible(false);
            setSettings(args);
        }
    }

    public void reset() {
        score = null;
        p1 = null;
        p2 = null;
    }
}
