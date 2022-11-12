package TextAdventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
        private static Map<String, CommandMethod> availableCommands = new HashMap<>();

        private static Scanner scanner;
        MainMenu(Scanner mainScanner){
            this.scanner = mainScanner;

            //Initialize the available commands ony
            availableCommands.put("start", () -> startGame());
            availableCommands.put("exit", () -> stopGame());
            availableCommands.put("create_character", () -> createCharacter());
        }

        private static void createCharacter(){
            System.out.println("===============================");
            System.out.println("====== CHARACTER CREATOR ======");
            System.out.println("===============================");

            CharacterDisplay display = new CharacterDisplay();
            display.availableCharacters.get(0); //Get the first available character

            System.out.println();
            System.out.println("COMMAND: next - go to the next available character.");
            System.out.println("COMMAND: select - select the current character.");
            System.out.println("COMMAND: prev - go to the previous available character.");

            System.out.println("");



            gameCommandLoop();
        }

        //Moves character up one space in any direction the world
        private static void move(MovementDirection direction){
            System.out.printf("Moving character %s one step",direction.toString());
            gameCommandLoop();
        }

        private static void printCharacter(int characterIndex){

        }

        private static void startGame(){
            System.out.println("Starting the game.");
            gameCommandLoop();
        }

        private static void stopGame(){
            System.out.println("Stopping the game.");
            System.out.println("Thanks for playing Solemn Shadows!");
        }

        public static void printTitle(){
            System.out.println("   _____       __                        _____ __              __    __                  ");
            System.out.println("  / ___/____  / /__  ____ ___  ____     / ___// /_  ____ _____/ /___/ /___ _      _______");
            System.out.println("  \\__ \\/ __ \\/ / _ \\/ __ `__ \\/ __ \\    \\__ \\/ __ \\/ __ `/ __  / __  / __ \\ | /| / / ___/");
            System.out.println(" ___/ / /_/ / /  __/ / / / / / / / /   ___/ / / / / /_/ / /_/ / /_/ / /_/ / |/ |/ (__  ) ");
            System.out.println("/____/\\____/_/\\___/_/ /_/ /_/_/ /_/   /____/_/ /_/\\__,_/\\__,_/\\__,_/\\____/|__/|__/____/  ");
            System.out.println();
        }

        public static void printAvailableGameCommands(){
            System.out.println("===============================");
            System.out.println("====== Available Commands =====");
            System.out.println("===============================");
            availableCommands.forEach((String cmd, CommandMethod meth) -> {
                System.out.printf("COMMAND: %s\n",cmd);
            });
            gameCommandLoop();
        }

        public static void gameCommandLoop(){
            System.out.println("SOLEMN >");
            String incomingCommand = scanner.nextLine();
            availableCommands.forEach((String cmd, CommandMethod meth) -> {
                if(incomingCommand.equalsIgnoreCase(cmd)){
                    meth.CommandMethod();
                }
            });
        }

        public static void printMainMenu(){
            printTitle(); //Print out the title of the game
            printAvailableGameCommands(); //Show the commands that are available for the game
            gameCommandLoop();
        }
}
