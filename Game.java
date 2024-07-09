import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {

    private int turns=0;

    User player1, player2 = new User();
    Game(User player1, User player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    Game(){}
    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }


    protected void execute() {
    }

    protected void handCards(User player1, User player2) {
            Random rand = new Random();

            // Create a deep copy of the ArrayList
            ArrayList<Card> copiedCards1 = new ArrayList<>(),copiedCards2 = new ArrayList<>();



            ArrayList<Integer> indexer = new ArrayList<>();
            for(int i=0; i< player1.getDeck().size(); i++){
                indexer.add(i);
            }

            Collections.shuffle(indexer);
            ArrayList<Card> player1Hand = new ArrayList<>();
            for(int i: indexer.subList(0,5)){
                player1Hand.add(player1.getDeck().get(i));
            }
            player1.setHand(player1Hand);

            indexer.clear();
            for(int i=0; i< player2.getDeck().size(); i++){
                indexer.add(i);
            }
            Collections.shuffle(indexer);
            ArrayList<Card> player2Hand = new ArrayList<>();
            for(int i: indexer.subList(0,5)){
                player2Hand.add(player2.getDeck().get(i));
            }
            player2.setHand(player2Hand);
    }


}
