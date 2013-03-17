package dominoes;

import dominoes.players.DominoPlayer;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 17/03/13
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
public class GameRunner {

    //parameters

    static int targetScore = 50;
    static int maxpips = 6;  //graphics output currently can not cope with higher than 6
    static Boolean running = true;

    //Go play Dominoes
    public static void runGame() {
        Settings gameSettings = new Settings();
        SettingsManager sm = new SettingsManager();
        Command fetch = new FetchSettings(gameSettings);
        sm.setCommand(fetch);
        while (running) {
            gameSettings.reset();
            sm.fetchSettings();
            while (gameSettings.score == null) {
                /*try {
                    wait();
                } catch (InterruptedException e) {
                    //loop back around
                } */
            }

            /*
            Player player1 = setPlayerType(args[0]);
            Player player2 = setPlayerType(args[1]);
            Player[] players = {player1, player2};
            players[0].setName(args[2]);
            players[1].setName(args[3]);
            targetScore = Integer.parseInt((args[4]));
            */
            DominoPlayer player1 = gameSettings.p1;
            DominoPlayer player2 = gameSettings.p2;
            DominoPlayer[] players = {player1, player2};
            targetScore = gameSettings.score;
            DominoUI ui = UI.getInstance();

            Dominoes dominoes = new Dominoes(ui, players[0], players[1], targetScore, maxpips);
            DominoPlayer victorious = dominoes.play();
            String winningMessage = victorious.getName() + " has won! Would you like to play again?";
            int x = JOptionPane.showOptionDialog(new JFrame(),
                    winningMessage, "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Yes", "No"}, null);
            if (x == 1) running = false;
        }
    }

    /*private static Player setPlayerType(String type) {
        if (type.equals("Human")) {
            return new Player();
        }
        return new ComputerPlayer();
    }    */


}
