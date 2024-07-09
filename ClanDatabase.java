import java.util.ArrayList;

public class ClanDatabase {

    private ArrayList<Clan> clans = new ArrayList<>();

    public ArrayList<Clan> getClans() {
        return clans;
    }

    public void setClans(ArrayList<Clan> clans) {
        this.clans = clans;
    }
    public boolean clanExists(String name){
        for(Clan clan: clans){
            if(clan.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
