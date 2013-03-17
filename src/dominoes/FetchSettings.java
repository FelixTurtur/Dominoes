package dominoes;

public class FetchSettings implements Command{

    Settings settings;

    public FetchSettings(Settings settings) {
        this.settings = settings;
    }

    public void execute() {
        settings.getSettings();
    }
}
