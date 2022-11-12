package TextAdventureGame;

import java.util.Scanner;

public class TextAdventureGame {
    private static World world = new World();
    public static void main(String[] args){
        MainMenu worldMenu = world.getWorldMenu();
        worldMenu.printMainMenu();
    }
}
