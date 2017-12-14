import java.util.*;
import java.io.*;

public class Exercise1
{  
        String[] command = new String[5];
        String[] data = new String[5];
        Map<String, String> m_map = new HashMap<String, String>();
        int bitSize = 16;
        String[] test = new String[16];
        int accumulator = 0;
        //String[] push = new String[16];
        //int PushCounter = 1;

    public static void main(String args[])
    {
        
        Exercise1 main = new Exercise1();
        main.read();
        main.print();
        main.exe();
        main.printMemoryMap();
    }
    
    private void read()
    {
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("instuct.txt")))
    {
        
      String line = reader.readLine();
      while (line != null)
      {
          
      if(!line.contains("/"))
      {
          //System.out.println("Boom");
        command[i] = line.substring(0,3);
        
        if(line.length()!=3)
        {
         int temp = Integer.parseInt(line.substring(4,line.length()));
         String lol3 = Integer.toBinaryString(temp);
            
            while(lol3.length() <4)
            {
                lol3 = "0" + lol3;
            }
         
         //System.out.println(lol3);
         data[i] = lol3;
         //System.out.println(i +" " + data[i]);
         
        }
        
        i++;
      }
        
        line = reader.readLine();
        
      }
    }
    catch (IOException x)
    {
      System.err.format("IOException: %s%n", x);
    }
    }
    
    private void print()
    {
        for(int i = 0; i < 4; i++)
        System.out.println(data[i]);
    }

    private void exe()
    {

        for(int i = 0; i < 16; i++)
        {
            String binary = Integer.toBinaryString(i);
            
            while(binary.length() <4)
            {
                binary = "0" + binary;
            }
            
            System.out.println("Addresses: " + binary);
            
            m_map.put(binary, "00000000");
            test[i] = binary;
        }
        
         //m_map.put("1111", "00000100");
         //m_map.put("1110", "00000111");
        
        for(int i = 0; i < 3; i++)
        {
            if(command[i].equals("LDA"))
            LDA(i);
            if(command[i].equals("ADD"))
            ADD(i);
            if(command[i].equals("OUT"))
            OUT();
            if(command[i].equals("HLT"))
            HLT();
            System.out.println("Loaded Commands: " + command[i]);
        }
    }
    
    private void LDA(int index)
    {
        int index2 = index;
        String index3 = Integer.toBinaryString(index2);
  
        index3 = Standerdize(index3);    
        String data2 = "0000" + "" + data[index];
        System.out.println("Data In Array: " + data2);
        m_map.put(index3, data2);
        accumulator = Integer.parseInt(m_map.get("1111"),2);
        
        //System.out.println("test "+Integer.parseInt(m_map.get("1111"),2));
        
    }
    
    private void ADD(int index)
    {
        int index2 = index;
        String index3 = Integer.toBinaryString(index2); 
        index3 = Standerdize(index3); 
        String data2 = "0000" + "" + data[index];
        m_map.put(index3, data2);
        accumulator = accumulator + Integer.parseInt(m_map.get("1110"),2);
    }
    
    private void OUT()
    {
        
    }
    
    private void HLT()
    {}
    
    private String Standerdize(String s)
    {
      while(s.length() <4)
        {
          s = "0" + s;
        }
        
        return s;
    }
    
    private void printMemoryMap()
    {
        for(String i : test)
        {
           String t = m_map.get(i);
           //System.out.printf("%s -> %s%n", k, t);
           System.out.println(i + " " + t );
           
        }
    }
    
/*      private void push(String s)
    { //you might be able to let the user specify memory;
        
        for(int i = 0; i < PushCounter; i++)
        {
            String temp = Integer.toBinaryString(15 - i);
            System.out.println(temp);
            m_map.put(temp, s);
        }
    }*/
}

