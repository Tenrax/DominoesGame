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
    //First piece to be placed at the start of the game
    public void placeFirst(String first){
        String[] placed = first.split("");
        openLeft = placed[0];
        openRight = placed[1];
    }
    //places a piece on the table and determinies if it is a legal move
    public void placePiece(String side, String piece, Player player, int domino){
        Boolean matchL;
        Boolean matchR;
        Boolean twin;
        String[] played = piece.split("");
        
        if(side.toLowerCase().equals("left")){
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
    //if a piece is placed on the left side of the table, updates left side
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
    //if a piece is placed on the right side of the table, updates right side
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
    //returns the open left domino
    public static String getLeft(){
        return openLeft;
    }
    //returns the open right domino
    public static String getRight(){
        return openRight;
    }
    //returns the printed ends to place a domino
    public static String openEnds(){
        String open = "";
        open += "Open spot left: " + getLeft() + "\nOpen spot right: " + getRight();
        return open;
    }
    
    
}
