import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Handles the reading and writing of tasks from a file.
 */
public class Storage {
    private final String filePath;



    /**
     * Creates a new Storage object that manages task persistence.
     *
     * @param filePath The file path where tasks will be stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
        ensureDirectoryExists();  // Ensures "data/" exists before using file
    }

    /**
     * Ensures that the directory for storing the file exists.
     * If it does not exist, the method attempts to create it.
     */
    private void ensureDirectoryExists() {
        File file = new File(filePath);
        File directory = file.getParentFile(); // Get parent directory "data/"

        if (directory != null && !directory.exists()) {
            boolean isCreated = directory.mkdirs();  // Create the directory if it doesn’t exist
            if (isCreated) {
                System.out.println("📂 Created directory: " + directory.getAbsolutePath());
            } else {
                System.out.println("⚠️ Failed to create directory: " + directory.getAbsolutePath());
            }
        }
    }

    /**
     * Loads tasks from the file and returns them as an ArrayList.
     *
     * @return A list of tasks stored in the file.
     */
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading tasks.");
        }
        return tasks;
    }

    /**
     * Saves tasks to the file, formatting them appropriately based on their type.
     *
     * @param tasks The list of tasks to be saved.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try {
            File file = new File(filePath);
            ensureDirectoryExists(); // Ensure directory exists before writing
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Task task : tasks) {
                    if (task instanceof Deadline) {
                        Deadline deadline = (Deadline) task;
                        writer.write("[D]" + (deadline.isDone ? "[X]" : "[ ]") + " " +
                                deadline.description + " (by: " + deadline.getBy().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")\n");
                    } else if (task instanceof Events) {
                        Events event = (Events) task;
                        writer.write("[E]" + (event.isDone ? "[X]" : "[ ]") + " " +
                                event.description + " (at: " + event.getAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")\n");
                    } else {
                        writer.write(task.toString() + "\n"); // Default for ToDo tasks
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error saving tasks.");
        }
    }
}