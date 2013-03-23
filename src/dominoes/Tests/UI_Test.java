package dominoes.Tests;

import dominoes.UIFrame;

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
        /*while (x == 0) {
            UI ui = new UI();
            ui.setPlayer1Type(PlayerType.Computer);
            ui.setPlayer2Type(PlayerType.Computer);

            Player[] players = {new ComputerPlayer("Player 1", ui), new ComputerPlayer("Player 2", ui)};

            Dominoes dominoes = new Dominoes(ui, players[0], players[1], targetScore, maxpips);
            dominoes.players.DominoPlayer victorious = dominoes.play();
            String winningMessage = victorious.getName() + " has won! Would you like to play again?";
            x = JOptionPane.showOptionDialog(new JFrame(),
                    winningMessage, "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Yes", "No"}, null);
        }*/
        UIFrame uiFrame = new UIFrame();
        uiFrame.showNewGameDialog();
    }

}
