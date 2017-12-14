import java.util.*;
import java.util.concurrent.*;

public class FindingPrimesWithThreads
{
	public static void main(String[] args) throws Exception
	{
		(new FindingPrimesWithThreads()).go();
	}

	private void go() throws Exception
	{
		List<Double> allPrimes = Collections.synchronizedList(new ArrayList<Double>());

		List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
		//this should be somthing like the number of rows and coulumns
		//Good keep with this idea and see where it take the cse
		for (int n = 0; n < 10; n++)
		{
		  int start = ((n*100)-500);
		  int end = start + 100;
		  System.out.printf("Creating thread for range %d-%d ...%n",start,end);

		  Callable<Boolean> task = new MyThread(start, end, allPrimes);
		  tasks.add(task);
		}

		ExecutorService executor = Executors.newFixedThreadPool(5);
		List<Future<Boolean>> futures = executor.invokeAll(tasks);

		for (Future<Boolean> f : futures)
		{
			if (!f.get())
			  throw new Exception("Thread completion error!");
		}
		executor.shutdown();

		for (double i : allPrimes)
		{
			//System.out.printf("%s X =.%n", i);
		}
	}
	
	public class MyThread implements Callable<Boolean>
	{
		private int m_start;
		private int m_end;
		private List<Double> m_allPrimes;
		
		public MyThread(int start, int end, List<Double> allPrimes)
		{
			m_start = start;
			m_end = end;
			m_allPrimes = allPrimes;
		}
		
		@Override
		public 	Boolean call()
		{
	      for (double i = m_start; i < m_end; i = i + 0.1)
	      {
	        
	        double x = 0;
	        
	        x = (Math.pow(i,5)) + (3.5 * Math.pow(i,4)) - (2.5 * Math.pow(i,3))- (12.5 * Math.pow(i,2)) + ((1.5*i) +9);
	        
	        if(x < 2  && x > -2)
	        {
	            m_allPrimes.add(x);
	            System.out.println( "y = " + x + " x = " + i);
	        }
	      }
	      
	      int i = -3;
	      double x = 0;
	      //x = (Math.pow(i,5)) + (3.5 * Math.pow(i,4)) - (2.5 * Math.pow(i,3))- (12.5 * Math.pow(i,2)) + ((1.5*i) +9);
	      //System.out.println("This sux " + x);
	      
		  return true;
		}	
		
	}
}