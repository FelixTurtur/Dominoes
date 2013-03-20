package dominoes;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 20/03/2013
 * Time: 13:16
 * To change this template use File | Settings | File Templates.
 */
public class PlayWrapper {
    private boolean valid;
    private Play play;

    public PlayWrapper(boolean valid, Play play) {
        this.valid = valid;
        this.play = play;
    }

    public Play getPlay() {
        return play;
    }

    public boolean isValid() {
        return valid;
    }
}
