import java.util.*;
import java.io.*;
public class execution
{
    static Scanner keyboard = new Scanner(System.in);
    static CreatePage page = new CreatePage();
    static Table table = new Table();
    public variables v;
    static char[] key;
    static execution compareA;
    static execution compareB;
    static char c;
    
    static int frame_no = 0;
    int page_no;
    static String[] mirror = new String[80];
    
    public execution()
    { 
        variables v = new variables();
        this.v = v;
        do
        {
            v.enterPassword();
            if (v.password.length() == 8)
            {
                v.cha = v.password.toCharArray();
                encrypt();
                table.assignValue(v.encryptPassword);
                table.accessTime++;
                
                page.page(table.accessTime, v.encryptPassword);
                
                v.stored_encryptPassword[table.accessTime][0] = v.encryptPassword;
                v.stored_password[table.accessTime][0] = v.password;
            }else if(v.password.length() != 8 )
            {
                System.out.println("Please enter proper password");
            }
        }while(!v.password.equals("!stop"));       
        new Paging();
        table.accessTime = 0;
        System.out.println();
    }

    public static void main(String[] args) 
    {
        compareA = new execution();
        do
        {
            System.out.print("Would you like to match those password? (y/n): ");
            c = keyboard.next().charAt(0);
            System.out.println();
        }while(c != 'y' && c != 'n'&& c != 'Y' && c != 'N');
    
        if(c == 'y' || c == 'Y')
        {
            table.name = "Page Number";
            page.varName = "variable";
            
            compareB = new execution();
            matching();
            table.name = "Memory Frame";
            table.name_p = "Process Page";
            for(int i = 0; i < mirror.length; i++)
            {
                if(mirror[i] == null)
                {
                    mirror[i] = "Guess";
                }
            }
            table.outPut = mirror;
            new Paging();
        }
        table.name = "Frame Number";
        if (c == 'n' || c == 'N')
        {
            System.out.println("Terminate");
        }
    }
       
    public void encrypt()
    {
        for (int i = 0; i < v.cha.length; i++)
        {
            v.cha[i] = (char)((int)key[i] + (int)v.cha[i]);
        }   
        v.encryptPassword = new String(v.cha);    
    }
    
     public static void matching()
    {     
        for(int i = 0; i < compareB.v.stored_encryptPassword.length; i++)
        {
            for(int j = 0; j < compareB.v.stored_encryptPassword[i].length; j++ )
            {
                if(compareB.v.stored_encryptPassword[i][j] != null)
                {
                    System.out.println("Located Page" + i +":");
                    each(compareB.v.stored_encryptPassword[i][j].toCharArray(), i);
                    System.out.println();
                }
            }
        }
    
    }
    
    public static void each(char[] ch_B, int pNum)
    {
        char[] ch_A = {' '};
        for(int i = 0; i < compareA.v.stored_encryptPassword.length; i++)
        {
            for(int j = 0; j < compareA.v.stored_encryptPassword[i].length; j++ )
            {
                if(compareA.v.stored_encryptPassword[i][j] != null)
                {
                    ch_A = compareA.v.stored_encryptPassword[i][j].toCharArray();
                    for(int k = 0; k < ch_A.length; k++)
                    {
                        pageFault(ch_B[k], ch_A[k], i, pNum, k);
                    }
                }
            }
        }
    }
    
    public static void pageFault(char cha_B, char cha_A, int fNum, int pNum, int pos)
    {
     
        if(cha_B == cha_A)
        {
            System.out.println("Located in Page "+ (pos+1) + " access first time. Page fault");
            mirror();
            mirror[table.accessTime] = "p" + pNum;
        }
        else
        {
            System.out.println("Located page " + (pos+1) + " page not access for the first time. No Page Fault");
        }
        table.accessTime++;
        if(table.accessTime > fNum * 8)
        {
            table.accessTime = 1;
        }
    }
    
    public static boolean mirror()
    {
        if(mirror[table.accessTime] == null)
        {
            return true;
        }
        else if(mirror[table.accessTime] != null)
        {
            mirror[table.accessTime] = mirror[table.accessTime];
        }
        return false;
    }
        
    
}
