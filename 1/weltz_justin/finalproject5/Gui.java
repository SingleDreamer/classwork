import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//used youtude tutorial for assistance to set up the basic paint and graphics

public class Gui implements ActionListener {
    private JFrame frame = new JFrame("Guess the Shape");
    private String[] questionShapeStrings = { "Shape","Is it a triangle?","Is it a square?","Is it a pentagpn?", "Is it a hexagon?", "Is it a cirlce?"};
    private String[] questionBorderColorStrings = { "Border Color", "Is the border blue?","Is the border green?", "Is the border black?", "Is the border cyan?", "Is the border purple?"};
    private String[] questionInteriorColorStrings = { "Interior Color", "Is there an interior color?","Is the interior blue?","Is the interior green?", "Is the interior black?", "Is the interior cyan?", "Is the interior purple?"};
    private String[] questionPatternStrings = {"Patterns", "Are there dots in the shape?","Is the interior color the same as the border color?", "Is the border a series of dashes?","Is the interior striped?"};   
    private JComboBox questionShape = new JComboBox (questionShapeStrings);
    private JComboBox questionBorderColor = new JComboBox(questionBorderColorStrings);
    private JComboBox questionInteriorColor = new JComboBox(questionInteriorColorStrings);
    private JComboBox questionPatterns = new JComboBox(questionPatternStrings);
    private JButton questionSubmit = new JButton("Submit Your Question(s)");
    private JTextField guess = new JTextField("Guess here...");
    private JButton guessButton = new JButton("Guess");
    private String PatternSelect;
    private String ShapeSelect;
    private String InteriorColorSelect;
    private String BorderColorSelect;
    private Shape rightShape;
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == questionSubmit) {
            PatternSelect = (String)(questionPatterns.getSelectedItem());
	    ShapeSelect = (String)(questionBorderColor.getSelectedItem());
	    InteriorColorSelect = (String)(questionInteriorColor.getSelectedItem());
	    BorderColorSelect = (String)(questionBorderColor.getSelectedItem());
        }
    }
    public Gui(){
	questionSubmit.addActionListener(this);
	guessButton.addActionListener(this);
	frame.setBackground(Color.RED.darker());
	questionPatterns.setPreferredSize(new Dimension(250,40));
	questionSubmit.setPreferredSize(new Dimension (250,50));
     	guess.setPreferredSize(new Dimension(100,20));
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
	rightShape = object.getRandomShape();
        object.drawing();
    }
    public static void main(String[] args){
	Gui g = new Gui();
    }
}
