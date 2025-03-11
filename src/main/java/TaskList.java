import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Added task: " + task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
            System.out.println("Marked task as done: " + tasks.get(index));
        } else {
            System.out.println("⚠️ Error: Invalid task number.");
        }
    }

    public void unmarkTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).unmarkAsDone();
            System.out.println("Unmarked task: " + tasks.get(index));
        } else {
            System.out.println("⚠️ Error: Invalid task number.");
        }
    }

    public void deleteTask(int taskNumber) {
        int index = taskNumber;

        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index); // Removes the task at index
            System.out.println("Deleted task: " + removedTask);
        } else {
            System.out.println("⚠️ Error: Invalid task number.");
        }
    }

    public void addAll(ArrayList<Task> tasksFromFile) {
        tasks.addAll(tasksFromFile);
    }

    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.description.contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}