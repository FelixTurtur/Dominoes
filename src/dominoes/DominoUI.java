package dominoes;

public interface DominoUI {
    void display(dominoes.players.DominoPlayer[] dominoPlayers, dominoes.Table table, dominoes.BoneYard boneYard);

    void displayRoundWinner(dominoes.players.DominoPlayer dominoPlayer);

    void displayInvalidPlay(dominoes.players.DominoPlayer dominoPlayer);
}
