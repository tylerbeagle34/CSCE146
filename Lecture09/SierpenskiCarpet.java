import java.applet.*;
import java.awt.*;
import java.util.*;
public class SierpenskiCarpet extends Applet{
	private Image display;
	private Graphics drawingArea;
	
	public void init()
	{
		int height = getSize().height;
		int width = getSize().width;
		
		display = createImage(width, height);
		drawingArea = display.getGraphics();
		//Draw the thing
		drawGasket(0, 0, width, drawingArea);
	}
	public void paint(Graphics g)
	{
		g.drawImage(display, 0, 0, null);
	}
	public static void drawGasket(int x, int y, int side, Graphics g)
	{
		int sub = side / 3;
		g.fillRect(x + sub, y + sub, sub, sub);
		if(sub >= 3)
		{
			//Top squares
			drawGasket(x, y, sub, g); //Left
			drawGasket(x + sub, y, sub, g); //Middle
			drawGasket(x + sub * 2, y, sub, g); //Right
			//Middle squares
			drawGasket(x, y + sub, sub, g); //Left
			drawGasket(x + sub * 2, y + sub, sub, g); //Right
			//Bottom Squares
			drawGasket(x, y + sub * 2, sub, g); //Left
			drawGasket(x + sub, y + sub * 2, sub, g); //Middle
			drawGasket(x + sub * 2, y + sub * 2, sub, g); //Right
		}
	}
}
