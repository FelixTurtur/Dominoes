package dominoes;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 20/03/2013
 * Time: 13:21
 * Description: This uses the Proxy pattern to provide type-safety when using the CubbyHole for PlayWrapper objects
 */

public class PlayWrapperCubbyHole {
    // A CubbyHole that we can only put PlayWrappers into
    private CubbyHole cubbyHole;

    public PlayWrapperCubbyHole() {
        this.cubbyHole = new CubbyHole();
    }

    public PlayWrapper get() {
        return (PlayWrapper) this.cubbyHole.get();
    }

    public void put(PlayWrapper playWrapper) {
        this.cubbyHole.put(playWrapper);
    }
}
