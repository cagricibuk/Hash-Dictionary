package dictionary;

import java.io.*;

/**
 *
 * @author cagri
 */
public class FileService {

    File dictFile;
    
    
    public void ReadFile(String fileName) throws FileNotFoundException, IOException {
       
        String dir = System.getProperty("user.dir");
        System.out.println("\ncurrent dir "+ dir);
        dictFile = new File(dir+"\\src\\dictionary\\" + fileName);
        System.out.println("\nTargetFile "+dictFile);
        File file = dictFile  ;

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) // Print the string
        {
            System.out.println(st);
        }
    }
}
