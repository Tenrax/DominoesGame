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
    
    public RandomNumber(int pieces){
        this.remain = pieces;
    }
    
    public void remaining(){
        this.remain--;
    }
    
    public static int getRandom(){
        Random rand = new Random();
        //System.out.print(remain + " ");
        int randDomino = rand.nextInt(remain);
        
        return randDomino;
    }
    
}
