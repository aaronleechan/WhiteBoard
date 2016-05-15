import java.awt.*;
import java.util.ArrayList;

// store a conceptual bounds rectangle define by 4 ints: x,y,width and height and a Color
public class DShapeModel {
	private Rectangle r;
	private int x;
	private int y;
	private int width;
	private int height;
	private int x2;
	private int y2;
	private Color color;
	private ArrayList<Object> modelList;

	
	public DShapeModel()
	{
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.x2 = 0;
		this.y2 = 0;
		this.color = color.GRAY;
		r = new Rectangle(x, y, width, height);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Rectangle getTheBounds() {
		return r.getBounds();
	}
	
	public ArrayList<Object> getModelList(){
		return modelList;
	}
	
	public void setModelList(ArrayList<Object> modelList){
		this.modelList = modelList;
	}
	

}
