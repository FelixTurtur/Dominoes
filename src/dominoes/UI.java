package dominoes;


/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 22:57
 */
public class UI implements DominoUI {

    //TODO - Remove Artist class by getting this class to handle it's job. This is currently only passing identical function calls to the Artist

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
            Thread.sleep(6000);
        } catch(InterruptedException e) {
        }

    }

    public void displayInvalidPlay(dominoes.players.DominoPlayer dominoPlayer){
        System.out.println("%%%%% Invalid Play %%%%%");
    }





}
