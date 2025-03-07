public class Parser {
    public static void parse(String input, TaskList taskList) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        switch (command) {
        case "list":
            taskList.listTasks();
            break;
        case "todo":
            taskList.addTask(new ToDos(parts[1]));
            break;
        case "deadline":
            taskList.addTask(new Deadline(parts[1]));
            break;
        case "event":
            taskList.addTask(new Events(parts[1]));
            break;
        case "mark":
            taskList.markTask(Integer.parseInt(parts[1]) - 1);
            break;
        case "unmark":
            taskList.unmarkTask(Integer.parseInt(parts[1]) - 1);
            break;
        case "delete":
            taskList.deleteTask(Integer.parseInt(parts[1]) - 1);
            break;
        case "bye":
            System.out.println("Goodbye!");
            System.exit(0);
        default:
            System.out.println("⚠️ Error:Unknown command. Please enter a valid command.");
            break;
        }
    }
}