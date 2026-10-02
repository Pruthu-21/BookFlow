import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();

        books.add("Java Programming");
        books.add("Database Systems");
        books.add("Computer Networks");

        for (String book : books) {
            System.out.println(book);
        }
    }
}
