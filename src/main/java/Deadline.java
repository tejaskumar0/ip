import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a specific deadline.
 */
public class Deadline extends Task {
    private final LocalDate by;

    /**
     * Creates a Deadline task with a description and due date.
     *
     * @param description The description of the deadline task.
     * @param by The due date of the task.
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    public LocalDate getBy() {
        return by;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    /**
     * Converts the Deadline task into a string format for display and saving.
     *
     * @return A formatted string representation of the task.
     */
    @Override
    public String toString() {
        String formattedDate = DateUtil.formatDate(by);
        String status = isDone ? "[X]" : "[ ]";
        return "[D]" + status + " " + description + " (by: " + formattedDate + ")";
    }
}