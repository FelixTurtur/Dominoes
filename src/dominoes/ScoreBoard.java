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
    private int round = 1;
    private DominoPlayer player1;
    private DominoPlayer player2;

    private final JLabel roundLabel;
    private final JLabel roundCount;
    private final JLabel player1Name;
    private final JLabel player1Score;
    private final JLabel player2Name;
    private final JLabel player2Score;

    public ScoreBoard() {
        Font scoreFont = new Font("Scores",Font.ITALIC, 18);
        roundLabel = new JLabel();
        roundLabel.setText("Round:");
        roundLabel.setFont(scoreFont);
        roundCount = new JLabel("",JLabel.CENTER);
        roundCount.setText("0");
        roundCount.setFont(scoreFont);
        player1Name = new JLabel();
        player1Name.setFont(scoreFont);
        player1Score = new JLabel("",JLabel.CENTER);
        player1Score.setFont(scoreFont);
        player2Name = new JLabel();
        player2Name.setFont(scoreFont);
        player2Score = new JLabel("",JLabel.CENTER);
        player2Score.setFont(scoreFont);

        this.setLayout(new GridLayout(3, 2, 0, 8));
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

    public void incrementRound() {
        this.round++;
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
}
