import java.util.concurrent.*;
import java.io.*;
import java.util.*;

public class main{
    public static void main(String [] args) throws Exception
    {
        (new main()).go();}
    
    private void go() throws Exception {
         Scanner key = new Scanner(System.in);
         System.out.println("Please enter n");
         int n = key.nextInt();
         group[] gArray = new group[n];
         int numberOfGroups = n;
         int[] firstNumber = new int[1];
         Random random = new Random();
         
         for(int i = 0; i < n; i++)
         {
             firstNumber = new int[1];
             firstNumber[0] = random.nextInt(15) + 1;
             group tempGroup = new group(firstNumber); 
             
             gArray[i] = tempGroup; 
         }
        
            
            
            
        List<Callable<group>> tasks = new ArrayList<Callable<group>>();
        
        while(n > 1)
        {
            for(int i = 0; i < n; i = i +2)
            {
              Callable<group> task = new MyThread(gArray[i], gArray[i+1]);
              tasks.add(task);
            }
            
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
		List<Future<group>> futures = executor.invokeAll(tasks);

        group[] tempGroup = new group[n/2];
        
        for(int i = 0; i < futures.size(); i++)
        {
            tempGroup[i] = futures.get(i).get();
            //We are getting the groups that the threads will return 
        }
        
        gArray = tempGroup;
		executor.shutdown();
            
            n = n/2;
            tasks.clear();
        }
        
        for(int i = 0; i < gArray.length; i++)
            System.out.println(gArray[i].toString());
    }
    
    public class MyThread implements Callable<group>
    {
        private group g1;
        private group g2;
    
        public MyThread(group one, group two)
        {
            g1 = one;
            g2 = two;
        }
        
        @Override
      public group call()
      {
          
          int[] temp1 = g1.numberArray;
          int[] temp2 = g2.numberArray;
          
          return merge(temp1, temp2);
      }
    
        
    }
    
    public static group merge(int[] a, int[] b)
    {
        int[] answer = new int[a.length+b.length];
        int i = 0, j = 0, k = 0;
        
        while(i<a.length && j<b.length)
            answer[k++] = a[i] < b[j] ? a[i++] : b[j++];
            
        while(i < a.length)
            answer[k++] = a [i++];
                
        while(j < b.length)
            answer[k++] = b[j++];
            
        group ret = new group(answer);
        
        return ret;
            
    }
}