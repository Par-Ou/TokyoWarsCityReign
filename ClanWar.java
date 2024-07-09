import java.util.ArrayList;
import java.util.Random;

public class ClanWar extends Game{

    private static ClanWar instance;
    private ArrayList<User> BossClanMembers, opponentClanMembers;
    private Clan userClan, opponentClan;
    ArrayList<DoublePlayer> games;
    private User Boss, currentUser;
    int currentClanWins, opponentClanWins;
    public static ArrayList<Boolean> playedA,playedB;
    public static boolean ongoing;
    public ClanWar(User Boss, Clan clanB) {
        userClan = Boss.getMyClan();
        this.BossClanMembers = Boss.getMyClan().getMembers();
        this.opponentClan = clanB;
        for(int i=0; i<BossClanMembers.size();i++){
            playedA.add(false);
        }
        for(int i=0; i<clanB.getMembers().size();i++){
            playedB.add(false);
        }
        this.Boss = Boss;
        this.opponentClanWins=0;
        this.currentClanWins=0;
        ongoing = true;
    }


    @Override
    public void execute(){

        Random random = new Random();
        int rand=0;
        while(!playedB.get(rand)){
            rand = random.nextInt(opponentClanMembers.size());
        }
        //login second user
        DoublePlayer dbPlayer = new DoublePlayer(currentUser, opponentClanMembers.get(rand));
        dbPlayer.execute();
        if(dbPlayer.getWinner().equals(currentUser)){
            currentClanWins+=1;
        }
        else{
            opponentClanWins+=1;
        }


        clanWarOver();

    }

    public void clanWarOver(){
        if(!(playedA.contains(false) && playedB.contains(false))){
            if(opponentClanWins> currentClanWins){
                System.out.println("Clan "+ opponentClan.getName()+" with code "+ opponentClan.getCode()+ "won!");
                for(User player: opponentClan.getMembers()){
                    player.setCoin(player.getCoin()+ opponentClanWins*100);
                }
            }
            else if(opponentClanWins < currentClanWins){
                System.out.println("Clan "+ userClan.getName()+" with code "+ userClan.getCode()+ "won!");
                for(User player: userClan.getMembers()){
                    player.setCoin(player.getCoin()+ currentClanWins*100);
                }
            }
            else{
                DoublePlayer doublePlayer = new DoublePlayer(userClan.getBoss(), opponentClan.getBoss());
                doublePlayer.execute();
                if(doublePlayer.getWinner().equals(userClan.getBoss())){
                    System.out.println("Clan "+ userClan.getName()+" with code "+ userClan.getCode()+ "won!");
                    for(User player: userClan.getMembers()){
                        player.setCoin(player.getCoin()+ currentClanWins*100);
                    }
                }
                else{
                    System.out.println("Clan "+ opponentClan.getName()+" with code "+ opponentClan.getCode()+ "won!");
                    for(User player: opponentClan.getMembers()){
                        player.setCoin(player.getCoin()+ opponentClanWins*100);
                    }
                }
            }
            ongoing = false;
        }
    }

    public static boolean isClanWarOver(){
        if(playedA.contains(false) && playedB.contains(false)){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean didParticipate(User player){
        return playedA.get(player.getMyClan().getMembers().indexOf(player));
    }

    public User getBoss() {
        return Boss;
    }

    public void setBoss(User boss) {
        Boss = boss;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
//    public static ClanWar getInstance() {
//        if (instance != null) {
//            return instance;
//        }
//
//    }

    public boolean isMember(User player){
        if(BossClanMembers.contains(player) || opponentClanMembers.contains(player)){
            return true;
        }
        else {
            return false;
        }
    }

}
