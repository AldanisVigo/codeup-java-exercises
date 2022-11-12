package TextAdventureGame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public static Map<String,String[]> availableObjects = new HashMap<>();

    ObjectDisplay(){
        availableObjects.put("closedbook",closedBook);
        availableObjects.put("openbook",openBook);
    }

    public void printObject(String[] object){
        Arrays.stream(object).forEach((line) -> {
            System.out.print(line);
        });
    }
}
