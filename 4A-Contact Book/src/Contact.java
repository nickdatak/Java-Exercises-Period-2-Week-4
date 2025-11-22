import java.util.List;

public class Contact {
    private String email;
    private Address address;
    private List<String> tags;

    public Contact(String email, Address address, List<String> tags) {
        this.email = email;
        this.address = address;
        this.tags = tags;
    }

    public String getEmail() {
        return this.email;
    }

    public Address getAddress() {
        return this.address;
    }

    public List<String> getTags() {
        return this.tags;
    }
    // more methods will follow in later steps
}
