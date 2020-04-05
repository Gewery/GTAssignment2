package Players;

public class GentleAgent extends Player {
    @Override
    public void reset() {

    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) { // returns the second best field
        if (xB >= xA && xA >= xC || xC >= xA && xA >= xB)
            return 1;
        else if (xA >= xB && xB >= xC || xC >= xB && xB >= xA)
            return 2;
        else
            return 3;
    }
}
