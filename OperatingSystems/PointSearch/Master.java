import java.io.*;
import java.util.*;

public class Master
{
  private String finalXY = "";
  private double finalDistance = Double.POSITIVE_INFINITY; //Here we create a large number so it will always start as a larger number
  private ArrayList<Point> pointsArray = new ArrayList<Point>(); //Here is an arraylist to hold points
    
  public static void main(String args[]) throws Exception
  {
    new Master().go();
  }

  private void go() throws Exception
  {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Please enter the size of the even grid (ex: 20 20 enter by typing 20)");
      int mapSize = keyboard.nextInt();
      System.out.println("Please enter a refrence point x (ex: 2)");
      int x = keyboard.nextInt();
      System.out.println("Please enter a refrence point y (ex: 5)");
      int y = keyboard.nextInt();
      System.out.println("Please enter the number of points (ex: 20)");
      int numberOfPoints = keyboard.nextInt();
      System.out.println("Please enter how many groups you want. Make it so the number of point are evenly divisible");
      int numberOfGroups = keyboard.nextInt();
      
      for(int i = 0; i < numberOfPoints; i++) //Here we generate our points randomly 
      {
         pointsArray.add(new Point(mapSize,mapSize)); 
      }
      
      int start = 0;
      int end = numberOfPoints/numberOfGroups;
    List<Process> list = new ArrayList<Process>();
    for (int i = 0; i < numberOfGroups; i++)
    {
      Process p = new ProcessBuilder("java", "Worker", end+"", x+"", y+"").start();
      sendParameters(p, start, end); //end is just a name for the number of Points in a group
      start = start + end;
      list.add(p);

    }

    for (Process p : list)
    {
      getClosest(p);
    }
    System.out.println("The Closest Point is " + finalXY +" with the distance of "+ finalDistance);
    
  }
  
 private void sendParameters(Process p, int start, int end) throws Exception
  {
    System.out.printf("Sending parameters for range %d-%d to process ...%n",start,start+end);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream(), "UTF-8"));
    
    for(int i = 0; i < end; i++)
    {
      System.out.println(pointsArray.get(start+i).toString());
      pw.println(pointsArray.get(start+i).toString());
      pw.flush();
    }
  }
  
    private void getClosest(Process p) throws Exception
  {
    p.waitFor();
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
    String line = br.readLine();
    int i = 0;
    while (line != null)
    { 
      String[] splitLine = line.split(" , ");
     // System.out.println("Process found " + i +splitLine[0] +", " +splitLine[1]);
      
      if(Double.parseDouble(splitLine[0]) < finalDistance)
      {
         finalXY = splitLine[1];
         finalDistance = Double.parseDouble(splitLine[0]);
      }
      
      line = br.readLine();
      i++;
    }
  }
  
}