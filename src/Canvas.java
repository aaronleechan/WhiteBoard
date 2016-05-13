import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel{

	private ArrayList<DShape> shapes = new ArrayList<DShape>();
	private DShape selectedShape;
	
	public Canvas(){
		displayCanvas();
	}
	
	
	public void displayCanvas(){
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.WHITE);
	}
	
	
	public void addShape(DShape shape){
		System.out.println("3");
		shapes.add(shape);
		System.out.println(" repaint is not working? ");
		repaint();
		System.out.println(" DOWN");
	}
	
	public void paintComponent(Graphics g){
		System.out.println(" WHY NOT COME IT?? ");
		super.paintComponent(g);
//		g.fillRect(10, 10, 10, 10);
		for(DShape shape : shapes){
			shape.paintComponent(g);
		}
	}
	
}