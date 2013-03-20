package dominoes;

import dominoes.players.DominoPlayer;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 20/03/2013
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */
public class ScoreBoard extends JPanel {
    private int round = 0;
    private DominoPlayer player1;
    private DominoPlayer player2;

    private final JTextPane roundLabel;
    private final JTextPane roundCount;
    private final JTextPane player1Name;
    private final JTextPane player1Score;
    private final JTextPane player2Name;
    private final JTextPane player2Score;

    public ScoreBoard() {
        this.roundLabel = new JTextPane();
        this.roundLabel.setText("Round:");
        this.roundCount = new JTextPane();
        this.roundCount.setText("0");
        this.player1Name = new JTextPane();
        this.player1Score = new JTextPane();
        this.player2Name = new JTextPane();
        this.player2Score = new JTextPane();

        this.setLayout(new GridLayout(3, 2, 10, 10));
        this.add(this.roundLabel);
        this.add(this.roundCount);
        this.add(this.player1Name);
        this.add(this.player1Score);
        this.add(this.player2Name);
        this.add(this.player2Score);

        updateFields();
    }

    public void reset() {
        this.player1 = null;
        this.player1 = null;
        this.round = 0;
    }

    public void setPlayers(DominoPlayer[] players) {
        this.player1 = players[0];
        this.player2 = players[1];
        updateFields();
    }

    public void setRound(int round) {
        this.round = round;
        updateFields();
    }

    private void updateFields() {
        this.roundCount.setText(Integer.toString(this.round));
        if (this.player1 != null) {
            this.player1Name.setText(this.player1.getName());
            this.player1Score.setText(Integer.toString(this.player1.getPoints()));
        } else {
            this.player1Name.setText("Player 1");
            this.player1Score.setText("N/A");
        }
        if (this.player2 != null) {
            this.player2Name.setText(this.player2.getName());
            this.player2Score.setText(Integer.toString(this.player2.getPoints()));
        } else {
            this.player2Name.setText("Player 2");
            this.player2Score.setText("N/A");
        }
        validate();
    }
    // Shows current round and scores for both players
}
