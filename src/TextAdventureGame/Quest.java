package TextAdventureGame;

import java.util.Scanner;

public class Quest {
    private QuestStatus status;
    private String questTitle;
    private String[] questDescription;

    private Position questPosition;
    private Scanner questScanner;

    private String questMapSymbol;

    Quest(String title, String[] description, QuestStatus status, Scanner scanner,Position questPosition,String questMapSymbol){
        this.questTitle = title;
        this.questDescription = description;
        this.status = status;
        this.questScanner = scanner;
        this.questPosition = questPosition;
        this.questMapSymbol = questMapSymbol;
    }

    public void printQuestDescription(){
        for(int dp = 0; dp < this.questDescription.length; dp++) {
            System.out.print(this.questDescription[dp]);
            if(dp < this.questDescription.length) {
                System.out.println("Press enter for more.");
                this.questScanner.nextLine();
            }
        }
    }

    public Position getQuestPosition(){
        return this.questPosition;
    }

    public String getQuestTitle(){
        return this.questTitle;
    }

    public String getQuestMapSymbol(){
        return this.questMapSymbol;
    }
}
