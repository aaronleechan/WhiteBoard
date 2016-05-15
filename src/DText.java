import java.awt.*;

public class DText extends DShape
{
    private Font f;
    private DTextModel dtModel;
    private double size;
    private String startText = "hello!";

    public DText()
    {
        this.dtModel = new DTextModel();
        super.setDshapemodel(this.dtModel);
        originalModel();
    }

    public void originalModel()
    {
        dtModel.setX(100);
        dtModel.setY(100);
        dtModel.setWidth(200);
        dtModel.setHeight(100);
    }

    public void paintComponent(Graphics g)
    {
        int x,y,w,h;
        x = dtModel.getX();
        y = dtModel.getY();
        w = dtModel.getWidth();
        h = dtModel.getHeight();
        g.setColor(dtModel.getColor());
        g.drawRect(x, y, w, h);
        super.paintComponent(g);

        computeFont(g); //TODO: is this how to use the graphics object from paintComponent??

        g.setFont(f);
        g.drawString(startText, dtModel.getX(), dtModel.getY() + dtModel.getHeight());
    }


    public void computeFont(Graphics g)
    {
        FontMetrics fmc = g.getFontMetrics(f); //TODO: still getting null pointer exception here

        size = 1.0;
        if (fmc.getHeight() < dtModel.getHeight())
        {
            size = (size * 1.10) + 1;
        }
        f = new Font("Dialog", Font.PLAIN, (int) size);
    }

	public Color getColor()
    {
        return this.dtModel.getColor();
	}
}
