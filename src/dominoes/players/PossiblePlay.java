package dominoes.players;

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
    private boolean flipped=false;


    PossiblePlay(Bone bone,int end ,boolean flip){
        flipped=flip;
        play=new Play(bone,end);
    }

    public void flipIfNeeded(){
        //check if the bone needs to be flipped for this play and if so then flip it.
        if (flipped) {
            play.bone().flip();
        };
    }

    public Play getPlay(){
        return play;
    }

}
