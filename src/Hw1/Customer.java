package Hw1;

public class Customer extends Person {
    private String address;
    private Book borrowedBook;
    private boolean borrowABook;


    public Customer(String name, String birthPlace, int birthDate, String address) {
        super(name, birthDate, birthPlace);  //invoking the constructor of the Person superclass
        this.address=address;
    }

    public Customer(String name, int birthDate, String address) {
        super(name, birthDate);  //invoking the constructor of the Person superclass
        this.address=address;
    }

    public Customer(String name, String address) {
        super(name);  //invoking the constructor of the Person superclass
        this.address=address;
    }

    public Customer(String name, int birthDate) {
        super(name, birthDate);  //invoking the constructor of the Person superclass
    }

    @Override
    public String toString() {
        return "Name:" + name + ", Birth Date: " + (getBirthDate()==null ? "-": getBirthDate())
                + ", Birth Place: " + (getBirthPlace()==null ? "-": getBirthPlace())
                + ", Address: " + (getAddress()==null ? "-": getAddress());
    }

    //getter and setter methods
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        try {
            if(address.length()>3) { //if string value named address contains more than 3 symbols
                this.address=address; //then, there is no error
            } else {        //if string value named address contains less than 3 symbols
                throw new IllegalArgumentException();  //throws an exception
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, input cannot contain less than 3 symbols.");

        }
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public boolean isBorrowABook() {
        return borrowABook;
    }

    public void setBorrowABook(boolean borrowABook) {
        this.borrowABook = borrowABook;
    }

}
