import java.util.ArrayList;
import java.util.Random;

public class CardThief extends MagicalCard{

    CardThief(){
        this.setCost(200);
        this.setCharacter("PAN");
        this.setName("CardThief");
    }
    @Override
    public void Activate(int playerOrder,User player, Hand hand, Board board,Round round){

    }
}
