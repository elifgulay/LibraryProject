package Hw1;

public class Book {
    int id;
    String title;
    Author author;
    boolean borrowed;

    public Book(int id, String title, Author author) {
        this.id=id;
        this.title=title;
        this.author=author;
    }
    public Book(int id, String title) {
        this.id=id;
        this.title=title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public boolean borrowed() {
        if(borrowed) {  //if book has been already borrowed
            return false;
        }
        else {      // if book has not been borrowed yet
            this.borrowed = true;
            return true;
        }
    }

    public boolean returned() {
        if(borrowed) {      //if the borrowed book has been returned
            this.borrowed = false;
            return true;
        }
        else {          // if the borrowed book has not been returned yet
            return false;
        }
    }

    @Override
    public String toString() {
        return "Book name is " + title + ", Author is " + author;
    }

    //getter and setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        try {
            if(title.length()>3) { //if string value named title contains more than 3 symbols
                this.title=title; //then, there is no error
            } else {        //if string value named title contains less than 3 symbols
                throw new IllegalArgumentException();  //throws an exception
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, input cannot contain less than 3 symbols.");

        }
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        //to make integer type value named id be positive only
        try {
            if (id >= 0) {
                this.id = id;
            } else {    //if id integer type value is not positive
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, input can't be negative.");
        }
    }

}
