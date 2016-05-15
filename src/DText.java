import java.awt.*;

public class DText extends DShape
{
    private Font f;
    private DTextModel dtModel;
    private double size;
    private String theMessage = "hello!";
    private String fontName = "Dialog";

    public DText()
    {
        this.dtModel = new DTextModel();
        super.setDshapemodel(this.dtModel);
        fontName = "Dialog";
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

        g.drawRect(x, y, w, h);
//        f = new Font(fontName, Font.PLAIN, (int) size);
        f = computeFont(g);
        computeFont(g);
        g.setFont(f);
        g.setColor(dtModel.getColor());
        Shape clip = g.getClip();
//        g.setClip(clip.getBounds().intersection(dtModel.getTheBounds()));


//        g.drawRect(x, y, w, h);

//        f = new Font(fontName, Font.PLAIN, (int) size);
//        g.setFont(f);
//        computeFont(g);
        g.drawString(theMessage, dtModel.getX(), dtModel.getY() + dtModel.getHeight());
//        g.setClip(clip);
        super.paintComponent(g);


    }


    public Font computeFont(Graphics g)
    {
        size = 1.0;
        double prevSize = 1.0;
        f = new Font(getFontName(), Font.PLAIN, (int) size);
        FontMetrics fmc = g.getFontMetrics(f);
        while (fmc.getAscent() <= dtModel.getHeight())
        {
            prevSize = size;
            size = (size * 1.10) + 1;
            f = new Font(getFontName(), Font.PLAIN, (int) size);
            fmc = g.getFontMetrics(f);
        }
        return f;
    }

	public Color getColor()
    {
        return this.dtModel.getColor();
	}

    public String getFontName() {
        return fontName;
    }

    public String getMessage() {
        return theMessage;
    }

    public void setMessage(String newMessage) {
        theMessage = newMessage;
    }

    public void setFontName(String fName) {
        fontName = fName;
    }

    public void setFont(String fName) {
        dtModel.setFontName(fName);
    }
}
