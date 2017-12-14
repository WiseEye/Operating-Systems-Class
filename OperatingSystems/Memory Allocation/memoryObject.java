public class memoryObject
{
    int start = 0;
    int size = 0;
    String holeOrnot = "Used";
    
    public memoryObject(int strt, int si, String holeorother, int id)
    {
        ID = id;
        start = strt;
        size = si;
        holeOrnot = holeorother;
    }


    public String toString()
    {
        return String.format("%d %d %d %s", start, size, id, holeOrnot);
    }
    
}
