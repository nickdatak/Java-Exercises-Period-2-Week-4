// TaskController.java
import java.util.List;

public class TaskController {

    private final TaskList taskList;

    public TaskController(TaskList taskList) {
        this.taskList = taskList;
    }

    // Basic validation helper
    private String normaliseTitle(String title) {
        if (title == null) {
            return null;
        }
        String trimmed = title.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }

    public void add(String title) {
        String normalised = normaliseTitle(title);
        if (normalised == null) {
            return; // reject invalid title silently
        }
        taskList.addTask(normalised);
    }

    public void complete(String title) {
        String normalised = normaliseTitle(title);
        if (normalised == null) {
            return; // invalid, ignore
        }
        taskList.completeTask(normalised);
    }

    public void completeAllContaining(String fragment) {
        if (fragment == null || fragment.isEmpty()) {
            return;
        }
        TaskList.TaskIterator it = taskList.iterator();
        while (it.hasNext()) {
            TaskList.Task t = it.next();
            if (t.getTitle().contains(fragment)) {
                // delegate to the model for each matching title
                taskList.completeTask(t.getTitle());
            }
        }
    }

    public void addAll(List<String> titles) {
        if (titles == null) {
            return;
        }
        for (String title : titles) {
            add(title); // reuse validation and normalisation
        }
    }
}
