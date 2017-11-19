
public class Frame {

    public String processID;
    public String pageNumber;


    public Frame()
    {
        super();
    }
    
    public Frame(String processID, String pageNumber)
    {
        super();
        this.processID = processID;
        this.pageNumber = pageNumber;
    }
    
    @Override
    public boolean equals(Object o) {
 
        /* Object compared with itself is true */  
        if (o == this) {
            return true;
        }
 
        /* Must be instance of Frame */
        if (!(o instanceof Frame)) {
            return false;
        }
         
        /* Cast for comparison */
        Frame that = (Frame) o;
         
        /* Compare fields */
        return this.processID.equals(that.processID) && this.pageNumber.equals(that.pageNumber);
    }
}
