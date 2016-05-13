import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main class of the whiteboard application.
 * It sets up the whiteboard main frame and adds a canvas component inside.
 */
public class Whiteboard extends JFrame {
	
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
	private Canvas canvas;
	
	public static void main (String[]args) {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		Whiteboard m = new Whiteboard();
	}
	

	
	private Whiteboard() {
		JFrame mainFrame = new JFrame("Whiteboard");
		mainFrame.setLayout(new BorderLayout());

		

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
		rect.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 DRect drect = new DRect();
				 System.out.println( rect + " come in? ");
				 canvas.addShape(drect);

			}
			
		});
		
		oval = new JButton("Oval");
		oval.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		text = new JButton("Text");
		text.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		line = new JButton("Line");
		line.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		setColor = new JButton("Set Color");
		setColor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		textEntry = new JTextField(10);
		textEntry.setMaximumSize(textEntry.getPreferredSize());

		edwardianScript = new JButton("Edwardian Script");
		edwardianScript.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		moveToFront = new JButton("Move To Front");
		moveToFront.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		moveToBack = new JButton("Move To Back");
		moveToBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		removeShape = new JButton("Remove Shape");	
		removeShape.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
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


		 canvas = new Canvas();
//		 this.canvas = canvas;	
		
	
		
		mainFrame.add(canvas, BorderLayout.CENTER);
		mainFrame.add(controlCenter,BorderLayout.WEST);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.pack();
	}

	
}
