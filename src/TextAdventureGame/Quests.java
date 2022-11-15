package TextAdventureGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quests {
    List<Quest> availableQuests;
    private Scanner questScanner;
    Quests(Scanner scanner){
        questScanner = scanner;
        availableQuests = new ArrayList<>();
        initializeQuestList();
    }

    private void initializeQuestList(){
        //Create the first quest
        String[] firstQuestDescription = {
                "You've found your first quest. Sometimes you will find items marked on the map",
                "Once you pick them up, they might be a quest you'll be able to take part on.",
                "Welcome to your first quest!. In this game we like to kill stuff. So in order to do that you will need to have a weapon.",
                "Make your way to the plaza and find the blade smith Orion. I have provided you with ↂ300. The ↂ is the currency you can use at the plaza and market to trade for food and equipment.",
                "You can earn ↂ by taking part in quests and completing them. You can also earn ↂ by pawning weapons and equipment at the market.",
                "Use the ↂ to buy yourself a sword from the blacksmith Jack at the Market.",
                "Jack will me marked with ※ on the map."
        };

        //Position the first quest 2 steps to the left of the player's default starting position at the center of the home
        Position firstQuestPosition = new Position(
                Position.columnsNumMap.get(Position.commonPlaces.get("home").getColumn()) - 2,
                Position.commonPlaces.get("home").getRow()
        );

        Quest firstQuest = new Quest("Find a Weapon!",firstQuestDescription, QuestStatus.NotStarted, this.questScanner,firstQuestPosition,"⚀");
        availableQuests.add(firstQuest);

        //Create the second quest
        String[] secondQuestDescription = {
                "You've found your second quest. Now that you have a weapon, you'll need to upgrade it in order to win against mightier opponents.",
                "You'll need to hone your fighting skills, but to do so, you'll need some protective equipment.",
                "Make your way to the Solemn Center and find a fellow named Julius, he will be marked with ⁕ on the map.",
                "He will provide you the protective equipment you will need."
        };

        //Position the second quest 2 steps 3 steps left and 2 steps up from the center of the market
        Position secondQuestPosition = new Position(
                Position.columnsNumMap.get(Position.commonPlaces.get("market").getColumn()) - 3,
                Position.commonPlaces.get("market").getRow() - 2
        );

        Quest secondQuest = new Quest("Get Protective Equipment!", secondQuestDescription, QuestStatus.NotStarted, this.questScanner,secondQuestPosition, "⚁");
        availableQuests.add(secondQuest);
    }
}
