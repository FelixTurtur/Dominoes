package dominoes.players;

import dominoes.Play;


/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 21:33
 */

public class ComputerPlayer extends Player {

    public dominoes.Play makePlay(dominoes.Table table) throws dominoes.CantPlayException{


        //for now just go with first possible move.
        Play thePlay=null;
        for (int i=0; i<hand.size() && thePlay==null;i++){
            if (hand.get(i).right()== table.left()){
                hand.get(i).flip();
                thePlay = new Play(hand.get(i),thePlay.LEFT);
                }
            if (hand.get(i).right()== table.right()){
                thePlay = new Play(hand.get(i),thePlay.RIGHT);
            }
            if (hand.get(i).left()== table.right()){
                hand.get(i).flip();
                thePlay = new Play(hand.get(i),thePlay.RIGHT);
            }
            if (hand.get(i).left()== table.left()){
                thePlay = new Play(hand.get(i),thePlay.LEFT);
            }
        }


        // Pause so that we can watch the computer play
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
        }



        if (thePlay==null) throw new dominoes.CantPlayException();

        // remove the bone being played from player's hand
        hand.remove(thePlay.bone());



        return thePlay;
    }


}
