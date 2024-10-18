import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {

        System.out.println("Hello Wrld");

        // Gets an array list of the inputs of the file (line by line)
        ArrayList<String> v = read_file("nhlstats.txt");

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

        // Reads through all the values and displays them
        while (player_position.getNext() != null) {

            System.out.println(player_position.getData().toString());
            player_position = player_position.getNext();

        }

    }

    /*
     * Method for reading from a file, returns new an ArrayList of Strings which each element is separated by the line number.
    */
    public static ArrayList<String> read_file(String filename) {

        ArrayList<String> out_str = new ArrayList<String>();

        File my_file = new File(filename);
        Scanner sc;
        try {
            sc = new Scanner(my_file);

            while (sc.hasNextLine()) {
                out_str.add(sc.nextLine());
            }

            sc.close();

        } catch (Exception e) { }

        return out_str;

    }

    public static PlayerRecord parse_player_record(String input_str) {

        Scanner sc = new Scanner(input_str);

        // System.out.println(sc.next());
        PlayerRecord player_out = new PlayerRecord(
            sc.next(),
            parse_player_position(sc.next()),
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

    /*
     * Method for parsing a `PlayerPosition` from a string with the value
    */
    public static PlayerPosition parse_player_position(String input_str) {

        return switch(input_str) {
            case "C" -> PlayerPosition.C;
            case "LW" -> PlayerPosition.LW;
            case "RW" -> PlayerPosition.RW;
            case "LD" -> PlayerPosition.LD;
            case "RD" -> PlayerPosition.RD;
            case "D" -> PlayerPosition.D;
            case "G" -> PlayerPosition.G;

            default -> throw new IllegalArgumentException("Can't find player position!! from: " + input_str);
        };

    }

}
