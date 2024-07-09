import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Round {

    private User player1, player2;
    Board board;
    Game game;
    private int playerOrder;
    private final int HANDS_PER_ROUND = 2;
    Scanner scanner = new Scanner(System.in);
    private boolean DEAD = false;

    Round() {
    }

    Round(User player1, User player2, Board board, int playerOrder, Game game) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.playerOrder = playerOrder;
        this.game = game;
    }

    public void execute() {

        while (player1.getHands_played() < HANDS_PER_ROUND || player2.getHands_played() < HANDS_PER_ROUND) {
            System.out.println("It's player " + playerOrder + "'s turn!");
            Hand hand = new Hand();
            hand.execute(playerOrder, scanner, player1, player2, board, this);
            playerOrder = 3 - playerOrder;
            if(Board.INVISIBLE2 || Board.INVISIBLE1){
                board.printBoard(2);
            }
            else {
                board.printBoard(1);
            }

        }

        System.out.println("##\t\t\t\t\t##\n##Let's see if the odds were in your favour!##\n##\t\t\t\t\t##");
        finishSet(board);
        resetItems();
    }

    private void resetItems() {
        Arrays.fill(this.board.getRow1(), null);
        Arrays.fill(this.board.getRow2(), null);
        game.handCards(player1, player2);
        player2.setHands_played(0);
        player1.setHands_played(0);

    }


    private void finishSet(Board board) {
        Card card1, card2;
        boolean DEAD = false;
        int card1Index = 0, card2Index = 0;
        for (int i = 0; (i < board.BoardLength) && !DEAD; i++) {
            card1 = board.getRow1()[i];
            card2 = board.getRow2()[i];
            if (card1 != null) {
                if (card2 != null) {
                    DEAD = applyDamage(card1.getDamage_per_cell(player1.getCharacter(), card1Index),
                            card2.getDamage_per_cell(player2.getCharacter(), card2Index),
                            player1.getHP(), player2.getHP(), player1, player2);
                    card1Index += 1;
                    card2Index += 1;
                    if (card1Index == card1.getDuration()) {
                        card1Index = 0;
                    }
                    if (card2Index == card2.getDuration()) {
                        card2Index = 0;
                    }
                    dealWithSpellCard(card2,player2);
                } else {
                    DEAD = applyDamage(card1.getDamage_per_cell(player1.getCharacter(), card1Index), 0,
                            player1.getHP(), player2.getHP(), player1, player2);
                    card1Index += 1;
                    if (card1Index == card1.getDuration()) {
                        card1Index = 0;
                    }
                }
                dealWithSpellCard(card1,player1);
                board.printBoard(0);
            } else if (card2 != null) {
                DEAD = applyDamage(0, card2.getDamage_per_cell(player2.getCharacter(), card2Index),
                        player1.getHP(), player2.getHP(), player1, player2);
                card2Index += 1;
                if (card2Index == card2.getDuration()) {
                    card2Index = 0;
                }

                dealWithSpellCard(card2,player2);
                board.printBoard(0);
            }

            //this prints 21
            //board.printBoard(true);
        }
        this.DEAD = (player1.getHP() == 0) || (player2.getHP() == 0);
    }

    public void dealWithSpellCard(Card card, User player){
        if (card.getName().equals("Heal")) {
            ActivateHeal(player);
        }
    }

    private void ActivateHeal(User player) {
        if (player.getHP() >= 80) {
            player.setHP(100);
        } else {
            player.setHP(player.getHP() + 20);
        }
        System.out.println("User" + playerOrder + " used card heal! \n New HP:" + player.getHP());
    }

    //AT the end of set reset properties of card that depend upon the game


    private boolean applyDamage(int damage1, int damage2, int hp1, int hp2, User player1, User player2) {
        if (damage1 > damage2) {
            if (willSurvive(hp2, damage1 - damage2)) {
                player2.setHP(player2.getHP() - damage1 + damage2);
                player2.setDamage(player2.getDamage() + damage1 - damage2);
                return false;
            } else {
                player2.setHP(0);
                player2.setDamage(player2.getDamage() + damage1 - damage2);
                return true;
            }
        } else {
            if (willSurvive(hp1, damage2 - damage1)) {
                player1.setHP(player1.getHP() - damage2 + damage1);
                player1.setDamage(player1.getDamage() + damage2 - damage1);
                return false;
            } else {
                player1.setHP(0);
                player1.setDamage(player1.getDamage() + damage2 - damage1);
                return true;
            }
        }


    }

    private boolean willSurvive(int hp, int i) {
        return hp > i;
    }

    public boolean isDEAD() {
        return DEAD;
    }

    public User getPlayer(int playerOrder) {
        if (playerOrder == 1) {
            return player1;
        } else {
            return player2;
        }
    }




}
