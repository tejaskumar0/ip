import java.util.Scanner;

public class Tywin {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello I'm Tywin, your personal assistant!");
        System.out.println("What can I do for you?");
        System.out.println("----------------------");

        Task[] tasks = new Task[100];
        int taskCounter = 0;

        Scanner in = new Scanner(System.in);

        while (true) {
            String line = in.nextLine();
            String[] parts = line.split(" ",2);// Extract the command
            String command = parts[0];

            switch (command) {
            case "bye":
                System.out.println("Goodbye, have a nice day!");
                return;

            case "list":
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCounter; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("----------------------");
                break;

            case "todo":
                    if(parts.length < 2 || parts[1].trim().isEmpty()){
                        System.out.println("Description cannot be empty");
                        break;
                    }
                    else {
                        System.out.println("----------------------");
                        System.out.println("Added To Do Task");
                        tasks[taskCounter] = new ToDos(line);
                        taskCounter++;
                        break;
                    }
            case "deadline":
                if(parts.length < 2 || parts[1].trim().isEmpty()){
                    System.out.println("Description cannot be empty");
                    break;
                }
                System.out.println("----------------------");
                System.out.println("Added Deadline to list");
                tasks[taskCounter] = new Deadline(line);
                taskCounter++;
                break;

            case "event":
                if(parts.length < 2 || parts[1].trim().isEmpty()){
                    System.out.println("Description cannot be empty");
                    break;
                }
                System.out.println("----------------------");
                System.out.println("Added Event to list");
                tasks[taskCounter] = new Events(line);
                taskCounter++;
                break;

            case "mark":
                try {
                    int taskNumber = Integer.parseInt(line.split(" ")[1]) - 1;
                    if (taskNumber >= 0 && taskNumber < taskCounter) {
                        tasks[taskNumber].markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("  " + tasks[taskNumber]);
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please specify a valid task number.");
                }
                System.out.println("----------------------");
                break;

            case "unmark":
                try {
                    int taskNumber = Integer.parseInt(line.split(" ")[1]) - 1;
                    if (taskNumber >= 0 && taskNumber < taskCounter) {
                        tasks[taskNumber].unmarkAsDone();
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println("  " + tasks[taskNumber]);
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please specify a valid task number.");
                }
                System.out.println("----------------------");
                break;

            default:
                // Add a new task
                System.out.println("⚠️ Error: Unrecognized command '" + command + "'.");
                System.out.println("Please enter a valid command (todo, deadline, event, list, mark, unmark, bye).");
                System.out.println("----------------------");
                break;
            }
        }
    }
}
