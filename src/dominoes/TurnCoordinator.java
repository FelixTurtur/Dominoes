/*
 * Dominoes implementation by Timothy Baldock, Abbie James and Nick Mackin
 * MSc Computer Science
 * Submitted 31st March 2013
 */

package dominoes;

import dominoes.players.Player;

/**
 * Created with IntelliJ IDEA.
 * User: timothy
 * Date: 18/03/2013
 * Time: 23:30
 * Description: This acts as an observer for certain events from Player and the UI elements
 */

public interface TurnCoordinator {
    // Interface for turns
    // Called by PlayerHandPanel when player selects a bone to play
    void nextMoveBoneSelected(Bone bone);

    // Called by TablePanel when player selects play position
    void nextMovePosition(int position);

    // Called by Player when it requires a move from the UI
    void getPlayerMove(Player player, PlayWrapperCubbyHole nextMove);

    // Called to indicate the start of the AI's turn to the UI
    void aiMoveBegins(Player player);

    // Called to indicate the end of the AI's turn to the UI
    void aiMoveEnds();

    // Indicate that the player wishes to draw a bone from the boneyard (or pass if there are none)
    void drawOrPass();

    // Indicates that the display of the boneYard needs to be updated due to it changing
    void updateBoneYard(BoneYard boneYard);
}
