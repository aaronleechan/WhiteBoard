import javax.swing.*;
import java.awt.*;

// whiteboard subclass of JFrame
// sets up the comonent in a frame
// its main() should create a single whilteboard Frame


public class Whiteboard extends JFrame {
	
	static Canvas canvas;

	
	
	public  Whiteboard(String title)
	{
		super(title);
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main (String[]args)
	{
		Whiteboard theFrame = new Whiteboard("White Board");
		canvas = new Canvas();
		canvas.Canvas();
		canvas.controlField();
		canvas.drawingField();

		theFrame.add(canvas.gui);
		theFrame.setVisible(true);
		theFrame.pack();
	}
	

	
	

}
