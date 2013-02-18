package dominoes.players;

import dominoes.Bone;
import dominoes.Play;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 21:54
 */
public class Player implements DominoPlayer {

    private String name="new player";
    private int points=0;
    protected List<Bone> hand = new LinkedList<Bone>();


    public dominoes.Play makePlay(dominoes.Table table) throws dominoes.CantPlayException{
        Play thePlay=chooseMove(table);
        if (thePlay==null) throw new dominoes.CantPlayException();
        hand.remove(thePlay.bone());
        return thePlay;
    }

    protected dominoes.Play chooseMove(dominoes.Table table){
        //not implemented yet
        return null;
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

    public void setName(java.lang.String s){
        name=s;
    }

    public java.lang.String getName(){
        return name;
    }


}
