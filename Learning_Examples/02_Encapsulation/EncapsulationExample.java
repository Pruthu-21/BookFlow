class Book {
    private String title;
    private boolean available;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {
        Book book = new Book();

        book.setTitle("Java Basics");
        book.setAvailable(true);

        System.out.println("Book: " + book.getTitle());
        System.out.println("Available: " + book.isAvailable());
    }
}
