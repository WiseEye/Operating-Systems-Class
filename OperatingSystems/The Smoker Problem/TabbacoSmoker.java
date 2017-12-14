import java.util.*;
import java.util.concurrent.*;

public class TabbacoSmoker extends Smoker
{
    public Boolean call()
 {
    try 
    {
       while(true)
       {
           Match.acquire();
           
           if(Paper.tryAcquire())
           {
               System.out.println("The Tabbaco Smoker Is Smoking");
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
 
 public TabbacoSmoker( Semaphore paper, Semaphore match, Semaphore dealer)
   {
       super(null ,paper, match, dealer);
   }
}