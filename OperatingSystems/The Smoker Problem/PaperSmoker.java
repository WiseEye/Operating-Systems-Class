import java.util.*;
import java.util.concurrent.*;

public class PaperSmoker extends Smoker
{
   // public PaperSmoker
   
   public Boolean call()
 {
    try 
    {
       while(true)
       {
           Tobacco.acquire();
           
           if(Match.tryAcquire())
           {
               System.out.println("The Paper Smoker Is Smoking");
               Thread.sleep(1000);
               Supplier.release();
           }
           
           else
           {
               Match.release();
           }
       }
    } 
    catch(Exception e) 
    {
    }
    
    return false;
 }
 
 public PaperSmoker( Semaphore tabbaco, Semaphore match, Semaphore dealer)
   {
       super(tabbaco,null, match, dealer);
   }
}

