public class group
{
    int[] numberArray;
    int number;
    
    group(int[] array)
    {
        
        numberArray = array;
    }
    
    /*group( int n)
    {
        number = n;
    }*/
    
    @Override
    public String toString()
    { 
     String temp = "";
     
     for(int in : numberArray)
     {
        temp = temp + in + ",";
     }
     return temp;
 }
 
}