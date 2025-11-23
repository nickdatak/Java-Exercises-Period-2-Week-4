// TaskList.java
import java.util.ArrayList;
import java.util.List;

public class TaskList {

    // Use generics for type safety
    private final List<Task> tasks = new ArrayList<>();
    private final List<Listener> listeners = new ArrayList<>();

    // ===== Model: Task =====
    public static class Task {

        private final String title;
        private boolean done;

        public Task(String title) {
            // initialise title and default 'done' state
            this.title = title;
            this.done = false;          // start as NOT done
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isDone() {
            return this.done;
        }

        public void markDone() {
            this.done = true;          // mark as done
        }
    }

    // ===== Listener interface =====
    public interface Listener {
        /*
         * This method is called exactly once when the task is added.
         */
        void onTaskAdded(Task task);

        /*
         * This method is called when a previously not-done task gets done.
         */
        void onTaskCompleted(Task task);
    }

    // ===== Listener management =====
    public void addListener(Listener listener) {
        if (listener == null) {
            return;
        }
        if (!listeners.contains(listener)) {   // avoid duplicates
            listeners.add(listener);
        }
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    private void notifyTaskAdded(Task task) {
        // snapshot to avoid ConcurrentModification if a listener changes registration
        List<Listener> snapshot = new ArrayList<>(listeners);
        for (Listener listener : snapshot) {
            try {
                listener.onTaskAdded(task);
            } catch (Exception e) {
                System.err.println("Listener threw exception: " + e);
            }
        }
    }

    private void notifyTaskCompleted(Task task) {
        List<Listener> snapshot = new ArrayList<>(listeners);
        for (Listener listener : snapshot) {
            try {
                listener.onTaskCompleted(task);
            } catch (Exception e) {
                System.err.println("Listener threw exception: " + e);
            }
        }
    }

    // ===== Core model operations =====
    public void addTask(String title) {
        Task task = new Task(title);
        tasks.add(task);
        notifyTaskAdded(task);
    }

    public void completeTask(String title) {
        // complete the first not-done task with this exact title
        for (Task task : tasks) {
            if (task.getTitle().equals(title) && !task.isDone()) {
                task.markDone();
                notifyTaskCompleted(task);
                return;
            }
        }
        // If not found or already done, do nothing (no printing from model)
    }

    // ===== Inner iterator over tasks =====
    public class TaskIterator {

        private int current = 0;

        public boolean hasNext() {
            return current < tasks.size();
        }

        public Task next() {
            if (!hasNext()) {
                return null; // or throw NoSuchElementException if you prefer
            }
            Task t = tasks.get(current);
            current++;
            return t;
        }
    }

    public TaskIterator iterator() {
        return new TaskIterator();
    }
}
