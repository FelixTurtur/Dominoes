package dominoes;

import dominoes.players.ComputerPlayer;
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
    static int targetScore = 50;
    static Boolean gametime = true;
    static int maxpips = 6;  //graphics output currently can not cope with higher than 6

    public static void main(String[] args)
    {
        WelcomePage myWelcomePage = new WelcomePage();
        myWelcomePage.setUpGame();
    }

    private static Player createPlayer(PlayerType type, String name) {
        if (type == PlayerType.Computer) {
            return new ComputerPlayer(name);
        } else if (type == PlayerType.Human) {
            return new Player(name);
        }
        throw new IllegalArgumentException("type was not a valid createable player type");
    }

    public static void runGame(PlayerType player1Type, PlayerType player2Type, String player1Name, String player2Name, int targetScore) {
        while (gametime) {
            UI ui = UI.getInstance();
            ui.setPlayer1Type(player1Type);
            ui.setPlayer2Type(player2Type);

            Player[] players = { createPlayer(player1Type, player1Name), createPlayer(player2Type, player2Name) };

            Dominoes dominoes = new Dominoes(ui, players[0], players[1], targetScore, maxpips);
            dominoes.players.DominoPlayer victorious = dominoes.play();
            String winningMessage = victorious.getName() + " has won! Would you like to play again?";
            int x = JOptionPane.showOptionDialog(new JFrame(),
                    winningMessage, "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Yes", "No"}, null);
            if (x == 1) gametime = false;
        }
    }
}
