public class PlayerRecord {

    String name;
    PlayerPosition position;
    String team_name;
    int games_played;
    int goals_scored;
    int assists;
    int penalties_minutes;
    int shots_on_goal;
    int game_winning_goals;


    public PlayerRecord(String name, PlayerPosition position, String team_name, int games_played, int goals_scored, int assists, int penalties_minutes, int shots_on_goal, int game_winning_goals) {

        this.name = name;
        this.position = position;
        this.team_name = team_name;
        this.games_played = games_played;
        this.goals_scored = goals_scored;
        this.assists = assists;
        this.penalties_minutes = penalties_minutes;
        this.shots_on_goal = shots_on_goal;
        this.game_winning_goals = game_winning_goals;

    }

    public String toString() {
        return String.format("""
            name = %s
            position = %s
            team_name = %s
            games_played = %s
            goals_scored = %s
            assists = %s
            penalties_minutes = %s
            shots_on_goal = %s
            game_winning_goals = %s
            """,
            name,
            position,
            team_name,
            games_played,
            goals_scored,
            assists,
            penalties_minutes,
            shots_on_goal,
            game_winning_goals
                );
    }

}
