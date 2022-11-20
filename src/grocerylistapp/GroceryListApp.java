package grocerylistapp;

import util.Input;
import java.util.*;
import java.util.stream.Stream;

public class GroceryListApp {
    /*
        Method for asking the user to input a new item into the grocery list.
     */
    private static void askForNewItem(GroceryList groceryList, Input input){
        //Print the list of available product categories
        groceryList.printCategoriesMenu();

        //Ask them to select one of the categories from the list
        int newProductCategoryId = input.getInt(0,groceryList.availableCategories.size() - 1,"Select a category:".describeConstable());

        //Ask them to enter the name of the new item
        String newProductName = input.getString("Enter the name of the new item: ");

        //Ask them to enter the quantity of the new item
        int newProductQuantity = input.getInt("Enter the quantity of the new item:".describeConstable());

        //Create a new grocery item out of the data we collected
        GroceryItem newGroceryItem = new GroceryItem(newProductCategoryId,newProductName,newProductQuantity);

        //Add the item to the grocery list
        groceryList.addGroceryItem(newGroceryItem);
    }

    /*
        Method for displaying the alphabetized list of grocery items for a given category
     */
    private static void displayAlphabetizedCategory(GroceryList groceryList, int categoryId){
        //Get the list of grocery items for the category
        List<GroceryItem> groceryItemsForCategory = groceryList.getGroceryList().get(categoryId);

        //Display the header for the list of grocery items for the current category
        System.out.printf("========= PRINTING ITEMS FOR %s CATAGORY ==========\n",GroceryList.availableCategories.get(categoryId));
        System.out.printf("%-10s%-20s%-20s%-20s\n","Item Id","Item Category","Item Name","Item Quantity");

        try { //Attempt to sort the items in the category
            Collections.sort(groceryItemsForCategory);
        } catch (Exception e) { //If there's an exception
            throw new RuntimeException(e); //Throw it
        }

        //Iterate through the grocery items for the current category
        for(int i = 0; i < groceryItemsForCategory.size(); i++) {
            //Grab the grocery item for the current index
            GroceryItem item = groceryList.getGroceryList().get(categoryId).get(i);
            //Print out it's information
            System.out.printf("%-10d%-20s%-20s%-20s\n",
                    i,GroceryList.availableCategories.get(item.getCategoryId()), item.getName(), item.getQty());
        }
    }

    /*
        Method for displaying the categorized alphabetized grocery list
     */
    private static void displayCategorizedAlphabetizedGroceryList(GroceryList groceryList){
        //Generate an array of objects based on the grocery list map keyset.
        Object[] keys = groceryList.getGroceryList().keySet().toArray();
        //Get a stream of sorted keys from the grocery list keys array
        Stream<Object> sortedKeys = Arrays.stream(keys).sorted();
        //Iterate through the sorted keys
        sortedKeys.forEach(key->{
            //Display the alphabetized list for the category
            displayAlphabetizedCategory(groceryList,(int) key);
        });
    }


    /*
        Main method for testing the class
     */
    public static void main(String[] args){
        //Create an instance of the grocery list
        GroceryList groceryList = new GroceryList();

        //Create an instance of the Input class so that we can ask for information using a Scanner.
        Input input = new Input(new Scanner(System.in));

        //Ask the user if they want to create a grocery list.
        boolean wouldLikeToCreateList = input.yesNo("Would you like to create a grocery list?".describeConstable());

        //If the user answers yes
        if(wouldLikeToCreateList){
            //Give the user a choice to finalize the list or add a new item
            //and if they choose to add an item
            while(input.yesNo("Would you like to input a new item?".describeConstable())){
                //Ask the user to input the item's data
                askForNewItem(groceryList,input);
            }

            //Once the user finalizes the list
            displayCategorizedAlphabetizedGroceryList(groceryList);

        }else{ //Otherwise end the program
            System.exit(0);
        }
    }
}
