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
                String[] deadlineParts = parts[1].split("by", 2);
                String description = deadlineParts[0].trim();
                String by = deadlineParts[1].trim();

                LocalDate deadlineDate = DateUtil.parseDate(by);
                if (deadlineDate == null) {
                    System.out.println("⚠️ Error: Invalid date format! Use `d/M/yyyy` (e.g., `2/12/2025`).");
                    break;
                }

                taskList.addTask(new Deadline(description, deadlineDate));
            } catch (Exception e) {
                System.out.println("⚠️ Error: Invalid deadline command. Use `deadline <task> by <date>`.");
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

                LocalDate eventDate = DateUtil.parseDate(at);
                if (eventDate == null) {
                    System.out.println("⚠️ Error: Invalid date format! Use `d/M/yyyy` (e.g., `2/12/2025`).");
                    break;
                }

                taskList.addTask(new Events(description, eventDate));
            } catch (Exception e) {
                System.out.println("⚠️ Error: Invalid event command. Use `event <task> at <date>`.");
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