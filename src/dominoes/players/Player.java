/*
 * Dominoes implementation by Timothy Baldock, Abbie James and Nick Mackin
 * MSc Computer Science
 * Submitted 31st March 2013
 */

package dominoes.players;

import dominoes.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 21:54
 * Description: Interactive player implementation
 */

public class Player implements DominoPlayer {
    private String name;
    protected TurnCoordinator turnCoordinator;
    private int points = 0;
    protected List<Bone> hand = new LinkedList<Bone>();

    // TurnCoordinator used to request move from UI
    public Player(String name, TurnCoordinator turnCoordinator) {
        this.name = name;
        this.turnCoordinator = turnCoordinator;
    }

    // Implementation of DominoPlayer interface
    public Play makePlay(Table table) throws CantPlayException {
        Play thePlay = chooseMove(table);
        if (thePlay == null) throw new CantPlayException();
        hand.remove(thePlay.bone());
        return thePlay;
    }

    public void takeBack(Bone bone) {
        hand.add(bone);
    }

    public void draw(BoneYard boneYard) {
        Bone newBone = boneYard.draw();
        this.turnCoordinator.updateBoneYard(boneYard);
        if (newBone != null) {
            hand.add(newBone);
        }
    }

    public int numInHand() {
        return hand.size();
    }

    protected Play chooseMove(Table table) {
        PlayWrapperCubbyHole nextMove = new PlayWrapperCubbyHole();
        // Ask for a move to be made through the UI
        turnCoordinator.getPlayerMove(this, nextMove);
        // This will block until the other thread puts something here for us to retrieve
        PlayWrapper playWrapper = nextMove.get();

        if (playWrapper.isValid()) {
            return playWrapper.getPlay();
        } else {
            return null;
        }
    }

    public Bone[] bonesInHand() {
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
