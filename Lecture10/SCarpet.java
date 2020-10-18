import java.applet.*;
import java.awt.*;
import java.util.*;
public class SCarpet extends Applet {
	private Image display; //It's sort of the window
	private Graphics drawingArea; //Tools to draw the window
	
	public void init()
	{
		int height = getSize().height;
		int width = getSize().width;
		
		display = createImage(width, height);
		drawingArea = display.getGraphics();
		
		//TODO call the recursive method
		drawGasket(0, 0, width, drawingArea);
	}
	public void paint(Graphics g)
	{
		g.drawImage(display, 0, 0, null);
	}
	public static void drawGasket(int x, int y, int side, Graphics g)
	{
		int sub = side / 3;
		g.drawRect(x + sub, y + sub, sub, sub); //Draw the square
		if(sub >= 3)
		{
			//Top squares
			drawGasket(x, y, sub, g); //Left
			drawGasket(x + sub, y, sub, g); //Middle
			drawGasket(x + 2 * sub, y, sub, g); //Right
			//Middle squares
			drawGasket(x, y + sub, sub, g); //Left
			drawGasket(x + 2 * sub, y + sub, sub, g); //Right
			//Bottom squares
			drawGasket(x, y + 2 * sub, sub, g); //Left
			drawGasket(x + sub, y + 2 * sub, sub, g); //Middle
			drawGasket(x + 2 * sub, y + 2 * sub, sub, g); //Right
		}
	}
}
