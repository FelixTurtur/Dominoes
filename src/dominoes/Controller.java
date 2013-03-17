package dominoes;

import dominoes.players.ComputerPlayer;
import dominoes.players.Player;

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

    public static void runGame(String[] args) {
        while (gametime) {
            DominoUI ui = UI.getInstance();
            Player player1 = setPlayerType(args[0]);
            Player player2 = setPlayerType(args[1]);
            Player[] players = {player1, player2};
            players[0].setName(args[2]);
            players[1].setName(args[3]);
            targetScore = Integer.parseInt((args[4]));

            Dominoes dominoes = new Dominoes(ui, players[0], players[1], targetScore, maxpips);
            dominoes.players.DominoPlayer victorious = dominoes.play();
            String winningMessage = victorious.getName() + " has won! Would you like to play again?";
            int x = JOptionPane.showOptionDialog(new JFrame(),
                    winningMessage, "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Yes", "No"}, null);
            if (x == 1) gametime = false;
        }
    }

    private static Player setPlayerType(String type) {
        if (type.equals("Human")) {
            return new Player();
        }
        return new ComputerPlayer();
    }

}
