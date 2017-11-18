import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener{

    JFrame myGUI; 
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    
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
        myGUI.setSize(400,400);

        // place the die in the middle of the screen
        JPanel memoryPanel = new JPanel();
        GridLayout memoryPanelLayout = new GridLayout(5,3);
        myGUI.add(memoryPanel);
/*
        // position the GUI items on the screen
        JPanel top = new JPanel();
        top.add(player);
        top.add(new JLabel(" - "));
        top.add(round);
        top.add(new JLabel(" - "));    
        top.add(computer);
        panel.add(roll);
        panel.add(hold);
        panel.add(new JLabel(" --- "));      
        panel.add(compButton);
        myGUI.add(BorderLayout.NORTH, top);
        myGUI.add(BorderLayout.SOUTH, panel);    
*/
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
