import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events extends Task {
    private LocalDate at; // Stores the event date

    public Events(String description, LocalDate at) {
        super(description);
        this.at = at;
    }

    @Override
    public String getTaskType() {
        return "E";
    }

    @Override
    public String toString() {
        String formattedDate = DateUtil.formatDate(at); // Format date as "2nd December 2025"
        String status = isDone ? "[X]" : "[ ]";
        return "[E]" + status + " " + description + " (at: " + formattedDate + ")";
    }

    public LocalDate getAt() {
        return at;
    }
}
