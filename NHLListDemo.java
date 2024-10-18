import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class NHLListDemo {
    public static void main(String[] args) {

        // Gets an array list of the inputs of the file (line by line)
        String filename;
        if (true) {
            filename = "nhlstats.txt";
        } else {
            Scanner sc = new Scanner(System.in);
            filename = sc.next();
            sc.close();
        }

        ArrayList<String> v = read_file(filename);

        // Initializes the head node as well as `player_position`
        NHLStats<PlayerRecord> head = new NHLStats<PlayerRecord>(parse_player_record(v.get(0)), null);
        NHLStats<PlayerRecord> player_position = head;

        // Adds all the values from `v` to the linked list (I would never use a linked list like this)
        for (int i = 1; i < v.size(); i++) {

            PlayerRecord pr = parse_player_record(v.get(i)); // creates an object for the next value
            player_position.setNext(new NHLStats<PlayerRecord>(pr, null)); // Sets that object to come after the current object
            player_position = player_position.getNext(); // changes the current position being analyzed to the previously parse object

        }

        player_position = head; // resets the `player_position` to the start node

        NHLStats.get_most_goals_and_assists(head);
        System.out.println();
        NHLStats.get_most_aggressive(head);
        System.out.println();
        NHLStats.get_most_game_winning_goals(head);
        System.out.println();
        NHLStats.get_most_promising_players(head);
        System.out.println();
        NHLStats. get_team_with_most_penalty_minutes(head);
        System.out.println();
        NHLStats.get_team_with_most_game_winning_goals(head);

    }

    /*
     * Method for reading from a file, returns new an ArrayList of Strings which each element is separated by the line number.
    */
    public static ArrayList<String> read_file(String filename) {

        ArrayList<String> out_str = new ArrayList<String>();

        File my_file = new File(filename);
        Scanner sc;
        // Tries to initialize scanner
        try { sc = new Scanner(my_file); }
        catch (Exception e) {
            System.out.println("Can't find file! Filename: " + my_file);
            // not a resource leak, this only runs if sc isn't initialized
            // sc.close(); // try uncommenting this if you don't believe me
            return out_str;
        }

        // Reads all the lines
        while (sc.hasNextLine()) {
            out_str.add(sc.nextLine());
        }
        sc.close();
        return out_str;

    }

    public static PlayerRecord parse_player_record(String input_str) {

        Scanner sc = new Scanner(input_str);

        // System.out.println(sc.next());
        PlayerRecord player_out = new PlayerRecord(
            sc.next(),
            PlayerPosition.fromString(sc.next()),
            sc.next(),
            sc.nextInt(),
            sc.nextInt(),
            sc.nextInt(),
            sc.nextInt(),
            sc.nextInt(),
            sc.nextInt()
            );

        sc.close();

        return player_out;
    }

}
