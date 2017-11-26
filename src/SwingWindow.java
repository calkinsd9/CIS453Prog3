import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Button;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SwingWindow {

    private JFrame frmVmPageReplacement;
    private JButton[] frameProcessIds = new JButton[16];
    private JButton[] framePages = new JButton[16];
    private JLabel[] pageTablePages = new JLabel[16];
    private JLabel[] pageTableFrames = new JLabel[16];
    private MemoryManager memoryManager;
    private JLabel lblCurrentProcessValue, lblPageAccessedValue, lblTotalPageFaultsValue, 
        lblLastVictimValue, lblTotalReferencesValue, lblTotalFaultsValue, lblPageTableProcessId;
    private JFileChooser fChooser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwingWindow window = new SwingWindow();
                    window.frmVmPageReplacement.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SwingWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        try {
            memoryManager = new MemoryManager("Resources/input3a.data");  //TODO: change this eventually to be a menu option            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        frmVmPageReplacement = new JFrame();
        frmVmPageReplacement.setTitle("VM: Page Replacement System");
        frmVmPageReplacement.setBounds(100, 100, 791, 720);
        frmVmPageReplacement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmVmPageReplacement.getContentPane().setLayout(null);
        
        JLabel lblPhysicalMemory = new JLabel("Physical Memory");
        lblPhysicalMemory.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPhysicalMemory.setBounds(50, 16, 151, 20);
        frmVmPageReplacement.getContentPane().add(lblPhysicalMemory);
        
        JPanel panelPhysicalMemory = new JPanel();
        panelPhysicalMemory.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        panelPhysicalMemory.setBounds(25, 52, 182, 547);
        frmVmPageReplacement.getContentPane().add(panelPhysicalMemory);
        panelPhysicalMemory.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][][][][][][][]"));
        
        JLabel lblFrame_0 = new JLabel("Frame 0:");
        panelPhysicalMemory.add(lblFrame_0, "cell 0 0");
        
        JButton btnProcessIDFrame_0 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_0, "cell 1 0");
        
        JButton btnPageFrame_0 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_0, "cell 2 0");
        
        JLabel lblFrame_1 = new JLabel("Frame 1:");
        panelPhysicalMemory.add(lblFrame_1, "cell 0 1");
        
        JButton btnProcessIDFrame_1 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_1, "cell 1 1");
        
        JButton btnPageFrame_1 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_1, "cell 2 1");
        
        JLabel lblFrame_2 = new JLabel("Frame 2:");
        panelPhysicalMemory.add(lblFrame_2, "cell 0 2");
        
        JButton btnProcessIDFrame_2 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_2, "cell 1 2");
        
        JButton btnPageFrame_2 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_2, "cell 2 2");
        
        JLabel lblFrame_3 = new JLabel("Frame 3:");
        panelPhysicalMemory.add(lblFrame_3, "cell 0 3");
        
        JButton btnProcessIDFrame_3 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_3, "cell 1 3");
        
        JButton btnPageFrame_3 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_3, "cell 2 3");
        
        JLabel lblFrame_4 = new JLabel("Frame 4:");
        panelPhysicalMemory.add(lblFrame_4, "cell 0 4");
        
        JButton btnProcessIDFrame_4 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_4, "cell 1 4");
        
        JButton btnPageFrame_4 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_4, "cell 2 4");
        
        JLabel lblFrame_5 = new JLabel("Frame 5:");
        panelPhysicalMemory.add(lblFrame_5, "cell 0 5");
        
        JButton btnProcessIDFrame_5 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_5, "cell 1 5");
        
        JButton btnPageFrame_5 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_5, "cell 2 5");
        
        JLabel lblFrame_6 = new JLabel("Frame 6:");
        panelPhysicalMemory.add(lblFrame_6, "cell 0 6");
        
        JButton btnProcessIDFrame_6 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_6, "cell 1 6");
        
        JButton btnPageFrame_6 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_6, "cell 2 6");
        
        JLabel lblFrame_7 = new JLabel("Frame 7:");
        panelPhysicalMemory.add(lblFrame_7, "cell 0 7");
        
        JButton btnProcessIDFrame_7 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_7, "cell 1 7");
        
        JButton btnPageFrame_7 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_7, "cell 2 7");
        
        JLabel lblFrame_8 = new JLabel("Frame 8:");
        panelPhysicalMemory.add(lblFrame_8, "cell 0 8");
        
        JButton btnProcessIDFrame_8 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_8, "cell 1 8");
        
        JButton btnPageFrame_8 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_8, "cell 2 8");
        
        JLabel lblFrame_9 = new JLabel("Frame 9:");
        panelPhysicalMemory.add(lblFrame_9, "cell 0 9");
        
        JButton btnProcessIDFrame_9 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_9, "cell 1 9");
        
        JButton btnPageFrame_9 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_9, "cell 2 9");
        
        JLabel lblFrame_10 = new JLabel("Frame 10:");
        panelPhysicalMemory.add(lblFrame_10, "cell 0 10");
        
        JButton btnProcessIDFrame_10 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_10, "cell 1 10");
        
        JButton btnPageFrame_10 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_10, "cell 2 10");
        
        JLabel lblFrame_11 = new JLabel("Frame 11:");
        panelPhysicalMemory.add(lblFrame_11, "cell 0 11");
        
        JButton btnProcessIDFrame_11 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_11, "cell 1 11");
        
        JButton btnPageFrame_11 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_11, "cell 2 11");
        
        JLabel lblFrame_12 = new JLabel("Frame 12:");
        panelPhysicalMemory.add(lblFrame_12, "cell 0 12");
        
        JButton btnProcessIDFrame_12 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_12, "cell 1 12");
        
        JButton btnPageFrame_12 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_12, "cell 2 12");
        
        JLabel lblFrame_13 = new JLabel("Frame 13:");
        panelPhysicalMemory.add(lblFrame_13, "cell 0 13");
        
        JButton btnProcessIDFrame_13 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_13, "cell 1 13");
        
        JButton btnPageFrame_13 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_13, "cell 2 13");
        
        JLabel lblFrame_14 = new JLabel("Frame 14:");
        panelPhysicalMemory.add(lblFrame_14, "cell 0 14");
        
        JButton btnProcessIDFrame_14 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_14, "cell 1 14");
        
        JButton btnPageFrame_14 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_14, "cell 2 14");
        
        JLabel lblFrame_15 = new JLabel("Frame 15:");
        panelPhysicalMemory.add(lblFrame_15, "cell 0 15");
        
        JButton btnProcessIDFrame_15 = new JButton("  ");
        panelPhysicalMemory.add(btnProcessIDFrame_15, "cell 1 15");
        
        JButton btnPageFrame_15 = new JButton(" ");
        panelPhysicalMemory.add(btnPageFrame_15, "cell 2 15");
        
        //add buttons to arrays for indexing purposes
        frameProcessIds[0] = btnProcessIDFrame_0;
        frameProcessIds[1] = btnProcessIDFrame_1;
        frameProcessIds[2] = btnProcessIDFrame_2;
        frameProcessIds[3] = btnProcessIDFrame_3;
        frameProcessIds[4] = btnProcessIDFrame_4;
        frameProcessIds[5] = btnProcessIDFrame_5;
        frameProcessIds[6] = btnProcessIDFrame_6;
        frameProcessIds[7] = btnProcessIDFrame_7;
        frameProcessIds[8] = btnProcessIDFrame_8;
        frameProcessIds[9] = btnProcessIDFrame_9;
        frameProcessIds[10] = btnProcessIDFrame_10;
        frameProcessIds[11] = btnProcessIDFrame_11;
        frameProcessIds[12] = btnProcessIDFrame_12;
        frameProcessIds[13] = btnProcessIDFrame_13;
        frameProcessIds[14] = btnProcessIDFrame_14;
        frameProcessIds[15] = btnProcessIDFrame_15;
        
        framePages[0] = btnPageFrame_0;
        framePages[1] = btnPageFrame_1;
        framePages[2] = btnPageFrame_2;
        framePages[3] = btnPageFrame_3;
        framePages[4] = btnPageFrame_4;
        framePages[5] = btnPageFrame_5;
        framePages[6] = btnPageFrame_6;
        framePages[7] = btnPageFrame_7;
        framePages[8] = btnPageFrame_8;
        framePages[9] = btnPageFrame_9;
        framePages[10] = btnPageFrame_10;
        framePages[11] = btnPageFrame_11;
        framePages[12] = btnPageFrame_12;
        framePages[13] = btnPageFrame_13;
        framePages[14] = btnPageFrame_14;
        framePages[15] = btnPageFrame_15;
        
        //create listeners for all Physical Memory processID buttons
        for (int i = 0 ; i < frameProcessIds.length; i++)
        {
            frameProcessIds[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //get the process name from the button
                    JButton pressed = (JButton) e.getSource();
                    String processId = pressed.getText();
                    
                    //get the button's position in the array
                    int index;
                    for (index = 0; index < frameProcessIds.length; index++)
                    {
                        if (frameProcessIds[index].getText().equals(processId))
                            break;
                    }
                    
                    //use the button's position to get the corresponding page number in its array
                    String pageNumber = framePages[index].getText();
                    
                    //call updatePageTable()
                    updatePageTable(processId, pageNumber);
                }
            });
        }
                
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(280, 336, 480, 140);
        frmVmPageReplacement.getContentPane().add(panel_1);
        panel_1.setLayout(new MigLayout("", "[][][][][][][][][][][]", "[][][][][][][]"));
        
        JLabel lblPage = new JLabel("page /");
        panel_1.add(lblPage, "cell 0 0");
        
        JLabel lblFrame_17 = new JLabel("frame");
        panel_1.add(lblFrame_17, "cell 1 0");
        
        JLabel lblPage_1 = new JLabel("page /");
        panel_1.add(lblPage_1, "cell 3 0");
        
        JLabel lblFrame_18 = new JLabel("frame");
        panel_1.add(lblFrame_18, "cell 4 0");
        
        JLabel lblPage_2 = new JLabel("page /");
        panel_1.add(lblPage_2, "cell 6 0");
        
        JLabel lblFrame_19 = new JLabel("frame");
        panel_1.add(lblFrame_19, "cell 7 0");
        
        JLabel lblPage_3 = new JLabel("page /");
        panel_1.add(lblPage_3, "cell 9 0");
        
        JLabel lblFrame_20 = new JLabel("frame");
        panel_1.add(lblFrame_20, "cell 10 0");
        
        JLabel lblPage0 = new JLabel("0");
        panel_1.add(lblPage0, "cell 0 1,alignx center");
        
        JLabel lblFrame0 = new JLabel("n/a");
        panel_1.add(lblFrame0, "cell 1 1,alignx center");
        
        JLabel lblPage4 = new JLabel("4");
        panel_1.add(lblPage4, "cell 3 1,alignx center");
        
        JLabel lblFrame4 = new JLabel("n/a");
        panel_1.add(lblFrame4, "cell 4 1,alignx center");
        
        JLabel lblPage8 = new JLabel("8");
        panel_1.add(lblPage8, "cell 6 1,alignx center");
        
        JLabel lblFrame8 = new JLabel("n/a");
        panel_1.add(lblFrame8, "cell 7 1,alignx center");
        
        JLabel lblPage12 = new JLabel("12");
        panel_1.add(lblPage12, "cell 9 1,alignx center");
        
        JLabel lblFrame12 = new JLabel("n/a");
        panel_1.add(lblFrame12, "cell 10 1,alignx center");
        
        JLabel lblPage1 = new JLabel("1");
        panel_1.add(lblPage1, "cell 0 2,alignx center");
        
        JLabel lblFrame1 = new JLabel("n/a");
        panel_1.add(lblFrame1, "cell 1 2,alignx center");
        
        JLabel lblPage5 = new JLabel("5");
        panel_1.add(lblPage5, "cell 3 2,alignx center");
        
        JLabel lblFrame5 = new JLabel("n/a");
        panel_1.add(lblFrame5, "cell 4 2,alignx center");
        
        JLabel lblPage9 = new JLabel("9");
        panel_1.add(lblPage9, "cell 6 2,alignx center");
        
        JLabel lblFrame9 = new JLabel("n/a");
        panel_1.add(lblFrame9, "cell 7 2,alignx center");
        
        JLabel lblPage13 = new JLabel("13");
        panel_1.add(lblPage13, "cell 9 2,alignx center");
        
        JLabel lblFrame13 = new JLabel("n/a");
        panel_1.add(lblFrame13, "cell 10 2,alignx center");
        
        JLabel lblPage2 = new JLabel("2");
        panel_1.add(lblPage2, "cell 0 3,alignx center");
        
        JLabel lblFrame2 = new JLabel("n/a");
        panel_1.add(lblFrame2, "cell 1 3,alignx center");
        
        JLabel lblPage6 = new JLabel("6");
        panel_1.add(lblPage6, "cell 3 3,alignx center");
        
        JLabel lblFrame6 = new JLabel("n/a");
        panel_1.add(lblFrame6, "cell 4 3,alignx center");
        
        JLabel lblPage10 = new JLabel("10");
        panel_1.add(lblPage10, "cell 6 3,alignx center");
        
        JLabel lblFrame10 = new JLabel("n/a");
        panel_1.add(lblFrame10, "cell 7 3,alignx center");
        
        JLabel lblPage14 = new JLabel("14");
        panel_1.add(lblPage14, "cell 9 3,alignx center");
        
        JLabel lblFrame14 = new JLabel("n/a");
        panel_1.add(lblFrame14, "cell 10 3,alignx center");
        
        JLabel lblPage3 = new JLabel("3");
        panel_1.add(lblPage3, "cell 0 4,alignx center");
        
        JLabel lblFrame3 = new JLabel("n/a");
        panel_1.add(lblFrame3, "cell 1 4,alignx center");
        
        JLabel lblPage7 = new JLabel("7");
        panel_1.add(lblPage7, "cell 3 4,alignx center");
        
        JLabel lblFrame7 = new JLabel("n/a");
        panel_1.add(lblFrame7, "cell 4 4,alignx center");
        
        JLabel lblPage11 = new JLabel("11");
        panel_1.add(lblPage11, "cell 6 4,alignx center");
        
        JLabel lblFrame11 = new JLabel("n/a");
        panel_1.add(lblFrame11, "cell 7 4,alignx center");
        
        JLabel lblPage15 = new JLabel("15");
        panel_1.add(lblPage15, "cell 9 4,alignx center");
        
        JLabel lblFrame15 = new JLabel("n/a");
        panel_1.add(lblFrame15, "cell 10 4,alignx center");
        
        //add to array for indexing purposes
        pageTablePages[0] = lblPage0;
        pageTablePages[1] = lblPage1;
        pageTablePages[2] = lblPage2;
        pageTablePages[3] = lblPage3;
        pageTablePages[4] = lblPage4;
        pageTablePages[5] = lblPage5;
        pageTablePages[6] = lblPage6;
        pageTablePages[7] = lblPage7;
        pageTablePages[8] = lblPage8;
        pageTablePages[9] = lblPage9;
        pageTablePages[10] = lblPage10;
        pageTablePages[11] = lblPage11;
        pageTablePages[12] = lblPage12;
        pageTablePages[13] = lblPage13;
        pageTablePages[14] = lblPage14;
        pageTablePages[15] = lblPage15;
        
        pageTableFrames[0] = lblFrame0;
        pageTableFrames[1] = lblFrame1;
        pageTableFrames[2] = lblFrame2;
        pageTableFrames[3] = lblFrame3;
        pageTableFrames[4] = lblFrame4;
        pageTableFrames[5] = lblFrame5;
        pageTableFrames[6] = lblFrame6;
        pageTableFrames[7] = lblFrame7;
        pageTableFrames[8] = lblFrame8;
        pageTableFrames[9] = lblFrame9;
        pageTableFrames[10] = lblFrame10;
        pageTableFrames[11] = lblFrame11;
        pageTableFrames[12] = lblFrame12;
        pageTableFrames[13] = lblFrame13;
        pageTableFrames[14] = lblFrame14;
        pageTableFrames[15] = lblFrame15;
        
        JLabel lblPageTable = new JLabel("Page Table for");
        lblPageTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPageTable.setBounds(280, 280, 120, 40);
        frmVmPageReplacement.getContentPane().add(lblPageTable);
        
        lblPageTableProcessId = new JLabel("P1");
        lblPageTableProcessId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPageTableProcessId.setBounds(400, 280, 40, 40);
        frmVmPageReplacement.getContentPane().add(lblPageTableProcessId);
        
        JLabel lblTotalFaults = new JLabel("Total Faults: ");
        lblTotalFaults.setBounds(490, 277, 99, 20);
        frmVmPageReplacement.getContentPane().add(lblTotalFaults);
        
        JLabel lblTotalReferences = new JLabel("Total References:");
        lblTotalReferences.setBounds(455, 300, 134, 20);
        frmVmPageReplacement.getContentPane().add(lblTotalReferences);
        
        lblTotalFaultsValue = new JLabel("0");
        lblTotalFaultsValue.setBounds(591, 277, 40, 20);
        frmVmPageReplacement.getContentPane().add(lblTotalFaultsValue);
        
        lblTotalReferencesValue = new JLabel("0");
        lblTotalReferencesValue.setBounds(591, 300, 40, 20);
        frmVmPageReplacement.getContentPane().add(lblTotalReferencesValue);
        
        JPanel panelStatistics = new JPanel();
        panelStatistics.setBounds(299, 123, 383, 100);
        frmVmPageReplacement.getContentPane().add(panelStatistics);
        panelStatistics.setLayout(new MigLayout("", "[][][][][][]", "[][][]"));
        
        JLabel lblCurrentProcess = new JLabel("Current Process:");
        panelStatistics.add(lblCurrentProcess, "cell 0 1");
        
        lblCurrentProcessValue = new JLabel("n/a");
        panelStatistics.add(lblCurrentProcessValue, "cell 1 1");
        
        JLabel lblTotalPageFaults = new JLabel("Total Page Faults:");
        panelStatistics.add(lblTotalPageFaults, "cell 4 1");
        
        lblTotalPageFaultsValue = new JLabel("000");
        panelStatistics.add(lblTotalPageFaultsValue, "cell 5 1");
        
        JLabel lblPageAccessed = new JLabel(" Page Accessed:");
        panelStatistics.add(lblPageAccessed, "cell 0 2");
        
        lblPageAccessedValue = new JLabel("n/a");
        panelStatistics.add(lblPageAccessedValue, "cell 1 2");
        
        JLabel lblLastVictim = new JLabel("        Last Victim:");
        panelStatistics.add(lblLastVictim, "cell 4 2");
        
        lblLastVictimValue = new JLabel("n/a");
        panelStatistics.add(lblLastVictimValue, "cell 5 2");
        
        JLabel lblStatistics = new JLabel("Statistics");
        lblStatistics.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblStatistics.setBounds(391, 87, 86, 20);
        frmVmPageReplacement.getContentPane().add(lblStatistics);
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                memoryManager.reset();
                for (int i = 0; i < frameProcessIds.length; i++)
                {
                    frameProcessIds[i].setText("n/a");
                    framePages[i].setText("n/a");
                    pageTableFrames[i].setText("n/a");
                    pageTablePages[i].setText("n/a");
                }
                
                lblPageTableProcessId.setText("");
                lblCurrentProcessValue.setText("n/a");
                lblPageAccessedValue.setText("n/a");
                lblTotalPageFaultsValue.setText("0");
                lblLastVictimValue.setText("n/a");
                lblTotalFaultsValue.setText("0");
                lblTotalReferencesValue.setText("0");
            }
        });
        btnReset.setBounds(311, 492, 115, 29);
        frmVmPageReplacement.getContentPane().add(btnReset);
        
        JButton btnRunToFault = new JButton("Run to Fault");
        btnRunToFault.setBounds(300, 538, 134, 29);
        frmVmPageReplacement.getContentPane().add(btnRunToFault);
        btnRunToFault.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    do {
                        memoryManager.nextReference();
                    } while (!memoryManager.faultHappened);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                updateDisplay();                
            }
        });
        
        JButton btnRunAll = new JButton("Run All");
        btnRunAll.setBounds(449, 538, 115, 29);
        frmVmPageReplacement.getContentPane().add(btnRunAll);
        btnRunAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    while(memoryManager.nextReference());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                updateDisplay();                
            }
        });
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    memoryManager.nextReference();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                updateDisplay();
            }
        });
        btnNext.setBounds(449, 492, 115, 29);
        frmVmPageReplacement.getContentPane().add(btnNext);
        
        JMenuBar menuBar = new JMenuBar();
        frmVmPageReplacement.setJMenuBar(menuBar);
        
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        JMenuItem mntmOpen = new JMenuItem("Open");
        mnFile.add(mntmOpen);
        
        JMenuItem mntmQuit = new JMenuItem("Quit");
        mnFile.add(mntmQuit);
        
        JMenu mnOptions = new JMenu("Options");
        menuBar.add(mnOptions);
    }

    protected void updateDisplay() {
        //update physical memory table
        Frame[] physicalMemory = memoryManager.physicalMemory;

        for (int i = 0; i < frameProcessIds.length; i++)
        {
            if (physicalMemory[i] != null)
            {
                frameProcessIds[i].setText(physicalMemory[i].processID);
                framePages[i].setText(physicalMemory[i].pageNumber);
            }
            else 
            {
                frameProcessIds[i].setText("n/a");
                framePages[i].setText("n/a");
            }
        }
        
        //update statistics
        lblCurrentProcessValue.setText(memoryManager.currentProcessId);
        lblPageAccessedValue.setText(memoryManager.currentPage);
        lblTotalPageFaultsValue.setText(Integer.toString(memoryManager.totalPageFaults));
        lblLastVictimValue.setText(memoryManager.lastVictim);
        
        //update page table
        lblPageTableProcessId.setText(memoryManager.currentProcessId);
        
        updatePageTable(memoryManager.currentProcessId, memoryManager.currentPage);
//        Map<String,String> processPageTable = memoryManager.getPageTable(memoryManager.currentProcessId, Integer.parseInt(memoryManager.currentPage));
//        //processPageTable now has a HashMap of (String) pages -> (String) frames
//        //  but I don't know where they start, since it's a snippet
//        //    so run through all values from 0-63
//        //      if it doesn't return null, then that's the value to start on
//        
//        int j = 0;
//        //the while loop advances the page reference to the first that was written in the snippet
//        while(processPageTable.get(Integer.toString(j)) == null)
//        {
//            j++;
//        }
//        for (int i = 0; i < pageTableFrames.length; i++)
//        {
//            //check to make sure that there is a page to write
//            if (processPageTable.get(Integer.toString(j)) == null)
//            {
//                pageTablePages[i].setText("n/a");
//                pageTableFrames[i].setText("n/a");                
//            }
//            else
//            {
//                pageTablePages[i].setText(Integer.toString(j));
//                pageTableFrames[i].setText(processPageTable.get(Integer.toString(j)));
//            }
//
//            j++;
//        }
        
        //update process statistics
        lblTotalFaultsValue.setText(Integer.toString(memoryManager.getTotalFaultsForProcess(memoryManager.currentProcessId)));
        lblTotalReferencesValue.setText(Integer.toString(memoryManager.getTotalReferencesForProcess(memoryManager.currentProcessId)));
        
    }
    
    private void updatePageTable(String processId, String page)
    {
        lblPageTableProcessId.setText(processId);
        Map<String,String> processPageTable = memoryManager.getPageTable(processId, Integer.parseInt(page));
        //processPageTable now has a HashMap of (String) pages -> (String) frames
        //  but I don't know where they start, since it's a snippet
        //    so run through all values from 0-63
        //      if it doesn't return null, then that's the value to start on
        
        int j = 0;
        //the while loop advances the page reference to the first that was written in the snippet
        while(processPageTable.get(Integer.toString(j)) == null)
        {
            j++;
        }
        for (int i = 0; i < pageTableFrames.length; i++)
        {
            //check to make sure that there is a page to write
            if (processPageTable.get(Integer.toString(j)) == null)
            {
                pageTablePages[i].setText("n/a");
                pageTableFrames[i].setText("n/a");                
            }
            else
            {
                pageTablePages[i].setText(Integer.toString(j));
                pageTableFrames[i].setText(processPageTable.get(Integer.toString(j)));
            }

            j++;
        }
    }
}
