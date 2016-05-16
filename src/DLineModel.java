import java.awt.*;

public class DLineModel extends DShapeModel{

	private Point p1;
	private Point p2;
	
	public DLineModel(){
		System.out.println(" come in DLine Model");
		p1 = new Point(0, 0);
		p2 = new Point(0, 0);
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point thePoint) {
		p1 = new Point(thePoint);
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point thePoint) {
		p2 = new Point(thePoint);
	}

	public int getWidth(){
		return Math.abs(p1.x - p2.x);
	}
	
	public int getHeight(){
		return Math.abs(p1.y - p2.y);
	}
	
	public double getSlope(){
		System.out.println("getendingPoint: " + getP2() + ", getY(): " + getY() +
							", getstartingPoint: " +  getP1() + ", getX: " + getX() );
		// find slope = endingPoint - y1 / startingPoint -x1
		// getX and getY get from DShapeModel
		double result = 0;
		result = (getP2().y - getP1().y) / (getP2().x - getP1().x);
		System.out.println(" RESULT : " + result);
		return result;
	}

}
