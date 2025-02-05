public class ToDos extends Task {

    public ToDos(String description){
        super(description);
    }

    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return "[T]" + status + " " + description;
    }

}
