import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class GUI extends JFrame implements ActionListener{

    JFrame myGUI; 
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    int PHYSICAL_MEMORY_SIZE = 16;  //should eventually be 16
    JButton[] processButtons;
    JButton[] pageButtons;
    JLabel[] labels;
    JLabel currentProcess, pageAccessed, totalFaults, latestVictim, crntProcTotalFaults, crntProcTotalRef;
    JButton previous, next, runFault, runAll;
    
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("VM: Page Replacement System");
        gui.pack();
        gui.setVisible(true);
    }
    
    public GUI(){ 
        // create the ____ object as well as the GUI Frame
        myGUI = new JFrame();
        myGUI.setSize(800,800);

        //initialize labels
        labels = new JLabel[PHYSICAL_MEMORY_SIZE];
        for (int i = 0; i < PHYSICAL_MEMORY_SIZE; i++)
        {
            labels[i] = new JLabel("frame" + i, JLabel.TRAILING);
        }
        
        //initialize process buttons
        processButtons = new JButton[PHYSICAL_MEMORY_SIZE];
        for (int i = 0; i < PHYSICAL_MEMORY_SIZE; i++)
        {
            processButtons[i] = new JButton();
        }
        
        //initialize page buttons
        pageButtons = new JButton[PHYSICAL_MEMORY_SIZE];
        for (int i = 0; i < PHYSICAL_MEMORY_SIZE; i++)
        {
            pageButtons[i] = new JButton();
        }

        //Create and populate the panel.
        JPanel memoryPanel = new JPanel(new SpringLayout());
        for (int i = 0; i < PHYSICAL_MEMORY_SIZE; i++) {
            memoryPanel.add(labels[i]);
            labels[i].setLabelFor(processButtons[i]);
            memoryPanel.add(processButtons[i]);
            memoryPanel.add(pageButtons[i]);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(memoryPanel,
                PHYSICAL_MEMORY_SIZE, 3, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        
        //button panel
        JPanel buttonPanel = new JPanel(new SpringLayout());
        previous = new JButton("<-- Previous");
        next = new JButton("Next -->");
        runFault = new JButton("Run to Fault");
        runAll = new JButton("Run All");
        
        buttonPanel.add(previous);
        buttonPanel.add(next);
        buttonPanel.add(runFault);
        buttonPanel.add(runAll);
        
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(buttonPanel,
                2, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        
        //Stats pannel
        JPanel statsPanel = new JPanel(new SpringLayout());
        currentProcess = new JLabel();
        pageAccessed = new JLabel();
        totalFaults = new JLabel();
        latestVictim = new JLabel();
        JLabel currentProcLabel = new JLabel("Current process:");
        currentProcLabel.setLabelFor(currentProcess);
        JLabel pageAccLabel = new JLabel("Page Accessed:");
        pageAccLabel.setLabelFor(pageAccessed);
        JLabel totalFaultsLabel = new JLabel("Total Faults:");
        totalFaultsLabel.setLabelFor(totalFaults);
        JLabel latestVictimLabel = new JLabel("Latest Victim:");
        latestVictimLabel.setLabelFor(latestVictim);
        statsPanel.add(currentProcLabel);
        statsPanel.add(currentProcess);
        statsPanel.add(totalFaultsLabel);
        statsPanel.add(totalFaults);
        statsPanel.add(pageAccLabel);
        statsPanel.add(pageAccessed);
        statsPanel.add(latestVictimLabel);
        statsPanel.add(latestVictim);
        
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(statsPanel,
                2, 4, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
                
        
        
        //Current Process pannel
        JPanel currentProcessContainer = new JPanel();
        JPanel currentProcessStatistics = new JPanel(new SpringLayout());
        JPanel currentProcessPageTable = new JPanel();
        
        crntProcTotalFaults = new JLabel();
        crntProcTotalRef = new JLabel();
        JLabel crntProcTotFaultLabel = new JLabel("Total page faults:");
        crntProcTotFaultLabel.setLabelFor(crntProcTotalFaults);
        JLabel crntProcTotRefLabel = new JLabel("Total references:");
        crntProcTotRefLabel.setLabelFor(crntProcTotalRef);
        
        currentProcessStatistics.add(crntProcTotFaultLabel);
        currentProcessStatistics.add(crntProcTotalFaults);
        currentProcessStatistics.add(crntProcTotRefLabel);
        currentProcessStatistics.add(crntProcTotalRef);
        
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(currentProcessStatistics,
                2, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        currentProcessPageTable.add(new JLabel("PLACEHOLDER..."));
        
        currentProcessContainer.add(currentProcessStatistics, BorderLayout.NORTH);
        currentProcessContainer.add(currentProcessPageTable, BorderLayout.CENTER);
        
        JPanel statsAndProc = new JPanel();
        statsAndProc.add(statsPanel, BorderLayout.NORTH);
        statsAndProc.add(currentProcessContainer, BorderLayout.CENTER);

        
        myGUI.add(memoryPanel, BorderLayout.WEST);
//        myGUI.add(statsPanel, BorderLayout.EAST);
//        myGUI.add(currentProcessContainer, BorderLayout.SOUTH);
        myGUI.add(statsAndProc, BorderLayout.EAST);
        myGUI.add(buttonPanel, BorderLayout.SOUTH);
        
        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        myGUI.setJMenuBar(menus);
        menus.add(fileMenu);    
        myGUI.setVisible(true);
    }

    /****************************************************************
    Respond to the user action

    @param e - the JComponent just selected
     ****************************************************************/
    public void actionPerformed(ActionEvent e){

        // what did the user just select?
        JComponent buttonPressed = (JComponent) e.getSource();

        // quit the game
        if (buttonPressed == quitItem){
            System.exit(1);
        }

    }

}
