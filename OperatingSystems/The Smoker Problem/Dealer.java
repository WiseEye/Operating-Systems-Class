import java.util.*;
import java.util.concurrent.*;


public class Dealer extends Smoker
{
    //public Dealer
    
    Random random = new Random();
    public Boolean call()
    {
        
        try 
        {
            while(true)
        {
         // use random
        int seconds = random.nextInt(500) + 500; // .5 and up
         Thread.sleep(seconds);
        
         int flip = random.nextInt(3); // this is so we can generate products randomly
        
         if(flip == 1)
         {
            System.out.println("Your Dealer is putting tabbaco on the table");
            Tobacco.release();
            System.out.println("Your Dealer is putting matches on the table");
            Match.release();
            
         }
         
         if(flip == 2)
         {
             System.out.println("Your Dealer is putting paper on the table");
             Paper.release();
             System.out.println("Your Dealer is putting tabbaco on the table");
             Tobacco.release();
             
         }
         
         if(flip == 0)
         {
             System.out.println("Your Dealer has put mathces on the table");
             Match.release();
             System.out.println("Your Dealer has put tabbaco on te table");
             Tobacco.release();
         }
        }
        } 
        catch(Exception e) 
        
        {
        }
        
        
        return false; // This terminates..
    }
    
    public Dealer(Semaphore t, Semaphore p, Semaphore m, Semaphore s)
    {
        super(t, p, m, s);
    }
}