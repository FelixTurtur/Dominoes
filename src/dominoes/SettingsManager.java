package dominoes;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 17/03/13
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class SettingsManager {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void fetchSettings() {
        command.execute();
    }
}
