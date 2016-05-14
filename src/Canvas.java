import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel{

	private ArrayList<DShape> allShapes = new ArrayList<DShape>();
	private DShape selectedShape;
	
	// Select the shape 
	
	public DShape getSelectedShape() {
		return selectedShape;
	}


	public void setSelectedShape(DShape selectedShape) {
		this.selectedShape = selectedShape;
	}


	public Canvas(){
		displayCanvas();
		
		this.addMouseListener(new MouseAdapter(){
			
			public void mousePressed(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				Canvas.this.selectedShape = null;
				DShape selectedShape = locationOfShape(x,y);
				if(selectedShape != null){
					selectedShape.setSelected(true);
					Canvas.this.selectedShape = selectedShape;
					System.out.println( "arrived?");
					
					int indexForSelectedShape = allShapes.indexOf(selectedShape);
					
					for(int i = 0; i < allShapes.size(); i++)
					{
						if( i != indexForSelectedShape){
							allShapes.get(i).setSelected(false);
						}
					}
				}else if (selectedShape == null){
					for(DShape s : allShapes){
						s.setSelected(false);
					}
				}
				repaint();
			}
			
		});
		
		this.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				int x, y;
				x = e.getX(); y = e.getY();
				
				for(DShape s : allShapes){
					if(s.isSelected()){
						int anchorNumber = 0;
						if((anchorNumber = s.isAnchorChosen(x,y)) != 0){
							
							if(anchorNumber == 1) s.dragAnchorOne(x, y);
							else if (anchorNumber == 2) s.dragAnchorTwo(x, y);
							else if (anchorNumber == 3) s.dragAnchorTree(x, y);
							else if (anchorNumber == 4) s.dragAnchorFour(x, y);
							
							
						}else{
							s.moveShapeTo(e.getX(), e.getY());
						}
						repaint();
						
					}
				}
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	
	public void displayCanvas(){
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.WHITE);
	}
	
	
	public void addShape(DShape shape){
		System.out.println("3");
		allShapes.add(shape);
		repaint();
		System.out.println(" DOWN");
	}
	
	public void paintComponent(Graphics g){
		System.out.println("4");
		super.paintComponent(g);
		for(DShape shape : allShapes){
			shape.paintComponent(g);
		}
	}
	
	public DShape locationOfShape(int x, int y){
		DShape dshape;
		for(int i = allShapes.size()-1; i >= 0; i--){
			dshape = allShapes.get(i);
			if(dshape.containsPoint(x,y)){
				return dshape;
			}
		}
		return null;
	}
	
}