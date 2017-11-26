import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

public class MemoryManager {
    private int PHYSICAL_MEMORY_SIZE = 16;  //should eventually be 16

    private BufferedReader pageReferenceReader;
    public Frame[] physicalMemory;
    public Map<String, Process> processes;
    public LinkedList<Frame> referenceQueue;
    public String currentProcessId;
    public String currentPage;
    public int totalPageFaults;
    public String lastVictim;
    public boolean faultHappened;
    public String pageReferenceFile;
    
    
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
        this.pageReferenceFile = pageReferenceFile;
        this.pageReferenceReader = new BufferedReader(
                new FileReader(pageReferenceFile));
    }
    
    public Map<String, String> getPageTable(String processId, int page)
    {
        Process process = processes.get(processId);
        
        if (process == null)
            //process has not yet been recognized
            return null;
        
        if (process.pageTable.get(Integer.toString(page)) == null)
            //page has not yet been referenced
            return null;
        
        int totalPagesReferenced = process.pageTable.size();

        //the desired page should appear near the middle of the page table snippet (7 procs below it, 8 above it)
        //if that middle location is too close to the last referenced page (less than 8 away)
        //  re-adjust it to 8 spaces away
        int startingPosition = page;
        if (startingPosition > totalPagesReferenced - 8)
            startingPosition = totalPagesReferenced - 8;
        
        //now, if the position is less than 7 spaces away from the absolute beginning, re-adjust it to exactly 7
        if (startingPosition < 7)
            startingPosition = 7;
        
        //now subtract 7 to get the actual starting position of the page table
        startingPosition -= 7;
        
        Map<String, String> pageTable = new HashMap<String,String>();
        
        //load a return pagetable snippet with mapped pages -> frames starting at determined position
        for (int position = startingPosition; position < startingPosition + totalPagesReferenced; position++)
        {
            pageTable.put(Integer.toString(position), process.pageTable.get(Integer.toString(position)));
        }
        
        return pageTable;
    }
    
    public int getTotalFaultsForProcess(String processId)
    {
        return processes.get(processId).totalFaults;
    }
    
    public int getTotalReferencesForProcess(String processId)
    {
        return processes.get(processId).totalReferences;
    }
        
    public Boolean nextReference() throws IOException
    {
        String line = pageReferenceReader.readLine();
        if (line == null)
            return false;
        
        /* get the process and the page it wants */
        String processID = line.split(":")[0];
        String page = Integer.toString(Integer.parseInt(line.split("\t")[1], 2));
        
        currentProcessId = processID;
        currentPage = page;
        
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
            if (frame.processID.equals(processID) && frame.pageNumber.equals(page))
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
            faultHappened = false;
        }
        else  //page is not in memory; page fault
        {
            processes.get(processID).totalFaults++;
            totalPageFaults++;
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
                lastVictim = victim.processID;
                
                
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
            
            faultHappened = true;
        }
        return true;
    }
    
    public void reset()
    {
        this.processes = new HashMap<String, Process>();
        this.physicalMemory = new Frame[PHYSICAL_MEMORY_SIZE];
        this.referenceQueue = new LinkedList<Frame>();
        this.currentProcessId = "n/a";
        this.currentPage = "n/a";
        this.totalPageFaults = 0;
        this.lastVictim = "n/a";
        this.faultHappened = false;
        try {
            this.pageReferenceReader = new BufferedReader(
                    new FileReader(pageReferenceFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
