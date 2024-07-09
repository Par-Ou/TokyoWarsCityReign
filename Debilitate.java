import java.util.ArrayList;
import java.util.Random;

public class Debilitate extends MagicalCard{
    //on the unused cards

    Debilitate(){
        this.setCost(200);
        this.setCharacter("PAN");
        this.setName("Debilitate");
    }

    @Override
    public void Activate(int playerOrder,User player, Hand hand, Board board,Round round) {
    }

}
