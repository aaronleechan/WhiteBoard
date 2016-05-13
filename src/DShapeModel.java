import java.awt.Color;
import java.util.ArrayList;

// store a conceptual bounds rectangle define by 4 ints: x,y,width and height and a Color
public class DShapeModel {
	int x;
	int y;
	int width;
	int height;
	Color color;
	ArrayList<Object> modelList;
	
	public DShapeModel()
	{
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.color = color.GRAY;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public ArrayList<Object> getModelList(){
		return modelList;
	}
	
	public void setModelList(ArrayList<Object> modelList){
		this.modelList = modelList;
	}
	

}
