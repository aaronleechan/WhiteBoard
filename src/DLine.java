import java.awt.Graphics;
import java.awt.*;

public class DLine extends DShape
{
    private DLineModel dlModel;
    private boolean selected = false;
    private Point p1;
    private Point p2;

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
        dlModel.setP1(new Point(100, 100));
        dlModel.setP2(new Point(200, 200));
//        dlModel.setX(100);
//        dlModel.setY(100);
//        dlModel.setX2(200);
//        dlModel.setY2(200);
    }

    public void paintComponent(Graphics g)
    {
    	System.out.println( " selected 5: point in Dline paintComponent");
        int x1, y1, x2, y2;

        p1 = dlModel.getP1();
        p2 = dlModel.getP2();

        x1 = (int) dlModel.getP1().getX();
        y1 = (int) dlModel.getP1().getY();
        x2 = (int) dlModel.getP2().getX();
        y2 = (int) dlModel.getP2().getY();

        g.setColor(dlModel.getColor());
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
//        super.paintComponent(g);
        if(selected)drawKnobs(g);
    }
    
    public void drawKnobs(Graphics g){
    	int x1, x2,y1,y2;
    	x1 = dlModel.getP1().x;
    	y1 = dlModel.getP1().y;
    	x2 = dlModel.getP2().x;
    	y2 = dlModel.getP2().y;
    	
    	g.setColor(Color.BLACK);
    	// first
    	g.drawRect(x1-1, y1-1, 9, 9);
    	g.fillRect(x1-1, y1-1, 9, 9);
    	// second
    	g.drawRect(x2-1, y2-1, 9, 9);
    	g.fillRect(x2-1, y2-1, 9, 9);
    }

	public Color getColor()
    {
		
		return this.dlModel.getColor();
	}
	
	public boolean containsPoint(int x, int y){
		System.out.println("Check select 3: containsPoint in DLine");
		int y1; // starting point
		int y2; // ending point
		y1 = dlModel.getP1().y;
		y2 = dlModel.getP2().y;
		System.out.println(" passed 3 " );
		// get the slope from dLineModel
		double slope = this.dlModel.getSlope();
		System.out.println("passed slope test");
		// y = mx + b
		// b = y - mx

		double b = (double)dlModel.getP1().y - slope * (double)dlModel.getP1().x;
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

    @Override
    public boolean isAnchorOne(int x, int y)
    {
        int xAxis = dlModel.getP1().x;  //model.getX();
        int yAxis = dlModel.getP2().y;
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
        int xAxis = dlModel.getP2().x;
        int yAxis = dlModel.getP2().y;
        if( x >= xAxis + dlModel.getWidth() - ANCHORSIZE && x <= xAxis + dlModel.getWidth() + ANCHORSIZE && y >= yAxis - ANCHORSIZE && y <= yAxis + ANCHORSIZE)
        {
            System.out.println("anchor2 pressed");
            return true;
        }
        else
            return false;
    }

    @Override
    public void dragAnchorOne(int x, int y)
    {
        int preX = dlModel.getP1().x;
        int preY = dlModel.getP1().y;
        int preEndX = dlModel.getP1().x + dlModel.getWidth();
        int preEndY = dlModel.getP1().y +  + dlModel.getHeight();
        int diffX = (preX - x);
        int diffY = (preY - y);
        moveShape(x,y);
        dlModel.setWidth(dlModel.getWidth() + diffX);
        dlModel.setHeight(dlModel.getHeight() + diffY);
    }

    @Override
    public void dragAnchorTwo(int x, int y)
    {
        int preX, preY,diffX, diffY, originX;
        originX = dlModel.getP2().x;
        preX = dlModel.getP2().x + dlModel.getWidth();
        preY = dlModel.getP2().y;
        diffX = (x - preX);
        diffY = (preY - y);
        moveShape(originX,preY - diffY);
        dlModel.setWidth(dlModel.getWidth() + diffX);
        dlModel.setHeight(dlModel.getHeight() + diffY);
    }

//    @Override
//    public void moveShapeTo(int x, int y) {
//        p1.x += x;
//        p1.y += y;
//        p2.x += x;
//        p2.y += y;
//
//        super.moveShapeTo(x, y);
//    }
}

