import java.util.ArrayList;

public class Clan {

    ClanDatabase cdb = new ClanDatabase();
    private ArrayList<User> members = new ArrayList<User>();
    private String code, name, password;
    private int points, losses, wins, ties, total_games;
    private User boss;

    Clan(String name, User boss) {
        this.name = name;
        this.boss = boss;
        this.code = encoder(name);
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
        this.total_games = 0;
        this.members.add(boss);
    }

    private String encoder(String name) {
        String res = "";
        // Convert the string to an array of characters
        char[] asciiArray = name.toCharArray();

        // Print the ASCII values for each character
        for (char ch : asciiArray) {
            res += ((int) ch);
        }
        return res;
    }


    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getTotal_games() {
        return total_games;
    }

    public void setTotal_games(int total_games) {
        this.total_games = total_games;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (cdb.clanExists(name))
            this.name = name;
    }


    public User getBoss() {
        return boss;
    }

    public void setBoss(User boss) {
        this.boss = boss;
    }
}
