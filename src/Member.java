public class Member {
    private final String id;
    private final String name;
    private final String phone;

    public Member(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Phone: %s", id, name, phone);
    }
}
