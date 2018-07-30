import java.util.*;
import java.io.*;
public class variables 
{
    static Scanner keyboard = new Scanner(System.in);    
    execution e;
    char[] cha = new char[8];
    String password = new String();
    String key = new String();
    String encryptPassword;
    String[][] stored_password = new String[2^62][1];
    String[][] stored_encryptPassword = new String[2^62][1];
    public variables()
    {   
         key = "        ";
         e.key = key.toCharArray();
    }
    
    public void enterPassword()
    {   
        System.out.print("Enter 8 characters password: ");
        password = keyboard.nextLine();
    }
}







   
   

