package _06_Pixel_Art_Save_State;

import java.awt.Color;
import java.io.Serializable;

public class Pixel{
	public static int x;
	public static int y;
	public Color color;
	
	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;
		color = Color.WHITE;
	}
}
