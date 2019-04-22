/*
 * This class will hold all the dominoes
 * Be called for getting a domino
 */
package domino;

import java.util.ArrayList;

/**
 *
 * @author tenrax
 */
public class Domino {
    
    private static ArrayList<String> set = new ArrayList<>();
    
    public Domino (){
        createSet();
    }
    //creates all the pieces for the domino game
    public ArrayList createSet(){
        int[][] createSet = new int[7][];
        for(int i = 0; i < createSet.length; i++){
            int[] peices = new int[i+1];
            for(int j = 0; j <= i; j++){
                peices[i] = j;
                //System.out.print("[" + j + "|" + i + "] ");
                
            }
            //System.out.println();
            createSet[i] = peices;
        }
        for(int i = 0; i < createSet.length; i++){
            for(int j = 0; j < createSet[i].length; j++){
                String domino = "" + j + i;
                set.add(domino);
            }
        }
        
        return set;
    }
    //removes the domino from the set when player passes
    public static String getDomino(int number){
        String picked = set.get(number);
        set.remove(number);
        //System.out.print(picked + " ");
        return picked;
    }
    //returns the entire set of dominos
    public static ArrayList getSet(){
        return set;
    }
    
}
