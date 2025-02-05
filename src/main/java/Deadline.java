public class Deadline extends Task{

    public Deadline(String description) {
        super(description);
    }
    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return "[D]" + status + " " + description;
    }
}
