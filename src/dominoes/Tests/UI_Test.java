package dominoes.Tests;

import dominoes.DominoUI;
import dominoes.Dominoes;
import dominoes.UI;
import dominoes.players.ComputerPlayer;
import dominoes.players.Player;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 16/03/13
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */

public class UI_Test {
    static int targetScore = 50;
    static int maxpips = 6;

    public static void main(String[] args) {
        DominoUI ui = UI.getInstance();

        Player[] players = {new ComputerPlayer(),new ComputerPlayer()};
        players[0].setName("Player 1");
        players[1].setName("Player 2");

        Dominoes dominoes = new Dominoes(ui, players[0], players[1], targetScore, maxpips);
        dominoes.play();
    }

}
