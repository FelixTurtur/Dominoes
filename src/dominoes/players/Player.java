package dominoes.players;

import dominoes.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 21:54
 */
public class Player implements DominoPlayer {
    private String name;
    protected TurnCoordinator turnCoordinator;
    private int points = 0;
    protected List<Bone> hand = new LinkedList<Bone>();

    public CubbyHole nextMove = new CubbyHole();

    public Player(String name, TurnCoordinator turnCoordinator) {
        this.name = name;
        this.turnCoordinator = turnCoordinator;
    }


    // Implementation of DominoPlayer interface
    public dominoes.Play makePlay(dominoes.Table table) throws dominoes.CantPlayException {
        Play thePlay = chooseMove(table);
        if (thePlay == null) throw new dominoes.CantPlayException();
        hand.remove(thePlay.bone());
        return thePlay;
    }

    public void takeBack(dominoes.Bone bone) {
        hand.add(bone);
    }

    public void draw(dominoes.BoneYard boneYard) {
        Bone newBone = boneYard.draw();
        if (newBone != null) {
            hand.add(newBone);
        }
    }

    public int numInHand() {
        return hand.size();
    }

    protected dominoes.Play chooseMove(dominoes.Table table) {
        // Ask for a move to be made through the UI
        turnCoordinator.getPlayerMove(this, nextMove);
        // This will block until the other thread puts something here for us to retrieve
        return (Play) nextMove.get();
    }

    public dominoes.Bone[] bonesInHand() {
        Bone[] b = hand.toArray(new Bone[0]);
        return b;
    }

    public void newRound() {
        hand.clear();
    }

    public void setPoints(int i) {
        points = i;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }
}
