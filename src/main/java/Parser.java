import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
            try {
                if (!parts[1].contains("by")) {
                    System.out.println("⚠️ Error: Deadline task must include 'by' followed by the due date.");
                    break;
                }

                String[] deadlineParts = parts[1].split("by", 2);
                String description = deadlineParts[0].trim();
                String by = deadlineParts[1].trim();

                LocalDate deadlineDate = Task.parseDate(by);
                if (deadlineDate == null) {
                    System.out.println("⚠️ Error: Invalid date format! Use `yyyy-MM-dd` (e.g., `2024-12-02`).");
                    break;
                }

                taskList.addTask(new Deadline(description, deadlineDate));
            } catch (Exception e) {
                System.out.println("⚠️ Error: Invalid deadline command. Use `deadline <task> by <yyyy-MM-dd>`.");
            }
            break;
        case "event":
            try {
                if (!parts[1].contains("at")) {
                    System.out.println("⚠️ Error: Event task must include 'at' followed by the event date.");
                    break;
                }

                String[] eventParts = parts[1].split("at", 2);
                String description = eventParts[0].trim();
                String at = eventParts[1].trim();

                LocalDate eventDate = Task.parseDate(at);
                if (eventDate == null) {
                    System.out.println("⚠️ Error: Invalid date format! Use 'dd/MM/yyyy' (e.g., `2024-12-02`).");
                    break;
                }

                taskList.addTask(new Events(description, eventDate));
            } catch (Exception e) {
                System.out.println("⚠️ Error: Invalid event command. Use `event <task> at dd/MM/yyyy.");
            }
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

        case "find":
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                System.out.println("⚠️ Error: Please provide a keyword to search for.");
                break;
            }
            String keyword = parts[1].trim();
            ArrayList<Task> matchingTasks = taskList.findTasks(keyword);

            if (matchingTasks.isEmpty()) {
                System.out.println("No matching tasks found.");
            } else {
                System.out.println("Here are the matching tasks in your list:");
                for (int i = 0; i < matchingTasks.size(); i++) {
                    System.out.println((i + 1) + ". " + matchingTasks.get(i));
                }
            }
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