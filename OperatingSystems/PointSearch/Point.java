import java.util.*;

public class Point
{
    public final int x;//These variables proabbly shouldent be public
    public final int y;
    
    Random rand = new Random();
    
    //both these valueas are dependent on the user imput for the size of the 2D grid
    public Point(int X, int Y) //A Constructor to create an instance of the point class
    {
         x = rand.nextInt(X);
         y = rand.nextInt(Y);
    }
    
    
    public int distanceTo(Point other) //Another method that can be refrenced safely from both our Master and Worker class
    {
        int distance = 0;
        
        return distance;
    }
        
    public int getX() //Getters and Setters 
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    @Override
    public String toString() //Here is a toString() that we use to convert the point data to a good format
    {
       return this.x +","+ this.y;
    }
    //Here we create a distance method that can be safely refrenced from both Worker and Master classes
  public double distanceTo(int x1, int y1, int x2, int y2)
   {
       return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2)); //<-- this is probably the correct way to do it
   }
    
}