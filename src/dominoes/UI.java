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
        artist=Artist.getInstance();

    }

    public void display(dominoes.players.DominoPlayer[] dominoPlayers, dominoes.Table table, dominoes.BoneYard boneYard){
        System.out.println("************************************************************************************");
        System.out.println("");
        drawScoreBoard(dominoPlayers);
        drawBoneYard(boneYard);


        drawTable(table);

        //for now - let's display both players hands
        drawHand(dominoPlayers[0]);
        drawHand(dominoPlayers[1]);


    }

    public void displayRoundWinner(dominoes.players.DominoPlayer dominoPlayer){
        System.out.println("");
        System.out.println("************************************************");
        System.out.println(dominoPlayer.getName() + "wins the round!" );
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
        System.out.println("");
        System.out.println("Boneyard [ " + boneYard.size() + " ]");
        System.out.println("");
    }


    private void drawTable(Table table){
        Bone[] bones=table.layout();
        System.out.println("");
        for (int i=0; i<bones.length;i++){
            drawTextBone(bones[i]);
            artist.drawBone(125*i,40,bones[i]);
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("");
    }

    private void drawHand(dominoes.players.DominoPlayer player){
        System.out.println("");
        Bone[] bones=player.bonesInHand();
        System.out.print(player.getName() + "'s hand:  ");
        for (int i=0; i<bones.length;i++){

            drawTextBone(bones[i]);
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("");
    }

    private void drawTextBone(Bone b){
        System.out.print("[" + b.left() + "|" + b.right() +"]" );
    }


}
