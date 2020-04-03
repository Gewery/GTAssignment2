package Players;

import java.util.Random;

public class RandomAgent extends Player {
    static Random rn = new Random();
    @Override
    public void reset() {

    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        return rn.nextInt(3) + 1;
    }
}
