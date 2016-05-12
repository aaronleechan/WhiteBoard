import javax.swing.*;
import java.awt.*;

/**
 * The main class of the whiteboard application.
 * It sets up the whiteboard main frame and adds a canvas component inside.
 */
public class Whiteboard extends JFrame {

	/**
	 * Creates the main frame of the whiteboard.
	 */
	private Whiteboard() {
		JFrame mainFrame = new JFrame("Whiteboard");
		Canvas canvas = new Canvas();
		canvas.Canvas();
		canvas.controlField();
		canvas.drawingField();

		mainFrame.add(canvas.gui);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.pack();
	}

	public static void main (String[]args) {
		new Whiteboard();
	}
}
