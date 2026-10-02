class BookDemo {
    String title;
    String author;

    void showBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

public class ClassObjectExample {
    public static void main(String[] args) {
        BookDemo book = new BookDemo();

        book.title = "Java Programming";
        book.author = "James Gosling";

        book.showBook();
    }
}
