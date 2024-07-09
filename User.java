import java.util.ArrayList;

public class User {

    private int HP,XP,Level, Coin, password_recovery_question, damage, hands_played=0, playerPoints=0 ,maxXp=100, maxHP=100;
    private String Name, username, password, email, Character;
    private Clan myClan;
    private ArrayList<Card> ownedCards = new ArrayList<Card>(), Deck = new ArrayList<Card>(), Hand = new ArrayList<Card>();
    User(){
        this.Level =1;
        this.HP = 100;
        this.XP=0;
        this.Coin = 1000;
    }
    User(String name, ArrayList<Card> owned){
        this.Level =1;
        this.HP = 100;
        this.XP=0;
        this.Coin = 1000;
        this.Name = name;
        this.ownedCards = owned;
    }

    public void chooseDeck(){

    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = HP;
    }

    public int getOrder(Game game) {
        if(game.player2.equals(this)){
            return 2;
        }
        else{
            return 1;
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getCoin() {
        return Coin;
    }

    public void setCoin(int coin) {
        Coin = coin;
    }

//    public void levelUp(){
//        this.Coin+=100*this.Level;
//        this.Level+=1;
//    }
    public void leveledUp(){
        if(this.XP >= this.maxXp){
            this.Coin+=100*this.Level;
            this.maxHP += 10*this.Level;
            this.Level+=1;
            this.maxXp = this.Level*50*(this.Level+1);
        }
    }

    public String getCharacter() {
        return Character;
    }

    public void setCharacter(String character) {
        Character = character;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHands_played() {
        return hands_played;
    }

    public void setHands_played(int hands_played) {
        this.hands_played = hands_played;
    }

    public ArrayList<Card> getDeck() {
        return Deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        Deck = deck;
    }

    public ArrayList<Card> getHand() {
        return Hand;
    }

    public void setHand(ArrayList<Card> hand) {
        Hand = hand;
    }

    public ArrayList<Card> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(ArrayList<Card> ownedCards) {
        this.ownedCards = ownedCards;
    }

    public void printHand() {
        for(Card card: this.Hand){
            System.out.println("Name:" + card.getName() + ",\tType:"+ isMagical(card)+",\tDuration:"
                    + card.getDuration()+",\t Player damage:"+ card.getPlayer_damage(this.getCharacter())+
                    ",\tAttack/defense point:"+ card.getCard_defense_attack()+"||");
        }
        System.out.println();
    }

    private String isMagical(Card card) {
        if(card instanceof MagicalCard){
            return "Spell card";
        }
        else{
            return "Attack/defense card";
        }
    }


    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public double getMaxXp() {
        return this.maxXp;
    }

    public void reset() {
        this.HP = maxHP;
        this.damage = 0 ;
        this.hands_played =0;
        this.playerPoints =0;
        this.Character = null;
        this.Deck.clear();
        this.Hand.clear();
    }

    public Clan getMyClan() {
        return myClan;
    }

    public void setMyClan(Clan myClan) {
        this.myClan = myClan;
    }


    //WHERE DOES IT CHOOSE DECK??

}
