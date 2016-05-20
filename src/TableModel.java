import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel 
{
	String[] tableColumns = {"X", "Y", "Width", "Height"};
	//TODO: placeholder values until action listeners are set up
	int[][] tableData = 
		{
			{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},
			{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},
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
		return tableData[row][col];
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
	
	private void zeroAll(int row)
	{
		setValueAt(0, row, 0);
		setValueAt(0, row, 1);
		setValueAt(0, row, 2);
		setValueAt(0, row, 3);
	}
	
	public void newChanges(ArrayList<DShape> shapes)
	{
		for(int i = 0; i < shapes.size(); i++)
		{
			DShapeModel shapeModel = shapes.get(i).getDshapemodel();
			setValueAt(shapeModel.getX(), i, 0);
			setValueAt(shapeModel.getY(), i, 1);
			setValueAt(shapeModel.getWidth(), i, 2);
			setValueAt(shapeModel.getHeight(), i, 3);
		}
		for(int i = shapes.size(); i < tableData.length; i++)
		{
			zeroAll(i);
		}
	}
}
