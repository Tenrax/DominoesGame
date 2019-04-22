/**
 * This method will be an array list that holds the players dominoes
 */
package domino;

import java.util.ArrayList;

/**
 *
 * @author tenrax
 */
public class Player {
    public Domino domino;
    public RandomNumber random;
    public ArrayList<String> dominos = new ArrayList<>(); 
    //constructor
    public Player(Domino domino, RandomNumber random){
        this.domino = domino;
        this.random = random;
        createHand();
    }
    //creates the player's hand to play the game
    public void createHand(){
        int startingHand = 10;
        for(int i = 0; i < startingHand; i++){
            giveDomino();
        }
    }
    //when picked up domino, adds to the players hand
    public void giveDomino(){
        int number = RandomNumber.getRandom();
        String piece = domino.getDomino(number);
        dominos.add(piece);
        random.remaining();
    }
    //pickes up domino from player's hand
    public String getDomino(int chosen){
        String piece = dominos.get(chosen);
        return piece;
    }
    //removes domino from hand when said domino is played
    public void removeDomino(int chosen){
        dominos.remove(chosen);
    }
    //returns how many dominos are in the player's hand
    public int getDominoCount(){
        return dominos.size();
    }
    //prints out the dominos the player has in his hand so the player can pick a piece
    public String printHand(){
        String hand = "";
        for(int i = 0; i < dominos.size(); i++){
            String[] handPiece = dominos.get(i).split("");
            //System.out.println(dominos.get(i) + "*");
            //System.out.print(("[" + handPiece[0] + "|" + handPiece[1] + "]") + " ");
            hand += (i + 1) + ":" + ("[" + handPiece[0] + "|" + handPiece[1] + "]") + " ";
        }
        return hand;
    }
}
