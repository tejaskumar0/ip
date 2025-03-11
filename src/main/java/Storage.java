import java.io.*;
import java.util.ArrayList;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
        ensureDirectoryExists();  // Ensures "data/" exists before using file
    }

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

    public void saveTasks(ArrayList<Task> tasks) {
        try {
            File file = new File(filePath);
            ensureDirectoryExists(); // Ensure directory exists before writing
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Task task : tasks) {
                    writer.write(task.toString() + "\n");  // ✅ Ensures date is stored correctly
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error saving tasks.");
        }
    }
}