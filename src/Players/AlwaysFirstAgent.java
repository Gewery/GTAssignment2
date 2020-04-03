package Players;

public class AlwaysFirstAgent extends Player {
    @Override
    public void reset() {

    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        return 1;
    }
}
