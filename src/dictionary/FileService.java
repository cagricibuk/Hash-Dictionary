package dictionary;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.*;

/**
 *
 * @author cagri
 */
public class FileService {

    File dictFile;

    public HashService ReadFile(String fileName) throws FileNotFoundException, IOException, InterruptedException {

        String dir = System.getProperty("user.dir");
        //System.out.println("\ncurrent dir "+ dir);
        dictFile = new File(dir + "\\src\\dictionary\\" + fileName);
        //System.out.println("\nTargetFile "+dictFile);
        File file = dictFile;

        if (file.exists() && !file.isDirectory()) {

            System.out.println("\nFile Found!");
        } else {
            System.out.println("\nFile not found!");
            return null;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        int count = 1;
        while ((st = br.readLine()) != null) // Print the string
        {
            count++;

        }
        br.close();
        br = new BufferedReader(new FileReader(file));
        System.out.println("\nFound " + count + " entries!");

        HashService hs = new HashService(count + 1);
        while ((st = br.readLine()) != null) // Print the string
        {

            //System.out.println("key " + st);
            hs.insert(st);

        }
        Thread.sleep(1000);
        Dictionary.clearme();
        Thread.sleep(500);
        
       
        return hs;

    }
}
