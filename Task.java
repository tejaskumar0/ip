public class Task extends Tywin {
    private final String description;
    private boolean isDone;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    // Mark the task as done
    public void markAsDone() {
        this.isDone = true;
    }

    // Mark the task as not done
    public void unmarkAsDone() {
        this.isDone = false;
    }

    // String representation of the task
    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return status + " " + description;
    }
}
