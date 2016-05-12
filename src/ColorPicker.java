import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This class creates the color picker, using the java standard color chooser interface.
 */
public class ColorPicker extends JPanel implements ChangeListener {
    JColorChooser colorChooser;
    Color newColor;

    /**
     * Creates the standard java color chooser.
     */
    public ColorPicker() {
        super(new BorderLayout());

        colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(this);
        colorChooser.setBorder(BorderFactory.createTitledBorder("Choose A Color"));
        add(colorChooser);

    }

    /**
     * Creates the main frame of the color chooser.
     */
    void createFrame() {
        JFrame frame = new JFrame("Color Picker");
        frame.setContentPane(new ColorPicker().colorChooser);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Change event to determine the state change of the color selected
     */
    public void stateChanged(ChangeEvent e) {
        //TODO: maybe doesn't work yet, check after we have shapes
        newColor = colorChooser.getColor();
    }

}
