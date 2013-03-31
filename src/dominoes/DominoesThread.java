/*
 * Dominoes implementation by Timothy Baldock, Abbie James and Nick Mackin
 * MSc Computer Science
 * Submitted 31st March 2013
 */

package dominoes;

import dominoes.players.DominoPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 21/03/2013
 * Time: 16:35
 * To change this template use File | Settings | File Templates.
 */
public class DominoesThread implements Runnable {

    private final Dominoes dominoesGame;
    private boolean started;
    public final UI ui;

    public DominoesThread(Dominoes dominoesGame, UI ui) {
        this.dominoesGame = dominoesGame;
        this.ui = ui;
    }

    public void run() {
        if (!started) {
            DominoPlayer pWinner = this.dominoesGame.play();
            ui.handleWinner(pWinner);
        }
    }

}
