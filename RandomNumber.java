/**
 * Random class that randomly picks a number to be used to find a
 * blind domino
 */
package domino;

import java.util.Random;

/**
 *
 * @author tenrax
 */
public class RandomNumber {
    
    private static int remain = 0;
    //constructor
    public RandomNumber(int pieces){
        this.remain = pieces;
    }
    //when a piece is picked up from the deck, the remaining dominos is decreased
    public void remaining(){
        this.remain--;
    }
    //randomly generates number to grab a new domino
    public static int getRandom(){
        Random rand = new Random();
        //System.out.print(remain + " ");
        int randDomino = rand.nextInt(remain);
        
        return randDomino;
    }
    
}
