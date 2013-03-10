package dominoes;


/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 22:57
 */
public class UI implements DominoUI {
    private Artist artist;
    UI(){
        artist = Artist.getInstance();
        artist.setVisible(true);

    }

    public void display(dominoes.players.DominoPlayer[] dominoPlayers, dominoes.Table table, dominoes.BoneYard boneYard){

        System.out.println("************************************************************************************");
        System.out.println("");
        drawScoreBoard(dominoPlayers);
        drawBoneYard(boneYard);

        artist.updateScreen(table, dominoPlayers, boneYard);

    }

    public void displayRoundWinner(dominoes.players.DominoPlayer dominoPlayer){
        System.out.println("");
        System.out.println("************************************************");
        System.out.println(dominoPlayer.getName() + " wins the round!" );
        System.out.println("************************************************");
        System.out.println("");
    }

    public void displayInvalidPlay(dominoes.players.DominoPlayer dominoPlayer){
        System.out.println("%%%%% Invalid Play %%%%%");
    }


    private void drawScoreBoard(dominoes.players.DominoPlayer[] dominoPlayers){
        System.out.println("");
        System.out.println("Scores:");
        for (int i=0; i<dominoPlayers.length;i++){
            System.out.println(dominoPlayers[i].getPoints() + "    " +dominoPlayers[i].getName() );
        }
        System.out.println("************************************");
    }

    private void drawBoneYard(BoneYard boneYard){
        //TODO Draw this in the game window
        //TODO Put this in a frame above the top hand, in the right hand corner.
        //TODO Game option buttons will be on the left of the same frame.
        System.out.println("");
        System.out.println("Boneyard [ " + boneYard.size() + " ]");
        System.out.println("");
    }


}
