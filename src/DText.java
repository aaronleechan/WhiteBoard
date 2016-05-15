import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

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

        f = new Font("Dialog", Font.PLAIN, (int) size);
        FontMetrics fmc = g.getFontMetrics(f);
        g.setFont(f);
        computeFont(g);
        g.drawString(startText, dtModel.getX(), dtModel.getY() + dtModel.getHeight());

        super.paintComponent(g);
    }


    public void computeFont(Graphics g)
    {
        size = 1.0;
        FontMetrics fmc = g.getFontMetrics(f);
        while (fmc.getAscent() <= dtModel.getHeight())
        {
            size = (size * 1.10) + 1;
            f = new Font("Dialog", Font.PLAIN, (int) size);
            fmc = g.getFontMetrics(f);
        }
    }

	public Color getColor()
    {
        return this.dtModel.getColor();
	}
}
