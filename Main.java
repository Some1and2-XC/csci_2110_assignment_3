import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {

        System.out.println("Hello Wrld");

        ArrayList<String> v = read_file("nhlstats.txt");

        ArrayList<PlayerRecord> player_positions = new ArrayList<PlayerRecord>();

        for (int i = 0; i < v.size(); i++) {
            player_positions.add(parse_player_record(v.get(i)));
        }

        for (int i = 0; i < player_positions.size(); i++) {
            // System.out.println("" + player_positions.get(i));
            System.out.println("" + player_positions.get(i).goals_scored);
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

    public static PlayerPosition parse_player_position(String input_str) {

        if (input_str == "C") { return PlayerPosition.C; }
        else if (input_str == "LW") { return PlayerPosition.LW; }
        else if (input_str == "RW") { return PlayerPosition.RW; }
        else if (input_str == "LD") { return PlayerPosition.LD; }
        else if (input_str == "RD") { return PlayerPosition.RD; }
        else if (input_str == "G") { return PlayerPosition.G; }
        else {

            System.out.println("Didn't find position?? Defaulting to 'G' from: " + input_str);
            return PlayerPosition.G;


        }

    }

}
