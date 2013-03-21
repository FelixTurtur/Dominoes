package dominoes;

import dominoes.players.ComputerPlayer;
import dominoes.players.DominoPlayer;
import dominoes.players.Player;
import dominoes.players.PlayerType;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 17/02/13
 * Time: 14:49
 */
public class Controller {
    //controls the running of the program

    //parameters

    public static void main(String[] args) {
        UIFrame uiFrame = new UIFrame();
        uiFrame.setVisible(true);
        uiFrame.showNewGameDialog();
    }
}
