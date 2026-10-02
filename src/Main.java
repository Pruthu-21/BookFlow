import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InputHelper input = new InputHelper(scanner);
    private static final Library library = new Library();

    public static void main(String[] args) {
        FileManager.load(library);

        System.out.println("\n==============================================");
        System.out.println("        BOOKFLOW - LIBRARY MANAGEMENT");
        System.out.println("   From Shelf to Borrower and Back");
        System.out.println("==============================================");

        boolean running = true;
        while (running) {
            showMenu();
            int choice = input.number("Enter your choice: ");

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> viewBooks();
                case 4 -> searchBook();
                case 5 -> registerMember();
                case 6 -> viewMembers();
                case 7 -> issueBook();
                case 8 -> returnBook();
                case 9 -> viewIssuedBooks();
                case 10 -> viewTransactions();
                case 11 -> FileManager.save(library);
                case 12 -> {
                    FileManager.save(library);
                    running = false;
                    System.out.println("Thank you for using BookFlow!");
                }
                default -> System.out.println("Invalid choice. Please select 1-12.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n------------- MAIN MENU ----------------");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. View All Books");
        System.out.println("4. Search Book");
        System.out.println("5. Register Member");
        System.out.println("6. View Members");
        System.out.println("7. Issue Book");
        System.out.println("8. Return Book");
        System.out.println("9. View Issued Books");
        System.out.println("10. View Transaction History");
        System.out.println("11. Save Data");
        System.out.println("12. Exit");
        System.out.println("-----------------------------------------");
    }

    private static void addBook() {
        String id = input.text("Book ID: ");
        String title = input.text("Title: ");
        String author = input.text("Author: ");

        if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        System.out.println(library.addBook(new Book(id, title, author))
                ? "Book added successfully." : "Book ID already exists.");
    }

    private static void removeBook() {
        String id = input.text("Book ID to remove: ");
        System.out.println(library.removeBook(id)
                ? "Book removed successfully." : "Book not found or currently issued.");
    }

    private static void viewBooks() {
        if (library.getBooks().isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        System.out.println("\n--- BOOKS ---");
        for (Book b : library.getBooks()) System.out.println(b);
    }

    private static void searchBook() {
        String keyword = input.text("Enter ID, title, or author: ");
        List<Book> result = library.searchBooks(keyword);

        if (result.isEmpty()) {
            System.out.println("No matching books found.");
            return;
        }
        for (Book b : result) System.out.println(b);
    }

    private static void registerMember() {
        String id = input.text("Member ID: ");
        String name = input.text("Name: ");
        String phone = input.text("Phone: ");

        if (id.isEmpty() || name.isEmpty() || phone.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        System.out.println(library.addMember(new Member(id, name, phone))
                ? "Member registered successfully." : "Member ID already exists.");
    }

    private static void viewMembers() {
        if (library.getMembers().isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        System.out.println("\n--- MEMBERS ---");
        for (Member m : library.getMembers()) System.out.println(m);
    }

    private static void issueBook() {
        String bookId = input.text("Book ID: ");
        String memberId = input.text("Member ID: ");

        System.out.println(library.issueBook(bookId, memberId)
                ? "Book issued successfully." : "Issue failed. Check book/member or availability.");
    }

    private static void returnBook() {
        String bookId = input.text("Book ID: ");
        String memberId = input.text("Member ID: ");

        System.out.println(library.returnBook(bookId, memberId)
                ? "Book returned successfully." : "Return failed. Check book/member or issue status.");
    }

    private static void viewIssuedBooks() {
        boolean found = false;
        System.out.println("\n--- ISSUED BOOKS ---");
        for (Book b : library.getBooks()) {
            if (!b.isAvailable()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No books are currently issued.");
    }

    private static void viewTransactions() {
        if (library.getTransactions().isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        System.out.println("\n--- TRANSACTION HISTORY ---");
        for (Transaction t : library.getTransactions()) System.out.println(t);
    }
}
