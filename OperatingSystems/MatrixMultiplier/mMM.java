import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public class mMM
{
    
    public static void main(String [] args) throws Exception
    {
        (new mMM()).go();
    }
    
    private void go() throws Exception
    {

       Scanner key = new Scanner(System.in);
       System.out.println("Welome to THE Matrix \n Please enter the name of the file to multiply by. (You must keep in mind that in the case \n of matrix multiplication order matters)");
       String s = key.nextLine();
       System.out.println("Please enter the full name of your second file");
       String s2 = key.nextLine();
       
       Matrix a = new Matrix(s2);
       Matrix b = new Matrix(s);
       int cRow = a.getColumns(); //Here we get the size of our C matrix row by getting the column size of a
       int cColumn = b.getRows(); //Here we get the C Matrix Clolumn size by getting row Size of b
       int c1 = b.getColumns();   //Here we get the size of our B matrix Column ehich will allow us to check if thr Matrices where multiplies in the correct order
      
       if(a.getRows() != b.getColumns())
           throw new Exception("Matrices Size Error");
           
       Matrix c = new Matrix(cRow,cColumn);
       List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
       
       for(int i = 0; i < cRow; i++) //Here we are making a thread for every cell of thr C Matrix
       {
         for(int j = 0; j < cColumn; j++)
         {
            int row = i;
            int column = j;
            Callable<Boolean> task = new MyThread(row, column, c, a, b, cColumn, c1); //This calls out Anonymous Threads Class, We pass in our data
		    tasks.add(task); 
         }
       }
    
       ExecutorService executor = Executors.newFixedThreadPool(50);
		List<Future<Boolean>> futures = executor.invokeAll(tasks);

		for (Future<Boolean> f : futures)
		{
			if (!f.get())
			  throw new Exception("Thread completion error!");
		}
		executor.shutdown();
         System.out.println(c.getCellTotal());
         


try{
    PrintWriter writer = new PrintWriter("Output.txt", "UTF-8");
    writer.println(c.toString());
    writer.close();
} catch (IOException e) {
   
}

    }
    
    public class MyThread implements Callable<Boolean>
	 {
		private int m_rowat; //this is the row we are currently at for our loop
		private int m_columnat;//this is the clumn we are currently atfor our loop
		private Matrix m_Matrix; //this is our c matrix
		//private int rLength; //this is the 
		private Matrix a;
		private Matrix b;
		int cLength;
		int m_c1;
		                              //Matricies that we are passing in to our internal class
		public MyThread(int r, int c, Matrix matrix, Matrix a1, Matrix b1, int cl, int c1)
		{
			m_rowat = r;
			m_columnat = c;
			m_Matrix = matrix;
			b = b1;
			a = a1;
			m_c1 = c1;
			
			cLength = cl;
		
		}
		
		@Override
		public 	Boolean call()
		{
		    int cellVal = 0;
		   // i< .. this will be  c1 or r2 of matrix a or b
	      for (int i = 0; i < m_c1; i++)
	      {                 
	        int cellA = a.getCell(m_rowat, i);  
	        int cellB = b.getCell(i, m_columnat);
	        int temp = cellA * cellB;
	        cellVal = cellVal + temp;
	        
	      }
	        String cellValueInt = cellVal +""; 
	        m_Matrix.setCell(m_rowat, m_columnat, cellValueInt);
		    return true;
		}	
		
	 }
}