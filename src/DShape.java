import java.awt.*;

public abstract class DShape {
	
	private DShapeModel dshapemodel;
	boolean choose = false;
	public int dimension = 30;
	
	
	
	public void paintComponent(Graphics g){
		System.out.println("COM E???");
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
		y3 = this.dshapemodel.getY() + dshapemodel.getHeight();
		
		g.setColor(Color.GRAY);
		// TODO Auto-generated method stub
		
		g.drawRect(x, y, dimension, dimension);
		g.fillRect(x, y, dimension, dimension);
		
		g.drawRect(x1, y1, dimension, dimension);
		g.fillRect(x1, y1, dimension, dimension);
		
		g.drawRect(x2, y2, dimension, dimension);
		g.fillRect(x2, y2, dimension, dimension);
		
		g.drawRect(x3, y3, dimension, dimension);
		g.fillRect(x3, y3, dimension, dimension);
	}



	public DShapeModel getDshapemodel() {
		return dshapemodel;
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
	

	

	

	
	
}
