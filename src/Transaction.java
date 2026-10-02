import java.time.LocalDate;

public class Transaction {
    private final String bookId;
    private final String memberId;
    private final String type;
    private final LocalDate date;

    public Transaction(String bookId, String memberId, String type) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.type = type;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("%s | Book: %s | Member: %s | Date: %s",
                type, bookId, memberId, date);
    }
}
