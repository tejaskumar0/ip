import java.util.Scanner;
import java.util.ArrayList;

public class Tywin {
    public static void main(String[] args) {
        Ui ui = new Ui();
        Storage storage = new Storage("data/storage.txt");
        TaskList taskList = new TaskList();

        ui.showWelcomeMessage();
        taskList.addAll(storage.loadTasks());

        while (true) {
            String command = ui.readCommand();
            if (command.equals("bye")) {
                storage.saveTasks(taskList.getTasks());
                System.out.println("Goodbye! Tasks have been saved.");
                break;
            }
            Parser.parse(command, taskList);
        }
    }
}