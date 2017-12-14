import java.util.*;// we need Javas linked lists

public class BestFit implements ISwapper
{
    //Make a class to represent whole or procces, procce id, size, memory adress, time
    //make  an objest 
    //the algorith is just how you look for the processes
    List<memoryObject> list = new LinkedList<memoryObject>();



     public void init(int memSize)
     {
         list.add(memoryObject(0, memSize, "Hole", 0)); // we should set our ID to 0 so we know it is the start
         
     }
     
    public boolean load(IProcess p, IMemory mem) throws BlueScreenException
    {
        //We have to find the memory object that has nearest length. Then swap in
        int tempSize = 0;
        int tempSize2 = 100000000000;
        int index = 0;
        int processSize = p.getSize();
        int processID = p.getId();
        boolean loadbool = false;
        
        
        for(int i = 0; i < list.size(); i++)
        {
   
           memoryObject m_object =  list.get(i);
         
           if(m_object.holeOrnot.equals("Hole"))
           {
               
             if(tempSize2 >= tempSize && tempSize >= 0)
             {
                 tempSize2 = tempSize;
                 index = i;
                 loadbool = true;
             }
             
             tempSize = processSize - m_object.size;
             
           }
        }
        
          list.get(index).size = tempSize;
        
          memoryObject addedObject = new memoryObject(list.get(index).size + list.get(index).start + 1, processSize, "Not", processID); //subtract size of new node from object at i
          list.add(index + 1, addedObject);
          mem.load(p, addedObject.start, addedObject.size + addedObject.start);
          return loadbool;
    }
   
    public void unload(IProcess p, IMemory mem) throws BlueScreenException
    {
     
     memoryObject before = null;
     memoryObject curret = null;
     memoryObject after = null;
     //mem.unload(p);
     
     for(int = 0; i < list.size(); i++)
     {
         curret = list.get(i);
         after = list.get(i+1);
         if(i > 0)
         {before = i - 1}
         
     }
     
     
     
     
     
    }
     
}