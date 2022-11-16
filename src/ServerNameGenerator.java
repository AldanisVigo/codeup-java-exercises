public class ServerNameGenerator {
//    We are going to build a server name generator. Create a class inside of src named ServerNameGenerator,
//    and follow the specs below.
//
//    Create two arrays whose elements are strings: one with at least 10 adjectives, another with at least 10 nouns. done
//    Create a method that will return a random element from an array of strings. done
//    Add a main method, and inside of your main method select and random noun and adjective and hyphenate the
//    combination and display the generated name to the user.
//    Example Output
//
//
//    Here is your server name:
//    dedicated-photon

    private String[] adjectives = {"strong","tall","fast","ashamed","aweful","bloody","bewildered","black","better","bad"};
    private String[] nouns = {"airport","guitar","piano","ambulance","hair","hamburger","pizza","planet","gold","helicopter"};


    public String randomFromStringArray(String[] strings){
        int myRandomIndex = (int) Math.floor(Math.random() * strings.length);
        return strings[myRandomIndex];
    }

    public String[] getAdjectives() {
        return this.adjectives;
    }

    public String[] getNouns() {
        return this.nouns;
    }

    public static void main(String[] args){
        ServerNameGenerator gen = new ServerNameGenerator();
        System.out.printf("%s-%s\n",gen.randomFromStringArray(gen.getAdjectives()),gen.randomFromStringArray(gen.getNouns()));
    }
}
