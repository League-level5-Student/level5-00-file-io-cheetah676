package _06_Pixel_Art_Save_State;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

import _05_Serialization.SaveData;

public class PixelArtMaker implements MouseListener, ActionListener{
	private static final String DATA_FILE = "src/_06_Pixel_Art_Save_State/saved.dat";
	private JFrame window;
	private GridInputPanel gip;
	private GridPanel gp;
	private JButton saveButton;
	private JButton loadButton;
	ColorSelectionPanel csp;
	
	public void start() {
		gip = new GridInputPanel(this);	
		window = new JFrame("Pixel Art");
		saveButton=new JButton("Save Button");
		loadButton=new JButton("Load Button");
		window.setLayout(new FlowLayout());
		window.setResizable(false);
		
		window.add(gip);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public void submitGridData(int w, int h, int r, int c) {
		//gp = new GridPanel(w, h, r, c);
		gp=load1();
		csp = new ColorSelectionPanel();
		csp.add(saveButton);
		saveButton.addActionListener(this);
		csp.add(loadButton);
		loadButton.addActionListener(this);
		window.remove(gip);
		window.add(gp);
		window.add(csp);
		gp.repaint();
		gp.addMouseListener(this);
		window.pack();
	}
	
	public static void main(String[] args) {
		new PixelArtMaker().start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gp.setColor(csp.getSelectedColor());
		System.out.println(csp.getSelectedColor());
		gp.clickPixel(e.getX(), e.getY());
		gp.repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//gp.setColor(csp.getSelectedColor());
		//System.out.println(csp.getSelectedColor());
		//gp.clickPixel(e.getX(), e.getY());
		//gp.repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==saveButton) {
			save1(gp);
		}
		if(e.getSource()==loadButton) {
			window.remove(gp);
			window.remove(csp);
			gp=load1();
			csp = new ColorSelectionPanel();
			csp.add(saveButton);
			saveButton.addActionListener(this);
			csp.add(loadButton);
			loadButton.addActionListener(this);
			window.remove(gip);
			window.add(gp);
			window.add(csp);
			gp.repaint();
			gp.addMouseListener(this);
			window.pack();
		}
	}
	private static void save1(GridPanel gridPanel) {
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE)); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(gridPanel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static GridPanel load1() {
		try (FileInputStream fis = new FileInputStream(new File(DATA_FILE)); ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (GridPanel) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			return null;
		}
	}
}
