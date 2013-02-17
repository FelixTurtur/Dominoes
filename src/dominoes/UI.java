package dominoes;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 22:57
 */
public class UI implements DominoUI {
    public void display(dominoes.players.DominoPlayer[] dominoPlayers, dominoes.Table table, dominoes.BoneYard boneYard){
        System.out.println("Boneyard [ " + boneYard.size() + " ]");
        drawScoreBoard(dominoPlayers);
        System.out.println("");

        //for now - let's display both players hands
        System.out.println(dominoPlayers[0].getName() + "'s hand:");
        drawHand(dominoPlayers[0]);

        System.out.println(dominoPlayers[1].getName() + "'s hand:");
        drawHand(dominoPlayers[1]);


    }

    public void displayRoundWinner(dominoes.players.DominoPlayer dominoPlayer){
        System.out.println(dominoPlayer.getName() + "wins the round!" );

    }

    public void displayInvalidPlay(dominoes.players.DominoPlayer dominoPlayer){
        System.out.println("Invalid Play");
    }


    private void drawScoreBoard(dominoes.players.DominoPlayer[] dominoPlayers){
        for (int i=0; i<dominoPlayers.length;i++){
            System.out.println(dominoPlayers[i].getPoints() + "    " +dominoPlayers[i].getName() );
        }
    }

    private void drawHand(dominoes.players.DominoPlayer player){
        Bone[] bones=player.bonesInHand();
        for (int i=0; i<bones.length;i++){
            drawBone(bones[i]);
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("");

    }

    private void drawBone(Bone b){
        System.out.print("[" + b.left() + "|" + b.right() +"]" );
    }


}
