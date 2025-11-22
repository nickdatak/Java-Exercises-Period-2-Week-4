import java.util.ArrayList;
import java.util.List;

public class ContactDemo {
    public static void main(String[] args) {
        Address addr = new Address("Main Street 1", "Maastricht");
        List<String> tags = new ArrayList<>();
        tags.add("friend");

        Contact original = new Contact("alice@example.com", addr, tags);

        // Shallow copy shares internal Address and tags list
        Contact shallow = Contact.createShallow(original);

        // Deep copy has its own Address and tags list
        Contact deep = new Contact(original);

        System.out.println("Initial state:");
        System.out.println("original = " + original);
        System.out.println("shallow  = " + shallow);
        System.out.println("deep     = " + deep);

        // Modify shallow's internal state via the shared list and address
        // (This uses the shallow copy factory that intentionally shared references.)
        shallow.getTags().add("colleague"); // modifies copy of list only, but underlying list is shared
        // To demonstrate aliasing clearly, we need direct access to the shared list,
        // so:
        // In practice you might expose a method on Contact for demo purposes; here we
        // simply
        // simulate another modification by constructing another shallow that reuses the
        // same list.
        // For simplicity, we modify the original's tags directly before copying.
        // This is mainly for illustration.

        System.out.println("\nAfter modifying tags via a new shallow copy demonstration:");
        Contact shallow2 = Contact.createShallow(original);
        List<String> sharedTags = shallow2.getTags();
        sharedTags.add("vip");
        System.out.println("original = " + original);
        System.out.println("shallow2 = " + shallow2);
        System.out.println("deep     = " + deep);

        System.out.println("\nEquality check (same email):");
        Contact sameEmail = new Contact("alice@example.com", addr, tags);
        System.out.println("original.equals(sameEmail) = " + original.equals(sameEmail));
        System.out.println("original.hashCode() == sameEmail.hashCode() = " +
                (original.hashCode() == sameEmail.hashCode()));
    }
}
