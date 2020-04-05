package Players;

public class MaxXAgent extends Player {
    @Override
    public void reset() {

    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        if (xA >= xB && xA >= xC) // return the best field
            return 1;
        else if (xB >= xA && xB >= xC)
            return 2;
        else
            return 3;
    }
}
