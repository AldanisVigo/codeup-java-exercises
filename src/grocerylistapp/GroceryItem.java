package grocerylistapp;

public class GroceryItem implements Comparable {
    //Field for storing the grocery item's name
    private String name;

    //Field for storing the grocery item's quantity
    private int qty;

    //Field for storing the id of the category the item falls under
    private int category_id;

    public void setCategoryId(int id){
        this.category_id = id;
    }

    //Overloaded Constructor
    public GroceryItem(int category_id,String name, int qty){
        this.category_id = category_id;
        this.name = name;
        this.qty = qty;
    }

    //Default Constructor
    public GroceryItem(){
    }

    //Method for updating the current grocery item with the values of the given grocery item
    public void updateWith(GroceryItem item){
        this.category_id = item.category_id;
        this.name = item.name;
        this.qty = item.qty;
    }

    //Method for getting the category id of this grocery item
    public int getCategoryId(){
        return this.category_id;
    }

    //Method for getting the name of this grocery item
    public String getName() {
        return this.name;
    }

    //Method for setting the name of the grocery item
    public void setName(String name){
        this.name = name;
    }

    //Method for getting the quantity of this grocery item
    public int getQty(){
        return this.qty;
    }

    //Method for setting the quantity of this grocery item
    public void setQty(int qty){
        this.qty = qty;
    }

    //Method required to conform to the Comparable interface
    @Override
    public int compareTo(Object o) {
        GroceryItem  passedItem;
        try {
            //Cast the passed object to a grocery item
            passedItem = (GroceryItem) o;

            //And return the comparison of the passed item to this one
            return this.name.compareTo(passedItem.getName());

        }catch (Exception e){ //Catch the error
            throw e; //Throw the error
        }
    }
}
