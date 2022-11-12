package TextAdventureGame;

public class CharacterPosition {
    private int x;
    private int y;

    CharacterPosition(){
        this.x = 0; //Default at x = 0
        this.y = 0; //Default at y - 0
    }

    CharacterPosition(int startingX, int startingY){
        this.x = startingX;
        this.y = startingY;
    }

    public void setX(int x){

    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
