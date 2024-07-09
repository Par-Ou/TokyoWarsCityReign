import java.util.ArrayList;
import java.util.Random;

public class MoveDitch extends MagicalCard {


    MoveDitch() {
        this.setCharacter("PAN");
        this.setCost(200);
        this.setName("MoveDitch");
    }

    @Override
    public void Activate(int playerOrder, User player, Hand hand, Board board, Round round) {

    }
}
