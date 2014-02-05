import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//used youtude tutorial for assistance to set up the basic paint and graphics

public class Gui {
    private class myKeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            if (e.getSource() ==
        }
        public void keyReleased(KeyEvent e) {
            // System.out.println("RELEASED");
        }
        public void keyTyped(KeyEvent e) {
            // System.out.println("TYPED:"+e.getKeyChar());
        }
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Guess the Shape");
	frame.setBackground(Color.RED.darker());
	String[] questionShapeStrings = { "Shape","Is it a triangle?","Is it a square?","Is it a pentagpn?", "Is it a hexagon?", "Is it a cirlce?"};
	String[] questionBorderColorStrings = { "Border Color", "Is the border blue?","Is the border green?", "Is the border black?", "Is the border cyan?", "Is the border purple?"};
	String[] questionInteriorColorStrings = { "Interior Color", "Is there an interior color?","Is the interior blue?","Is the interior green?", "Is the interior black?", "Is the interior cyan?", "Is the interior purple?"};
	String[] questionPatternStrings = {"Patterns", "Are there dots in the shape?","Is the interior color the same as the border color?", "Is the border a series of dashes?","Is the interior striped?"};   
	JComboBox questionShape = new JComboBox (questionShapeStrings);
	JComboBox questionBorderColor = new JComboBox(questionBorderColorStrings);
	JComboBox questionInteriorColor = new JComboBox(questionInteriorColorStrings);
	JComboBox questionPatterns = new JComboBox(questionPatternStrings);
	questionPatterns.setPreferredSize(new Dimension(250,40));
	JButton questionSubmit = new JButton("Submit Your Question(s)");
	questionSubmit.setPreferredSize(new Dimension (250,50));
	JTextField guess = new JTextField("Guess here...");
	guess.setPreferredSize(new Dimension(100,20));
	JButton guessButton = new JButton("Guess");
	guessButton.setPreferredSize(new Dimension(250,50));
        frame.setVisible(true);
        frame.setSize(938,800);
	Container contentPane = frame.getContentPane();
	JPanel questions = new JPanel(new FlowLayout(FlowLayout.CENTER,5,65));
	questions.setBackground(Color.GREEN.darker());
	questions.setVisible(true);
	questions.setPreferredSize(new Dimension(290,800));
	questions.add(questionShape);
	questions.add(questionBorderColor);
	questions.add(questionInteriorColor);
	questions.add(questionPatterns);
	questions.add(questionSubmit);
	questions.add(guess);
	questions.add(guessButton);
	contentPane.setLayout(new FlowLayout(FlowLayout.LEADING));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw object = new draw();
        contentPane.add(object);
	contentPane.add(questions);
        object.drawing();
	
    }
}
