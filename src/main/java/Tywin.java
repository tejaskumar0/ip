import java.util.Scanner;

public class Tywin {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello I'm Tywin");
        System.out.println("What can I do for you?");
        System.out.println("----------------------");

        Task[] tasks = new Task[100];
        int taskCounter = 0;

        Scanner in = new Scanner(System.in);

        while (true) {
            String line = in.nextLine();

            if (line.equals("bye")) {
                System.out.println("Goodbye.");
                break;
            } else if (line.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCounter; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]); // Display each task
                }
                System.out.println("----------------------");
            } else if (line.startsWith("mark ")) {
                // Extract task number to mark
                int taskNumber = Integer.parseInt(line.split(" ")[1]) - 1;
                if (taskNumber >= 0 && taskNumber < taskCounter) {
                    tasks[taskNumber].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + tasks[taskNumber]);
                } else {
                    System.out.println("Invalid task number.");
                }
                System.out.println("----------------------");
            } else if (line.startsWith("unmark ")) {
                // Extract task number to unmark
                int taskNumber = Integer.parseInt(line.split(" ")[1]) - 1;
                if (taskNumber >= 0 && taskNumber < taskCounter) {
                    tasks[taskNumber].unmarkAsDone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + tasks[taskNumber]);
                } else {
                    System.out.println("Invalid task number.");
                }
                System.out.println("----------------------");
            } else {
                // Add a new task
                tasks[taskCounter] = new Task(line);
                taskCounter++;
                System.out.println("added: " + line);
                System.out.println("----------------------");
            }
        }

        in.close(); // Close the scanner
    }
}