package Hw1;

public class Author extends Person {
    private String publisher;

    public Author(String name, String publisher, int birthDate) {
        super(name, birthDate);  //invoking the constructor of the Person superclass
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return name;
    }

    //getter and setter methods
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        try {
            if (publisher.length() > 3) {  //if string value named publisher contains more than 3 symbols
                this.publisher = publisher; //then, there is no error
            } else {    //if string value named publisher contains less than 3 symbols
                throw new IllegalArgumentException();  //throws an exception
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, input cannot contain less than 3 symbols.");
        }
    }
}

