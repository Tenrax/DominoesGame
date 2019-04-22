/**
 * This is where you place a domino. Holds the open ends to place a domino
 */
package domino;

/**
 *
 * @author tenrax
 */
public class Table {
    
    private static String openLeft = "";
    private static String openRight = "";
    
    public Table(){
        
    }
    
    public void placeFirst(String first){
        String[] placed = first.split("");
        openLeft = placed[0];
        openRight = placed[1];
    }
    
    public void placePiece(String side, String piece, Player player, int domino){
        Boolean matchL;
        Boolean matchR;
        Boolean twin;
        String[] played = piece.split("");
        
        if(side.toLowerCase().equals("left")){
            System.out.println("getting to left");
            matchL = (played[0].equals(openLeft));
            matchR = (played[1].equals(openLeft));
            twin = (matchL && matchR);
            if(twin){
                openLeft = played[1];
                player.removeDomino(domino);
            }
            else if(matchL){
                openLeft = played[1];
                player.removeDomino(domino);
            }
            else if(matchR){
                openLeft = played[0];
                player.removeDomino(domino);
            }
            else{
                System.out.println("Invalid piece. Lose a turn.");
            }
        }
        else if(side.toLowerCase().equals("right")){
            System.out.println("getting to right");
            matchL = (played[0].equals(openRight));
            matchR = (played[1].equals(openRight));
            twin = (matchL && matchR);
            if(twin){
                openRight = played[1];
                player.removeDomino(domino);
            }
            else if(matchL){
                openRight = played[1];
                player.removeDomino(domino);
            }
            else if(matchR){
                openRight = played[0];
                player.removeDomino(domino);
            }
            else{
                System.out.println("Invalid piece. You lose a turn.");
            }
        }
        
    }
    
    public void addLeft(String leftSide, String connectBy){
        String[] sides = leftSide.split("");
        if(sides[0].equals(connectBy) && sides[1].equals(connectBy)){
            openLeft = sides[0];
        }
        else{
            for(int i = 0; i < sides.length; i++){
                if(!(sides[i].equals(connectBy))){
                    openLeft = sides[i];
                }
            }
        }
    }
    
    public void addRight(String rightSide, String connectBy){
        String[] sides = rightSide.split("");
        if(sides[0].equals(connectBy) && sides[1].equals(connectBy)){
            openRight = sides[0];
        }
        else{
            for(int i = 0; i < sides.length; i++){
                if(!(sides[i].equals(connectBy))){
                    openRight = sides[i];
                }
            }
        }
    }
    
    public static String getLeft(){
        return openLeft;
    }
    
    public static String getRight(){
        return openRight;
    }
    
    public static String openEnds(){
        String open = "";
        open += "Open spot left: " + getLeft() + "\nOpen spot right: " + getRight();
        return open;
    }
    
    
}
