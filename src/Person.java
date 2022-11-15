public class Person {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void sayHello() {
        if (this.name == null) {
            System.out.println("Hello that whom shall be unamed.");
        } else {
            System.out.printf("Hello %s\n", this.name);
        }
    }

    Person(){

    }

    Person(String name){
        this.name = name;
    }

    public static void main(String[] args){
        //Creating an instance
        Person someone = new Person("Someone");

        //Calling methods from the instance
        someone.sayHello();

        //Understanding references
//        Person person1 = new Person("John");
//        Person person2 = new Person("John");
//        System.out.println(person1.getName().equals(person2.getName()));
//        System.out.println(person1 == person2);

//        Person person1 = new Person("John");
//        Person person2 = person1;
//        System.out.println(person1 == person2);
        Person person1 = new Person("John");
        Person person2 = person1;
        System.out.println(person1.getName());
        System.out.println(person2.getName());
        person2.setName("Jane");
        System.out.println(person1.getName());
        System.out.println(person2.getName());


    }
}
