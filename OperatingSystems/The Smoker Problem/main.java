import java.util.*;
import java.util.concurrent.*;
public class main
{
	public static void main(String args[]) throws Exception
	{
		
		
		
		Semaphore match = new Semaphore(0, true);
		Semaphore paper = new Semaphore(0, true);
		Semaphore tabbaco = new Semaphore(0, true);
		Semaphore dealer = new Semaphore(0, true);
		List<Callable<Boolean>> threadsL = new ArrayList <Callable<Boolean>>();
		
		threadsL.add(new MathchesSmoker(tabbaco, paper, dealer));
		threadsL.add(new TabbacoSmoker(paper, match, dealer));
		threadsL.add(new PaperSmoker(tabbaco, match, dealer));
		threadsL.add(new Dealer(tabbaco, paper, match, dealer));
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		executor.invokeAll(threadsL);
		executor.shutdown();
	}
}