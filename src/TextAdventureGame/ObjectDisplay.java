package TextAdventureGame;

import java.util.Arrays;

public class ObjectDisplay {
    public static String[] closedBook = {
            "    _______\n",
            "   /      /,\n",
            "  /      //\n",
            " /______//\n",
            "(______(/\n"
    };

    public static String[] openBook = {
            "      ______ ______\n",
            "    _/      Y      \\_\n",
            "   // ~~ ~~ | ~~ ~  \\\n",
            "  // ~ ~ ~~ | ~~~ ~~ \\\n",
            " //________.|.________\\\n",
            "`----------`-'----------'\n"
    };

    public void printObject(String[] object){
        Arrays.stream(object).forEach((line) -> {
            System.out.print(line);
        });
    }
}
