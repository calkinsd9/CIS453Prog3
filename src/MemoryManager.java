import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MemoryManager {
    private int PHYSICAL_MEMORY_SIZE = 3;

    private BufferedReader pageReferenceReader;
    public Frame[] physicalMemory;
    public Map<String, Process> processes;
    public LinkedList<Frame> referenceQueue;
    
    public static void main(String[] args) {
        try {
            MemoryManager mm = new MemoryManager("Resources/input3a.data");
            while(mm.nextReference());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public MemoryManager(String pageReferenceFile) throws FileNotFoundException
    {
        super();
        this.processes = new HashMap<String, Process>();
        this.physicalMemory = new Frame[PHYSICAL_MEMORY_SIZE];
        this.referenceQueue = new LinkedList<Frame>();
        this.pageReferenceReader = new BufferedReader(
                new FileReader(pageReferenceFile));
    }
    
    
    public Boolean nextReference() throws IOException
    {
        String line = pageReferenceReader.readLine();
        if (line == null)
            return false;
        
        /* get the process and the page it wants */
        String processID = line.split(":")[0];
        //debug
        String[] teString = line.split("\t");
        String page = Integer.toString(Integer.parseInt(line.split("\t")[1], 2));
        
        /* see if we've ever encountered that process. if not, create it */
        if (!processes.containsKey(processID))
        {
            Process newProc = new Process(processID);
            processes.put(processID, newProc);
        }
        
        /* tell the process which page has been referenced */
        processes.get(processID).pageReference(page);
        
        /* see if the process and page is in memory */
        Boolean pageInMemory = false;
        Frame victim = new Frame();
        for (Frame frame : physicalMemory)
        {
            if (frame == null)
                continue;
            if (frame.processID == processID && frame.pageNumber == page)
            {
                pageInMemory = true;
                victim = frame;
                break;
            }
        }

        if (pageInMemory)
        {
            //pull the last reference from wherever it is in the queue and put it at the end
            referenceQueue.remove(victim);
            referenceQueue.add(new Frame(processID, page));
        }
        else  //page is not in memory; page fault
        {
            //if there is an empty spot in memory, use it
            int frameIndex;
            for (frameIndex = 0; frameIndex < physicalMemory.length; frameIndex++)
            {
                if (physicalMemory[frameIndex] == null)
                    break;
            }
            
            //if the frameIndex is larger than the array, then it's full;
            // need to choose victim
            if (frameIndex == physicalMemory.length)
            {
                //victim should be the first element of the list (which is the last one referenced)
                victim = referenceQueue.pollFirst();
                
                //get the index of the victim in physical memory
                for (frameIndex = 0; frameIndex < physicalMemory.length; frameIndex++)
                {
                    if (physicalMemory[frameIndex].equals(victim))
                        break;
                }
                
                //tell the process that its page will be pulled (to change its page table)
                processes.get(victim.processID).movedPageOutOfMemory(victim.pageNumber);
            }
            
            //move in the new page to physical memory
            Frame newFrame = new Frame(processID, page);
            physicalMemory[frameIndex] = newFrame;
            
            //update reference queue
            referenceQueue.add(newFrame);
            
            //notify process the page has been moved in (to change its page table)
            processes.get(processID).movedPageIntoMemory(page, Integer.toString(frameIndex));
            
        }
        return true;
    }


}
