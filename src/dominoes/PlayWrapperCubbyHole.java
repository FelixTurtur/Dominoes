package dominoes;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 20/03/2013
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */

// This is a lovely little example of the facade pattern used to enforce type-safety when casting from object
public class PlayWrapperCubbyHole extends CubbyHole {

    public PlayWrapperCubbyHole() {
        super();
    }

    public synchronized PlayWrapper get() {
        return (PlayWrapper) super.get();
    }

    public synchronized void put(PlayWrapper playWrapper) {
        super.put(playWrapper);
    }
}
