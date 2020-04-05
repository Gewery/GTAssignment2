package Players;
import java.util.Random;

public class AdvancedRandomAgent extends Player {
    static Random rn = new Random();
    @Override
    public void reset() {

    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
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
