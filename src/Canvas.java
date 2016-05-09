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
		
		JPanel drawing = new JPanel();
		drawing.setSize(400,400);

		
		
		
		gui.add(drawing,BorderLayout.EAST);
		super.paintComponent(g);
		
		
	}
	
	
	private JLabel JLabel(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void drawingField()
	{
		
	}
	
	public void controlField()
	{
		
		
		JPanel controlCenter = new JPanel(new FlowLayout());
		controlCenter.setSize(400,400);
		
		add = new JLabel("Add");
		controlCenter.add(add);
		add.setLocation(0, 0);
		
		Rect = new JButton("Rect");
		controlCenter.add(Rect);
		Rect.setLocation(50, 00);
		
		Oval = new JButton("Oval");
		controlCenter.add(Oval);
		Oval.setLocation(100, 0);
		
		Text = new JButton("Text");
		controlCenter.add(Text);
		Text.setLocation(150, 0);
		
		SetColor = new JButton("Set Color");
		controlCenter.add(SetColor);
		SetColor.setLocation(0,100);
		
		text = new JTextField("",10);
		controlCenter.add(text,FlowLayout.CENTER);
		text.setLocation(0, 200);
		
		moveToFront = new JButton("Move To Front");
		controlCenter.add(moveToFront,FlowLayout.CENTER);
		moveToFront.setLocation(0, 300);
		
		moveToBack = new JButton("Move To Back");
		controlCenter.add(moveToBack);
		moveToFront.setLocation(100, 300);
		
		removeShape = new JButton("Remove Shape");
		controlCenter.add(removeShape);
		moveToFront.setLocation(200, 300);
		
		
		
		gui.add(controlCenter,BorderLayout.WEST);
			
	}
	
	

}
