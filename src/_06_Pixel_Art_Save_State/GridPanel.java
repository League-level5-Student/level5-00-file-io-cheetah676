package _06_Pixel_Art_Save_State;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JPanel;

public class GridPanel extends JPanel implements Serializable{

	final long serialVersionUID = 1L;
	static int windowWidth;
	static int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	static int rows;
	static int cols;
	GridPanel gridPanelLoadVar=_06_Pixel_Art_Save_State.PixelArtMaker.load1();
	//1. Create a 2D array of pixels. Do not initialize it yet.
	Pixel[][] array;
	Color color;
	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;
		
		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;
		
		color = Color.BLACK;
		
		setPreferredSize(new Dimension(windowWidth, windowHeight));
		
		//2. Initialize the pixel array using the rows and cols variables.
	array=new Pixel[rows][cols];
		
		//3. Iterate through the array and initialize each element to a new pixel.
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j]=new Pixel(i, j);
			}
		}
		}
	
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void clickPixel(int mouseX, int mouseY) {
		//5. Use the mouseX and mouseY variables to change the color
		//   of the pixel that was clicked. *HINT* Use the pixel's dimensions.
		int pixelX=mouseX/pixelWidth;
		int pixelY=mouseY/pixelHeight;
		array[pixelX][pixelY].color=(color);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//4. Iterate through the array.
		//   For every pixel in the list, fill in a rectangle using the pixel's color.
		//   Then, use drawRect to add a grid pattern to your display.
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				g.setColor(array[i][j].color);
				g.fillRect(i*pixelWidth, j*pixelHeight, pixelWidth, pixelHeight);
				g.setColor(Color.BLACK);
				g.drawRect(i*pixelWidth, j*pixelHeight, pixelWidth, pixelHeight);
			}
		}
	}
	public void loadGridPanel(){
		this.windowWidth = gridPanelLoadVar.windowWidth;
		this.windowHeight = gridPanelLoadVar.windowHeight;
		this.rows = gridPanelLoadVar.rows;
		this.cols = gridPanelLoadVar.cols;
		
		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;
		
		color = Color.BLACK;
		
		setPreferredSize(new Dimension(windowWidth, windowHeight));
		
		//2. Initialize the pixel array using the rows and cols variables.
	array=new Pixel[rows][cols];
		
		//3. Iterate through the array and initialize each element to a new pixel.
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j]=new Pixel(i, j);
				array[i][j].color=(gridPanelLoadVar.array[i][j].color);
			}
		}
	}
}
