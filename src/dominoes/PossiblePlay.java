package dominoes;

import dominoes.Play;
import dominoes.Bone;


/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 17/02/13
 * Time: 17:39
 */
public class PossiblePlay {
    private Play play;
    private boolean flipped = false;
    private int score; //used for computer player routine to score the possible moves to pick a better option
    private static int doubleWeighting = 2; //multiple to apply to weight of bones which are doubles - these are harder to get rid of.

    public PossiblePlay(Bone bone, int end, boolean flip) {
        score = bone.right() + bone.left();
        if (bone.right() == bone.left()) score = score * doubleWeighting;
        flipped = flip;
        play = new Play(bone, end);
    }

    public void flipIfNeeded() {
        //check if the bone needs to be flipped for this play and if so then flip it.
        if (flipped) {
            play.bone().flip();
        }
    }

    public Play getPlay() {
        return play;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int i) {
        score = score + i;
    }


}
