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
        //System.out.println("\ncurrent dir "+ dir);
        dictFile = new File(dir+"\\src\\dictionary\\" + fileName);
        //System.out.println("\nTargetFile "+dictFile);
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
        int count = 1;
        while ((st = br.readLine()) != null) // Print the string
        {
          count++;
          
            
        }
        br.close();
        br = new BufferedReader(new FileReader(file));
        System.out.println("\nFound "+count+" entries!");
        
        HashService hs = new HashService(count);
        System.out.println(hs.getSize());
        while ((st = br.readLine()) != null) // Print the string
        {
          hs.insert(st, st);
          
           
          
          
            
        }
        
        System.out.println("InsertComplete");
        //System.out.println(hs.getSize());
        //hs.get("aback");
        
    }
}
