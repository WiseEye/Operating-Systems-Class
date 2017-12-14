import java.io.*;
import java.util.*;

 public class Matrix
 {
    ArrayList<String[]> firstMatrix = new ArrayList<String[]>();
    
    public Matrix(String FileName)
    {
        BufferedReader reader;
        String newLine;
        try 
        {
        
        String[] row;
        reader = new BufferedReader(new FileReader(FileName));
        newLine = reader.readLine();
        
       while(newLine != null)
       {
           
           row = newLine.split(",");
           firstMatrix.add(row);
           newLine = reader.readLine();
       }
       
          reader.close();
        
        } 
        catch(Exception e) 
        {
        }
        
    }
    
    //take in the row and column number
    //make a new matrix
    
    public Matrix(int r, int c)
    {  
        String[] row;
        
        for(int i = 0; i < c; i++)
        {
           row = new String[r];
           Arrays.fill(row, "0");
           firstMatrix.add(row);
        }
    }
    
 public int getCellTotal()
 {
    int total = 0;
    
    for(int i = 0; i < firstMatrix.size(); i++)
    {
        String[] tempRow = firstMatrix.get(i);
      
        for(int j = 0; j < firstMatrix.get(0).length; j++)
        {
            total = total + Integer.parseInt(tempRow[j]);
        }
    }
    
    return total;
 } 
 
 public int getRows()
 {
     return firstMatrix.get(0).length;
 }
 
 public int getColumns()
 {
     return firstMatrix.size();
 }
 
 public int getCell(int row, int column)
 {
     String[] temp = firstMatrix.get(row);
     return Integer.parseInt(temp[column]);
 }
 
  public void setCell(int row, int column, String s)
  {
     String[] temp = firstMatrix.get(row);
     temp[column] = s;
     firstMatrix.set(row, temp);
  }
 
 @Override
 public String toString()
 { 
      String temp = "";
     for(String[] sA : firstMatrix)
     {
        for(String s : sA)
        {
          temp = temp + " "+  s;  
        }
        
        temp = temp + "\n";
     }
     
     return temp;
 }
 
   
}
