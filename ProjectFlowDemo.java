public class ProjectFlowDemo {
    public static void main(String[] args) {
        System.out.println("========== BOOKFLOW CODE STRUCTURE ==========\n");

        System.out.println("1. Main.java");
        System.out.println("   -> Starts the application");
        System.out.println("   -> Shows menu");
        System.out.println("   -> Takes user choice\n");

        System.out.println("2. InputHelper.java");
        System.out.println("   -> Reads keyboard input");
        System.out.println("   -> Handles invalid numbers\n");

        System.out.println("3. Library.java");
        System.out.println("   -> Main business logic");
        System.out.println("   -> Add / Search / Issue / Return books");
        System.out.println("   -> Register members\n");

        System.out.println("4. Book.java");
        System.out.println("   -> Stores book information\n");

        System.out.println("5. Member.java");
        System.out.println("   -> Stores member information\n");

        System.out.println("6. Transaction.java");
        System.out.println("   -> Stores issue / return history\n");

        System.out.println("7. FileManager.java");
        System.out.println("   -> Saves and loads data\n");

        System.out.println("========== MAIN FLOW ==========");
        System.out.println("User");
        System.out.println("  |");
        System.out.println("  v");
        System.out.println("Main.java");
        System.out.println("  |");
        System.out.println("  v");
        System.out.println("InputHelper.java");
        System.out.println("  |");
        System.out.println("  v");
        System.out.println("Library.java");
        System.out.println("  |");
        System.out.println("  +----> Book.java");
        System.out.println("  +----> Member.java");
        System.out.println("  +----> Transaction.java");
        System.out.println("  |");
        System.out.println("  v");
        System.out.println("FileManager.java");
        System.out.println("  |");
        System.out.println("  v");
        System.out.println("data/*.txt");
    }
}
