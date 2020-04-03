package Players;

public class HistoryBasedAgent extends Player {
    int counter;
    int[] lastAccessed;

    @Override
    public void reset() {
        counter = 0;
        lastAccessed = new int[4];
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        lastAccessed[opponentLastMove] = counter;
        int min = counter + 1;
        int minind = -1;
        for (int i = 1; i <= 3; i++) {
            if (lastAccessed[i] < min) {
                min = lastAccessed[i];
                minind = i;
            }
        }
        counter += 1;
        lastAccessed[minind] = counter;
        return minind;
    }
}
