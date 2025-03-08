# Tywin project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into Intellij as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/Tywin.java` file, right-click it, and choose `Run Tywin.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:

```
 ##
 Hello! I'm Tywin, your personal assistant!
 What can I do for you?   
```
```
## Features
- 📝 **Task Management**: Add, mark, unmark, and delete tasks.
- 📅 **Deadlines & Events**: Set due dates and track upcoming tasks.
- 📜 **View Tasks**: List all tasks with completion status.
- 💾 **Save & Load Data**: Automatically saves tasks when exiting.
- 🏷️ **Flexible Commands**: Recognizes multiple input formats.

## Usage
Type the following commands in the terminal:

- `todo Read book` → Adds a new To-Do task.
- `deadline Submit report /by Monday` → Adds a deadline task.
- `event Project meeting /at Aug 6th 2-4pm` → Adds an event.
- `list` → Shows all tasks.
- `mark 2` → Marks task #2 as completed.
- `unmark 2` → Unmarks task #2.
- `delete 3` → Deletes task #3.
- `bye` → Exits the program.

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.
