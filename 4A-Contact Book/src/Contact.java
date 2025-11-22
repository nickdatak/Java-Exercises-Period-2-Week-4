import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Contact))
            return false;
        Contact other = (Contact) o;
        // Logical equality: only email counts
        return Objects.equals(this.email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
