import java.util.Scanner;

public class CopyCard extends MagicalCard{

    CopyCard(){
        this.setCost(200);
        this.setCharacter("PAR");
        this.setName("CopyCard");
    }

    @Override
    public void Activate(int playerOrder, User player, Hand hand, Board board, Round round) {
        super.Activate(playerOrder, player, hand, board, round);
    }


}
