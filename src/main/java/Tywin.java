import java.util.Scanner;
import java.util.ArrayList;

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

        ArrayList<Task> tasks = new ArrayList<>();

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
                if (tasks.isEmpty()) {
                    System.out.println("You have no more tasks! Enjoy your day!");
                    break;
                } else {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    System.out.println("----------------------");
                    break;
                }

            case "todo":
                    if(parts.length < 2 || parts[1].trim().isEmpty()){
                        System.out.println("Description cannot be empty");
                        break;
                    }
                    else {
                        System.out.println("----------------------");
                        System.out.println("Added To Do Task");
                        tasks.add(new ToDos(parts[1]));
                        break;
                    }
            case "deadline":
                if(parts.length < 2 || parts[1].trim().isEmpty()){
                    System.out.println("Description cannot be empty");
                    break;
                }
                System.out.println("----------------------");
                System.out.println("Added Deadline to list");
                tasks.add(new Deadline(parts[1]));
                break;

            case "event":
                if(parts.length < 2 || parts[1].trim().isEmpty()){
                    System.out.println("Description cannot be empty");
                    break;
                }
                System.out.println("----------------------");
                System.out.println("Added Event to list");
                tasks.add(new Events(line));
                break;

            case "mark":
                try {
                    int taskNumber = Integer.parseInt(line.split(" ")[1]) - 1;
                    if (taskNumber >= 0 && taskNumber < tasks.size()) {
                        tasks.get(taskNumber).markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("  " + tasks.get(taskNumber));
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
                    if (taskNumber >= 0 && taskNumber < tasks.size()) {
                        tasks.get(taskNumber).unmarkAsDone();
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println("  " + tasks.get(taskNumber));
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please specify a valid task number.");
                }
                System.out.println("----------------------");
                break;

            case "delete":
                try{
                    int taskNumber = Integer.parseInt(line.split(" ")[1]) - 1;
                    if (taskNumber >= 0 && taskNumber < tasks.size()) {
                        System.out.println("Task " + (taskNumber + 1) + " was successfully deleted!");
                        tasks.remove(taskNumber);
                    }
                    else {
                        System.out.println("Invalid task number.");
                    }
                }catch (Exception e){
                    System.out.println("Invalid input. List is empty");
                }
                System.out.println("----------------------");
                break;

            default:
                // Add a new task
                System.out.println("⚠️ Error: Unrecognized command '" + command + "'.");
                System.out.println("Please enter a valid command (todo, deadline, event, list, mark, unmark, bye,delete)");
                System.out.println("----------------------");
                break;
            }
        }
    }
}
