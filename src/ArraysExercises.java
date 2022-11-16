import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysExercises {
//    Array Basics
//
//    Create a class inside of src named ArraysExercises. Create a main method for this class to do your work. done
//
//    What happens when you run the following code? Why is Arrays.toString necessary?
//
//
//    int[] numbers = {1, 2, 3, 4, 5};
//    System.out.println(numbers);
//    Create an array that holds 3 Person objects. Assign a new instance of the Person class to each element. Iterate
//    through the array and print out the name of each person in the array.
//
//    Create a static method named addPerson. It should accept an array of Person objects, as well as a single person
//    object to add to the passed array. It should return an array whose length is 1 greater than the passed array,
//    with the passed person object at the end of the array.

    public static Person[] addPerson(Person[] persons,Person additionalPerson){
        Person[] newPersonArray = new Person[persons.length + 1];
        newPersonArray[persons.length] = additionalPerson;
        return newPersonArray;
    }

    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));

        // Create an array that holds 3 Person objects.
        Person[] persons = new Person[3];

        // Assign a new instance of the Person class to each element.
//        Arrays.fill(persons,new Person());
        persons[0] = new Person("John");
        persons[1] = new Person("Danny");
        persons[2] = new Person("Matthew");

        // Iterate through the array and print out the name of each person in the array.
        // Arrays.stream(persons).forEach((person) -> System.out.println(person.getName()));
        for(Person per : persons){
            System.out.println(per.getName());
        }
    }
}
