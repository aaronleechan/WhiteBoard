import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class DRect extends DShape {
	
	private DRectModel dRectModel;
	
	
	// Constructor
	public DRect()
	{	
		System.out.println(" 1 ");
		this.dRectModel = new DRectModel();
		super.setDshapemodel(this.dRectModel);
		originalModel();
	}
	
	public DRect(DRectModel model){
		this.dRectModel = model;
	}
	
	public void originalModel()
	{
		System.out.println(" 2 ");
		dRectModel.setX(100);
		dRectModel.setY(100);
		dRectModel.setWidth(50);
		dRectModel.setHeight(50);
	}
	
	public void paintComponent(Graphics g){
		
		int x,y,w,h;
		x = dRectModel.getX();
		y = dRectModel.getY();
		w = dRectModel.getWidth();
		h = dRectModel.getHeight();
		g.setColor(dRectModel.getColor());
		g.drawRect(x, y, w, h);
		g.fillRect(x, y, w, h);
		super.paintComponent(g);
			
	}
	
	public Color getColor()
	{
		return this.dRectModel.getColor();
	}
	
	public DRectModel getShapeModel(){
		System.out.println(" ?? " );
		return dRectModel;
	}
}
