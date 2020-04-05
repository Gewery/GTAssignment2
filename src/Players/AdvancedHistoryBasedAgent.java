package Players;

import java.util.Random;

public class AdvancedHistoryBasedAgent extends Player {
    static Random rn = new Random();
    private int numberOfRounds = 0;
    private int opponentKindness = 0; // number of rounds in which opponent leaved the best field for us
    private int lastxA, lastxB, lastxC; // X-es on the previous round
    @Override
    public void reset() {
        numberOfRounds = 0;
        opponentKindness = 0;
        lastxA = 0;
        lastxB = 0;
        lastxC = 0;
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        if (opponentLastMove != 0) {
            boolean opponentIsKind = false;
            if (lastxA >= lastxB && lastxA >= lastxC)
                opponentIsKind = opponentLastMove != 1;
            else if (lastxB >= lastxA && lastxB >= lastxC)
                opponentIsKind = opponentLastMove != 2;
            else
                opponentIsKind = opponentLastMove != 3;

            if (opponentIsKind)
                opponentKindness += 1;
            numberOfRounds += 1;
        }

        lastxA = xA;
        lastxB = xB;
        lastxC = xC;

        if (opponentKindness * 2 >= numberOfRounds) { // opponent is kind
            if (xA >= xB && xA >= xC) // take the best
            {
                return 1;
            }
            else if (xB >= xA && xB >= xC) {
                return 2;
            }
            else {
                return 3;
            }
        }
        else { // opponent is not kind
            // do like AdvancedRandomAgent
            if (rn.nextInt(2) == 0) // return the best field
                if (xA >= xB && xA >= xC)
                    return 1;
                else if (xB >= xA && xB >= xC)
                    return 2;
                else
                    return 3;
            else { // return the second best
                if (xB >= xA && xA >= xC || xC >= xA && xA >= xB)
                    return 1;
                else if (xA >= xB && xB >= xC || xC >= xB && xB >= xA)
                    return 2;
                else
                    return 3;
            }
        }
    }
}
