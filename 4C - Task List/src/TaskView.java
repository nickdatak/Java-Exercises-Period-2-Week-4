// TaskView.java
public class TaskView implements TaskList.Listener {

    @Override
    public void onTaskAdded(TaskList.Task task) {
        System.out.println("Task \"" + task.getTitle() + "\" was added.");
    }

    @Override
    public void onTaskCompleted(TaskList.Task task) {
        System.out.println("Task \"" + task.getTitle() + "\" was completed.");
    }
}
