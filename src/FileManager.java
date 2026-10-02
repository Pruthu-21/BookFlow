import java.io.*;
import java.util.List;

public class FileManager {
    private static final String DATA_DIR = "data";

    public static void save(Library library) {
        new File(DATA_DIR).mkdirs();

        try (PrintWriter out = new PrintWriter(new FileWriter(DATA_DIR + "/books.txt"))) {
            for (Book b : library.getBooks()) {
                out.println(b.getId() + "|" + b.getTitle() + "|" + b.getAuthor() + "|" + b.isAvailable());
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(DATA_DIR + "/members.txt"))) {
            for (Member m : library.getMembers()) {
                out.println(m.getId() + "|" + m.getName() + "|" + m.getPhone());
            }
        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(DATA_DIR + "/transactions.txt"))) {
            for (Transaction t : library.getTransactions()) {
                out.println(t);
            }
        } catch (IOException e) {
            System.out.println("Error saving transactions: " + e.getMessage());
        }

        System.out.println("Data saved successfully.");
    }

    public static void load(Library library) {
        File booksFile = new File(DATA_DIR + "/books.txt");
        if (!booksFile.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(booksFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("\\|", -1);
                if (p.length == 4) {
                    Book b = new Book(p[0], p[1], p[2]);
                    b.setAvailable(Boolean.parseBoolean(p[3]));
                    library.addBook(b);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }

        File membersFile = new File(DATA_DIR + "/members.txt");
        if (membersFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(membersFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] p = line.split("\\|", -1);
                    if (p.length == 3) library.addMember(new Member(p[0], p[1], p[2]));
                }
            } catch (IOException e) {
                System.out.println("Error loading members: " + e.getMessage());
            }
        }
    }
}
