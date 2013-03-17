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

    protected void detectLifeform() {
        isHuman = false;
    }

    protected dominoes.Play chooseMove(dominoes.Table table){
        Play thePlay=null;
        List<PossiblePlay> legalMoves=findLegalMoves(table);

        //for now just go with first possible move.
        if (legalMoves.size()>0){
            thePlay=examineMoveScores(legalMoves);
        }

        // Pause so that we can watch the computer play
        try {
            Thread.sleep(200);
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

    private Play examineMoveScores(List<PossiblePlay> legalMoves){
        Play thePlay;
        int highScore=0;
        int bestPlay=0;

        for (int i=0; i<legalMoves.size();i++){
            int theScore=legalMoves.get(i).getScore();
            if ( theScore>highScore){
                highScore=theScore;
                bestPlay=i;
            }
        }
        legalMoves.get(bestPlay).flipIfNeeded();
        thePlay=legalMoves.get(bestPlay).getPlay();

        return thePlay;
    }
}
