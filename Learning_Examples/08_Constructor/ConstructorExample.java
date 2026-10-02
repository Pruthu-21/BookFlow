class DemoBook {
    String id;
    String title;

    DemoBook(String id, String title) {
        this.id = id;
        this.title = title;
    }

    void display() {
        System.out.println(id + " - " + title);
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        DemoBook book = new DemoBook("B101", "Java Programming");
        book.display();
    }
}
