package movies;

public class Movie {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String name;

    private String category;

    public Movie(String name, String category){
        this.name = name;
        this.category = category;
    }

//    Create a class named Movie. It should have private fields for name and category, and a constructor that sets
//    both of these. Create methods to access these properties and change them (getters and setters).
//    Download the MoviesArray file and save it as MoviesArray.java inside of movies. This class has a static method
//    named findAll that will return an array of Movie objects.
//    Create a class named MoviesApplication that has a main method.
//    Give the user a list of options for viewing all the movies or viewing movies by category.
//    Use your Input class to get input from the user, and display information based on their choice.
//    (Remember to import your Input class)
//    If a category is selected, only movies from that category should be displayed.
//    Your application should continue to run until the user chooses to exit.
}
