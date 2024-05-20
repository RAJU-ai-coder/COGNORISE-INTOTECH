package GuessingNumber;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false; 
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public boolean checkoutBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && !book.isCheckedOut()) {
            book.setCheckedOut(true);
            return true; 
        }
        return false; 
    }

    public boolean returnBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && book.isCheckedOut()) {
            book.setCheckedOut(false);
            return true; 
        }
        return false; 
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("1984", "George Orwell"));
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Search by Title");
            System.out.println("2. Search by Author");
            System.out.println("3. Checkout Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter title to search: ");
                    String titleToSearch = scanner.nextLine();
                    Book foundBookByTitle = library.searchByTitle(titleToSearch);
                    if (foundBookByTitle != null) {
                        System.out.println("Found: " + foundBookByTitle.getTitle() + " by " + foundBookByTitle.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter author to search: ");
                    String authorToSearch = scanner.nextLine();
                    ArrayList<Book> booksByAuthor = library.searchByAuthor(authorToSearch);
                    if (!booksByAuthor.isEmpty()) {
                        System.out.println("Books found by " + authorToSearch + ":");
                        for (Book book : booksByAuthor) {
                            System.out.println("- " + book.getTitle());
                        }
                    } else {
                        System.out.println("No books found by " + authorToSearch + ".");
                    }
                    break;
                case 3:
                    System.out.print("Enter title to checkout: ");
                    String titleToCheckout = scanner.nextLine();
                    boolean checkedOut = library.checkoutBook(titleToCheckout);
                    if (checkedOut) {
                        System.out.println("Book checked out successfully.");
                    } else {
                        System.out.println("Book not available or already checked out.");
                    }
                    break;
                case 4:
                    System.out.print("Enter title to return: ");
                    String titleToReturn = scanner.nextLine();
                    boolean returned = library.returnBook(titleToReturn);
                    if (returned) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book not found or not checked out.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
               default:
            	   System.out.println("Invalid choice,Please enter a number from 1 to 5.");
            }
        }
    }
}