import java.util.*;
import java.util.concurrent.*;

public abstract class Smoker implements Callable<Boolean>
{
	protected final Semaphore Tobacco;
	protected final Semaphore Paper;
	protected final Semaphore Match;
	protected final Semaphore Supplier;

public Smoker(Semaphore t, Semaphore p, Semaphore m, Semaphore s)
{
	Tobacco = t;
	Paper = p;
	Match = m;
	Supplier = s;
}

public abstract Boolean call();

	 
}
