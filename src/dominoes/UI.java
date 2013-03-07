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

        //drawTable(table);

        //drawHands(dominoPlayers);
        artist.updateScreen(table, dominoPlayers, boneYard);
        //artist.repaint();

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


   /* private void drawTable(Table table){
        //Draws the line of dominoes that have so far been played this round.
        //Includes ellipse in the middle to limit the total number to a viewable amount
        //TODO Put this into a frame central within the master frame.
        Bone[] bones = table.layout();
        int y=300; //y position of domino line
        System.out.println("");
        for (int i=0,n=0; i<bones.length;i++,n++){
            drawTextBone(bones[i]);
            if ((i>3) && (i<bones.length-4)){
                i=bones.length-5;
                artist.drawDashes(10+130*n,y+30);
            }
            else{
                artist.drawBone(10+130*n,y,bones[i]);
            }
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("");
    }
    */
    /*
    private void drawHands(dominoes.players.DominoPlayer[] players){
        //Represent the domino hands each player has.
        //Consider visible/not visible to human player
        //TODO Put each into a frame above and below the central table frame within parent frame
        //Within each human hand, in order for the dominoes to be selectable, they will need to sit in a frame
        //This frame can glow when mouse-over events happen and playBone when clicked.
        System.out.println("");
        // When is players.length not 2?
        for (int n=0; n<players.length;n++){
            Bone[] bones=players[n].bonesInHand();
            System.out.print(players[n].getName() + "'s hand:  ");
            for (int i=0; i<bones.length;i++){
                artist.drawBone(10+130*i,500+n*100,bones[i], players[n].getClass().getName());
                drawTextBone(bones[i]);
                System.out.print(" ");
            }
            System.out.println("");
            System.out.println("");
        }
    }
      */
   /* private void drawTextBone(Bone b){
        System.out.print("[" + b.left() + "|" + b.right() +"]" );
    }
     */

}
