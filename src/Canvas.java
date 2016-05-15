import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel
{

	private ArrayList<DShape> allShapes = new ArrayList<DShape>();
	private DShape selectedShape;

	public Canvas()
	{
		displayCanvas();
		selectedShape = null;
		
		this.addMouseListener(new MouseAdapter()
		{
			// Select the Item
			
			public void mousePressed(MouseEvent e)
			{
				
				System.out.println("select item 1");
				int x = e.getX();
				int y = e.getY();
				Canvas.this.selectedShape = null;
				DShape selectedShape = locationOfShape(x,y); // go to locationOfShape

	
					if(selectedShape != null)
					{
						selectedShape.setSelected(true);
						Canvas.this.selectedShape = selectedShape;
						System.out.println( " selected shape 3");
						int indexForSelectedShape = allShapes.indexOf(selectedShape);
						
						for(int i = 0; i < allShapes.size(); i++)
						{
							if( i != indexForSelectedShape)
							{
								allShapes.get(i).setSelected(false);
							}
						}
	
					}
					else
					{
						for(DShape s : allShapes)
							s.setSelected(false);
					}
				
				repaint();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			@Override
			public void mouseDragged(MouseEvent e)
			{
				System.out.println( " move item step 1");
				int x = e.getX();
				int y = e.getY();
				
				for(DShape s : allShapes)
				{
					if(s.isSelected())
					{
						// Handle when item move 
						int anchorNumber = s.isAnchorChosen(x,y);

						if(anchorNumber != 0)
						{
							System.out.println(" move item step 2");
							if(anchorNumber == 1)
								s.dragAnchorOne(x, y);
							else if (anchorNumber == 2)
								s.dragAnchorTwo(x, y);
							else if (anchorNumber == 3)
								s.dragAnchorThree(x, y);
							else if (anchorNumber == 4)
								s.dragAnchorFour(x, y);
						}
						else
							s.moveShapeTo(x, y);

						repaint();
					}
				}	
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				// TODO Auto-generated method stub
			}
		});
	}
	
	// Select the shape 
	public DShape getSelectedShape()
	{
		return selectedShape;
	}

	public void setSelectedShape(DShape selectedShape)
	{
		this.selectedShape = selectedShape;
	}

	
	public void displayCanvas()
	{
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.WHITE);
	}
	
	
	public void addShape(DShape shape)
	{
		//System.out.println("3");
		allShapes.add(shape);
		repaint();
		System.out.println(" DOWN");
	}

	public void removeShape(DShape shape)
	{
		allShapes.remove(shape);
		repaint();
	}

	public void paintComponent(Graphics g)
	{
		//System.out.println("4");
		super.paintComponent(g);
		for(DShape shape : allShapes)
			shape.paintComponent(g);
	}
	
	public DShape locationOfShape(int x, int y)
	{
		System.out.println("selected 2 in canvas");
		for(int i = allShapes.size() - 1; i >= 0; i--)
		{
			if(allShapes.get(i).containsPoint(x,y))
				return allShapes.get(i);
		}
		return null;
	}

	ArrayList<DShape> getShapeList()
	{
		return allShapes;
	}

	void updateShapeList(ArrayList<DShape> list)
	{
		allShapes = list;
	}
}