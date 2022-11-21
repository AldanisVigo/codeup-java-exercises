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
        System.out.printf(">>>> %s\n",GroceryList.availableCategories.get(categoryId));
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
        //Empty line
        System.out.println();

        //Generate an array of objects based on the grocery list map keyset.
        Object[] keys = groceryList.getGroceryList().keySet().toArray();

        //Get a stream of sorted keys from the grocery list keys array
        Stream<Object> sortedKeys = Arrays.stream(keys).sorted();

        //Display the header for the grocery list
        System.out.println("================================================");
        System.out.println("================== Grocery List ================");
        System.out.println("================================================");

        //Iterate through the sorted keys
        sortedKeys.forEach(key->{
            //Display the alphabetized list for the category
            displayAlphabetizedCategory(groceryList,(int) key);
        });

        System.out.println(); //Empty line
    }

    /*
        Menu that appears after the list has been generated.
     */
    private static void postResultMenu(Input input, GroceryList list){
        //Empty line
        System.out.println();

        //Print out the menu header
        System.out.println("==========================");
        System.out.println("========== MENU ==========");
        System.out.println("==========================");

        while(true) {
            //Print out the menu choices
            System.out.println("edit     : Edit an item in the list");
            System.out.println("category : Filter list by category");
            System.out.println("ls       : Show the grocery list");
            System.out.println("add      : Add a new item to the list");
            System.out.println("exit     : Close the program");
            System.out.println();
            System.out.print(">>> ");

            //Get the menu choice
            String menuChoice = input.getString();
            if (menuChoice.equals("exit")){ //If the user wants to exit the program
                System.exit(0); //Send the kill signal
            } else if (menuChoice.equals("add")){ //If they want to add something to the list
                askForNewItem(list,input); //Ask for a new item
            } else if (menuChoice.equals("ls")){ //If they want to list all the items in the list
                displayCategorizedAlphabetizedGroceryList(list); //Do it
            } else if (menuChoice.equals("edit")) { //If they want to edit the list
                boolean selectedACategory = false; //Flag for when they select a category
                int selectedCategoryId = -1;
                do { //Keep looping through this next block
                    //Ask what category the user wants to edit a grocery item from
                    System.out.println("Please select a category of products to edit:");

                    //Iterate through the grocery list and get all the categories that are available in the list
                    for (int i = 0; i < list.getGroceryList().keySet().size(); i++) {
                        //Print out the category id and it's name
                        System.out.printf("%d - %s\n", i, GroceryList.availableCategories.get(i));
                    }

                    //Prompt for the category id
                    selectedCategoryId = input.getInt("Enter a number >>> ".describeConstable());

                    //Check if the category they typed in is valid
                    if (selectedCategoryId > list.getGroceryList().keySet().size() || selectedCategoryId < 0) {
                        //If the user provided a negative number for the id, or the user provided an id out of range
                        System.out.println("Please provide a valid category id.");
                    } else {
                        selectedACategory = true;
                    }

                    //As long as the input is null
                } while (!selectedACategory);

                //TODO: Display all the products for the selected category id
                int selectedItemIndex = -1;
                boolean itemSelected = false;
                //Grab the list of grocery items for the selected category id
                List<GroceryItem> items = list.getGroceryList().get(selectedCategoryId);

                do {
                    //Display the products for the selected category
                    System.out.printf("Now select the product you want to edit in the %s category:\n", GroceryList.availableCategories.get(selectedCategoryId));

                    //Iterate through the items
                    for (int i = 0; i < items.size(); i++) {
                        GroceryItem currentItem = items.get(i); //Pull out each grocery item

                        //And print out it's index and information
                        System.out.printf("%-15d%-20s%-20d\n", i, currentItem.getName(), currentItem.getQty());
                    }

                    //Empty line
                    System.out.println();

                    //Get the selected item index
                    selectedItemIndex = input.getInt(" SELECT AN ENTRY >>> ".describeConstable());

                    //Check if the item is in range
                    if (selectedItemIndex > -1 && selectedItemIndex < items.size()) {
                        itemSelected = true; //If it is kick us out of the loop
                    } else {
                        System.out.println("Please select an entry that is in range.");
                    }
                } while (!itemSelected);

                System.out.printf("===== Editing the %d'th item in the %s category ===== \n",
                        selectedItemIndex, GroceryList.availableCategories.get(selectedCategoryId));

                boolean deleteItem = input.yesNo("Would you like to delete this item?".describeConstable());
                //If the user does not want to delete this item
                if (!deleteItem) { //Edit the item instead
                    System.out.printf("New Item Name (default: %s)", list.getGroceryList().get(selectedCategoryId).get(selectedItemIndex).getName());
                    String newItemName = input.getString();

                    System.out.printf("New Item Quantity (default %d)", list.getGroceryList().get(selectedCategoryId).get(selectedItemIndex).getQty());
                    int newItemQty = input.getInt(null);

                    //Create a new grocery item to update the selected one with
                    GroceryItem updatedItem = new GroceryItem();

                    //Set the category id to the selected category id
                    updatedItem.setCategoryId(selectedCategoryId);

                    //Keep the default name
                    if(newItemName.equals("")){
                        updatedItem.setName(list.getGroceryList().get(selectedCategoryId).get(selectedItemIndex).getName());
                    }else{
                        updatedItem.setName(newItemName);
                    }

                    //Keep the default qty
                    if(newItemQty == Integer.MIN_VALUE){
                        updatedItem.setQty((list.getGroceryList().get(selectedCategoryId).get(selectedItemIndex).getQty()));
                    }else{
                        updatedItem.setQty(newItemQty);
                    }


                    //And update it with the updated item
                    list.getGroceryList().get(selectedCategoryId).get(selectedItemIndex).updateWith(updatedItem);

                } else {
                    list.deleteCategoryItem(selectedCategoryId, selectedItemIndex);
                }
            } else if (menuChoice.equals("category")) {
                boolean selectedCategory = false;
                int selectedCategoryIndex = -1;
                do {
                    System.out.println();
                    System.out.println("Please select a category to display:");
                    GroceryList.printCategoriesMenu();
                    System.out.println();
                    selectedCategoryIndex = input.getInt(" SELECT CATEGORY >>> ".describeConstable());
                    System.out.printf("You have selected: %d\n",selectedCategoryIndex);
                    //Check that the selected category id is in range
                    if (selectedCategoryIndex >= 0 && selectedCategoryIndex < list.getGroceryList().keySet().size()) {
                        //If the category is in range
                        selectedCategory = true; //Kick us out of the loop
                    } else { //Otherwise
                        //Ask the user to enter a category that is in range
                        System.out.println("That category is not found in the list");
                    }
                } while (!selectedCategory);

                //Get a final selected category index
                final int catIndex = selectedCategoryIndex;

                //Display the alphabetized list for that category
                displayAlphabetizedCategory(list, catIndex);
            }
        }
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

            //Show post result menu
            postResultMenu(input,groceryList);

        }else{ //Otherwise end the program
            System.exit(0);
        }
    }
}
