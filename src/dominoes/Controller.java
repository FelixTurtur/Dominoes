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

        boolean gametime = true;
        while (gametime) {
            Dominoes dominoesGame = uiFrame.showNewGameDialog();

            dominoesGame.play();

            /*int x = JOptionPane.showOptionDialog(new JFrame(),
                    winningMessage, "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Yes", "No"}, null);
            if (x == 1) gametime = false;*/
        }
    }

}
