package dominoes.players;

public interface DominoPlayer {
    dominoes.Play makePlay(dominoes.Table table) throws dominoes.CantPlayException;

    void takeBack(dominoes.Bone bone);

    void draw(dominoes.BoneYard boneYard);

    int numInHand();

    dominoes.Bone[] bonesInHand();

    void newRound();

    void setPoints(int i);

    int getPoints();

    void setName(java.lang.String s);

    java.lang.String getName();
}