package Players;

public abstract class Player {
    public abstract void reset();
    public abstract int move(int opponentLastMove, int xA, int xB, int xC);
}