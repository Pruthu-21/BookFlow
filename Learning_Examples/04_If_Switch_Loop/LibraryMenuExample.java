public class LibraryMenuExample {
    public static void main(String[] args) {
        int choice = 2;

        switch (choice) {
            case 1:
                System.out.println("Add Book");
                break;
            case 2:
                System.out.println("View Books");
                break;
            case 3:
                System.out.println("Issue Book");
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}
