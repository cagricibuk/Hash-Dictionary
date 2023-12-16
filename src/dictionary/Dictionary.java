package dictionary;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cagri
 */
public class Dictionary {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws IOException, InterruptedException {

        FileService fs = new FileService();
        MenuService ms = new MenuService();
        HashService hs = null;

        // id of selection
        int num = 99;

        ms.GetMenuText();

        while (num
                != 0) {
            // Create Scanner object
            Scanner scanner = new Scanner(System.in);

            // Read the next integer from the screen
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                System.out.println(ANSI_RED + "\n Please Enter Int Value not String!" + ANSI_RESET);
            }

            switch (num) {
                case 1:
                    System.out.println("Please write down below the name of file with extension! example.txt");
                    Scanner sc = new Scanner(System.in);
                    String str = sc.nextLine();
                    System.out.print("You have entered: " + str);

                    Thread.sleep(1000);
                    long startTime = System.currentTimeMillis();
                    hs = fs.ReadFile(str);
                    long endTime = System.currentTimeMillis();
                    if (hs == null) {
                        Thread.sleep(500);
                        ms.GetMenuText();

                    } else {

                        System.out.println(ANSI_GREEN + "InsertComplete with " + (endTime - startTime) + " milliseconds" + ANSI_RESET);
                        Thread.sleep(2000);
                        clearme();
                        Thread.sleep(500);
                        ms.GetMenuText();
                    }
                    break;
                case 2:
                    System.out.println("\nPlease Enter complete key string");
                    sc = new Scanner(System.in);
                    String query = null;
                    if (sc.hasNextLine()) {
                        query = sc.nextLine();
                    } else {
                        System.out.println(ANSI_RED + "\n Please Enter String Value not Integer!" + ANSI_RESET);
                    }
                    startTime = System.nanoTime();

                    System.out.println(ANSI_GREEN + "Found! " + hs.get(query) + " with " + (System.nanoTime() - startTime) + " nanoseconds" + ANSI_RESET);
                    Thread.sleep(2000);
                    clearme();
                    Thread.sleep(500);
                    ms.GetMenuText();

                    break;
                case 3:
                    System.out.println("\nPlease Enter complete key string");
                    sc = new Scanner(System.in);
                    String newEntry = null;

                    if (sc.hasNextLine()) {
                        newEntry = sc.nextLine();
                    } else {
                        System.out.println(ANSI_RED + "\n Please Enter String Value not Integer!" + ANSI_RESET);
                    }
                    startTime = System.nanoTime();

                    System.out.println(ANSI_GREEN + "Inserted! " + hs.insert(newEntry) + " with " + (System.nanoTime() - startTime) + " nanoseconds" + ANSI_RESET);
                    Thread.sleep(2000);
                    clearme();
                    Thread.sleep(500);
                    ms.GetMenuText();
                    break;
                case 4:
                    System.out.println("\nPlease Enter complete key string");
                    sc = new Scanner(System.in);
                    String TargetEntry = null;

                    if (sc.hasNextLine()) {
                        TargetEntry = sc.nextLine();
                    } else {
                        System.out.println(ANSI_RED + "\n Please Enter String Value not Integer!" + ANSI_RESET);
                    }
                    startTime = System.nanoTime();
                    hs.delete(TargetEntry);
                    endTime = System.nanoTime();
                    System.out.println(ANSI_GREEN + "Inserted! " + TargetEntry +" with " + ( endTime - startTime) + " nanoseconds" + ANSI_RESET);
                    Thread.sleep(2000);
                    clearme();
                    Thread.sleep(500);
                    ms.GetMenuText();
                    break;
                case 5:
                    System.out.println("Friday");
                    break;

            }

        }

    }

    public static void clearme() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        } catch (AWTException ex) {

        }
    }

}
