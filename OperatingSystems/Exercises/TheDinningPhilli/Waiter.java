public class Waiter
{
    
    public synchronized boolean forkThis(Fork f1,Fork f2)
    {
        Boolean f1Status;
        Boolean f2Status;
        Boolean status = false;
        
        f1Status = f1.getStatus();
        f2Status = f2.getStatus();
        
        if(f1Status == false && f2Status == false)
        {
            f1.setStatus(true);
            f2.setStatus(true);
        }
        
        else
        {
            status = true;
        }
        
        return status
    }
}