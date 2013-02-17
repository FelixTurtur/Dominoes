package dominoes;

import dominoes.players.Player;
import dominoes.players.ComputerPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 17/02/13
 * Time: 14:49
 */
public class Controller {
    //controls the running of the program

    //parameters
    static int targetScore=50;
    static int maxpips=6;

    public static void main(String [ ] args)
    {
        UI ui=new UI();

        Player[] players = {new ComputerPlayer(),new ComputerPlayer()};
        players[0].setName("Player 1");
        players[1].setName("Player 2");

        Dominoes dominoes=new Dominoes(ui,players[0],players[1],targetScore,maxpips);
        dominoes.play();
    }

}
