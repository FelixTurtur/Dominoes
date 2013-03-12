package dominoes;


/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 22:57
 */
public class UI implements DominoUI {

    //TODO - Remove Artist class by getting this class to handle it's job. This is currently only passing identical function calls to the Artist
    //TODO - need to change the implements bit on the Artist class so that the above is possible.
    private Artist artist;
    UI(){
        artist = Artist.getInstance();
        artist.setVisible(true);

    }

    public void display(dominoes.players.DominoPlayer[] dominoPlayers, dominoes.Table table, dominoes.BoneYard boneYard){

        artist.updateScreen(table, dominoPlayers, boneYard);

    }

    public void displayRoundWinner(dominoes.players.DominoPlayer dominoPlayer){

        artist.displayRoundWinner(dominoPlayer);


        // Pause so that we see the message
        //TODO - add a continue button
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
        }

    }

    public void displayInvalidPlay(dominoes.players.DominoPlayer dominoPlayer){

        //TODO - make graphics version of this. Need unit test or human interaction first to ensure it works
        System.out.println("%%%%% Invalid Play %%%%%");
    }





}
