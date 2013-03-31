package dominoes;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 20/03/2013
 * Time: 13:16
 * Description: Wraps a Play for communication between the UI and the game engine via specialised cubby hole
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

    // Shows whether this Play is valid or not
    public boolean isValid() {
        return valid;
    }
}
