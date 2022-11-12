package TextAdventureGame;

import java.util.*;
import static java.util.Map.Entry;


public class CharacterDisplay {
    public static String[] mickey = {
            "                       _____\n",
            "                   .d88888888bo.\n",
            "                 .d8888888888888b.\n",
            "                 8888888888888888b\n",
            "                 888888888888888888\n",
            "                 888888888888888888\n",
            "                  Y8888888888888888\n",
            "            ,od888888888888888888P\n",
            "         .'`Y8P'```'Y8888888888P'\n",
            "       .'_   `  _     'Y88888888b\n",
            "      /  _`    _ `      Y88888888b   ____\n",
            "   _  | /  \\  /  \\      8888888888.d888888b.\n",
            "  d8b | | /|  | /|      8888888888d8888888888b\n",
            " 8888_\\ \\_|/  \\_|/      d888888888888888888888b\n",
            " .Y8P  `'-.            d88888888888888888888888\n",
            "/          `          `      `Y8888888888888888\n",
            "|                        __    888888888888888P\n",
            " \\                       / `   dPY8888888888P'\n",
            "  '._                  .'     .'  `Y888888P`\n",
            "     `\"'-.,__    ___.-'    .-'\n",
            "         `-._````  __..--'`\n",
            "             ``````\n"
    };

    public static String[] bart = {
            "     ,.\n",
            "    /   `' |,-,\n",
            "   /         /_\n",
            " _/            /\n",
            "(.-,--.       /\n",
            "/o/  o \\     /\n",
            "\\_\\    /   _/\n",
            "(__`--'    _)\n",
            " /         |\n",
            "(_____,'    \\\n",
            "   \\_       _\\\n",
            "     `._..-'"
    };

    public Map<String,String[]> availableCharacters = new HashMap<>();

    CharacterDisplay(){
        //Create the mickey character
        availableCharacters.put("mickey",mickey);
        //Create the bart character
        availableCharacters.put("bart",bart);
    }

    public void printCharacter(String name) {
        Arrays.stream(availableCharacters.get(name)).forEach(System.out::print);
    }

    public void printCharacterAtIndex(int index){
        Entry<String,String[]> selectedCharacter = (Entry<String,String[]>) availableCharacters.entrySet().toArray()[index];
        System.out.printf("Character's Name: %s\n", selectedCharacter.getKey());
        Arrays.stream(selectedCharacter.getValue()).forEach(System.out::print);
    }
}
