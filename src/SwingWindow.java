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
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Button;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class SwingWindow {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwingWindow window = new SwingWindow();
                    window.frame.setVisible(true);
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
        frame = new JFrame();
        frame.setBounds(100, 100, 864, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblFrame = new JLabel("Physical Memory");
        lblFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFrame.setBounds(50, 16, 151, 20);
        frame.getContentPane().add(lblFrame);
        
        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        panel.setBounds(25, 52, 182, 547);
        frame.getContentPane().add(panel);
        panel.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][][][][][][][]"));
        
        JLabel lblFrame_1 = new JLabel("Frame 0:");
        panel.add(lblFrame_1, "cell 0 0");
        
        JButton btnP = new JButton("  ");
        panel.add(btnP, "cell 1 0");
        
        JButton button = new JButton(" ");
        panel.add(button, "cell 2 0");
        
        JLabel lblFrame_2 = new JLabel("Frame 1:");
        panel.add(lblFrame_2, "cell 0 1");
        
        JButton button_1 = new JButton("  ");
        panel.add(button_1, "cell 1 1");
        
        JButton button_2 = new JButton(" ");
        panel.add(button_2, "cell 2 1");
        
        JLabel lblFrame_3 = new JLabel("Frame 2:");
        panel.add(lblFrame_3, "cell 0 2");
        
        JButton button_3 = new JButton("  ");
        panel.add(button_3, "cell 1 2");
        
        JButton button_4 = new JButton(" ");
        panel.add(button_4, "cell 2 2");
        
        JLabel lblFrame_4 = new JLabel("Frame 3:");
        panel.add(lblFrame_4, "cell 0 3");
        
        JButton button_5 = new JButton("  ");
        panel.add(button_5, "cell 1 3");
        
        JButton button_6 = new JButton(" ");
        panel.add(button_6, "cell 2 3");
        
        JLabel lblFrame_5 = new JLabel("Frame 4:");
        panel.add(lblFrame_5, "cell 0 4");
        
        JButton button_7 = new JButton("  ");
        panel.add(button_7, "cell 1 4");
        
        JButton button_8 = new JButton(" ");
        panel.add(button_8, "cell 2 4");
        
        JLabel lblFrame_6 = new JLabel("Frame 5:");
        panel.add(lblFrame_6, "cell 0 5");
        
        JButton button_9 = new JButton("  ");
        panel.add(button_9, "cell 1 5");
        
        JButton button_10 = new JButton(" ");
        panel.add(button_10, "cell 2 5");
        
        JLabel lblFrame_7 = new JLabel("Frame 6:");
        panel.add(lblFrame_7, "cell 0 6");
        
        JButton button_11 = new JButton("  ");
        panel.add(button_11, "cell 1 6");
        
        JButton button_12 = new JButton(" ");
        panel.add(button_12, "cell 2 6");
        
        JLabel lblFrame_8 = new JLabel("Frame 7:");
        panel.add(lblFrame_8, "cell 0 7");
        
        JButton button_13 = new JButton("  ");
        panel.add(button_13, "cell 1 7");
        
        JButton button_14 = new JButton(" ");
        panel.add(button_14, "cell 2 7");
        
        JLabel lblFrame_9 = new JLabel("Frame 8:");
        panel.add(lblFrame_9, "cell 0 8");
        
        JButton button_15 = new JButton("  ");
        panel.add(button_15, "cell 1 8");
        
        JButton button_16 = new JButton(" ");
        panel.add(button_16, "cell 2 8");
        
        JLabel lblFrame_10 = new JLabel("Frame 9:");
        panel.add(lblFrame_10, "cell 0 9");
        
        JButton button_17 = new JButton("  ");
        panel.add(button_17, "cell 1 9");
        
        JButton button_18 = new JButton(" ");
        panel.add(button_18, "cell 2 9");
        
        JLabel lblFrame_11 = new JLabel("Frame 10:");
        panel.add(lblFrame_11, "cell 0 10");
        
        JButton button_19 = new JButton("  ");
        panel.add(button_19, "cell 1 10");
        
        JButton button_20 = new JButton(" ");
        panel.add(button_20, "cell 2 10");
        
        JLabel lblFrame_12 = new JLabel("Frame 11:");
        panel.add(lblFrame_12, "cell 0 11");
        
        JButton button_21 = new JButton("  ");
        panel.add(button_21, "cell 1 11");
        
        JButton button_22 = new JButton(" ");
        panel.add(button_22, "cell 2 11");
        
        JLabel lblFrame_13 = new JLabel("Frame 12:");
        panel.add(lblFrame_13, "cell 0 12");
        
        JButton button_23 = new JButton("  ");
        panel.add(button_23, "cell 1 12");
        
        JButton button_24 = new JButton(" ");
        panel.add(button_24, "cell 2 12");
        
        JLabel lblFrame_14 = new JLabel("Frame 13:");
        panel.add(lblFrame_14, "cell 0 13");
        
        JButton button_25 = new JButton("  ");
        panel.add(button_25, "cell 1 13");
        
        JButton button_26 = new JButton(" ");
        panel.add(button_26, "cell 2 13");
        
        JLabel lblFrame_15 = new JLabel("Frame 14:");
        panel.add(lblFrame_15, "cell 0 14");
        
        JButton button_27 = new JButton("  ");
        panel.add(button_27, "cell 1 14");
        
        JButton button_28 = new JButton(" ");
        panel.add(button_28, "cell 2 14");
        
        JLabel lblFrame_16 = new JLabel("Frame 15:");
        panel.add(lblFrame_16, "cell 0 15");
        
        JButton button_29 = new JButton("  ");
        panel.add(button_29, "cell 1 15");
        
        JButton button_30 = new JButton(" ");
        panel.add(button_30, "cell 2 15");
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(280, 385, 480, 140);
        frame.getContentPane().add(panel_1);
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
        
        JLabel label = new JLabel("0");
        panel_1.add(label, "cell 0 1,alignx center");
        
        JLabel lblNa_1 = new JLabel("n/a");
        panel_1.add(lblNa_1, "cell 1 1,alignx center");
        
        JLabel label_3 = new JLabel("4");
        panel_1.add(label_3, "cell 3 1,alignx center");
        
        JLabel label_18 = new JLabel("n/a");
        panel_1.add(label_18, "cell 4 1,alignx center");
        
        JLabel label_8 = new JLabel("8");
        panel_1.add(label_8, "cell 6 1,alignx center");
        
        JLabel label_22 = new JLabel("n/a");
        panel_1.add(label_22, "cell 7 1,alignx center");
        
        JLabel label_12 = new JLabel("12");
        panel_1.add(label_12, "cell 9 1,alignx center");
        
        JLabel label_26 = new JLabel("n/a");
        panel_1.add(label_26, "cell 10 1,alignx center");
        
        JLabel label_2 = new JLabel("1");
        panel_1.add(label_2, "cell 0 2,alignx center");
        
        JLabel lblNa_2 = new JLabel("n/a");
        panel_1.add(lblNa_2, "cell 1 2,alignx center");
        
        JLabel label_5 = new JLabel("5");
        panel_1.add(label_5, "cell 3 2,alignx center");
        
        JLabel label_19 = new JLabel("n/a");
        panel_1.add(label_19, "cell 4 2,alignx center");
        
        JLabel label_9 = new JLabel("9");
        panel_1.add(label_9, "cell 6 2,alignx center");
        
        JLabel label_23 = new JLabel("n/a");
        panel_1.add(label_23, "cell 7 2,alignx center");
        
        JLabel label_13 = new JLabel("13");
        panel_1.add(label_13, "cell 9 2,alignx center");
        
        JLabel label_27 = new JLabel("n/a");
        panel_1.add(label_27, "cell 10 2,alignx center");
        
        JLabel label_4 = new JLabel("2");
        panel_1.add(label_4, "cell 0 3,alignx center");
        
        JLabel label_16 = new JLabel("n/a");
        panel_1.add(label_16, "cell 1 3,alignx center");
        
        JLabel label_6 = new JLabel("6");
        panel_1.add(label_6, "cell 3 3,alignx center");
        
        JLabel label_20 = new JLabel("n/a");
        panel_1.add(label_20, "cell 4 3,alignx center");
        
        JLabel label_10 = new JLabel("10");
        panel_1.add(label_10, "cell 6 3,alignx center");
        
        JLabel label_24 = new JLabel("n/a");
        panel_1.add(label_24, "cell 7 3,alignx center");
        
        JLabel label_14 = new JLabel("14");
        panel_1.add(label_14, "cell 9 3,alignx center");
        
        JLabel label_28 = new JLabel("n/a");
        panel_1.add(label_28, "cell 10 3,alignx center");
        
        JLabel label_1 = new JLabel("3");
        panel_1.add(label_1, "cell 0 4,alignx center");
        
        JLabel label_17 = new JLabel("n/a");
        panel_1.add(label_17, "cell 1 4,alignx center");
        
        JLabel label_7 = new JLabel("7");
        panel_1.add(label_7, "cell 3 4,alignx center");
        
        JLabel label_21 = new JLabel("n/a");
        panel_1.add(label_21, "cell 4 4,alignx center");
        
        JLabel label_11 = new JLabel("11");
        panel_1.add(label_11, "cell 6 4,alignx center");
        
        JLabel label_25 = new JLabel("n/a");
        panel_1.add(label_25, "cell 7 4,alignx center");
        
        JLabel label_15 = new JLabel("15");
        panel_1.add(label_15, "cell 9 4,alignx center");
        
        JLabel label_29 = new JLabel("n/a");
        panel_1.add(label_29, "cell 10 4,alignx center");
        
        JLabel lblPageTable = new JLabel("Page Table for");
        lblPageTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPageTable.setBounds(280, 329, 120, 40);
        frame.getContentPane().add(lblPageTable);
        
        JLabel lblP = new JLabel("P1");
        lblP.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblP.setBounds(400, 329, 40, 40);
        frame.getContentPane().add(lblP);
        
        JLabel lblTotalFaults = new JLabel("Total Faults: ");
        lblTotalFaults.setBounds(619, 326, 99, 20);
        frame.getContentPane().add(lblTotalFaults);
        
        JLabel lblTotalReferences = new JLabel("Total References:");
        lblTotalReferences.setBounds(584, 349, 134, 20);
        frame.getContentPane().add(lblTotalReferences);
        
        JLabel label_30 = new JLabel("0");
        label_30.setBounds(720, 326, 40, 20);
        frame.getContentPane().add(label_30);
        
        JLabel label_31 = new JLabel("0");
        label_31.setBounds(720, 349, 40, 20);
        frame.getContentPane().add(label_31);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(316, 133, 383, 100);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(new MigLayout("", "[][][][][][]", "[][][]"));
        
        JLabel lblCurrentProcess = new JLabel("Current Process:");
        panel_2.add(lblCurrentProcess, "cell 0 1");
        
        JLabel lblNa = new JLabel("n/a");
        panel_2.add(lblNa, "cell 1 1");
        
        JLabel lblTotalPageFaults = new JLabel("Total Page Faults:");
        panel_2.add(lblTotalPageFaults, "cell 4 1");
        
        JLabel lblNa_4 = new JLabel("000");
        panel_2.add(lblNa_4, "cell 5 1");
        
        JLabel lblPageAccessed = new JLabel("Page Accessed:");
        panel_2.add(lblPageAccessed, "cell 0 2");
        
        JLabel lblNa_3 = new JLabel("n/a");
        panel_2.add(lblNa_3, "cell 1 2");
        
        JLabel lblLastVictim = new JLabel("Last Victim:");
        panel_2.add(lblLastVictim, "cell 4 2");
        
        JLabel lblNa_5 = new JLabel("n/a");
        panel_2.add(lblNa_5, "cell 5 2");
        
        JLabel lblStatistics = new JLabel("Statistics");
        lblStatistics.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblStatistics.setBounds(471, 97, 86, 20);
        frame.getContentPane().add(lblStatistics);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        JMenuItem mntmQuit = new JMenuItem("Quit");
        mnFile.add(mntmQuit);
        
        JMenu mnOptions = new JMenu("Options");
        menuBar.add(mnOptions);
    }
}
