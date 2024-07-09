import java.util.ArrayList;

public class Card {
    private String name, Character;
    //character type: KIM, KAI, PAR , PAN
    private int duration, card_defense_attack, player_damage, upgrade_level,upgrade_cost, cost, number_of_broken_Cells=0;
    private Boolean deactivate = false , CopiedCard =false, Extra = false;
    private ArrayList<Boolean> brokenCells = new ArrayList<>();
    ArrayList<Integer> damage_per_cell = new ArrayList<>();
    public String execution;

    Card(){}
    Card(ArrayList<String> cmd){
        this.name = cmd.get(0);
        this.card_defense_attack = Integer.parseInt(cmd.get(1));
        this.duration = Integer.parseInt(cmd.get(2));
        this.player_damage = Integer.parseInt(cmd.get(3));
        this.upgrade_level = Integer.parseInt(cmd.get(4));
        this.upgrade_cost = Integer.parseInt(cmd.get(5));
        fillDamagePerCell();
        fillBrokenCells();
    }

    Card(String name, int accuracy, int duration, int player_damage, int upgrade_cost, int upgrade_level, String character){
        this.name = name;
        this.card_defense_attack = accuracy;
        this.duration =duration;
        this.player_damage = player_damage;
        this.upgrade_level = upgrade_level;
        this.upgrade_cost =upgrade_cost;
        this.Character = character;
        fillDamagePerCell();
        fillBrokenCells();

    }

    public Card(Card card) {
        this.name = card.name;
        this.card_defense_attack = card.card_defense_attack;
        this.duration =card.duration;
        this.player_damage = card.player_damage;
        this.upgrade_level = card.upgrade_level;
        this.upgrade_cost =card.upgrade_cost;
        this.Character = card.Character;
        this.cost = card.cost;
        fillDamagePerCell();
        fillBrokenCells();

    }
    private void fillDamagePerCell() {
        for(int i=0; i< this.duration; i++){
            this.damage_per_cell.add(this.player_damage/this.duration);
        }
    }
    public void fillBrokenCells(){
        for(int i=0; i< this.duration; i++){
            this.brokenCells.add(false);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCard_defense_attack() {
        return card_defense_attack;
    }

    public void setCard_defense_attack(int card_defense_attack) {
        this.card_defense_attack = card_defense_attack;
    }

    public int getPlayer_damage(String character) {
        if(this.Character.equals(character)){
            return player_damage+5*this.duration;
        }
        else{ //"-1" for normal mode
            return player_damage;
        }

    }

    public void setPlayer_damage(int player_damage) {
        this.player_damage = player_damage;
        fillDamagePerCell();
    }

    public int getUpgrade_level() {
        return upgrade_level;
    }

    public void setUpgrade_level(int upgrade_level) {
        this.upgrade_level = upgrade_level;
    }

    public int getUpgrade_cost() {
        return upgrade_cost;
    }

    public void setUpgrade_cost(int upgrade_cost) {
        this.upgrade_cost = upgrade_cost;
    }

    //for the graphic breaking of card
    public void Break(){}

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    protected void lowerDamage() {
        this.player_damage-=5;
    }
    protected void lowerPower(){
        this.card_defense_attack-=5;
    }

    public void printDetails() {
        System.out.println("Card name:\t"+ this.name+"\tDuration:\t"+this.duration+
                "\tDefense/Attack:\t"+this.card_defense_attack+"\tUser damage:\t"+this.player_damage+
                "\tCharacter\t"+this.Character);

    }

    public Boolean getDeactivate() {
        return deactivate;
    }

    public void setDeactivate(Boolean deactivate) {
        this.deactivate = deactivate;
    }

    public Boolean getCopiedCard() {
        return CopiedCard;
    }

    public void setCopiedCard(Boolean copiedCard) {
        CopiedCard = copiedCard;
    }

    public String getCharacter() {
        return Character;
    }

    public void setCharacter(String character) {
        Character = character;
    }


    public int getNumberOfBrokenCells() {
        return number_of_broken_Cells;
    }

    public void setBrokenCell(int number_of_broken_Cells, int cellIndex) {
        this.number_of_broken_Cells = number_of_broken_Cells;
        this.brokenCells.set(cellIndex, true);

    }

    public boolean isCellBroken(int index){
        return this.brokenCells.get(index);
    }

    public int getDamage_per_cell(String character, int index) {
        if(this.Character.equals(character)){
            return damage_per_cell.get(index)+5;
        }
        else{  //"-1" for normal mode
            return damage_per_cell.get(index);
        }
    }

    public void setDamage_per_cell(int value, int index) {
        this.damage_per_cell.set(index,value);
    }

    protected void setExtra(boolean b) {
        this.Extra = b;
    }

    public Boolean getExtra() {
        return Extra;
    }
}
