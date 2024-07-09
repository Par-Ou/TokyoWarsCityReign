import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Board {
    public static boolean INVISIBLE1, INVISIBLE2;
    final int BoardLength = 21;
    private Card[] Row1 = new Card[BoardLength], Row2 = new Card[BoardLength];

    private int Row1DitchIndex = 5, Row2DitchIndex = 5; // if -1, there is no ditch
    User player1, player2;

    Board(User player1, User player2) {
        Random random = new Random();
        int rand = random.nextInt(BoardLength);
        this.Row1DitchIndex = rand;
        rand = random.nextInt(BoardLength);
        this.Row2DitchIndex = rand;
        this.player1 = player1;
        this.player2 = player2;
        INVISIBLE1 = false;
        INVISIBLE2 = false;
    }


    public Card[] getRow(int orderPlayer) {
        if (orderPlayer == 1) {
            return Row1;
        } else {
            return Row2;
        }
    }

    public Card[] getRow1() {
        return Row1;
    }

    public Card[] getRow2() {
        return Row2;
    }

    public int getRow1DitchIndex() {
        return Row1DitchIndex;
    }

    public void setRow1DitchIndex(int row1DitchIndex) {
        Row1DitchIndex = row1DitchIndex;
    }

    public int getRow2DitchIndex() {
        return Row2DitchIndex;
    }

    public void setRow2DitchIndex(int row2DitchIndex) {
        Row2DitchIndex = row2DitchIndex;
    }

    public ArrayList<Card> getPlayedCards(int playerOrder) {
        ArrayList<Card> cardsPlacedOnTheBoard = new ArrayList<Card>();
        if (playerOrder == 1) {
            for (Card card : this.Row1) {
                if (card.getName() != null) {
                    cardsPlacedOnTheBoard.add(card);
                }
            }
        } else {
            for (Card card : this.Row2) {
                if (card.getName() != null) {
                    cardsPlacedOnTheBoard.add(card);
                }
            }
        }
        return cardsPlacedOnTheBoard;
    }



    public void printBoard(int finish) {
        //cards (5 from deck , can be rep[etitive -> show HAND
        if (player2 instanceof Computer) {
            System.out.println("########");
            if (finish !=0) {
                if (finish==1) {
                    System.out.println("Player 1 Hand:");
                    player1.printHand();
                    System.out.println("Computer Hand:");
                    player2.printHand();
                }
                else {
                    if(INVISIBLE1){
                        System.out.println("Player 1 hand is invisible :)");
                        System.out.println("Computer Hand:");
                        player2.printHand();
                        INVISIBLE1 = false;
                    }
                    else{
                        System.out.println("Player 1 Hand:");
                        player1.printHand();
                        System.out.println("Computer hand is invisible :)");
                        INVISIBLE2 = false;
                    }
                }
            }
            System.out.println("Player 1 Stats:\n\t" + "XP:" + player1.getXP() + "\tDamage:" + player1.getDamage() + "\tHands played:" + player1.getHands_played() + "\tHP:" + player1.getHP()
                    + "\tPoints:" + player1.getPlayerPoints() + "\tCharacter:" + player1.getCharacter());
            System.out.println("Computer Stats:\n\t" + "XP: " + player2.getXP() + "\tDamage: " + player2.getDamage() + "\tHands played:" + player2.getHands_played() + "\tHP:" + player2.getHP()
                    + "\tPoints:" + player2.getPlayerPoints() + "\tCharacter:" + player2.getCharacter());

            System.out.println("***Board:");
            int i = 0;
            System.out.print("PLAYER 1:\t");
            while (i < BoardLength) {
                if (i == Row1DitchIndex) {
                    System.out.print("DITCH\t");
                } else if (!(this.Row1[i] == null)) {
                    System.out.print(this.Row1[i].getName() + ": D/A:" + this.Row1[i].getCard_defense_attack() + ", Damage:" + this.Row1[i].getDamage_per_cell(player1.getCharacter(), 0));
                    for (int j = 0; j < this.Row1[i].getDuration() - 1; j++) {
                        System.out.print("| ~~," + this.Row1[i].getDamage_per_cell(player1.getCharacter(), j + 1));
                        i++;
                    }
                    System.out.print("\t||\t");
                } else {
                    System.out.print("blank\t");
                }
                i++;
            }
            System.out.println();
            i = 0;
            System.out.print("Computer:\t");
            while (i < BoardLength) {
                if (i == Row2DitchIndex) {
                    System.out.print("DITCH\t");
                } else if (this.Row2[i] != null) {
                    System.out.print(this.Row2[i].getName() + ": D/A:" + this.Row2[i].getCard_defense_attack() + ", Damage:" + this.Row2[i].getDamage_per_cell(player2.getCharacter(), 0));
                    for (int j = 0; j < this.Row2[i].getDuration() - 1; j++) {
                        System.out.print("| ~~," + this.Row2[i].getDamage_per_cell(player2.getCharacter(), j + 1));
                        i++;
                    }
                    System.out.print("\t||\t");
                } else {
                    System.out.print("blank\t");
                }
                i++;
            }
            System.out.println("\n ########");
            System.out.println();
        } else {
            System.out.println("########");
            if (finish !=0) {
                if (finish==1) {
                    System.out.println("Player 1 Hand:");
                    player1.printHand();
                    System.out.println("Player 2 Hand:");
                    player2.printHand();
                }
                else {
                    if(INVISIBLE1){
                        System.out.println("Player 1 hand is invisible :)");
                        System.out.println("Player 2 Hand:");
                        player2.printHand();
                        INVISIBLE1 = false;
                    }
                    else{
                        System.out.println("Player 1 Hand:");
                        player1.printHand();
                        System.out.println("Player 2 hand is invisible :)");
                        INVISIBLE2 = false;
                    }
                }
            }
            System.out.println("Player 1 Stats:\n\t" + "XP:" + player1.getXP() + "\tDamage:" + player1.getDamage() + "\tHands played:" + player1.getHands_played() + "\tHP:" + player1.getHP()
                    + "\tPoints:" + player1.getPlayerPoints() + "\tCharacter:" + player1.getCharacter());
            System.out.println("Player 2 Stats:\n\t" + "XP: " + player2.getXP() + "\tDamage: " + player2.getDamage() + "\tHands played:" + player2.getHands_played() + "\tHP:" + player2.getHP()
                    + "\tPoints:" + player2.getPlayerPoints() + "\tCharacter:" + player2.getCharacter());

            System.out.println("***Board:");
            int i = 0;
            System.out.print("PLAYER 1:\t");
            while (i < BoardLength) {
                if (i == Row1DitchIndex) {
                    System.out.print("DITCH\t");
                } else if (!(this.Row1[i] == null)) {
                    System.out.print(this.Row1[i].getName() + ": D/A:" + this.Row1[i].getCard_defense_attack() + ", Damage:" + this.Row1[i].getDamage_per_cell(player1.getCharacter(), 0));
                    for (int j = 0; j < this.Row1[i].getDuration() - 1; j++) {
                        System.out.print("| ~~," + this.Row1[i].getDamage_per_cell(player1.getCharacter(), j + 1));
                        i++;
                    }
                    System.out.print("\t||\t");
                } else {
                    System.out.print("blank\t");
                }
                i++;
            }
            System.out.println();
            i = 0;
            System.out.print("PLAYER 2:\t");
            while (i < BoardLength) {
                if (i == Row2DitchIndex) {
                    System.out.print("DITCH\t");
                } else if (this.Row2[i] != null) {
                    System.out.print(this.Row2[i].getName() + ": D/A:" + this.Row2[i].getCard_defense_attack() + ", Damage:" + this.Row2[i].getDamage_per_cell(player2.getCharacter(), 0));
                    for (int j = 0; j < this.Row2[i].getDuration() - 1; j++) {
                        System.out.print("| ~~," + this.Row2[i].getDamage_per_cell(player2.getCharacter(), j + 1));
                        i++;
                    }
                    System.out.print("\t||\t");
                } else {
                    System.out.print("blank\t");
                }
                i++;
            }
            System.out.println("\n ########");
            System.out.println();
        }
    }


    public void invisible(int playerOrder) {
        if (playerOrder == 1) {
            INVISIBLE1 = true;
        } else {
            INVISIBLE2 = true;
        }
    }


}
