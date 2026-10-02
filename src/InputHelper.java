import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public String text(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int number(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(text(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
