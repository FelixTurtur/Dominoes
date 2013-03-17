package dominoes.Tests;

import dominoes.DominoUI;
import dominoes.Dominoes;
import dominoes.UI;
import dominoes.players.ComputerPlayer;
import dominoes.players.Player;

import javax.swing.*;

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
    static int x = 0;

    public static void main(String[] args) {
        while (x == 0) {
            DominoUI ui = UI.getInstance();

            Player[] players = {new ComputerPlayer(),new ComputerPlayer()};
            players[0].setName("Player 1");
            players[1].setName("Player 2");

            Dominoes dominoes = new Dominoes(ui, players[0], players[1], targetScore, maxpips);
            dominoes.players.DominoPlayer victorious = dominoes.play();
            String winningMessage = victorious.getName() + " has won! Would you like to play again?";
            x = JOptionPane.showOptionDialog(new JFrame(),
                    winningMessage, "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Yes", "No"}, null);
        }
    }

}
