import java.awt.Graphics;
import java.awt.*;

public class DLine extends DShape
{
    private DLineModel dlModel;

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
        int x1, y1, x2, y2;

        x1 = dlModel.getX();
        y1 = dlModel.getY();
        x2 = dlModel.getX2();
        y2 = dlModel.getY2();

        g.setColor(dlModel.getColor());
        g.drawLine(x1, y1, x2, y2);
        super.paintComponent(g);
    }

	public Color getColor()
    {
		return this.dlModel.getColor();
	}
}

