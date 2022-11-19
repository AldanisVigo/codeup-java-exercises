package TextAdventureGame;

import java.util.*;
import static java.util.Map.Entry;


public class CharacterDisplay {
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

    public static String[] casper = {
            "    .-----.\n",
            "   .' -   - '.\n",
            "  /  .-. .-.  \\\n",
            "  |  | | | |  |\n",
            "   \\ \\o/ \\o/ /\n",
            "  _/    ^    \\_\n",
            " | \\  '---'  / |\n",
            " / /`--. .--`\\ \\\n",
            "/ /'---` `---'\\ \\\n",
            "'.__.       .__.'\n",
            "    `|     |`\n",
            "     |     \\\n",
            "     \\      '--.\n",
            "      '.        `\\\n",
            "        `'---.   |\n",
            "           ,__) /\n",
            "            `..'\n"
    };

    public static String[] homer = {
            "    ___\n",
            "   //_\\\\_\n",
            " .\"\\\\    \".\n",
            " .\"\\\\    \".\n",
            "/          \\\n",
            "|           \\_\n",
            "|       ,--.-.)\n",
            " \\     /  o \\o\\\n",
            " /\\/\\  \\    /_/\n",
            "  (_.   `--'__)\n",
            "   |     .-'  \\\n",
            "   |  .-'.     )\n",
            "   | (  _/--.-'\n",
            "   |  `.___.'\n",
            "         (\n"
    };

    public Map<String,String[]> availableCharacters = new HashMap<>();

    CharacterDisplay(){
        //Create the bart character
        availableCharacters.put("bart",bart);
        //Create the homer character
        availableCharacters.put("homer",homer);
        //Create the casper character
        availableCharacters.put("casper",casper);
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
