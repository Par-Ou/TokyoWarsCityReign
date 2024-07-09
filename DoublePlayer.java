import java.util.Random;
import java.util.Scanner;

public class DoublePlayer extends Game {

    Scanner scanner = new Scanner(System.in);
    private User Winner, Loser;

    DoublePlayer(User player1, User player2) {
        super(player1, player2);
    }

    public void execute() {
        //we won't handle error here because we use a button in graphic

        getCharacters();

        Board board = new Board(this.player1, this.player2);
        handCards(player1, player2);
        Random random = new Random();
        int playerOrder = random.nextInt(2) + 1;
        System.out.println("Player " + playerOrder + " gets to go first!\n");


        boolean DEAD = false;
        while (!DEAD) {
            System.out.println("\n***START ROUND***");
            board.printBoard(1);
            Round round = new Round(player1, player2, board, playerOrder, this);
            round.execute();
            System.out.println("***ROUND OVER***\n");
            DEAD = round.isDEAD();
        }
        givePoints();
        player1.reset();
        player2.reset();
        player2 = null;
        System.out.println("logged out of player 2.\n Game over.");
    }

    private void getCharacters() {
        System.out.println("Player1 please select your character: /n Your options are: KIM, PAN, PAR, KAI");
        String str = scanner.nextLine();
        str = str.trim();
        player1.setCharacter(str);
        System.out.println("Player2 please select your character: /n Your options are: KIM, PAN, PAR, KAI");
        str = scanner.nextLine();
        str = str.trim();
        player2.setCharacter(str);
    }

    private void givePoints() {
        //give point, xp, level, coin
        //refer to database handler.
        if (player1.getHP() == 0) {
            this.Winner = player2;
            this.Loser = player1;
        } else {
            this.Winner = player1;
            this.Loser = player2;
        }
        this.Loser.setXP((int) (this.Loser.getXP() + this.Loser.getPlayerPoints()));
        this.Winner.setXP(this.Winner.getXP() + (int) ((double) (this.Winner.getPlayerPoints() / 100) * 0.5 * this.Winner.getMaxXp()));
        this.Winner.setCoin(this.Winner.getCoin() + this.Winner.getPlayerPoints() * 2 + 100 * this.Winner.getLevel());
        Winner.leveledUp();
        Loser.leveledUp();
        printStats(Winner, Loser);

        player1.setPlayerPoints(abser(player1.getDamage() - player2.getDamage()));
        player2.setPlayerPoints(abser(player2.getDamage() - player1.getDamage()));
        player1.setDamage(0);
        player2.setDamage(0);


    }

    private int abser(int i) {
        if (i > 0) {
            return i;
        } else {
            return 0;
        }
    }

    public void printStats(User winner, User loser) {
        System.out.println("Stats:");
        System.out.println("Winner:\t" + winner.getName() + "\tLevel:\t" + winner.getLevel() + "\tCoins:\t" + winner.getCoin() + "\tXP:\t" + winner.getXP());
        System.out.println("Loser:\t" + loser.getName() + "\tLevel:\t" + loser.getLevel() + "\tCoins:\t" + loser.getCoin() + "\tXP:\t" + loser.getXP());
    }

    public User getWinner(){
        return this.Winner;
    }


}
