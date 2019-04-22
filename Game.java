/**
 * This method is where the game runs
 */
package domino;

import java.util.Scanner;

public class Game {
    
    public static int dominoPieces = 28;
    public static boolean canPlay = true;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        Domino domino = new Domino();
        RandomNumber random = new RandomNumber(dominoPieces);
        Player player1 = new Player(domino, random);
        Player player2 = new Player(domino, random);
        Table table = new Table();
        dominoPieces = 8;
        
        int turn = 1;
        System.out.println();
        System.out.println("Player 1: place a piece to start the game");
        System.out.println(player1.printHand());
        int start = input.nextInt();
        input.nextLine();
        start--;
        String firstPiece = player1.getDomino(start);
        player1.removeDomino(start);
        //System.out.println(firstPiece);
        table.placeFirst(firstPiece);
        turn++;
        
        boolean playerOnePieces = true;
        boolean playerTwoPieces = true;
        
        while(canPlay && playerOnePieces && playerTwoPieces){
            
            if(player1.getDominoCount() <= 0){
                playerOnePieces = false;
            }
            else if(player2.getDominoCount() <= 0){
                playerTwoPieces = false;
            }
            
            if(turn % 2 == 1){
                //player1
                System.out.println(table.openEnds());
                System.out.println(player1.printHand());
                System.out.println("Player 1: place, pass, or unable");
                choice(input, player1, table);
                turn++;
                
            }
            else if(turn % 2 == 0){
                //player2
                System.out.println(table.openEnds());
                System.out.println(player2.printHand());
                System.out.println("Player 2: place, pass, or unable");
                choice(input, player2, table);
                turn++;
            }
        }
        
        winner(player1, player2);
        
    }
    
    public static void choice(Scanner input, Player player, Table table){
        //System.out.println("Getting");
        String choice = "";
        //System.out.println("To");
        choice = input.nextLine();
        //System.out.println("Here");
        if(choice.toLowerCase().equals("pass")){
            pass(player);
        }
        else if(choice.toLowerCase().equals("place")){
            place(input, player, table);
        }
        else{
            System.out.println("Invalid choice. Lose a turn.");
        }
                
    }
    
    public static void pass(Player player){
        dominoPieces--;
        if(dominoPieces > 0){
            player.giveDomino();
            System.out.println("Take a piece");
        }
        else{
            System.out.println("No more pieces");
            canPlay = false;
        }
    }
    
    public static void place(Scanner input, Player player, Table table){
        System.out.println("What domino: ");
        int domino = input.nextInt();
        input.nextLine();
        domino--;
        String piece = "" + player.getDomino(domino);
        System.out.println("What side on table: ");
        String side = input.nextLine();
        table.placePiece(side, piece, player, domino);
    }
    
    public static void winner(Player player1, Player player2){
        if(player1.getDominoCount() < player2.getDominoCount()){
            System.out.println("Player 1 is the Winner!");
        }
        else if(player1.getDominoCount() > player2.getDominoCount()){
            System.out.println("Player 2 is the Winner!");
        }
        else{
            System.out.println("It's a draw");
        }
    }
    
}
