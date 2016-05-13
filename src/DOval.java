import java.awt.Color;
import java.awt.Graphics;

public class DOval extends DShape {
	
	private DOvalModel dovalmodel;
	
	
	// Constructor
	public DOval()
	{	
		System.out.println(" 1 ");
		this.dovalmodel = new DOvalModel();
		super.setDshapemodel(this.dovalmodel);
		originalModel();
	}
	
	public DOval(DOvalModel model){
		this.dovalmodel = model;
	}
	
	public void originalModel()
	{
		System.out.println(" 2 ");
		dovalmodel.setX(200);
		dovalmodel.setY(200);
		dovalmodel.setWidth(100);
		dovalmodel.setHeight(100);
	}
	
	public void paintComponent(Graphics g){
		
		int x,y,w,h;
		x = dovalmodel.getX();
		y = dovalmodel.getY();
		w = dovalmodel.getWidth();
		h = dovalmodel.getHeight();
		g.setColor(dovalmodel.getColor());
		g.drawOval(x, y, w, h);
		g.fillOval(x, y, w, h);
		super.paintComponent(g);
			
	}
	
	public Color getColor()
	{
		return this.dovalmodel.getColor();
	}
}
