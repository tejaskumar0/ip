import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDate by;

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

    @Override
    public String toString() {
        String formattedDate = DateUtil.formatDate(by);
        String status = isDone ? "[X]" : "[ ]";
        return "[D]" + status + " " + description + " (by: " + formattedDate + ")";
    }
}