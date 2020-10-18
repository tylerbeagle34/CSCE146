import java.applet.*;
import java.awt.*;
import java.util.*;
public class RandomFractal extends Applet{
	private Image display;
	private Graphics drawingArea;
	
	public void init()
	{
		int height = getSize().height;
		int width = getSize().width;
		
		display = createImage(width, height); //Creates the display
		drawingArea = display.getGraphics();
		//Call random fractal
		randomFractal(0, height / 2, width, height / 2, drawingArea);
	}
	public void paint(Graphics g)
	{
		g.drawImage(display, 0, 0, null);
	}
	public static final int STOP = 4; //Stop at 4 pixels
	public static final int MAX_Y = 12;
	public static void randomFractal(int leftX, int leftY, int rightX, int rightY, Graphics drawingArea)
	{
		Random r = new Random();
		int midX;
		int midY;
		int delta;
		if((rightX - leftX) <= STOP) //Reached pixel limit
		{
			//Draws the line
			drawingArea.drawLine(leftX, leftY, rightX, rightY);
		}
		else //Subdivide the line
		{
			midX = (leftX + rightX) / 2;
			midY = (leftY + rightY) / 2;
			delta = r.nextInt(MAX_Y);
			midY += delta;
			//Left part
			randomFractal(leftX, leftY, midX, midY, drawingArea);
			//Right part
			randomFractal(midX, midY, rightX, rightY, drawingArea);
		}
	}
}
