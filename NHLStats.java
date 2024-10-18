/*Node class
Defines a Node object to build a Linked List
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NHLStats<T>{
    private T data;
    private NHLStats<T> next;
    
    public NHLStats(T data, NHLStats<T> next){
        this.data = data;
        this.next = next;
    }
    
    public T getData(){
        return data;
    }
    
    public NHLStats<T> getNext(){
        return this.next;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public void setNext(NHLStats<T> next){
        this.next = next;
    }

    /* Method for getting the player with the most goals and assists
     * Reads through each value in the linked list after this node (you should probably call this on the head node)
     * */
    public static void get_most_goals_and_assists(NHLStats<PlayerRecord> head) {

        NHLStats<PlayerRecord> current = head;

        int max_goals_and_assists = -1;
        ArrayList<PlayerRecord> max_node = null;

        // Gets the max values
        while (current.getNext() != null) {

            PlayerRecord pr = current.getData();
            int current_goals_and_assists = pr.goals_scored + pr.assists;

            // Resetting the array
            if (max_node == null || max_goals_and_assists > current_goals_and_assists) {
                max_node = new ArrayList<PlayerRecord>();
                max_node.add(pr);
                max_goals_and_assists = current_goals_and_assists;
            } else if (max_goals_and_assists == current_goals_and_assists) {
                max_node.add(pr);
            }

            current = current.getNext();

        }

        // Checks if null
        if (max_node == null) {
            System.out.println("Couldn't find player!");
            return;
        }

        // Displays output
        System.out.println("Players with the highest points and their teams:");
        for (int i = 0; i < max_node.size(); i++) {
            System.out.println(max_node.get(i));
        }

    }

    /* Method for getting the player with the most penalties
     * Reads through each value in the linked list after this node (you should probably call this on the head node)
     * */
    public static void get_most_aggressive(NHLStats<PlayerRecord> head) {

        NHLStats<PlayerRecord> current = head;

        int max_penalties = -1;
        ArrayList<PlayerRecord> max_node = null;

        // Gets the max values
        while (current.getNext() != null) {

            PlayerRecord pr = current.getData();
            int current_penalties = pr.penalties_minutes;

            // Resetting the array
            if (max_node == null || max_penalties > current_penalties) {
                max_node = new ArrayList<PlayerRecord>();
                max_node.add(pr);
                max_penalties = current_penalties;
            } else if (max_penalties == current_penalties) {
                max_node.add(pr);
            }

            current = current.getNext();

        }

        // Checks if null
        if (max_node == null) {
            System.out.println("Couldn't find player!");
            return;
        }

        // Displays output
        System.out.println("Most aggressive players, their teams and their positions:");
        for (int i = 0; i < max_node.size(); i++) {
            System.out.println(max_node.get(i).toStringWithPosition());
        }

    }

    /* Method for getting the player with the most game winning goals
     * Reads through each value in the linked list after this node (you should probably call this on the head node)
     * */
    public static void get_most_game_winning_goals(NHLStats<PlayerRecord> head) {

        NHLStats<PlayerRecord> current = head;

        int max_game_winning_goals = -1;
        ArrayList<PlayerRecord> max_node = null;

        // Gets the max values
        while (current.getNext() != null) {

            PlayerRecord pr = current.getData();
            int current_game_winning_goals = pr.game_winning_goals;

            // Resetting the array
            if (max_node == null || max_game_winning_goals > current_game_winning_goals) {
                max_node = new ArrayList<PlayerRecord>();
                max_node.add(pr);
                max_game_winning_goals = current_game_winning_goals;
            } else if (max_game_winning_goals == current_game_winning_goals) {
                max_node.add(pr);
            }

            current = current.getNext();

        }

        // Checks if null
        if (max_node == null) {
            System.out.println("Couldn't find player!");
            return;
        }

        // Displays output
        System.out.println("Most valuable players and their teams:");
        for (int i = 0; i < max_node.size(); i++) {
            System.out.println(max_node.get(i));
        }

    }

    /* Method for getting the player with the most promising players
     * Reads through each value in the linked list after this node (you should probably call this on the head node)
     * */
    public static void get_most_promising_players(NHLStats<PlayerRecord> head) {

        NHLStats<PlayerRecord> current = head;

        int max_shot_on_goal = -1;
        ArrayList<PlayerRecord> max_node = null;

        // Gets the max values
        while (current.getNext() != null) {

            PlayerRecord pr = current.getData();
            int current_shot_on_goal = pr.shots_on_goal;

            // Resetting the array
            if (max_node == null || max_shot_on_goal > current_shot_on_goal) {
                max_node = new ArrayList<PlayerRecord>();
                max_node.add(pr);
                max_shot_on_goal = current_shot_on_goal;
            } else if (max_shot_on_goal == current_shot_on_goal) {
                max_node.add(pr);
            }

            current = current.getNext();

        }

        // Checks if null
        if (max_node == null) {
            System.out.println("Couldn't find player!");
            return;
        }

        // Displays output
        System.out.println("Most valuable players and their teams:");
        for (int i = 0; i < max_node.size(); i++) {
            System.out.println(max_node.get(i));
        }

    }

    /* Method for getting the team with the most penalty minutes
     * Reads through each value in the linked list after this node (you should probably call this on the head node)
     * */
    public static void get_team_with_most_penalty_minutes(NHLStats<PlayerRecord> head) {

        Map<String, Integer> team_penalty_minutes = new HashMap<String, Integer>();

        NHLStats<PlayerRecord> current = head;
        int max_penalty_minutes = 0;

        while (current.getNext() != null) {

            PlayerRecord pr = current.getData();

            // Initializes the updated value
            int current_minutes = pr.penalties_minutes;

            // Checks if the value exists
            if (team_penalty_minutes.containsKey(pr.team_name)) {
                current_minutes += team_penalty_minutes.get(pr.team_name);
            }

            // Changes value
            team_penalty_minutes.put(pr.team_name, current_minutes);

            // Changes max
            if (max_penalty_minutes < current_minutes) {
                max_penalty_minutes = current_minutes;
            }

            current = current.getNext();

        }

        System.out.println("Teams that had the most number of penalty minutes:");
        for (String k: team_penalty_minutes.keySet()) {
            int penalty_minutes = team_penalty_minutes.get(k);
            if (penalty_minutes == max_penalty_minutes) {
                System.out.println(String.format("\tTeam: %s\tPenalty Minutes: %s", k, penalty_minutes));
            }
        }

    }

    /* Method for getting the team with the most game winning goals
     * Reads through each value in the linked list after this node (you should probably call this on the head node)
     * */
    public static void get_team_with_most_game_winning_goals(NHLStats<PlayerRecord> head) {

        Map<String, Integer> team_game_winning_goals = new HashMap<String, Integer>();

        NHLStats<PlayerRecord> current = head;
        int max_winning_goals = 0;

        while (current.getNext() != null) {

            PlayerRecord pr = current.getData();

            // Initializes the updated value
            int current_winning_goals = pr.game_winning_goals;

            // Checks if the value exists
            if (team_game_winning_goals.containsKey(pr.team_name)) {
                current_winning_goals += team_game_winning_goals.get(pr.team_name);
            }

            // Changes value
            team_game_winning_goals.put(pr.team_name, current_winning_goals);

            // Changes max
            if (max_winning_goals < current_winning_goals) {
                max_winning_goals = current_winning_goals;
            }

            current = current.getNext();

        }

        System.out.println("Teams that had the most number of game winning goals:");
        for (String k: team_game_winning_goals.keySet()) {
            int team_winning_goals = team_game_winning_goals.get(k);
            if (team_winning_goals  == max_winning_goals) {
                System.out.println(String.format("\tTeam: %s\tGame Winning Goals: %s", k, team_winning_goals));
            }
        }

    }

}
