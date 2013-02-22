package dominoes.players;

import dominoes.Play;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nick
 * Date: 16/02/13
 * Time: 21:33
 */

public class ComputerPlayer extends Player {

    protected dominoes.Play chooseMove(dominoes.Table table){
        Play thePlay=null;
        List<PossiblePlay> legalMoves=findLegalMoves(table);

        //for now just go with first possible move.
        if (legalMoves.size()>0){
            legalMoves.get(0).flipIfNeeded();
            thePlay=legalMoves.get(0).getPlay();
        }

        // Pause so that we can watch the computer play
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
        }

        return thePlay;
    }

     private List<PossiblePlay> findLegalMoves(dominoes.Table table){
         List<PossiblePlay> legalMoves=new LinkedList<PossiblePlay>();
         for (int i=0; i<hand.size();i++){
             if (hand.get(i).right()== table.left()){
                 legalMoves.add(new PossiblePlay(hand.get(i),Play.LEFT, true));
             }
             if (hand.get(i).right()== table.right()){
                 legalMoves.add(new PossiblePlay(hand.get(i),Play.RIGHT,false));
             }
             if (hand.get(i).left()== table.right()){
                 legalMoves.add(new PossiblePlay(hand.get(i),Play.RIGHT,true));
             }
             if (hand.get(i).left()== table.left()){
                 legalMoves.add(new PossiblePlay(hand.get(i), Play.LEFT, false));
             }
         }
         return legalMoves;
     }
}
