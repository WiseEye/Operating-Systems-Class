import java.util.*;
import java.util.concurrent.*;

public class MathchesSmoker extends Smoker
{
       public Boolean call()
 {
    try 
    {
       while(true)
       {
           Tobacco.acquire();
           
           if(Paper.tryAcquire())
           {
               System.out.println("The Match Smoker Is Smoking");
               Thread.sleep(1000);
               Supplier.release();
           }
           
           else
           {
               Tobacco.release();
           }
       }
    } 
    catch(Exception e) 
    {
    }
    
    return false;
 }
 
 public MathchesSmoker(Semaphore tabbaco, Semaphore paper, Semaphore dealer)
   {
       super(tabbaco, paper, null, dealer);
   }
}