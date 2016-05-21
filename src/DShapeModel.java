import java.awt.*;
import java.util.ArrayList;

// store a conceptual bounds rectangle define by 4 ints: x,y,width and height and a Color
public class DShapeModel {
	private Rectangle bounds;
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private ArrayList<Object> modelList;

	
	public DShapeModel()
	{
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.color = color.GRAY;
		bounds = new Rectangle(x, y, width, height);
	}

	public int getX() {
		return bounds.x;
	}

	public void setX(int x) {
		bounds.x = x;
	}

	public int getY() {
		return bounds.y;
	}

	public void setY(int y) {
		bounds.y = y;
	}

	public int getWidth() {
		return bounds.width;
	}

	public void setWidth(int width) {
		bounds.width = width;
	}

	public int getHeight() {
		return bounds.height;
	}

	public void setHeight(int height) {
		bounds.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Rectangle getBounds() {
		return bounds.getBounds();
	}
	
	public ArrayList<Object> getModelList(){
		return modelList;
	}
	
	public void setModelList(ArrayList<Object> modelList){
		this.modelList = modelList;
	}
	

}
