import java.awt.*;

public abstract class DShape {
	
	private DShapeModel model;
	private boolean selected;
	private static int ANCHORSIZE = 20;
	public abstract Color getColor();
	
	public void paintComponent(Graphics g){
		if(selected)
			draw(g);
	}

	private void draw(Graphics g) 
	{
		int x = this.model.getX();
		int y = this.model.getY();
		
		int x1 = this.model.getX();
		int y1 = this.model.getY() + model.getHeight();
		
		int x2 = this.model.getX() + model.getWidth();
		int y2 = this.model.getY();
		
		int x3 = this.model.getX() + model.getWidth();
		int y3 = model.getY() + model.getHeight();
		
		g.setColor(Color.BLACK);
		g.fillRect(x-5, y-5, 10, 10);
		g.fillRect(x1-5, y1-5, 10, 10);
		g.fillRect(x2-5, y2-5, 10, 10);
		g.fillRect(x3-5, y3-5, 10, 10);
	}

	public void setColor(Color color)
	{
		this.model.setColor(color);
	}

	public DShapeModel getDshapemodel() 
	{
		return model;
	}
	
	public boolean isSelected()
	{
		return this.selected;
	}
	
	public void setSelected(Boolean b)
	{
		this.selected = b;
	}

	public void setDshapemodel(DShapeModel model) 
	{
		this.model = model;
	}

	public void setselected(boolean selected) 
	{
		this.selected = selected;
	}

	public Rectangle getBounds() {
		return model.getTheBounds();
	}
	
	public void moveShape(int x, int y){
		model.setX(x);
		model.setY(y);
	}
	
	public void moveShapeTo(int x, int y){
		model.setX( x - model.getWidth() /2);
		model.setY( y - model.getHeight()/ 2);
	}
	
	public int isAnchorChosen(int x, int y){
		if(isAnchorOne(x,y))
			return 1;
		else if(isAnchorTwo(x,y))
			return 2;
		else if(isAnchorThree(x,y))
			return 3;
		else if(isAnchorFour(x,y))
			return 4;
		else
			return 0;
	}
	
	public boolean isAnchorOne(int x, int y)
	{
		int xAxis = model.getX();
		int yAxis = model.getY();
		if( x >= xAxis - ANCHORSIZE && x <= xAxis + ANCHORSIZE && y >= yAxis - ANCHORSIZE && y <= yAxis + ANCHORSIZE)
		{
			System.out.println("anchor1 pressed");
			return true;
		}
		else
			return false;
	}
	
	public boolean isAnchorTwo(int x, int y)
	{
		int xAxis = model.getX();
		int yAxis = model.getY();
		if( x >= xAxis + model.getWidth() - ANCHORSIZE && x <= xAxis + model.getWidth() + ANCHORSIZE && y >= yAxis - ANCHORSIZE && y <= yAxis + ANCHORSIZE)
		{
			System.out.println("anchor2 pressed");
			return true;
		}
		else
			return false;
	}
	
	public boolean isAnchorThree(int x, int y){
		int xAxis = model.getX();
		int yAxis = model.getY();
		if( x >= xAxis - ANCHORSIZE && x <= xAxis + ANCHORSIZE && y >= yAxis + model.getHeight() - ANCHORSIZE && y <= yAxis + model.getHeight() + ANCHORSIZE)
		{
			System.out.println("anchor3 pressed");
			return true;
		}
		else
			return false;
	}
	
	public boolean isAnchorFour(int x, int y){
		int xAxis = model.getX();
		int yAxis = model.getY();
		if(  x >= xAxis + model.getWidth() - ANCHORSIZE && x <= xAxis + model.getWidth() + ANCHORSIZE && y >= yAxis + model.getHeight() - ANCHORSIZE && y <= yAxis + model.getHeight() + ANCHORSIZE)
		{
			System.out.println("anchor4 pressed");
			return true;
		}
		else
			return false;
	}

	public boolean containsPoint(int x, int y) {
		DShapeModel model = this.model;
		if(model != null){
			int h = model.getHeight();
			int w = model.getWidth();
			if(x >= model.getX() && x <= model.getX() + w && y>= model.getY() && y <= model.getY() + h)
			{
				this.setSelected(true);
				return true;
			}
			this.setSelected(false);
		}
		return false;
	}
	
	private void setSelected(boolean b) 
	{
		this.selected = b;
	}
	
	public void dragAnchorOne(int x, int y)
	{
		DShapeModel shapemodel = this.model;
		int preX = shapemodel.getX();
		int preY = shapemodel.getY();
		int preEndX = shapemodel.getX() + shapemodel.getWidth();
		int preEndY = shapemodel.getY() +  + shapemodel.getHeight();
		int diffX = (preX - x);
		int diffY = (preY - y);
		moveShape(x,y);
		model.setWidth(model.getWidth() + diffX);
		model.setHeight(model.getHeight() + diffY);
	}
	
	public void dragAnchorTwo(int x, int y)
	{
		DShapeModel shapemodel = this.model;
		int preX, preY,diffX, diffY, originX;
		originX = shapemodel.getX();
		preX = shapemodel.getX() + shapemodel.getWidth();
		preY = shapemodel.getY();
		diffX = (x - preX);
		diffY = (preY - y);
		moveShape(originX,preY - diffY);
		model.setWidth(model.getWidth() + diffX);
		model.setHeight(model.getHeight() + diffY);
	}
	
	public void dragAnchorThree(int x, int y){
		DShapeModel shapemodel = this.model;
		int preX, preY,diffX, diffY, originY, originX;
		originX = shapemodel.getX();
		originY = shapemodel.getY();
		preX = shapemodel.getX();
		preY = originY + shapemodel.getHeight();
		diffX = (preX - x);
		diffY = (y - preY);
		moveShape(originX - diffX, originY);
		model.setWidth(shapemodel.getWidth() + diffX);
		model.setHeight(shapemodel.getHeight() + diffY);
	}
	
	public void dragAnchorFour(int x, int y)
	{
		DShapeModel shapemodel = this.model;
		int preX, preY,diffX, diffY,originY, originX;
		originX = shapemodel.getX();
		originY = shapemodel.getY();
		
		preX = originX + shapemodel.getWidth();
		preY = originY + shapemodel.getHeight();
		diffX = x - preX;
		diffY = y - preY;
		model.setWidth(model.getWidth() + diffX);
		model.setHeight(model.getHeight() + diffY);
	}
}
