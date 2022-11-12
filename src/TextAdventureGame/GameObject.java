package TextAdventureGame;

public class GameObject {
    private String objectKey;
    private Position objectPosition;

    ObjectDisplay display;

    GameObject(String key, Position pos){
        this.objectKey = key;
        this.objectPosition = pos;
        this.display = new ObjectDisplay();
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public Position getObjectPosition() {
        return this.getObjectPosition();
    }
}
