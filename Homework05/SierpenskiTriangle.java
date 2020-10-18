/*
 * Homework05: Sierpenski's Triangle
 * Written by Warren Beagle
 */
import java.applet.*;
import java.awt.*;
import java.util.*;
public class SierpenskiTriangle extends Applet{
	//Instance variables
	private Image display;
	private Graphics drawingArea;
	public static final int PIXEL = 8;
	//Init method
	public void init()
	{
		//Get the height and width
		int height = getSize().height;
		int width = getSize().width;
		//Create the display and drawing area
		display = createImage(width, height);
		drawingArea = display.getGraphics();
		
		//Call recursive method
		drawFilledTriangle(0, 0, width, drawingArea, Color.BLACK); //Draws the first filled triangle in black
		drawGasket(0, 0, width, drawingArea, Color.WHITE); //Draws the smaller triangles in white
	}
	//Paint method
	public void paint(Graphics g)
	{
		g.drawImage(display, 0, 0, null);
	}
	//Recursive method to draw
	public void drawGasket(int x, int y, int side, Graphics g, Color aColor)
	{
		int sub = side / 2; //Subdivides the drawing area
		//Draw triangle
		g.setColor(aColor); //Sets the color
		drawSmallerTriangles(x, y, side, g); //Recursive call to draw the smaller triangles 
		//Draw the triangles smaller
		if(sub >= PIXEL)
		{
			//Recursive methods to draw
			drawGasket(x + sub / 2, y, sub, g, aColor); //Middle
			drawGasket(x, y + sub, sub, g, aColor); //Left
			drawGasket(x + sub, y + sub, sub, g, aColor); //Right
		}
	}
	//Method to draw the first filled triangle 
	private static void drawFilledTriangle(int x, int y, int side, Graphics g, Color aColor)
	{
		//Sets the x and y points 
		int[] xS = {x + side / 2, x + side, x, x + side / 2};
		int[] yS = {y, y + side, y + side, y};
		g.setColor(Color.BLACK); //Sets the color to black
		g.fillPolygon(xS, yS, 4); //Fills the developed polygon using the points and the color
	}
	//Method to draw the smaller filled triangles
	private static void drawSmallerTriangles(int x, int y, int side, Graphics g)
	{
		//Sets the x and y points
		int[] xS = {x + side / 4, x + side * 3 / 4, x + side / 2, x + side / 4};
		int[] yS = {y + side / 2, y + side / 2, y + side, y + side / 2};
		g.setColor(Color.WHITE); //Sets the color to white
		g.fillPolygon(xS, yS, 4); //Fills the developed polygon using the points and the color
	}
}
