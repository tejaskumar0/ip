import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a description and completion status.
 */
public abstract class Task {
    protected final String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Mark the task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Mark the task as not done
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Convert Date into a more readable format
     */
    public static LocalDate parseDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            return LocalDate.parse(dateStr, formatter);
        } catch (Exception e) {
            return null;
        }
    }

    public abstract String getTaskType();

    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return "[" + getTaskType() + "]" + status + " " + description;
    }


    public static Task fromString(String line) {
        boolean isDone = line.contains("[X]");

        if (line.startsWith("[T]")) {
            String description = line.substring(6).trim();
            ToDos todo = new ToDos(description);
            if (isDone) todo.markAsDone();
            return todo;
        } else if (line.startsWith("[D]")) {
            int byIndex = line.indexOf("(by:");
            String description = line.substring(6, byIndex - 1).trim();
            String by = line.substring(byIndex + 5, line.length() - 1).trim();

            LocalDate deadlineDate = DateUtil.parseDate(by);
            if (deadlineDate == null) {
                System.out.println("⚠️ Error: Invalid date format in saved file.");
                return null;
            }

            Deadline deadline = new Deadline(description, deadlineDate);
            if (isDone) deadline.markAsDone();
            return deadline;
        } else if (line.startsWith("[E]")) {
            int atIndex = line.indexOf("(at:");
            String description = line.substring(6, atIndex - 1).trim();
            String at = line.substring(atIndex + 5, line.length() - 1).trim();

            LocalDate eventDate = DateUtil.parseDate(at);
            if (eventDate == null) {
                System.out.println("⚠️ Error: Invalid date format in saved file.");
                return null;
            }

            Events event = new Events(description, eventDate);
            if (isDone) event.markAsDone();
            return event;
        }

        return new ToDos(line); // Default case for unknown formats
    }
}