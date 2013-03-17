package dominoes;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 17/02/13
 * Time: 14:49
 */
public class Controller {
    //controls the running of the program

    /*public static void main(String[] args)
    {
        /*WelcomePage myWelcomePage = new WelcomePage();
        myWelcomePage.setUpGame();*/
        /*SettingsManager sm = new SettingsManager();
        Settings gameSettings = new Settings();

        Command fetch = new FetchSettings(gameSettings);
        sm.setCommand(fetch);
        sm.fetchSettings();

    }  */
    public static void main(String[] args) {
        GameRunner gr = new GameRunner();
        gr.runGame();
    }
}