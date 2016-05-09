import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// Canvas class subclass of JPanel with white background, size 400*400
// contain the little drawing shapes

public class Canvas extends JPanel{
	
	// install the canvas at the center of a border layout
	// position the controls in the west
	JPanel gui;
	JLabel add;
	JButton Rect, Oval, Line, Text, SetColor, EdwardianScript, moveToFront, moveToBack, removeShape;
	JTextField text;
	
	public void Canvas()
	{
		gui = new JPanel(new BorderLayout());
		repaint(); // call paintComponent method
		
		
		
	}
	
	public void paintComponent(Graphics g){
		
		
		
		
		
		
		
		super.paintComponent(g);
		
		
	}
	
	

	public void drawingField()
	{
		JPanel drawing = new JPanel();
		drawing.setLayout(new BoxLayout(drawing, BoxLayout.Y_AXIS));
		drawing.setBorder(BorderFactory.createRaisedBevelBorder());
		drawing.setSize(400,400);
		
		
		
		gui.add(drawing,BorderLayout.EAST);
	}
	
	public void controlField()
	{
		
		
		JPanel controlCenter = new JPanel();
		controlCenter.setLayout(new BoxLayout(controlCenter,BoxLayout.Y_AXIS));
		controlCenter.setSize(400,400);
		controlCenter.setAlignmentX(Box.LEFT_ALIGNMENT);
		
		Box horizontal1 = Box.createHorizontalBox();	
		Box horizontal2 = Box.createHorizontalBox();
		Box horizontal3 = Box.createHorizontalBox();
		Box horizontal4 = Box.createHorizontalBox();
		Box verticalBox = Box.createVerticalBox();
		
		add = new JLabel("Add");				
		Rect = new JButton("Rect");	
		Oval = new JButton("Oval");
		Text = new JButton("Text");		
		SetColor = new JButton("Set Color");	
		text = new JTextField("",10);
		text.setMaximumSize(text.getPreferredSize());
		EdwardianScript = new JButton("Edwardian Script");
		moveToFront = new JButton("Move To Front");
		moveToBack = new JButton("Move To Back");	
		removeShape = new JButton("Remove Shape");
			
		horizontal1.add(add);
		horizontal1.add(Rect);
		horizontal1.add(Oval);
		horizontal1.add(Text);
		
		horizontal2.add(SetColor);
		
		horizontal3.add(text);
		horizontal3.add(EdwardianScript);
		
		horizontal4.add(moveToFront);
		horizontal4.add(moveToBack);
		horizontal4.add(removeShape);
		
		
		verticalBox.add(horizontal1);
		verticalBox.add(Box.createVerticalStrut(100));
		verticalBox.add(horizontal2);
		verticalBox.add(Box.createVerticalStrut(100));
		verticalBox.add(horizontal3);
		verticalBox.add(Box.createVerticalStrut(100));
		verticalBox.add(horizontal4);
		
		for(Component comp: verticalBox.getComponents())
		{
			((JComponent)comp).setAlignmentX(Box.LEFT_ALIGNMENT);
		}
		
		
		controlCenter.add(verticalBox);

		
		gui.add(controlCenter,BorderLayout.WEST);
			
	}
	
	

}
