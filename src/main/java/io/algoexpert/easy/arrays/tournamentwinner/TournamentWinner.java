package io.algoexpert.easy.arrays.tournamentwinner;

import java.util.*;

public class TournamentWinner {

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * We are going to traverse the array, then we are going to get which is the winner team
     * after we get the winner team, we are going to sum 3 points for the winner in the hashmap
     * by using merge function
     * Then we are going to compare which has the highest score and store it in winner variable
     * @param competitions
     * @param results
     * @return
     */
    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> scores = new HashMap<String, Integer>();
        String winner = "";
        for (int i = 0; i < competitions.size(); i++) {
            String team = competitions.get(i).get(results.get(i) == 0 ? 1 : 0);
            scores.merge(team, 3, Integer::sum);
            winner = scores.get(team) > scores.getOrDefault(winner, 0) ? team : winner;
        }
        return winner;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> competitions = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add("HTML");
                add("C#");
            }});
            add(new ArrayList<>() {{
                add("C#");
                add("Python");
            }});
            add(new ArrayList<>() {{
                add("Python");
                add("HTML");
            }});
        }};

        ArrayList<Integer> results = new ArrayList<>() {{
            add(0);
            add(0);
            add(1);
        }};
        System.out.println(tournamentWinner(competitions, results));
    }
}
