import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Contact {
    private final String email;
    private final Address address;
    private final List<String> tags;

    /**
     * Main constructor.
     * Stores defensively copied state.
     */
    public Contact(String email, Address address, List<String> tags) {
        if (email == null || address == null || tags == null) {
            throw new IllegalArgumentException("email, address and tags must not be null");
        }
        this.email = email;
        // deep copy of address and list
        this.address = new Address(address);
        this.tags = new ArrayList<>(tags);
    }

    /**
     * Deep copy constructor.
     */
    public Contact(Contact other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.email = other.email;
        this.address = new Address(other.address);
        this.tags = new ArrayList<>(other.tags);
    }

    /**
     * Factory method to demonstrate a shallow copy.
     * It intentionally shares internal mutable objects with the original.
     */
    public static Contact createShallow(Contact other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        // Shares the same Address and tag list references.
        return new Contact(other.email, other.address, other.tags, false);
    }

    // Internal constructor that can optionally skip defensive copying.
    private Contact(String email, Address address, List<String> tags, boolean defensiveCopy) {
        if (email == null || address == null || tags == null) {
            throw new IllegalArgumentException("email, address and tags must not be null");
        }
        this.email = email;
        if (defensiveCopy) {
            this.address = new Address(address);
            this.tags = new ArrayList<>(tags);
        } else {
            this.address = address;
            this.tags = tags;
        }
    }

    public String getEmail() {
        return email;
    }

    /**
     * Defensive copy: callers receive a new Address instance.
     */
    public Address getAddress() {
        return new Address(address);
    }

    /**
     * Defensive copy: callers receive a new list instance.
     */
    public List<String> getTags() {
        return new ArrayList<>(tags);
    }

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

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + ' ' +
                ", address=" + address +
                ", tags=" + tags +
                '}';
    }
}
