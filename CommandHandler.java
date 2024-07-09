import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class CommandHandler {

    Boolean user_logged_in = false;
    String str;

    Pattern pattern1 = Pattern.compile("select card number (\\d+) player (\\d+)");
    Pattern pattern2 = Pattern.compile("placing card number (\\d+) in block (\\d+)");


    ArrayList<Card> player1Owned = new ArrayList<Card>(), player2Owned = new ArrayList<Card>(), compOwned = new ArrayList<>();


    User player1 = new User("Sara", player1Owned );
    User player2 = new User("Helen", player2Owned);

    CommandHandler(){
        for(int i =1;i<51;i++){
            if(i>0){
                player1Owned.add(new Card ("CardRegistered" + Integer.toString(i), 10+((i*2)%91),
                        i%5 +1, player_damage_randomizer(i%5+1), 1000, 1, getCharacter(i%4)));
                player2Owned.add(new Card ("CardRegistered" + Integer.toString(i+30), 10+((2*i*i)%91),
                        (i*i)%5 +1,  player_damage_randomizer((i*i)%5+1), 1000, 1, getCharacter((i*i)%4)));

                compOwned.add(new Card ("CardRegistered" + Integer.toString(i+30), 10+((2*i*i)%91),
                        (i*i)%5 +1,  player_damage_randomizer((i*i)%5+1), 1000, 1, getCharacter((i*i)%4)));

            }
            else{
                //player1Owned.add(new CardThief());
                player1Owned.add(new Heal());
                player1Owned.add(new Shield());
                player1Owned.add(new CopyCard());
                player1Owned.add(new CardThief());
                player1Owned.add(new Buffer());
                player1Owned.add(new MoveDitch());
                player1Owned.add(new Repair());
                player2Owned.add(new Invisibility());
                player2Owned.add(new Debilitate());
                player2Owned.add(new RoundReducer());

                //player2Owned.add(new CardThief());
            }
        }

    }

    private int player_damage_randomizer(int duration) {
        // 10-50
        Random rand = new Random();
        int low = 10 / duration;
        int high = 50 / duration;
        int randomNum = rand.nextInt((high - low) + 1) + low;
        return randomNum * duration;
        //return duration;
    }


    private String getCharacter(int i) {
        return switch (i) {
            case 0 -> "KIM";
            case 1 -> "KAI";
            case 2 -> "PAN";
            default -> "PAR";
        };
    }

    public void handle(String input) {
        str = input.toLowerCase().trim().replaceAll("\\s+"," ");
        System.out.println(str);
//        DoublePlayer game = new DoublePlayer(player1,player2);
//        player1.setOwnedCards(player1Owned);
//        player2.setOwnedCards(player2Owned);
//        int i=0;
//        while(i<20){
//            player1.getDeck().add(player1Owned.get((i*i)%50));
//            player2.getDeck().add(player2Owned.get((i*i)%50));
//            i++;
//        }
//        game.execute();
        Computer computer = new Computer("computer", this.compOwned);
        SinglePlayer singlePlayer = new SinglePlayer(player1, computer);
        player1.setOwnedCards(player1Owned);
        computer.setOwnedCards(compOwned);
        int i=0;
        while(i<20){
            player1.getDeck().add(player1Owned.get((i*i)%50));
            computer.getDeck().add(compOwned.get((i*i)%50));
            i++;
        }
        singlePlayer.execute();

    }
}
