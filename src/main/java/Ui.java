import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showWelcomeMessage() {
        System.out.println("Hello! I'm Tywin, your personal assistant!");
        System.out.println("What can I do for you?");
    }

    public void showExitMessage() {
        System.out.println("Goodbye, have a nice day!");
    }
}
