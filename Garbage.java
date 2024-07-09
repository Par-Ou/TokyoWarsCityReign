public class Garbage {

    /*


    //                    if(chosenCard.getExtra()){
//                        player.getHand().remove(5);
//                        chosenCard.setExtra(false);
//                    }
//                    if (n == 6) {
//                        player.getHand().remove(5);
//                        chosenCard.setExtra(false);
//                    } else {
//                        rand = random.nextInt(roundDeck.size());
//                        player.getHand().set(n - 1, roundDeck.get(rand));
//                    }

                    //check if it breaks the opponent's cell or otherwise
                    //check if broken a whole





    if (card1 != null && card2 != null) {


        if (card1.getName().equals("Heal")) {
            if(player1.getHP()>=80){
                player1.setHP(100);
                System.out.println(player1.getHP()+ " BRUH THIS S HTE HP");
            }
            else{
                player1.setHP(player1.getHP()+20);
            }
            System.out.println("Player"+1+" used card heal! \n New HP:"+ player1.getHP());
            if(card2.getName().equals("Heal")){
                if(player2.getHP()>=80){
                    player2.setHP(100);
                    System.out.println(player2.getHP()+ " BRUH THIS S HTE HP");
                }
                else{
                    player2.setHP(player2.getHP()+20);
                }
                System.out.println("Player"+2+" used card heal! \n New HP:"+ player2.getHP());
            }
            else{
                DEAD = applyDamage(0, card2.getDamage_per_cell(player2.getCharacter(), card2Index),
                        player1.getHP(), player2.getHP(), player1, player2);
                card2Index += 1;
                if (card2Index == card2.getDuration()) {
                    card2Index = 0;
                }

            }
        }
        else if (card2.getName().equals("Heal")){
            ((Heal) card2).Activate(playerOrder, player2, new Hand(), board, this);
            DEAD = applyDamage(card1.getDamage_per_cell(player1.getCharacter(), card1Index), 0,
                    player1.getHP(), player2.getHP(), player1, player2);
            card1Index += 1;
            if (card1Index == card1.getDuration()) {
                card1Index = 0;
            }
        }
        else{
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
        }
        board.printBoard(true);
    }


            else if (card1 == null && card2 != null) {
        DEAD = applyDamage(0, card2.getDamage_per_cell(player2.getCharacter(), card2Index),
                player1.getHP(), player2.getHP(), player1, player2);
        card2Index += 1;
        if (card2Index == card2.getDuration()) {
            card2Index = 0;
        }
        board.printBoard(true);
    } else if (card1 != null && card2 == null) {
        DEAD = applyDamage(card1.getDamage_per_cell(player1.getCharacter(), card1Index), 0,
                player1.getHP(), player2.getHP(), player1, player2);
        card1Index += 1;
        if (card1Index == card1.getDuration()) {
            card1Index = 0;
        }
        board.printBoard(true);
    }



*/



}
