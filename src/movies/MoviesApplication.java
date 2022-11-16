package movies;

import util.Input;

import java.util.Scanner;

public class MoviesApplication {
    private Scanner scanner;
    private String[] categories;
    private MoviesArray moviesArray;

    public Scanner getScanner() {
        return this.scanner;
    }

    public MoviesApplication(Scanner scanner){
        this.scanner = scanner;
        this.categories = new String[]{"animated", "drama", "horror", "sci-fi", "musical", "comedy"};
        this.moviesArray = new MoviesArray();
    }

    private static void drawMovie(Movie movie){
        if(movie == null) return;
        System.out.printf("%s", movie.getName());
        int dashes = 50 - movie.getName().length();
        for (int i = 0; i < dashes; i++) {
            System.out.print('-');
        }
        System.out.printf("%s\n", movie.getCategory());
    }

    private static void drawMovies(Movie[] allMovies,String selectedCategory){
        if(selectedCategory.equals("all")){
            for (Movie movie : allMovies) {
               drawMovie(movie);
            }
        }else {
            for (Movie movie : allMovies) {
                if (movie.getCategory().equalsIgnoreCase(selectedCategory)) {
                    drawMovie(movie);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // Give the user a list of options for viewing all the movies or viewing movies by category.
        MoviesApplication moviesApplication = new MoviesApplication(scan);
        boolean exitConditionMet = false;

        while(!exitConditionMet) {
            System.out.println("\n0 - Exit");
            System.out.println("1 - Add Movie");
            System.out.println("2 - View all movies");
            for (int i = 3; i < moviesApplication.categories.length + 3; i++) {
                System.out.printf("%d - view movies in the %s category\n", i, moviesApplication.categories[i - 3]);
            }
            Input input = new Input(new Scanner(System.in));
            System.out.println();
            int choice = input.getInt("Enter your choice:".describeConstable());
            Movie[] allMovies = moviesApplication.moviesArray.findAll();
            if (choice != 0 && choice != 1 && choice != 2) { //As long as the user has not chosen to exit or see all movies
                String selectedCategory = moviesApplication.categories[choice - 3]; //Grab the category they selected
                System.out.println();
                drawMovies(allMovies,selectedCategory);
            } else if( choice == 0){ //User has chosen to exit
                exitConditionMet = true; //Kick us out of the loop
            } else if( choice == 1) { //The user wants to add a movie
                moviesApplication.addMovieFlow();
            } else if( choice == 2){ //User wants to see all movies
                drawMovies(allMovies,"all");
            } else {
                System.out.println("Invalid choice, please select a valid choice.");
            }
        }
    //    Use your Input class to get input from the user, and display information based on their choice.
    //    (Remember to import your Input class)
    //    If a category is selected, only movies from that category should be displayed.
    //    Your application should continue to run until the user chooses to exit.
    }

    private void addMovieFlow(){
        System.out.print("Enter the name of the new movie: ");
        String movieName = this.scanner.nextLine();
        for(int i = 1; i < categories.length + 1; i++){
            System.out.printf("%d - %s\n",i,categories[i-1]);
        }
        System.out.println();
        System.out.print("Choose the category: ");
        int selectedCategory = this.scanner.nextInt() - 1;
        System.out.println();
        System.out.printf("New Movie Name: %s \nNew Movie Category: %s",movieName,this.categories[selectedCategory]);
        this.moviesArray.addMovie(new Movie(movieName,this.categories[selectedCategory]));
    }
}

