import Players.*;
import javafx.util.Pair;
import java.util.ArrayList;

public class Main {
    final static int NUMBER_OF_ROUNDS = 10;

    static double f(int x) {
        return 10 * Math.exp(x) / (1 + Math.exp(x));
    }

    static Pair<Double, Double> runOneGame(Player a, Player b) {
        a.reset();
        b.reset();
        int[] x = new int[4];
        int lastMoveA = 0, lastMoveB = 0;
        double scoreA = 0, scoreB = 0;
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            int moveA = a.move(lastMoveB, x[1], x[2], x[3]);
            int moveB = b.move(lastMoveA, x[1], x[2], x[3]);
            lastMoveA = moveA;
            lastMoveB = moveB;

            if (moveA != moveB) {
                scoreA += f(x[moveA]) - f(0);
                scoreB += f(x[moveB]) - f(0);
            }

            for (int j = 1; j <= 3; j++)
                if (j != moveA && j != moveB)
                    x[j] += 1;
                else
                    x[j] = Math.max(0, x[j] - 1);
        }

        return new Pair<>(scoreA, scoreB);
    }

    static ArrayList<Double> runTournament(ArrayList<Player> players, int N) {
        ArrayList<Double> results = new ArrayList<>();
        for (int i = 0; i < players.size(); i++)
            results.add(0.0);
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < players.size(); i++) {
                for (int j = i + 1; j < players.size(); j++) {
                    Pair<Double, Double> result = runOneGame(players.get(i), players.get(j));
                    results.set(i, results.get(i) + result.getKey());
                    results.set(j, results.get(j) + result.getValue());
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
//        players.add(new CopyCatAgent());
//        players.add(new RandomAgent());
//        players.add(new AlwaysFirstAgent());
//        players.add(new HistoryBasedAgent());
        players.add(new MaxXAgent());
//        players.add(new GentleAgent());
        players.add(new AdvancedRandomAgent());
        players.add(new AdvancedHistoryBasedAgent());

        ArrayList<Double> results = runTournament(players, 100);

        System.out.println("Scores:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getClass() + " : " + results.get(i));
        }
    }
}
