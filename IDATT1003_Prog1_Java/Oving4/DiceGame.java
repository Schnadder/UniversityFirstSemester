package Oving4;

public class DiceGame {
    public static void main(String[] args){
        Player player1 = new Player();
        Player player2 = new Player();

        boolean repeat = true;
        int turn = 0;
        boolean printing = true;

        while(repeat){
            turn++;
            // Player 1 turn
            int kast1 = player1.kastTerningen();
            player1.getSumPoeng(kast1);
            if (player1.erFerdig()){
                repeat = false;
            }
            
            // Player 2 turn
            int kast2 = player2.kastTerningen();
            player2.getSumPoeng(kast2);
            if (player2.erFerdig()){
                repeat = false;
            }

            //Making testing easier
            if (player1.sumPoeng > 90 || player2.sumPoeng > 90){
                printing = true;
            }
            else{
                printing = false;
            }

            // Printing
            if(printing){
                System.out.printf("Tur: %s\n", turn);
                System.out.printf("Player1 poengsum: %s\n", player1.sumPoeng);
                System.out.printf("Player2 poengsum: %s\n", player2.sumPoeng);
            }
        }
        // Check who won
        if(player1.erFerdig()){
            if(player2.erFerdig()){
                System.out.println("Uavgjort!\n");
            }
            else{
                System.out.println("Player1 vant\n");
            }
        }
        else if(player2.erFerdig()){
            System.out.println("Player2 vant\n");
        }
        else{
            System.out.println("Something went wrong\n");
        }
    }
}
