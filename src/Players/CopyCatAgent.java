package Players;

public class CopyCatAgent extends Player {
    @Override
    public void reset() {

    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        return Math.max(1, opponentLastMove); // copy the last move of its opponent. If it the first round - choose 1st field
    }
}
