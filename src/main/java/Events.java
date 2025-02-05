public class Events extends ToDos{

    public Events(String description) {
        super(description);
    }

    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return "[E]" + status + " " + description;
    }
}
