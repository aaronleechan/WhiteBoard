import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The main class of the whiteboard application.
 * It sets up the whiteboard main frame and adds a canvas component inside.
 */
public class Whiteboard extends JFrame
{
	private Canvas canvas;
	private JPanel controlCenter;
	
	public static void main (String[]args) 
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();	
		}
		Whiteboard m = new Whiteboard();
	}
	
	private Whiteboard() 
	{
		this.setName("WhiteBoard");
		this.setLayout(new BorderLayout());
		
		createControlCenter();
		canvas = new Canvas();
		
		this.add(canvas, BorderLayout.CENTER);
		this.add(controlCenter,BorderLayout.WEST);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	
	/**
	 * Creates the control side of the whiteboard
	 */
	private void createControlCenter()
	{
		controlCenter = new JPanel();
		controlCenter.setLayout(new BoxLayout(controlCenter,BoxLayout.Y_AXIS));
		controlCenter.setSize(400,300);
		controlCenter.setAlignmentX(Box.LEFT_ALIGNMENT);
		
		ArrayList<Box> horizontalBoxes = getHorizontalBoxes();
		Box verticalBox = Box.createVerticalBox();
		
		for(int i = 0; i < horizontalBoxes.size(); i++)
		{
			verticalBox.add(horizontalBoxes.get(i));
			if(i != horizontalBoxes.size()-1)
			{
				verticalBox.add(Box.createVerticalStrut(20));
			}
		}
		
		for(Component comp: verticalBox.getComponents()) 
		{
			((JComponent)comp).setAlignmentX(Box.LEFT_ALIGNMENT);
		}
		
		controlCenter.add(verticalBox);
	}
	
	/**
	 * Gets all the horizontal boxes to add to the control center
	 * @return horizontal boxes
	 */
	private ArrayList<Box> getHorizontalBoxes()
	{
		ArrayList<Box> boxes = new ArrayList<Box>();
		
		boxes.add(getAddBox());
		boxes.add(getColorBox());
		boxes.add(getTextBox());
		boxes.add(getMoveAndRemoveBox());
		boxes.add(getTableBox());
		
		return boxes;
	}
	
	/**
	 * Creates the horizontal box of add label & rect, oval, line, text buttons
	 * @return first horizontal box
	 */
	private Box getAddBox()
	{
		Box addRow = Box.createHorizontalBox();
		
		JLabel add = new JLabel("Add");

		JButton rect = new JButton("Rect");
		rect.addActionListener(e ->
		{
			DRect drect = new DRect();
			canvas.addShape(drect);
		});
		
		JButton oval = new JButton("Oval");
		oval.addActionListener(e ->
		{
			DOval doval = new DOval();
			canvas.addShape(doval);
		});
		
		JButton line = new JButton("Line");
		line.addActionListener(e ->
		{
			DLine dLin = new DLine();
			canvas.addShape(dLin);
		});
		
		JButton text = new JButton("Text");
		text.addActionListener(e ->
		{
			//TODO: add functionality
		});
		
		addRow.add(add);
		addRow.add(rect);
		addRow.add(oval);
		addRow.add(line);
		addRow.add(text);
		
		return addRow;
	}
	
	/**
	 * Creates the set Color horizontal box
	 * @return the color horizontal box
	 */
	private Box getColorBox()
	{
		Box addRow = Box.createHorizontalBox();
		
		JButton setColor = new JButton("Set Color");
		setColor.addActionListener(e ->
		{
			DShape ds = canvas.getSelectedShape();
			Color currentColor = ds.getColor();
			Color newColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
			if (newColor != null)
			{
				ds.setColor(newColor);
				repaint();
			}
		});
		
		addRow.add(setColor);
		
		return addRow;
	}
	
	/**
	 * Creates the horizontal text box
	 * @return the horizontal text box
	 */
	private Box getTextBox()
	{
		Box textBox = Box.createHorizontalBox();
		
		JTextField textEntry = new JTextField(10);
		textEntry.setMaximumSize(textEntry.getPreferredSize());

		JButton edwardianScript = new JButton("Edwardian Script");
		edwardianScript.addActionListener(e ->
		{
			//TODO: add functionality
		});

		textBox.add(textEntry);
		textBox.add(edwardianScript);
		
		return textBox;
	}
	
	/**
	 * Creates the move & remove box
	 * @return the move & remove box
	 */
	private Box getMoveAndRemoveBox()
	{
		Box moveBox = Box.createHorizontalBox();
		
		JButton moveToFront = new JButton("Move To Front");
		moveToFront.addActionListener(e ->
		{
			ArrayList<DShape> aL = canvas.getShapeList();
			DShape ds = canvas.getSelectedShape();
			
			aL.remove(ds);
			aL.add(ds);

			canvas.updateShapeList(aL);
			repaint();
		});
		
		JButton moveToBack = new JButton("Move To Back");
		moveToBack.addActionListener(e ->
		{
			ArrayList<DShape> aL = canvas.getShapeList();
			DShape ds = canvas.getSelectedShape();
			
			aL.remove(ds);
			aL.add(0, ds);

			canvas.updateShapeList(aL);
			repaint();
		});
		
		JButton removeShape = new JButton("Remove Shape");	
		removeShape.addActionListener(e ->
		{
			DShape ds = canvas.getSelectedShape();
			canvas.removeShape(ds);
		});
		
		moveBox.add(moveToFront);
		moveBox.add(moveToBack);
		moveBox.add(removeShape);
		
		return moveBox;
	}
	
	/**
	 * Creates the horizontal box for the table
	 * @return the table box
	 */
	private Box getTableBox()
	{
		Box tableBox = Box.createHorizontalBox();
		
		JTable table = new JTable(new MyTableModel());
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(100, 100));
		table.setFillsViewportHeight(true);
		
		tableBox.add(tableScrollPane);
		
		return tableBox;
	}
	
	/**
	 * Creates the model that the table uses
	 */
	class MyTableModel extends AbstractTableModel 
	{
		String[] tableColumns = {"X", "Y", "Width", "Height"};
		//TODO: placeholder values until action listeners are set up
		int[][] tableData = 
			{
				{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
				{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
			};

		public String getColumnName(int col) 
		{
			return tableColumns[col];
		}
		public int getRowCount() 
		{
			return tableData.length;
		}
		public int getColumnCount() 
		{
			return tableColumns.length;
		}
		public Object getValueAt(int row, int col) 
		{
			//TODO: fix. always getting null pointer exception so made return = 0 for now

			return 0; //return tableData[row][col];
		}
		public void setValueAt(int value, int row, int col) 
		{
			tableData[row][col] = value;
			fireTableRowsUpdated(row, col);
			fireTableDataChanged();
		}
		public boolean isCellEditable(int row, int col) 
		{
			return false;
		}
	}
}
