package dominoes.players;

import dominoes.Bone;
import dominoes.CubbyHole;
import dominoes.Play;
import dominoes.UI;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 21:54
 */
public class Player implements DominoPlayer {

    private String name = "new player";
    private int points = 0;
    protected List<Bone> hand = new LinkedList<Bone>();
    UI ui;

    public CubbyHole nextMove = new CubbyHole();

    public Player(String name, UI ui) {
        this.name = name;
        this.ui = ui;
    }

    public dominoes.Play makePlay(dominoes.Table table) throws dominoes.CantPlayException{
        Play thePlay = chooseMove(table);
        if (thePlay==null) throw new dominoes.CantPlayException();
        hand.remove(thePlay.bone());
        return thePlay;
    }

    protected dominoes.Play chooseMove(dominoes.Table table){
        //not implemented yet
        nextMove.put(null);
        ui.getPlayerMove(this);

        // Wait for UI thread to place the next move in here
        while (nextMove.get() == null) {
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return (Play)nextMove.get();
    }


    public void takeBack(dominoes.Bone bone){
        hand.add(bone);
    }

    public void draw(dominoes.BoneYard boneYard){
        Bone newBone=boneYard.draw();
        if ( newBone != null ){
            hand.add(newBone);
        }
    }


    public int numInHand(){
         return hand.size();
    }

    public dominoes.Bone[] bonesInHand(){
        Bone[] b = hand.toArray(new Bone[0]);
        return b;
    }

    public void newRound(){
         hand.clear();
    }

    public void setPoints(int i){
        points = i;
    }

    public int getPoints(){
        return points;
    }

    public void setName(String s){
        name=s;
    }

    public String getName(){
        return name;
    }

}
