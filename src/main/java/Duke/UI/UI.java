package Duke.UI;
import Duke.DukeExceptions;
import Duke.commands.Parser;

import java.util.Random;
import java.util.Scanner;

public class UI {
    private static Scanner sc = new Scanner(System.in);
    private static boolean isStillGoing = true;
    private enum Messages {
        WRONG_INPUT("Bark bark? (This doesn't make sense?)"),
        MISSING_INPUT("Bork bark?? Bark bark woof. (What does this command mean?? Try again with todo *task*, " +
                "*task* /at *start date/time* *end date/time*, or *task* by *deadline.)"),
        DONE_ERROR("Bork. (Sorry, can't be done.)"),
        BYE("bye"),
        LIST("list"),
        DONE("done"),
        DELETE("delete"),
        FIND("find"),
        GOODBYE_MSG("BARK! (Come back soon!)"),
        WELCOME_MSG("BARK BARK WOOF! (Welcome! Tell me your tasks and I'll help you keep track of them!)");


        private final String value;

        Messages(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }
    private static final Messages[] ERROR_MESSAGES = {Messages.WRONG_INPUT, Messages.MISSING_INPUT,
            Messages.MISSING_INPUT, Messages.DONE_ERROR};

    /**
     * Prints GOODBYE_MSG.
     */
    public static void printGoodbye() {
        System.out.println(Messages.GOODBYE_MSG);
    }

    /**
     * Prints a standard line to create spacing.
     */
    public static void printLine() {
        System.out.println("************************************************************");
    }

    /**
     * Gets a standard line to create spacing.
     * @return The line.
     */
    public static String getLine() {
        return "************************************************************";
    }

    /**
     * Prints logo of a dog.
     */
    protected static void printLogo() {
        System.out.println(Messages.LOGO);
    }

    /**
     * Prints a random message chosen from ERROR_MESSAGES
     */
    public static void printWrongInput() {
        int rnd = new Random().nextInt(ERROR_MESSAGES.length);
        System.out.println(ERROR_MESSAGES[rnd].toString());
    }

    /**
     * Stops the programme from running.
     */
    public static void stop() {
        isStillGoing = false;
    }

    /**
     * Retrieves messages of the title cmd.
     * @param cmd
     * @return String value stored in Messages.cmd.toString()
     */
    public static String getMessage(String cmd) {
        return Messages.valueOf(cmd).toString();
    }

    /**
     * Starts the Duke.TaskList.Duke.UI, and the rest of the programme.
     * @throws DukeExceptions
     */
    public static void start() throws DukeExceptions {
        isStillGoing = true;
        while (sc.hasNextLine()) {
            Parser.parseAndAddToList(sc.nextLine());
            if(!isStillGoing) {
                break;
            }
        }
    }
}
