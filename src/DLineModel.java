import java.awt.Color;

public class DLineModel extends DShapeModel{
	
	private int startingPoint;
	private int endingPoint;
	
	public DLineModel(){
		System.out.println(" come in DLine Model");
		startingPoint = 0;
		endingPoint = 0;
	}

	public int getstartingPoint() {
		return startingPoint;
	}

	public void setstartingPoint(int startingPoint) {
		this.startingPoint = startingPoint;
	}

	public int getendingPoint() {
		return endingPoint;
	}

	public void setendingPoint(int endingPoint) {
		this.endingPoint = endingPoint;
	}
	
	public int getWidth(){
		return 0;
	}
	
	public int getHeight(){
		return 0;
	}
	
	public double getSlope(){
		System.out.println("getendingPoint: " + getendingPoint() + ", getY(): " + getY() + 
							", getstartingPoint: " +  getstartingPoint() + ", getX: " + getX() );
		// find slope = endingPoint - y1 / startingPoint -x1
		// getX and getY get from DShapeModel
		double result = 0;
		result = ( ((double)getendingPoint() - (double)getY()) / ((double)getstartingPoint() - (double) getX()) );
		System.out.println(" RESULT : " + result);
		return result;
	}
	

}
