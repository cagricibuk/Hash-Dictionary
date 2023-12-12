package dictionary;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cagri
 */
public class Dictionary {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileService fs = new FileService();
        MenuService ms = new MenuService();

        // id of selection
        int num = 99;
        
        ms.GetMenuText();
        
        while (num != 0) {
            // Create Scanner object
            Scanner scanner = new Scanner(System.in);
            
            // Read the next integer from the screen
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    System.out.println("Please write down below the name of file with extension! example.txt");
                    Scanner sc= new Scanner(System.in); 
                    String str= sc.nextLine();
                    System.out.print("You have entered: "+str);
                    Thread.sleep(2000);
                    fs.ReadFile(str);
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                case 6:
                    System.out.println("Saturday");
                    break;
                case 7:
                    System.out.println("Sunday");
                    break;
            }

            
        }

    }
}
