package dominoes;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 22:57
 */
public class UI implements DominoUI {
    public void display(dominoes.players.DominoPlayer[] dominoPlayers, dominoes.Table table, dominoes.BoneYard boneYard){
        System.out.println("Not implemented yet" );
        System.out.println(boneYard.size() + "bones left in boneyard");

    }

    public void displayRoundWinner(dominoes.players.DominoPlayer dominoPlayer){
        System.out.println(dominoPlayer.getName() + "wins the round!" );

    }

    public void displayInvalidPlay(dominoes.players.DominoPlayer dominoPlayer){
        System.out.println("Invalid Play");
    }


    private void drawBone(Bone b){
        System.out.println("[" + b.left() + "|" + b.right() +"]" );
    }
}
