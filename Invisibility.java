public class Invisibility extends MagicalCard{

    Invisibility(){
        this.setCost(500);
        this.setCharacter("KIM");
        this.setName("Invisibility");
    }
    @Override
    public void Activate(int playerOrder,User player, Hand hand, Board board,Round round){
        //only show duration of card
        //
    }

}
