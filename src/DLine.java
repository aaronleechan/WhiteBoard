import java.awt.Graphics;
import java.awt.*;

public class DLine extends DShape
{
    private DLineModel dlModel;
    private boolean selected = false;

    public DLine()
    {
        System.out.println("5");
        this.dlModel = new DLineModel();
        super.setDshapemodel(this.dlModel);
        originalModel();
    }

    public DLine(DLineModel model)
    {
        this.dlModel = model;
    }

    public void originalModel()
    {
        System.out.println(" 2 ");
        dlModel.setX(100);
        dlModel.setY(100);
        dlModel.setX2(200);
        dlModel.setY2(200);
    }

    public void paintComponent(Graphics g)
    {
    	System.out.println( " selected 5: point in Dline paintComponent");
        int x1, y1, x2, y2;

        x1 = dlModel.getX();
        y1 = dlModel.getY();
        x2 = dlModel.getX2();
        y2 = dlModel.getY2();

        g.setColor(dlModel.getColor());
        g.drawLine(x1, y1, x2, y2);
//        super.paintComponent(g);
        if(selected)drawKnobs(g);
    }
    
    public void drawKnobs(Graphics g){
    	int x1, x2,y1,y2;
    	x1 = dlModel.getX();
    	y1 = dlModel.getY();
    	x2 = dlModel.getX2();
    	y2 = dlModel.getY2();
    	
    	g.setColor(Color.BLACK);
    	// first
    	g.drawRect(x1-1, y1-1, 5, 5);
    	g.fillRect(x1-1, y1-1, 5, 5);
    	// second
    	g.drawRect(x2-1, y2-1, 5, 5);
    	g.fillRect(x2-1, y2-1, 5, 5);
    }

	public Color getColor()
    {
		
		return this.dlModel.getColor();
	}
	
	public boolean containsPoint(int x, int y){
		System.out.println("Check select 3: containsPoint in DLine");
		int y1; // starting point
		int y2; // ending point
		y1 = dlModel.getY();
		y2 = dlModel.getY2();
		System.out.println(" passed 3 " );
		// get the slope from dLineModel
		double slope = this.dlModel.getSlope();
		System.out.println("passed slope test");
		// y = mx + b
		// b = y - mx
		
		double b = (double)dlModel.getY() - slope * (double)dlModel.getX();
		System.out.println("y: " + y + ", slope: " + slope + ", x: " + x + ", b: " + b);

		
		if(y > (int)(slope*(double)x + b-30) && y < (int)(slope*(double)x+b+30)){
			if(y <= Math.max(y1, y2) && y >= Math.min(y1, y2)){
				this.selected=true;
				return true;
			}
		}
		this.selected = false;
		return false; 
	}
}

