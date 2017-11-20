import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class GUI2 {


    public static void main(String[] args) {
        JButton[] processButtons;
        JButton[] pageButtons;
        JLabel[] labels;
        JMenuBar menus;
        JMenu fileMenu;
        JMenuItem quitItem;
        int PHYSICAL_MEMORY_SIZE = 16;  //should eventually be 16
        
        JFrame frame = new JFrame("Testing MigLayout");
        JPanel contentPane = new JPanel(new MigLayout("fillx"));
        
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

        // Row 1
        JLabel areaLabel = new JLabel("Physical Memory");
        areaLabel.setFont(areaLabel.getFont().deriveFont(16.0f));
        areaLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(areaLabel, "spanx, growx, wrap");
        // wrap indicates a new row

        // Row 2
        JLabel side1Label = new JLabel("Side 1:");
        contentPane.add(side1Label, "alignx trailing");
        JTextField side1Field = new JTextField();
        side1Field.setColumns(6);
        contentPane.add(side1Field, "alignx leading, wrap");

        // Row 3
        JLabel side2Label = new JLabel("Side 2:");
        contentPane.add(side2Label, "alignx trailing");
        JTextField side2Field = new JTextField();
        side2Field.setColumns(6);
        contentPane.add(side2Field, "alignx leading, wrap");

        // Row 4
        JLabel side3Label = new JLabel("Side 3:");
        contentPane.add(side3Label, "alignx trailing");
        JTextField side3Field = new JTextField();
        side3Field.setColumns(6);
        contentPane.add(side3Field, "alignx leading, wrap");

        // Row 5
        JButton calculateButton = new JButton("Calculate Area");
        contentPane.add(calculateButton, "spanx, growx");

        frame.setContentPane(contentPane);
        // Resizes automatically
        frame.pack();
        // Centers automatically
        frame.setLocationRelativeTo(null);
        // Exit when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
