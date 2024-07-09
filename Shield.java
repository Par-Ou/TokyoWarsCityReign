public class Shield extends MagicalCard{

    Shield() {
        this.setCost(200);
        this.setCharacter("KIM");
        this.setCard_defense_attack(Integer.MAX_VALUE);
        this.setDuration(1);
        this.damage_per_cell.clear();
        this.damage_per_cell.add(0);
        this.setName("Shield");
        this.setPlayer_damage(0);
    }
//THIS IS A MAGICAL CARD DOES NOT EXTED NORMAL CARD
    @Override
    public void Activate(int playerOrder, User player, Hand hand, Board board, Round round) {
        System.out.println("Shield card applied!");
    }

}
