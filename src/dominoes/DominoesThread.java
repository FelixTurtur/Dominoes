package dominoes;

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

    public DominoesThread(Dominoes dominoesGame) {
        this.dominoesGame = dominoesGame;
    }

    public void run() {
        if (!started) {
            this.dominoesGame.play();
        }
    }
}
