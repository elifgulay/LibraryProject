package Hw1;

import java.util.ArrayList;

public class Library {
    public String address;
    public ArrayList<Book> books = new ArrayList<Book>();
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    public static ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();

    public Library(String address) {
        this.address=address;
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9 am to 5 pm.");
    }

    public void printAddress() {
        System.out.println(getAddress());
    }

    public void addBook(Book book) {
        books.add(book);    //Adds the given book to the books ArrayList.
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);    //Adds the given customer to the customers ArrayList.
    }

    public void borrowBook(String bookName, String personName) {
        Book availableBook = new Book(0, null);

        boolean bookExist = false;
        for (Book borrowedBook : books) {
            if (borrowedBook.getTitle().contains(bookName)) {  //If the ArrayList named books contains the title of the book to be borrowed, which name is borrowedBook,
                bookExist = true;                     //that means the book is exist so we assign the value true to the boolean variable named bookExist.

                if (!borrowedBook.isBorrowed()) {   //If the book to be borrowed has not been borrowed before by anyone,
                    borrowedBook.borrowed();        //this book is available on loan. Therefore, we call the borrowed method in the Book class and specify that the selected book is taken.
                    availableBook = borrowedBook;
                    break;

                } else {  //This part is for the second The Lord of the Rings book

                    boolean isMoreBook = false;

                    for (Book moreBook : books) {
                        //to check that the titles of the two Lord of the Rings book are same and have different IDs.
                        if (borrowedBook.getTitle().equals(moreBook.getTitle()) && borrowedBook.getId() != moreBook.getId()) {
                            if (!moreBook.isBorrowed()) {  //If the book has not been borrowed by anyone
                                moreBook.borrowed();        //then, it is borrowed
                                isMoreBook = true;
                                availableBook = moreBook;
                                break;
                            }
                        }
                    }

                    if (isMoreBook) {
                        break;
                    } else {  //If the book has already been borrowed by someone else
                        System.out.println("Sorry, this book is already borrowed");
                        break;
                    }

                }
            }
        }

        if (!bookExist) {  //If the book to be borrowed is not in ArrayList named books
            System.out.println("Sorry, this book is not in our catalog");
        }

        if (bookExist && availableBook.getId() != 0) {
            boolean customerExist = false;

            for (Customer customer : customers) {
                if (customer.getName().contains(personName)) {  //If the given customer's name is in the ArrayList named customers

                    customerExist = true;  //this indicates that the given customer exists. So, we assign the value true to the boolean variable named customerExists.

                    if (customer.isBorrowABook()) {  //If the customer has already borrowed books
                        System.out.println("Sorry, " + personName + " already borrowed a book");  //cannot borrow books again.

                        availableBook.borrowed=false;  //Since the customer cannot borrow a book, the availableBook value must be set to false.
                        books.set(availableBook.getId()-1, availableBook);

                    } else { //If the customer has not borrowed the book yet,
                        customer.setBorrowABook(true); //s/he can borrow a book
                        customer.setBorrowedBook(availableBook);

                        System.out.println(personName + " successfully borrowed " + bookName + ".");
                    }
                }
            }
            if (!customerExist) {  //If given customer is not exist

                //Even if the selected book is available, it cannot be borrowed.
                if(availableBook.getId() != 0)
                    availableBook.borrowed= false; //Since the book cannot be borrowed, the availableBook value should be set to false.
                    books.set(availableBook.getId()-1, availableBook);

                System.out.println("Sorry, " + personName + " is not a customer.");
            }
        }

    }



    public void returnBook(String personName) {
        boolean customerExist = false;

        for (Customer customer : customers) {
            if (customer.getName().contains(personName)) {  //If the name of the given customer is in the Arraylist named customers
                customerExist = true;                       //that means given customer exists.

                if (customer.isBorrowABook()) {  //If the customer borrowed a book
                    customer.getBorrowedBook().returned();  //to return the borrowed book by invoking the returned method in the class named Book.
                    customer.setBorrowABook(false);  //to indicate that the customer has no books to be returned.

                    books.set(customer.getBorrowedBook().getId()-1, customer.getBorrowedBook());

                    System.out.println(personName + " successfully returned " + customer.getBorrowedBook().getTitle());
                } else {  //If the given customer did not borrow any books
                    System.out.println("Sorry, " + personName + " did not borrow a book");
                }
            }
        }

        if (!customerExist) {  //If the given customer does not exist in Arraylist named customers
            System.out.println("Sorry, " + personName + " is not a customer");
        }
    }

    public void printAvailableBooks() {
        boolean bookExist = false;
        for (Book book : books) {
            if (!book.isBorrowed()) {  //If the book to be borrowed has not been borrowed by someone else

                bookExist = true;  //then, the book is available

                System.out.println(book.toString()); //The name and author of the available book is printed using the toString method of the Book class.
            }
        }

        for (Dictionary dictionary : dictionaries) {
            if (!dictionary.isBorrowed()) {  //If the dictionary in the ArrayList named books is not borrowed
                System.out.println(dictionary.toString());  //Then, since the dictionary is available, it is printed using the toString method in the Dictionary class.
            }
        }

        if (!bookExist) {  //If the book to be borrowed is not in ArrayList named books
            System.out.println("No book in catalog.");
        }
    }


    //getter and setter methods
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        try {
            if(address.length()>3) { //if string value named address contains more than 3 symbols
                this.address=address; //then, there is no error
            } else {  //if string value named address contains less than 3 symbols
                throw new IllegalArgumentException(); //throws an error
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, input cannot contain less than 3 symbols.");

        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

}
