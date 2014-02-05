import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* TopLevelDemo.java requires no other files. */
public class TopLevelDemo {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TopLevelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a yellow label to put in the content pane.
        JLabel yellowLabel = new JLabel();
         yellowLabel.setOpaque(true);
        yellowLabel.setPreferredSize(new Dimension(200,200));

        //Set the menu bar and add the label to the content pane.
        
        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
