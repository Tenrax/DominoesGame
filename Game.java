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
        //creates the domino object
        Domino domino = new Domino();
        //creates the random object
        RandomNumber random = new RandomNumber(dominoPieces);
        //creates player1 and player2 objects
        Player player1 = new Player(domino, random);
        Player player2 = new Player(domino, random);
        //creates the table object
        Table table = new Table();
        
        //after both players have their hands, 8 dominos remain
        dominoPieces = 8;
        
        //the turn number to determine what player can go.
        int turn = 1;
        System.out.println();
        
        //Player1 starts the game by placing a piece to start
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
        
        //booleans if players have pieces to play
        boolean playerOnePieces = true;
        boolean playerTwoPieces = true;
        
        
        //while loop the runs depending on the number of pieces the players
        //have and if there are any dominos to be picked up remian
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
        //when the game has finished, the player who won is displayed
        winner(player1, player2);
        
    }
    //sends the player to the correct method depending on what choice they made
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
    //when the player takes the pass action, takes a piece from the remaining
    //dominos and puts it into the players hand
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
    //when the player takes the place action, asks for what domino and what side
    //of the table
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
    //displays who the winner is and how many dominos that player has
    public static void winner(Player player1, Player player2){
        if(player1.getDominoCount() < player2.getDominoCount()){
            System.out.println("Player 1 is the Winner!");
            System.out.println("With: " + player1.getDominoCount() + " pieces!");
        }
        else if(player1.getDominoCount() > player2.getDominoCount()){
            System.out.println("Player 2 is the Winner!");
            System.out.println("With: " + player1.getDominoCount() + " pieces!");
        }
        else{
            System.out.println("It's a draw");
        }
    }
    
}
