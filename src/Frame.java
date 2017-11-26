/*****
 * Used within the memory manager as an object that keeps track of 
 *   a process ID and a page number.
 * This is essentially a dictionary, but having it as an object 
 *   allows for easier comparisons of frame objects by fields
 *   
 * @author calki_000
 *
 */
public class Frame {

    public String processID;
    public String pageNumber;

    /*****
     * Default constructor
     */
    public Frame()
    {
        super();
    }
    
    /*****
     * Constructor with field initialization
     * 
     * @param processID
     * @param pageNumber
     */
    public Frame(String processID, String pageNumber)
    {
        super();
        this.processID = processID;
        this.pageNumber = pageNumber;
    }
    
    /*****
     * Ensures proper comparison of Frame objects for .equals() purposes
     */
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
