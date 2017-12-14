import java.io.*;

public class Worker
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Boom");
        new Worker().go(args);
    }
    
    private void go(String args[]) throws Exception
    {
        String start = args[0].toUpperCase();
        File file = new File("./files/");
        
        String[] files = file.list();
        
    for(String s : files)
     {
       BufferedReader reader = new BufferedReader(new FileReader("./files/"+s));
       String newLine = reader.readLine();
       
       //System.out.println(newLine);
       
       while(newLine != null)
       {
           if(newLine.contains(args[1]))
           {
               System.out.println("Found " + args[1] + " in " + s);
               break;
           }
           
            newLine = reader.readLine();
       }
       
     }
    }
}