import java.util.*;
import java.io.*;

class Worker
{
      private Point p;  // This allows us to refrence the methods in the point class
      private double distance = Double.POSITIVE_INFINITY;  // This is the distance that will be returned to our Master class. We set it very high in order to make sure the number returned will be lower 
      private String topPoints = ""; // These are the points that will be returned to our Master class
      //This is a smile -->   :)
      //It points to Happiness
   public static void main(String args[]) throws Exception
  {
    new Worker().go(args);
  }
  
    private void go(String args[]) throws Exception
    {
      Scanner scan = new Scanner(System.in); // The scanner to skip the command line

      String mPoints = null; // This is used to store the points from the Scanner
      int numberOfPoints = Integer.parseInt(args[0]);
      int x = Integer.parseInt(args[1]); // our x for the refrence point
      int y = Integer.parseInt(args[2]); // our y for our refrence point
      
      for(int i = 0; i < numberOfPoints; i++) // The loop procceses all of the points coming from the scanner
      {
       mPoints = scan.next();
       String[] xy = mPoints.split(",");
       p = new Point(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])); // Here we create an instance of our Point class
       double tempDistance = p.distanceTo(Integer.parseInt(xy[0]),Integer.parseInt(xy[1]),x,y); // Here we are using the distanceTo method in our Point class
       
          if(tempDistance < distance)   // Here we are checking for the smalles value in order to send back the smallest distance
          {
             distance = tempDistance;
             topPoints = mPoints;
          }
      }
        System.out.println(distance + " , " + topPoints); // Here we return the x,y, and distance to the Master
    }
    
    
    //*:)
    // here the smile is being used to create happy thoughts
    
 /*   if(emotions >= :|(neagtive)) //here we cast to a negative emotion
    {
        emotion = emotion.(saySomthingNice());
    }
    
    public static void saySomthingNice()
    {
        emotion = love * care + kindness;
        return emotions + :)  ;
    }*/
}

