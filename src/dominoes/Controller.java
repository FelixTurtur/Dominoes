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
        UI ui = new UI();
        ui.setVisible(true);
        Player[] players = ui.showNewGameDialog();

        boolean gametime = true;
        while (gametime) {
            Dominoes dominoes = new Dominoes(ui, players[0], players[1], ui.getTargetScore(), ui.getMaxpips());
            DominoPlayer victorious = dominoes.play();
            String winningMessage = victorious.getName() + " has won! Would you like to play again?";
            int x = JOptionPane.showOptionDialog(new JFrame(),
                    winningMessage, "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Yes", "No"}, null);
            if (x == 1) gametime = false;
        }
    }

}
