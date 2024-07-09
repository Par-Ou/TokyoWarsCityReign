public class Heal extends MagicalCard{
    Heal(){
        this.setCost(200);
        this.setCharacter("KAI");
        super.setDuration(1);
        super.setName("Heal");
    }
    @Override
    public void Activate(int playerOrder,User player, Hand hand, Board board,Round round){

    }

}
