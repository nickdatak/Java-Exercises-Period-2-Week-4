// TaskDemo.java
import java.util.List;

public class TaskDemo {

    public static void main(String[] args) {
        TaskList model = new TaskList();
        TaskView view = new TaskView();
        model.addListener(view);

        TaskController controller = new TaskController(model);

        // Basic operations
        controller.add("Buy milk");
        controller.add("Clean desk");
        controller.complete("Buy milk");

        // Demonstrate validation and normalisation
        controller.add("   ");              // ignored by the controller
        controller.add("  Walk dog   ");    // controller trims the title

        // Demonstrate batch adding
        List<String> batch = List.of("Pay bills", "Read book", "Cook dinner");
        controller.addAll(batch);

        // Demonstrate batch completion
        controller.completeAllContaining("oo");

        // Inspect tasks using the iterator
        TaskList.TaskIterator it = model.iterator();
        while (it.hasNext()) {
            TaskList.Task t = it.next();
            System.out.println(t.getTitle() + " — done? " + t.isDone());
        }
    }
}
