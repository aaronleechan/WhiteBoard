import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * Creates the canvas, which is the component in which
 * objects, text, and lines are drawn in.
 */
public class Canvas extends JPanel
{
	// install the canvas at the center of a border layout
	// position the controls in the west
	JPanel gui;
	private JLabel add;
	private JButton rect;
	private JButton oval;
	private JButton line;
	private JButton text;
	private JButton setColor;
	private JButton edwardianScript;
	private JButton moveToFront;
	private JButton moveToBack;
	private JButton removeShape;
	private JTextField textEntry;
	private JTable table;
	private JScrollPane tableScrollPane;
	DShape dShape;
	DOval dOval;
	DLine dLine;
	DText dText;
	Color colour;
	ColorPicker cp = new ColorPicker();


	void Canvas() {
		gui = new JPanel(new BorderLayout());
		repaint(); // call paintComponent method
	}
	
	// paint component should loop through all the shapes and draw them
	// Shapes are not subclasses of JComponent
	// shapes will fill the view row, representing something to draw. don't store data itself
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
//		g.setColor(Color.BLUE);
//		g.fillRect(400, 300, 300, 300);
//		g.setColor(new Color(190,81,215));
//		g.fillRect(205, 200, 100, 100);
		
	}
	
	

	void drawingField()
	{
		JPanel drawing = new JPanel();
		drawing.setLayout(new BoxLayout(drawing,BoxLayout.Y_AXIS));
		drawing.setBorder(BorderFactory.createRaisedBevelBorder());
		drawing.setPreferredSize(new Dimension(400,400));
		drawing.setPreferredSize(new Dimension(400,400));
		Canvas p = new Canvas();
		
		drawing.add(p);
		
		gui.add(drawing,BorderLayout.CENTER);
	}
	
	void controlField()
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

		rect = new JButton("Rect");
		rect.addActionListener(e -> {
			//TODO: Add action listener
		});
		
		oval = new JButton("Oval");
		oval.addActionListener(e -> {
			//TODO: Add action listener
		});
		
		text = new JButton("Text");
		text.addActionListener(e -> {
			//TODO: Add action listener
		});

		line = new JButton("Line");
		line.addActionListener(e -> {
			//TODO: Add action listener
		});
		
		setColor = new JButton("Set Color");
		setColor.addActionListener(e -> {
			cp.createFrame();
		});
		
		textEntry = new JTextField(10);
		textEntry.setMaximumSize(textEntry.getPreferredSize());

		edwardianScript = new JButton("Edwardian Script");
		edwardianScript.addActionListener(e -> {

		});
		
		moveToFront = new JButton("Move To Front");
		moveToFront.addActionListener(e -> {

		});
		
		moveToBack = new JButton("Move To Back");
		moveToBack.addActionListener(e -> {

		});
		
		removeShape = new JButton("Remove Shape");	
		removeShape.addActionListener(e -> {

		});


		/**
		 * Creates the model that the table uses
		 */
		class MyTableModel extends AbstractTableModel {
			String[] tableColumns = {"X", "Y", "Width", "Height"};
			//TODO: placeholder values until action listeners are set up
			int[][] tableData = {
					{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
					{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},
			};

			public String getColumnName(int col) {
				return tableColumns[col];
			}
			public int getRowCount() {
				return tableData.length;
			}
			public int getColumnCount() {
				return tableColumns.length;
			}
			public Object getValueAt(int row, int col) {
				//TODO: fix. always getting null pointer exception so made return = 0 for now

				return 0; //return tableData[row][col];
			}
			public void setValueAt(int value, int row, int col) {
				tableData[row][col] = value;
				fireTableRowsUpdated(row, col);
				fireTableDataChanged();
			}
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		}
		table = new JTable(new MyTableModel());

		tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(100, 100));
		table.setFillsViewportHeight(true);

		horizontal1.add(add);
		horizontal1.add(rect);
		horizontal1.add(oval);
		horizontal1.add(line);
		horizontal1.add(text);
		
		horizontal2.add(setColor);
		
		horizontal3.add(textEntry);
		horizontal3.add(edwardianScript);
		
		horizontal4.add(moveToFront);
		horizontal4.add(moveToBack);
		horizontal4.add(removeShape);

		horizontal5.add(tableScrollPane);
		
		verticalBox.add(horizontal1);
		verticalBox.add(Box.createVerticalStrut(20));
		verticalBox.add(horizontal2);
		verticalBox.add(Box.createVerticalStrut(20));
		verticalBox.add(horizontal3);
		verticalBox.add(Box.createVerticalStrut(20));
		verticalBox.add(horizontal4);
		verticalBox.add(Box.createVerticalStrut(20));
		verticalBox.add(horizontal5);
		
		for(Component comp: verticalBox.getComponents()) {
			((JComponent)comp).setAlignmentX(Box.LEFT_ALIGNMENT);
		}

		controlCenter.add(verticalBox);

		gui.add(controlCenter,BorderLayout.WEST);
	}
}
