package dominoes;

import dominoes.players.Player;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 17/02/13
 * Time: 14:49
 */
public class Controller {

    //controls the running of the program

    public static void main(String [ ] args)
    {
        UI ui=new UI();

        Player[] players = {new Player(),new Player()};
        players[0].setName("Player 1");
        players[1].setName("Player 2");

        Table table=new Table();
        BoneYard boneYard=new BoneYard(6);

        //for testing purposes - does the Dominoes class handle the initial deal? I would imagine so...
        for (int i=0;i<7;i++){
            players[0].draw(boneYard);
            players[1].draw(boneYard);
        }


        ui.display(players,table,boneYard);
    }

}
