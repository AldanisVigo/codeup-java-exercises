package TextAdventureGame;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;

    private Weapon primaryWeapon;

    private List<Weapon> weaponsStorage = new ArrayList<>();

    private String[] ascii;
    private Position characterPosition;

    Character(String chosenName, Position characterPosition, String[] characterAscii){ //Constructor will execute when a new instance of character is created
        this.characterPosition = characterPosition; //Set the initial position of the character
        this.name = chosenName; //Give the new character the chosen name
        this.primaryWeapon = Weapon.Unarmed; //The character starts off with no weapons
        this.ascii = characterAscii;
    }

    /*
        Returns the name of the character instance
     */
    public String getName() {
        return name;
    }

    /*
        Returns the primary weapon of the character instance
     */
    public Weapon getPrimaryWeapon() {
        return primaryWeapon;
    }

    /*
        Returns the weapons storage list for the character instance
     */
    public List<Weapon> getWeaponsStorage() {
        return weaponsStorage;
    }


    /*
        Takes in a weapon and stores it in the weapons storage
     */
    private void addWeaponToStorage(Weapon w){
        if(weaponsStorage.size() < 10){ //Can only store up to 10 weapons
            weaponsStorage.add(w);
        }else{
            System.out.println("Your weapons storage is full. Please remove a weapon first.");
        }
    }

    /*
        Swaps the active weapon for one in the weapons storage at the passed index
     */
    private void swapActiveWeaponForStoredWeapon(int index){
        Weapon newPrimaryWeapon = weaponsStorage.get(index); //Get the weapon that's stored at that index
        weaponsStorage.set(index, primaryWeapon); //Replace it the active weapon
        this.primaryWeapon = newPrimaryWeapon; //Set the primary weapon to the one that was there
    }

    /*
        Drops a weapon at the current location in the world
     */
}
