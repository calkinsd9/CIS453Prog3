import java.util.HashMap;
import java.util.Map;

public class Process {

    public int totalFaults;
    public int totalReferences;
    public String processID;
    public Map<String, String> pageTable; 
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    /**
     * @param totalFaults
     * @param totalReferences
     * @param processID
     * @param pageTable
     */
    public Process(String processID) {
        super();
        this.totalFaults = 0;
        this.totalReferences = 0;
        this.processID = processID;
        this.pageTable = new HashMap<String,String>();  //maps pages -> frames
//        for (int i = 0; i < 64; i++)
//        {
//            this.pageTable.put(Integer.toString(i), "not in memory");
//        }
    }

    public void pageReference(String pageNum)
    {
        this.totalReferences++;
        String frame = this.pageTable.get(pageNum);
        if (frame == null)
            this.pageTable.put(pageNum, "not in memory");
    }
    
    public void movedPageIntoMemory(String page, String frame)
    {
        this.pageTable.put(page, frame);
    }
    
    public void movedPageOutOfMemory(String page) 
    {
        this.pageTable.put(page, "not in memory");
    }

}
