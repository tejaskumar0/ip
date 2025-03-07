import java.util.Scanner;
import java.util.ArrayList;

public class Tywin {
    public static void main(String[] args) {
        Ui ui = new Ui();
        Storage storage = new Storage("data/tasks.txt");
        TaskList taskList = new TaskList();

        ui.showWelcomeMessage();

        while (true) {
            String command = ui.readCommand();
            Parser.parse(command, taskList);
        }
    }
}