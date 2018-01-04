package laboration3C;

import java.util.Scanner;

public class Communication {
    
    private static final Scanner INPUT = new Scanner(System.in);
    
    public static void printGameStart(){
        System.out.println("======== GAME BEGINNING ========");
    }
    
    public static void playerTurnBegins(){
        System.out.println("[Player turn]\n");
    }
    
    public static void printHand(Player p, String belongsTo){
        System.out.println("[" + belongsTo + " shows]");
        System.out.print(p.toString());
        System.out.println();
    }
    
    public static void printInitDealerHand(Player p){
        System.out.println("\n[Dealer shows]");
        System.out.println(p.getHand().get(0).toString()+ "\n");
    }
    
    public static void currentSum(Player p, Player p2, String belongsToP, String belongsToP2){
        //System.out.println("[Current score]");
        System.out.println("[" + belongsToP + " score " + p.getCardSum() + "]");
        System.out.println("[" + belongsToP2 + " score " + p2.getHand().get(0).getRankValue() + "]\n");
    }
    public static void currentSumFullDealerHand(Player p, Player p2, String belongsToP, String belongsToP2) {
        //System.out.println("[Current score]");
        System.out.println("[" + belongsToP + " score " + p.getCardSum() + "]");
        System.out.println("[" + belongsToP2 + " score " + p2.getCardSum() + "]\n");
    }
    
    public static void playerBlackJack(){
        System.out.println("Player won on BLACKJACK!");
    }
    
    public static void pushHand(){
        System.out.println("Both the player and the dealer got BLACKJACK!");
    }
    
    public static boolean playAgain(){
        System.out.print("Play again?\n1 - Yes, 0 - No : ");
        int choice;
        do{
            choice = INPUT.nextInt();
            if(choice < 0 || choice > 1){
                System.out.print("Wrong input. Try again: ");
            }
        }while(choice < 0 || choice > 1);
        
        if(choice == 1){
            System.out.println("\n\n\n\n");
        }
        return choice == 1;
    }
    
    public static boolean pickNewCard(){
        System.out.printf("Would you like to pick a new card?\n1 - Yes, 0 - No : ");
        int choice;
        do{
            choice = INPUT.nextInt();
            if(choice < 0 || choice > 1){
                System.out.print("Wrong input. Try again: ");
            }
        }while(choice < 0 || choice > 1);
        
        return choice == 1;
    }
    
    public static void cardPicked(Player p, String belongsTo){
        System.out.println(belongsTo + " picked the card:\n" +
                p.getHand().get(p.getHand().size() - 1).toString() + "\n");
    }
    
    public static void dealerWon(){
        System.out.println("DEALER WON!");
    }
    
    public static void playerWon(){
        System.out.println("PLAYER WON!");
    }
    
    public static void draw(){
        System.out.println("It's a DRAW!");
    }
    
    public static void statistics(int playerWins, int dealerWins, int draws, int numberOfRuns){
        System.out.println("Player wins: " + ((double)playerWins / numberOfRuns) * 100 + "%");
        System.out.println("Dealer wins: " + ((double)dealerWins / numberOfRuns) * 100 + "%");
        System.out.println("Draw: " + ((double)draws / numberOfRuns) * 100 + "%");
    }
}