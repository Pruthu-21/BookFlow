import java.io.FileWriter;
import java.io.IOException;

public class FileWriteExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("book_demo.txt");

            writer.write("B101|Java Programming|Available");
            writer.close();

            System.out.println("Book data saved.");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
