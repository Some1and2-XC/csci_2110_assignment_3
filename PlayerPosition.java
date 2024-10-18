/*
 * An enum that represents the position a player plays
*/
public enum PlayerPosition {
    C,
    LW,
    RW,
    LD,
    RD,
    D, // wasn't in the instructions but was in the dataset
    G,
    ;

    public static PlayerPosition fromString(String in_str) {

        return switch(in_str) {
            case "C" -> PlayerPosition.C;
            case "LW" -> PlayerPosition.LW;
            case "RW" -> PlayerPosition.RW;
            case "LD" -> PlayerPosition.LD;
            case "RD" -> PlayerPosition.RD;
            case "D" -> PlayerPosition.D;
            case "G" -> PlayerPosition.G;

            default -> throw new IllegalArgumentException("Can't find player position!! from: " + in_str);
        };

    }

}
