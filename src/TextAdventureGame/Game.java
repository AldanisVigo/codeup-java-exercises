package TextAdventureGame;

import java.util.*;

public class Game {
        private static Map<String, CommandMethod> availableCommands = new HashMap<>();

        private static Scanner scanner;

        private static WorldState world;
        private boolean characterSelected;

        private Position characterPosition;

        private List<GameObject> gameObjectList = new ArrayList<>();

        private int currentSelection;

        Game(Scanner mainScanner){
            this.scanner = mainScanner;

            //Initialize the available commands ony
            availableCommands.put("start", () -> startGame());
            availableCommands.put("exit", () -> stopGame());
            availableCommands.put("showmap", () -> printMap());
            availableCommands.put("select", () -> createCharacter());
            availableCommands.put("menu", () -> printAvailableGameCommands());
            availableCommands.put("up", () -> move(MovementDirection.up));
            availableCommands.put("down", () -> move(MovementDirection.down));
            availableCommands.put("right", () -> move(MovementDirection.right));
            availableCommands.put("left", () -> move(MovementDirection.left));
            availableCommands.put("mypos", () -> {
                if(characterPosition != null){
                    System.out.printf("(%d,%c)\n",characterPosition.getY(),characterPosition.getColumn());
                }else{
                    System.out.println("You must select a character with the select command first!");
                }
            });

            //Create the world state
            world = new WorldState();

            //Set the character position

            printMainMenu();
        }

        private void printMap(){
            if(this.characterPosition != null) {
                System.out.printf("(%d,%d)\n", this.characterPosition.getY(), this.characterPosition.getX());
            }

            world.printMap(this.characterPosition);
        }

        private void createCharacter(){
            System.out.println("===============================");
            System.out.println("====== CHARACTER CREATOR ======");
            System.out.println("===============================");

            this.currentSelection = 0;
            this.characterSelected = false;

            while(!characterSelected) {
                //Get a character display
                CharacterDisplay display = new CharacterDisplay();

                //Display the character at the current selection
                display.printCharacterAtIndex(currentSelection);

                //Print the available commands
                System.out.println();
                System.out.println("COMMAND: next - go to the next available character.");
                System.out.println("COMMAND: select - select the current character.");
                System.out.println("COMMAND: prev - go to the previous available character.");
                System.out.println("COMMAND: return - return to the normal game menu.");
                System.out.println();

                //Show the character scroll command line
                System.out.print("SOLEMN > ");

                String inputCommand = scanner.nextLine();

                if(inputCommand.equals("next")){ //If they type in the next command
                    //If we're still in the range of available characters
                    if(this.currentSelection < display.availableCharacters.size() - 1){
                        this.currentSelection++; //Go to the next available character
                    }
                }else if(inputCommand.equals("prev")){ //If they type in the prev command
                    if(this.currentSelection > 0){ //If we're past the first character
                        this.currentSelection--; //Go to the previous character
                    }
                }else if(inputCommand.equals("return")){
                     break; //Break out of the loop without setting character selected
                }else if(inputCommand.equals("select")){
                    this.characterSelected = true; //Break out of the loop setting character selected
                }
            }

            if(this.characterSelected){ //Check if they selected the character.
                System.out.println("You have selected a character. You may now enter the world of Solemn Shadows by entering the start command.");
                char column = Position.commonPlaces.get("home").getColumn();
                int row = Position.commonPlaces.get("home").getY();
                System.out.printf("Column: %c\n", column);
                System.out.printf("Row: %d\n", row);

                this.characterPosition = new Position(row,column);
                System.out.printf("[%d, %c]\n",this.characterPosition.getY(),this.characterPosition.getColumn());
            }else{
                System.out.println("You must select a character with the select command in order to enter the world of Solemn Shadows.");
            }
        }

        //Moves character up one space in any direction the world
        private void move(MovementDirection direction){
            if(this.characterSelected) {
                System.out.print("How many steps would you like to move? > ");
                int steps = scanner.hasNextInt() ? scanner.nextInt() : 1;
                int maxSteps = 4;
                switch(direction) {
                    case up:
                        //Attempt to move that number of steps
                        for(int s = 0; s < steps; s++) { //iterate the number of steps
                            if(this.characterPosition.getY() > 0) { //As long as we're not at the top edge of the map
                                this.characterPosition.setY(this.characterPosition.getY() - 1); //Move up by 1 step
                            }else break;
                        }

                        //Edge check
                        if(this.characterPosition.getY() == 0){
                            System.out.println("You are at the northern edge of the map. You cannot move up any further.");
                        }
                        //Print the map
                        this.world.printMap(this.characterPosition);

                        //Break out of the switch
                        break;
                    case down:
                        //As long as we're not at the bottom edge of the map allow the player to move down one step
                        for(int s = 0; s < steps; s++) {
                            if(this.characterPosition.getY() < this.world.getWorldMap().length - 1) {
                                this.characterPosition.setY(this.characterPosition.getY() + 1);
                            }else break;
                        }

                        //Edge check
                        if(this.characterPosition.getY() == this.world.getWorldMap().length - 1) {
                            System.out.println("You are at the southern edge of the map. You cannot move down any further.");
                        }

                        //Print the map
                        this.world.printMap(this.characterPosition);

                        break;
                    case left:
                        //As long as we're not at the left edge of the map, allow the user to move left one step
                        for(int s = 0; s < steps; s++){
                            if(this.characterPosition.getX() > 0) {
                                this.characterPosition.setX(this.characterPosition.getX() - 1);
                            }else break;
                        }

                        //Edge check
                        if(this.characterPosition.getX() == 0) {
                            System.out.println("You are at the western edge of the map. You cannot move left any further.");
                        }

                        //Print the map
                        this.world.printMap(this.characterPosition);

                        break;
                    case right:
                        //As long as we're not at the right edge of the map, allow the player to move right one step
                        for(int s = 0; s < steps; s++){
                            if(this.characterPosition.getX() < this.world.getWorldMap()[0].length - 1) {
                                this.characterPosition.setX(this.characterPosition.getX() + 1);
                            }else break;
                        }

                        //Edge check
                        if(this.characterPosition.getX() == this.world.getWorldMap()[0].length - 1) {
                            System.out.println("You are at the eastern edge of the map. You cannot move right any further.");
                        }

                        //Print the map
                        this.world.printMap(this.characterPosition);

                        break;
                    default:
                        System.out.println("Invalid movement command");
                        break;
                }
            }else{
                System.out.println("You must select a character with the select command before attempting to move in the game!");
            }
        }

        private void startGame(){
            if(this.characterSelected) {
                System.out.println("Starting the game.");
            }else{
                System.out.println("You must select a character first by entering the select_character command.");
            }
        }

        private static void stopGame(){
            System.out.println("Stopping the game.");
            System.out.println("Thanks for playing Solemn Shadows!");
            System.exit(0);
        }

        public static void printTitle(){
            System.out.println("   _____       __                        _____ __              __                  ");
            System.out.println("  / ___/____  / /__  ____ ___  ____     / ___// /_  ____ _____/ /___ _      _______");
            System.out.println("  \\__ \\/ __ \\/ / _ \\/ __ `__ \\/ __ \\    \\__ \\/ __ \\/ __ `/ __  / __ \\ | /| / / ___/");
            System.out.println(" ___/ / /_/ / /  __/ / / / / / / / /   ___/ / / / / /_/ / /_/ / /_/ / |/ |/ (__  ) ");
            System.out.println("/____/\\____/_/\\___/_/ /_/ /_/_/ /_/   /____/_/ /_/\\__,_/\\__,_/\\____/|__/|__/____/");
            System.out.println();
        }

        public static void printAvailableGameCommands(){
            System.out.println("===============================");
            System.out.println("====== Available Commands =====");
            System.out.println("===============================");
            availableCommands.forEach((String cmd, CommandMethod meth) -> {
                System.out.printf("COMMAND: %s\n",cmd);
            });
        }

        public static void gameCommandLoop(){
            while(true) {
                System.out.print("SOLEMN > ");
                String incomingCommand = scanner.nextLine();
                availableCommands.forEach((String cmd, CommandMethod meth) -> {
                    if (incomingCommand.equalsIgnoreCase(cmd)) {
                            meth.CommandMethod();
                    }
                });
            }
        }

        public static void printMainMenu(){
            printTitle(); //Print out the title of the game
            printAvailableGameCommands(); //Show the commands that are available for the game
            gameCommandLoop();
        }
}
