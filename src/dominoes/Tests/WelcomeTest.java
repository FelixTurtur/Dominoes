package dominoes.Tests;

import dominoes.WelcomePage;

/**
 * Created with IntelliJ IDEA.
 * User: Abbie
 * Date: 10/03/13
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
public class WelcomeTest {
    //Test Setup
    String[] args;

    /*public void actionPerformed(ActionEvent evt) {
        if(evt.getActionCommand().equals("Start")) {
            Controller.main(args);
        }
        else if(evt.getActionCommand().equals("Exit")){
            alert("Are you sure you want to quit?") {

            };
        }
    }*/

    public static void main(String[] args) {
        WelcomePage myWelcome = new WelcomePage();
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
        }
    }

}
