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
	DShape dShape;
	DOval dOval;
	DLine dLine;
	DText dText;
	
	public void Canvas()
	{
		gui = new JPanel(new BorderLayout());
		repaint(); // call paintComponent method
			
		
	}
	
	// paint component should loop through all the shapes and draw them
	// Shapes are not subclasses of JComponent
	// shapes will fill the view row, representing sth to draw. don't store data itself
	
	public void paintComponent(Graphics g){
			
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.fillRect(400, 300, 300, 300);
		
		g.setColor(new Color(190,81,215));
		g.fillRect(205, 200, 100, 100);
		
		
		
	}
	
	

	public void drawingField()
	{
		JPanel drawing = new JPanel();
		drawing.setLayout(new BoxLayout(drawing,BoxLayout.Y_AXIS));
		drawing.setBorder(BorderFactory.createRaisedBevelBorder());
		drawing.setSize(400,400);
		Canvas p = new Canvas();
		
		drawing.add(p);
		
		gui.add(drawing,BorderLayout.CENTER);
	}
	
	public void controlField()
	{
		
		
		JPanel controlCenter = new JPanel();
		controlCenter.setLayout(new BoxLayout(controlCenter,BoxLayout.Y_AXIS));
		controlCenter.setSize(400,300);
		controlCenter.setAlignmentX(Box.LEFT_ALIGNMENT);
		
		Box horizontal1 = Box.createHorizontalBox();	
		Box horizontal2 = Box.createHorizontalBox();
		Box horizontal3 = Box.createHorizontalBox();
		Box horizontal4 = Box.createHorizontalBox();
		Box horizontal5 = Box.createHorizontalBox();
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
		
		JPanel tableLayout = new JPanel();
		tableLayout.setLayout(new GridLayout(0,4));
		tableLayout.setSize(400,100);
		JLabel x = new JLabel("X");
		JLabel y = new JLabel("Y");
		JLabel width = new JLabel("Width");
		JLabel height = new JLabel("Height");
		
		tableLayout.add(x);			
		tableLayout.add(y);
		tableLayout.add(width);		
		tableLayout.add(height);
		
			
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
		
		horizontal5.add(tableLayout);
		
		
		verticalBox.add(horizontal1);
		verticalBox.add(Box.createVerticalStrut(80));
		verticalBox.add(horizontal2);
		verticalBox.add(Box.createVerticalStrut(80));
		verticalBox.add(horizontal3);
		verticalBox.add(Box.createVerticalStrut(80));
		verticalBox.add(horizontal4);
		verticalBox.add(horizontal5);
		
		for(Component comp: verticalBox.getComponents())
		{
			((JComponent)comp).setAlignmentX(Box.LEFT_ALIGNMENT);
		}
		
		
		controlCenter.add(verticalBox);

		
		gui.add(controlCenter,BorderLayout.WEST);
			
	}
	
	

}
