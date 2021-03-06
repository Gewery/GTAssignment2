package Tests;
import Players.*;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class Tests {
    // (more tests are described in the report)
    @Test
    public void tournamentDanilKabirovCodeVSDanilKabirovCode() {
        ArrayList<Player> players = new ArrayList<>();
        // initialize the ArrayList by players that will play the tournament
        players.add(new DanilKabirovCode());
        players.add(new DanilKabirovCode());

        ArrayList<Double> results = runTournament(players, 100); // run the tournament 100 times

        System.out.println("Scores:");
        for (int i = 0; i < players.size(); i++) { // print the results
            System.out.println(players.get(i).getClass() + " : " + results.get(i));
        }

        Assertions.assertEquals(2, results.size()); // right size array
        Assertions.assertTrue(results.get(0) > 0); // both of the players have more than 0 score
        Assertions.assertTrue(results.get(1) > 0);
    }

    @Test
    public void tournamentMaxXAgentVSMaxXAgent() {
        ArrayList<Player> players = new ArrayList<>();
        // initialize the ArrayList by players that will play the tournament
        players.add(new MaxXAgent());
        players.add(new MaxXAgent());

        ArrayList<Double> results = runTournament(players, 100); // run the tournament 100 times

        System.out.println("Scores:");
        for (int i = 0; i < players.size(); i++) { // print the results
            System.out.println(players.get(i).getClass() + " : " + results.get(i));
        }

        Assertions.assertEquals(2, results.size()); // right size array
        Assertions.assertTrue(results.get(0) == 0); // both of the players have 0 score
        Assertions.assertTrue(results.get(1) == 0);
    }

    @Test
    public void tournamentAllAgents() {
        ArrayList<Player> players = new ArrayList<>();
        // initialize the ArrayList by players that will play the tournament
        players.add(new DanilKabirovCode());
        players.add(new AlwaysFirstAgent());
        players.add(new CopyCatAgent());
        players.add(new RandomAgent());
        players.add(new HistoryBasedAgent());
        players.add(new MaxXAgent());
        players.add(new GentleAgent());
        players.add(new AdvancedRandomAgent());

        ArrayList<Double> results = runTournament(players, 100); // run the tournament 100 times

        System.out.println("Scores:");
        for (int i = 0; i < players.size(); i++) { // print the results
            System.out.println(players.get(i).getClass() + " : " + results.get(i));
        }

        Assertions.assertEquals(8, results.size()); // right size array
        Assertions.assertTrue(results.get(0) > 0); // DanilKabirovCode has more than 0 score
        Assertions.assertTrue(results.get(1) == 0.0); // AlwaysFirstAgent has 0 score
    }

    @Test
    public void tournamentMaxXAgentVSDanilKabirovCode() {
        ArrayList<Player> players = new ArrayList<>();
        // initialize the ArrayList by players that will play the tournament
        players.add(new DanilKabirovCode());
        players.add(new MaxXAgent());

        ArrayList<Double> results = runTournament(players, 100); // run the tournament 100 times

        System.out.println("Scores:");
        for (int i = 0; i < players.size(); i++) { // print the results
            System.out.println(players.get(i).getClass() + " : " + results.get(i));
        }

        Assertions.assertEquals(2, results.size()); // right size array
        Assertions.assertTrue(results.get(0) > 0); // DanilKabirovCode has more than 0 score
        Assertions.assertTrue(results.get(0) < results.get(1)); // DanilKabirovCode has less than MaxXAgent
    }

    @Test
    public void tournament2MaxXAgentVSDanilKabirovCode() {
        ArrayList<Player> players = new ArrayList<>();
        // initialize the ArrayList by players that will play the tournament
        players.add(new DanilKabirovCode());
        players.add(new MaxXAgent());
        players.add(new MaxXAgent());

        ArrayList<Double> results = runTournament(players, 100); // run the tournament 100 times

        System.out.println("Scores:");
        for (int i = 0; i < players.size(); i++) { // print the results
            System.out.println(players.get(i).getClass() + " : " + results.get(i));
        }

        Assertions.assertEquals(3, results.size()); // right size array
        Assertions.assertTrue(results.get(0) > 0); // DanilKabirovCode has more than 0 score
        Assertions.assertTrue(results.get(0) > results.get(1) && results.get(0) > results.get(2)); // DanilKabirovCode has more than both MaxXAgents
    }

    @Test
    public void tournamentDanilKabirovCodeVSAdvancedRandomAgent() {
        ArrayList<Player> players = new ArrayList<>();
        // initialize the ArrayList by players that will play the tournament
        players.add(new DanilKabirovCode());
        players.add(new AdvancedRandomAgent());

        ArrayList<Double> results = runTournament(players, 100); // run the tournament 100 times

        System.out.println("Scores:");
        for (int i = 0; i < players.size(); i++) { // print the results
            System.out.println(players.get(i).getClass() + " : " + results.get(i));
        }

        Assertions.assertEquals(2, results.size()); // right size array
        Assertions.assertTrue(results.get(0) > 0); // DanilKabirovCode has more than 0 score
        Assertions.assertTrue(results.get(0) > results.get(1)); // DanilKabirovCode has more than AdvancedRandomAgent
    }

    @Test
    public void tournamentDanilKabirovCodeVSAdvancedRandomAgentVSMaxXAgent() {
        ArrayList<Player> players = new ArrayList<>();
        // initialize the ArrayList by players that will play the tournament
        players.add(new DanilKabirovCode());
        players.add(new MaxXAgent());
        players.add(new AdvancedRandomAgent());

        ArrayList<Double> results = runTournament(players, 100); // run the tournament 100 times

        System.out.println("Scores:");
        for (int i = 0; i < players.size(); i++) { // print the results
            System.out.println(players.get(i).getClass() + " : " + results.get(i));
        }

        Assertions.assertEquals(3, results.size()); // right size array
        Assertions.assertTrue(results.get(0) > 0); // DanilKabirovCode has more than 0 score
        Assertions.assertTrue(results.get(0) > results.get(2)); // DanilKabirovCode has score more than AdvancedRandom
        Assertions.assertTrue(results.get(0) < results.get(1)); // DanilKabirovCode has score less than MaxXAgent
    }

    final static int NUMBER_OF_ROUNDS = 10;

    /**
     * Calculation of vegetation growth function
     * @param x
     * @return value of given function
     */
    static double f(int x) {
        return 10 * Math.exp(x) / (1 + Math.exp(x));
    }

    /**
     * Run one game between 2 players (NUMBER_OF_ROUNDS rounds)
     * @param a first player
     * @param b second player
     * @return Pair (Score of the first player, Score of the 2nd player)
     */
    static Pair<Double, Double> runOneGame(Player a, Player b) {
        a.reset(); // reset both players
        b.reset();
        int[] x = new int[4]; // init an array of X for each field
        int lastMoveA = 0, lastMoveB = 0; // last move of each player
        double scoreA = 0, scoreB = 0; // score of each player
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            int moveA = a.move(lastMoveB, x[1], x[2], x[3]); // take a move
            int moveB = b.move(lastMoveA, x[1], x[2], x[3]);
            lastMoveA = moveA; // remember moves for the next round
            lastMoveB = moveB;

            if (moveA != moveB) { // if Moose chose different fields - add corresponding scores
                scoreA += f(x[moveA]) - f(0);
                scoreB += f(x[moveB]) - f(0);
            }

            for (int j = 1; j <= 3; j++)
                if (j != moveA && j != moveB) // if jth field wasn't chosen
                    x[j] += 1; // grow the vegetation on this
                else
                    x[j] = Math.max(0, x[j] - 1); // decrease the X by 1 to the minimum of 0
        }

        return new Pair<>(scoreA, scoreB); // return both scores
    }

    /**
     * Run the tournament N times
     * @param players ArrayList of players
     * @param N How many times the tournament has to be runned
     * @return ArrayList of scores of each player
     */
    static ArrayList<Double> runTournament(ArrayList<Player> players, int N) {
        ArrayList<Double> results = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) // initialize the scores ArrayList by 0
            results.add(0.0);
        for (int k = 0; k < N; k++) { // run the tournament N times
            for (int i = 0; i < players.size(); i++) {
                for (int j = i + 1; j < players.size(); j++) {
                    Pair<Double, Double> result = runOneGame(players.get(i), players.get(j)); // play the game between ith and jth player
                    results.set(i, results.get(i) + result.getKey()); // update the results
                    results.set(j, results.get(j) + result.getValue());
                }
            }
        }

        return results; // return ArrayList with the corresponding scores
    }
}
