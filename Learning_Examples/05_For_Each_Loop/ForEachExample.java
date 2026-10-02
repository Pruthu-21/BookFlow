public class ForEachExample {
    public static void main(String[] args) {
        String[] books = {
            "Java",
            "Operating System",
            "Database"
        };

        for (String book : books) {
            System.out.println("Book: " + book);
        }
    }
}
