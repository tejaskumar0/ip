# Tywin project template
By Tejas Kumar

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

Tywin is a simple yet powerful personal task assistant designed to help you manage tasks efficiently. It allows you to add, mark, unmark, delete, and list tasks, including deadlines and events. Your tasks are automatically saved and loaded whenever you use Tywin, ensuring seamless task management.

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
🚀 Features
Tywin offers the following features to help you stay organized:
	•	📝 Task Management – Add, mark, unmark, delete, and list tasks.
	•	📅 Deadlines & Events – Set due dates for tasks and track upcoming events.
	•	📜 Task Viewing – View all tasks along with their status.
	•	💾 Auto-Save & Load – Automatically saves tasks upon exiting and reloads them when the program starts.
	•	🏷️ Flexible Input – Recognizes multiple input formats for better usability.


⌨️ Usage Guide

Tywin supports the following commands:

## Task Commands

| Command                 | Description                     | Example                                  |
|-------------------------|--------------------------------|------------------------------------------|
| `todo <task>`          | Adds a new To-Do task.         | `todo Read book`                         |
| `deadline <task> by <date>` | Adds a task with a deadline. | `deadline Submit report by 12/12/2025`   |
| `event <event name> at <date>` | Adds an event with a specific date. | `event Project meeting at 6/8/2025` |

## Task Management Commands

| Command               | Description                      |
|-----------------------|----------------------------------|
| `list`               | Displays all tasks with their status. |
| `mark <task number>` | Marks a task as completed.      |
| `unmark <task number>` | Unmarks a completed task.    |
| `delete <task number>` | Deletes a task from the list. |

## Search & Exit Commands

| Command         | Description                          | Example       |
|---------------|--------------------------------------|---------------|
| `find <keyword>` | Searches for tasks containing the keyword. | `find book` |
| `bye`          | Saves all tasks and exits the program. | `bye` |

⸻

⚠️ Important Notes
	•	Date Format: Tywin recognizes dates in the dd/MM/yyyy format (e.g., 12/12/2025).
	•	Data Persistence: All tasks are automatically saved upon exiting and reloaded when the program starts.
	•	File Structure: Keep all Java files inside the src/main/java folder to avoid issues with project configuration.

⸻

📌 Example Usage

> todo Read book
Added task: [T][ ] Read book

> deadline Submit report by 12/12/2025
Added task: [D][ ] Submit report (by: 12th December 2025)

> event Project meeting at 6/8/2025
Added event: [E][ ] Project meeting (at: 6th August 2025)

> list
Here are your tasks:
1. [T][ ] Read book
2. [D][ ] Submit report (by: 12th December 2025)
3. [E][ ] Project meeting (at: 6th August 2025)

> mark 1
Task marked as done:
[T][X] Read book

> find book
Here are the matching tasks:
1. [T][X] Read book

> bye
Goodbye! Your tasks have been saved.

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.
