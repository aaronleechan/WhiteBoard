import java.awt.*;

public abstract class DShape {
	
	private DShapeModel dshapemodel;
	boolean choose;
	static int ANCHORSIZE = 20;
	public abstract Color getColor();
	public int pointer = 10;
	
	
	
	public void paintComponent(Graphics g){
		System.out.println("COME???");
		// if true drawing
		if(choose) drawing(g);
	}



	private void drawing(Graphics g) {
		int x,y;
		int x1, y1;
		int x2, y2;
		int x3, y3;
		
		x = this.dshapemodel.getX();
		y = this.dshapemodel.getY();
		
		x1 = this.dshapemodel.getX();
		y1 = this.dshapemodel.getY() + dshapemodel.getHeight();
		
		x2 = this.dshapemodel.getX() + dshapemodel.getWidth();
		y2 = this.dshapemodel.getY();
		
		x3 = this.dshapemodel.getX() + dshapemodel.getWidth();
		y3 = dshapemodel.getY() + dshapemodel.getHeight();
		
		g.setColor(Color.BLACK);
		// TODO Auto-generated method stub
		
		g.drawRect(x-5, y-5, pointer, pointer);
		g.fillRect(x-5, y-5, pointer, pointer);
		
		g.drawRect(x1-5, y1-5, pointer, pointer);
		g.fillRect(x1-5, y1-5, pointer, pointer);
		
		g.drawRect(x2-5, y2-5, pointer, pointer);
		g.fillRect(x2-5, y2-5, pointer, pointer);
		
		g.drawRect(x3-5, y3-5, pointer, pointer);
		g.fillRect(x3-5, y3-5, pointer, pointer);
	}



	public DShapeModel getDshapemodel() {
		return dshapemodel;
	}
	
	public boolean isSelected(){
		return this.choose;
	}
	
	public void setSelected(Boolean b)
	{
		this.choose = b;
	}



	public void setDshapemodel(DShapeModel dshapemodel) {
		this.dshapemodel = dshapemodel;
	}



	public boolean isChoose() {
		return choose;
	}



	public void setChoose(boolean choose) {
		this.choose = choose;
	}
	
	public void moveShape(int x, int y){
		dshapemodel.setX(x);
		dshapemodel.setY(y);
	}
	
	public void moveShapeTo(int x, int y){
		dshapemodel.setX( x - dshapemodel.getWidth() /2);
		dshapemodel.setY( y - dshapemodel.getHeight()/ 2);
	}
	
	public int isAnchorChosen(int x, int y){
		if(isAnchorOne(x,y)){
			System.out.println("Firt");
			return 1;
		}else if(isAnchorTwo(x,y)){
			System.out.println("Second");
			return 2;
		}else if(isAnchorThree(x,y)){
			System.out.println("Three");
			return 3;
		}else if(isAnchorFour(x,y)){
			System.out.println("Four");
			return 4;
		}
		return 0;
	}
	
	public boolean isAnchorOne(int x, int y){
		int xAxis = dshapemodel.getX();
		int yAxis = dshapemodel.getY();
		if( x >= xAxis - ANCHORSIZE && x <= xAxis + ANCHORSIZE && y >= yAxis - ANCHORSIZE && y <= yAxis + ANCHORSIZE)
			return true;
		else
			return false;
	}
	public boolean isAnchorTwo(int x, int y){
		int xAxis = dshapemodel.getX();
		int yAxis = dshapemodel.getY();
		if( x >= xAxis - ANCHORSIZE && x <= xAxis + ANCHORSIZE && y >= yAxis - ANCHORSIZE && y <= yAxis + ANCHORSIZE)
			return true;
		else
			return false;
	}
	public boolean isAnchorThree(int x, int y){
		int xAxis = dshapemodel.getX();
		int yAxis = dshapemodel.getY();
		if( x >= xAxis - ANCHORSIZE && x <= xAxis + ANCHORSIZE && y >= yAxis - ANCHORSIZE && y <= yAxis + ANCHORSIZE)
			return true;
		else
			return false;
	}
	public boolean isAnchorFour(int x, int y){
		int xAxis = dshapemodel.getX();
		int yAxis = dshapemodel.getY();
		if( x >= xAxis - ANCHORSIZE && x <= xAxis + ANCHORSIZE && y >= yAxis - ANCHORSIZE && y <= yAxis + ANCHORSIZE)
			return true;
		else
			return false;
	}



	public boolean containsPoint(int x, int y) {
		DShapeModel model = this.dshapemodel;
		if(model != null){
			int h = model.getHeight();
			int w = model.getWidth();
			if(x>=model.getX() && x <= model.getX() + w && y>= model.getY() && y <= model.getY() + h){
				this.setSelected(true);
				return true;
			}
			this.setSelected(false);
		}
		// TODO Auto-generated method stub
		return false;
	}
	private void setSelected(boolean b) {
		this.choose= b;
		// TODO Auto-generated method stub
		
	}
	
	public void dragAnchorOne(int x, int y){
		System.out.println("drag one");
		DShapeModel shapemodel = this.dshapemodel;
		int preX, preY,diffX, diffY;
		preX = shapemodel.getX();
		preY = shapemodel.getY();
		diffX = (preX - x);
		diffY = (preY - y);
		moveShape(x,y);
		dshapemodel.setWidth(dshapemodel.getWidth() + diffX);
		dshapemodel.setHeight(dshapemodel.getHeight() + diffY);
	}
	public void dragAnchorTwo(int x, int y){
		System.out.println("drag two");
		DShapeModel shapemodel = this.dshapemodel;
		int preX, preY,diffX, diffY, originX;
		originX = shapemodel.getX();
		preX = shapemodel.getX() + shapemodel.getWidth();
		preY = shapemodel.getY();
		diffX = (x - preX);
		diffY = (preY - y);
		moveShape(originX,preY - diffY);
		dshapemodel.setWidth(dshapemodel.getWidth() + diffX);
		dshapemodel.setHeight(dshapemodel.getHeight() + diffY);
	}
	public void dragAnchorThree(int x, int y){
		System.out.println("drag three");
		DShapeModel shapemodel = this.dshapemodel;
		int preX, preY,diffX, diffY, originY, originX;
		originX = shapemodel.getX();
		originY = shapemodel.getY();
		preX = shapemodel.getX();
		preY = originY + shapemodel.getHeight();
		diffX = (preX - x);
		diffY = (y - preY);
		moveShape(originX - diffX, originY);
		dshapemodel.setWidth(shapemodel.getWidth() + diffX);
		dshapemodel.setHeight(shapemodel.getHeight() + diffY);
	}
	public void dragAnchorFour(int x, int y){
		System.out.println("drag four");
		DShapeModel shapemodel = this.dshapemodel;
		int preX, preY,diffX, diffY,originY, originX;
		originX = shapemodel.getX();
		originY = shapemodel.getY();
		
		preX = originX + shapemodel.getWidth();
		preY = originY + shapemodel.getHeight();
		diffX = x - preX;
		diffY = y - preY;
		moveShape(x,y);
		dshapemodel.setWidth(dshapemodel.getWidth() + diffX);
		dshapemodel.setHeight(dshapemodel.getHeight() + diffY);
	}
	

	

	

	
	
}
