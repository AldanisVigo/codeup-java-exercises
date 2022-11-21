package grocerylistapp;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class GroceryList {

    //List of available categories for the grocery list
    public static ArrayList<String> availableCategories = new ArrayList<>() {
        {
            add("Frozen");
            add("Refrigerated");
            add("Canned");
            add("Baked");
            add("Dairy");
            add("Cereal");
            add("Cleaning");
            add("Miscellaneous");
        }
    };

    //Map of categories to grocery lists
    private HashMap<Integer,ArrayList<GroceryItem>> list;

    //Constructor
    public GroceryList(){
        //Initialize the private list map
        this.list = new HashMap<>();
    }

    /*
        Method for printing out the menu of available categories
     */
    public static void printCategoriesMenu(){
        //Display the menu header
        System.out.println("===================================");
        System.out.println("======== Grocery Categories =======");
        System.out.println("===================================");

        //Iterate through the available categories
        for(int i = 0; i < availableCategories.size(); i++){
            //And print out the category id and it's name
            System.out.printf("%d - %s\n",i,availableCategories.get(i));
        }
        //Add an empty line for looks
        System.out.println();
    }

    /*
        Method to add a grocery item to a category in the grocery list map
     */
    public void addGroceryItem(GroceryItem item){
        //Get a list of existing items for the category of the item
        ArrayList<GroceryItem> existingItems = list.get(item.getCategoryId());

        //if there's no list available
        if(existingItems == null){
            //Create a new list
            existingItems = new ArrayList<GroceryItem>();
            //Add the passed item into it
            existingItems.add(item);
        }else { //Otherwise
            existingItems.add(item); //Add the ite to the existing list of items
        }

        //Exchange the list of items for the new one for the category
        this.list.put(item.getCategoryId(),existingItems);
    }

    /*
        Method for updating a grocery item based on a category and item index
     */
    public void updateGroceryItem(int categoryId, int itemIndex, GroceryItem editedItem){
        this.list.get(categoryId).get(itemIndex).updateWith(editedItem);
    }

    /*
        Method for deleting a grocery item based on a category and item index
     */
    public void deleteCategoryItem(int categoryId, int itemIndex){

        //Get all the existing items from the list for the given category
        List<GroceryItem> existingItems = list.get(categoryId);

        //Get a filtered stream which excludes the item at the given index
        Stream<GroceryItem> filteredItems = existingItems.stream().filter(item->existingItems.indexOf(item) != itemIndex);

        //Replace the existing list of items for the category with the filtered list
        list.put(categoryId, (ArrayList<GroceryItem>) filteredItems.toList());
    }

    /*
        Method for getting the grocery list map
     */
    public HashMap<Integer,ArrayList<GroceryItem>> getGroceryList() {
        return this.list;
    }

    /*
        Main method for testing the class
     */
    public static void main(String[] args){
        //Create a new grocery list
        GroceryList list = new GroceryList();

        //Generate some grocery items
        GroceryItem itemO = new GroceryItem(0,"Item One",10);
        GroceryItem item1 = new GroceryItem(1, "Item Two", 14);

        //Add the grocery items to the grocery list
        list.addGroceryItem(itemO);
        list.addGroceryItem(item1);

        //Print the categories menu from the grocery list instance
        list.printCategoriesMenu();

        //Iterate through the groceryList
        list.getGroceryList().forEach((id,groceryItems)->{
            System.out.println("Category : " + id); //Print the category id
            groceryItems.stream().forEach((GroceryItem item)->{ //Iterate through the items list for that category
                System.out.printf("%s - %d\n",item.getName(),item.getQty()); //Display the item's name and quantity
            });
            System.out.println(); //Add an empty line for looks
        });
    }
}
