import java.awt.*;
import javax.swing.border.AbstractBorder;

public class triFrame extends AbstractBorder{
	
	private static final int THICKNESS = 2;
	
	triFrame()
    {
        super();
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) 
    {
    	Graphics2D g2 = (Graphics2D)g.create();

    //	g2.drawRoundRect(THICKNESS, THICKNESS, width - THICKNESS - 2, height - THICKNESS - 2, 10000, 10000);
        g2.drawPolygon(new int[] {50,100,0}, new int[] {0,85,85}, 3);
        
    }

    @Override
    public Insets getBorderInsets(Component c) 
    {
        return new Insets(THICKNESS, THICKNESS, THICKNESS, THICKNESS);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) 
    {
        insets.left = insets.top = insets.right = insets.bottom = THICKNESS;
        return insets;
    }
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}