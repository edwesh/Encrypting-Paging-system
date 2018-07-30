import java.io.*; 
public class CreatePage 
{ 
    execution e;
    public static BufferedReader bufread;
    private static String readStr ="";
    static String varName = "memory";
    static boolean bol;
    public CreatePage()
    {
        
    }
    
    public void page(int num, String newStr) 
    {  
        File textFile = new File("C:/users/apple/desktop/txt/" + varName + num +".txt"); // change the path to your local directory as where you store the file. 
        try 
        { 
            if (textFile.isFile()) 
            { 
                System.out.println( "File " + varName +" "+ num + " exists"); 
            }else{ 
                textFile.createNewFile(); 
                System.out.println("File "  + varName +" "+ num + " created"); 
            }  
            PrintWriter printWriter = new PrintWriter(textFile); 
            printWriter.println(newStr); 
            printWriter.close(); 
        }   
        catch (IOException e1) 
        { 
            e1.printStackTrace(); 
        }  
    } 
} 