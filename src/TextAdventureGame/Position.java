package TextAdventureGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Position {
    private int x;
    private int y;

    public static Map<Integer,java.lang.Character> columnsMap = Map.ofEntries(
            entry(0,'A'),
            entry(1,'B'),
            entry(2,'C'),
            entry(3,'D'),
            entry(4,'E'),
            entry(5,'F'),
            entry(6,'G'),
            entry(7,'H'),
            entry(8,'I'),
            entry(9,'J'),
            entry(10,'K'),
            entry(11,'L'),
            entry(12,'M'),
            entry(13,'N'),
            entry(14,'O'),
            entry(15,'P'),
            entry(16,'Q'),
            entry(17,'R'),
            entry(18,'S'),
            entry(19,'T'),
            entry(20,'U'),
            entry(21,'V'),
            entry(22,'W'),
            entry(23,'X'),
            entry(24,'Y'),
            entry(25,'Z')
    );
    public static Map<java.lang.Character,Integer> columnsNumMap = Map.ofEntries(
            entry('A',0),
            entry('B',1),
            entry('C',2),
            entry('D',3),
            entry('E',4),
            entry('F',5),
            entry('G',6),
            entry('H',7),
            entry('I',8),
            entry('J',9),
            entry('K',10),
            entry('L',11),
            entry('M',12),
            entry('N',13),
            entry('O',14),
            entry('P',15),
            entry('Q',16),
            entry('R',17),
            entry('S',18),
            entry('T',19),
            entry('U',20),
            entry('V',21),
            entry('W',22),
            entry('X',23),
            entry('Y',24),
            entry('Z',25)
    );


    public static Map<String,Position> commonPlaces = Map.ofEntries(
            entry("home", new Position(10,'M')), //Center of home
            entry("plaza", new Position(25,'W')) //Center of the plaza
    );

    Position(int startingX, int startingY){
        this.x = startingX;
        this.y = startingY;
    }

    Position(int startingX, char startingCol){
        this.x = startingX;
        this.y = Position.columnsNumMap.get(startingCol);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public char getColumn(){
        char column = Position.columnsMap.get(this.x);
        return column;
    }

    public int getRow(){
        return this.getY();
    }

}
