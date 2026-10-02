import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Transaction> transactions = new ArrayList<>();

    public boolean addBook(Book book) {
        if (findBook(book.getId()) != null) return false;
        books.add(book);
        return true;
    }

    public boolean removeBook(String id) {
        Book book = findBook(id);
        if (book == null || !book.isAvailable()) return false;
        return books.remove(book);
    }

    public Book findBook(String id) {
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id)) return b;
        }
        return null;
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(keyword)
                    || b.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    public boolean addMember(Member member) {
        if (findMember(member.getId()) != null) return false;
        members.add(member);
        return true;
    }

    public Member findMember(String id) {
        for (Member m : members) {
            if (m.getId().equalsIgnoreCase(id)) return m;
        }
        return null;
    }

    public boolean issueBook(String bookId, String memberId) {
        Book book = findBook(bookId);
        Member member = findMember(memberId);
        if (book == null || member == null || !book.isAvailable()) return false;

        book.setAvailable(false);
        transactions.add(new Transaction(bookId, memberId, "ISSUED"));
        return true;
    }

    public boolean returnBook(String bookId, String memberId) {
        Book book = findBook(bookId);
        Member member = findMember(memberId);
        if (book == null || member == null || book.isAvailable()) return false;

        book.setAvailable(true);
        transactions.add(new Transaction(bookId, memberId, "RETURNED"));
        return true;
    }

    public List<Book> getBooks() { return books; }
    public List<Member> getMembers() { return members; }
    public List<Transaction> getTransactions() { return transactions; }
}
