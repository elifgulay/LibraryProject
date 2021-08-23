package Hw1;

public class Dictionary extends Book {
    private int definitions;

    public Dictionary(int id, String title, Author author, int definitions) {
        super(id, title, author);  //invoking the constructor of the Book superclass
        this.definitions=definitions;
    }

    public Dictionary(int id, String title, int definitions) {
        super(id, title);  //invoking the constructor of the Book superclass
        this.definitions=definitions;
    }

    @Override
    public String toString() {
        return "Dictionary Name is " + getTitle() + ", definitions: " + definitions;
    }

    //getter and setter methods
    public int getDefinitions() {
        return definitions;
    }

    public void setDefinitions(int definitions) {

        //to make integer type value named definitions be positive only
        try {
            if (id >= 0) {
                this.definitions = definitions;
            } else {         //if definitions integer type value is not positive
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, number can't be negative.");
        }
    }


}
