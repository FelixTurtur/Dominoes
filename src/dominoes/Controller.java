package dominoes;

import dominoes.players.*;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 17/02/13
 * Time: 14:49
 */
public class Controller {
    //controls the running of the program

    //parameters
    static int targetScore = 50;
    static int maxpips = 6;  //graphics output currently can not cope with higher than 6

    public static void main(String [ ] args)
    {

        // TODO Because we're so good we could have a text or GUI option for the game with text only or
        // glorious, colourful dominoes. What do you think?
        // Yep, text version can also double as our testing classes  - NM


        DominoUI ui = UI.getInstance();

        Player[] players = {new ComputerPlayer(),new ComputerPlayer()};
        players[0].setName("Player 1");
        players[1].setName("Player 2");

        Dominoes dominoes = new Dominoes(ui, players[0], players[1], targetScore, maxpips);
        dominoes.play();

        //TODO work out who won the game and display it

    }

}
