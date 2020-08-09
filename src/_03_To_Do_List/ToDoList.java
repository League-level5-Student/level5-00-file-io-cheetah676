package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton button1=new JButton();
	JButton button2=new JButton();
	JButton button3=new JButton();
	JButton button4=new JButton();
	JButton button5=new JButton();
	ArrayList<String> tasks=new ArrayList<String>();
	public static void main(String[] args) {
ToDoList tdl=new ToDoList();
tdl.run();
	}
	void run() {
		try {
			BufferedReader br=new BufferedReader(new FileReader("src/_03_To_Do_List/ToDoListSaveFile.txt"));
			String line = br.readLine();
			while(line != null){
			tasks.add(line);	
			line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}
		button1.setText("Add task");
		button1.addActionListener(this);
		button2.setText("View tasks");
		button2.addActionListener(this);
		button3.setText("Remove task");
		button3.addActionListener(this);
		button4.setText("Save list");
		button4.addActionListener(this);
		button5.setText("Load List");
		button5.addActionListener(this);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==button1) {
			String newTask=JOptionPane.showInputDialog(null, "What task would you like to add?");
			tasks.add(newTask);
		}
		if(arg0.getSource()==button2) {
			String taskString="";
			for(int i=0; i<tasks.size(); i++) {
				taskString+=tasks.get(i)+"\n";
			}
			JOptionPane.showMessageDialog(null, taskString);
		}
		if(arg0.getSource()==button3) {
			String removeTask=JOptionPane.showInputDialog("Which task would you like to remove?");
			for(int i=0; i<tasks.size(); i++) {
				if(tasks.get(i).equals(removeTask)) {
					tasks.remove(i);
					System.out.println("Task removed");
				}
			}
		}
		if(arg0.getSource()==button4) {
			try {
				String taskString="";
				for(int i=0; i<tasks.size(); i++) {
					taskString+=tasks.get(i)+"\n";
				}
				FileWriter fw=new FileWriter("src/_03_To_Do_List/ToDoListSaveFile.txt");
				fw.write(taskString);
				fw.close();
				System.out.println(taskString);
				System.out.println("List saved");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(arg0.getSource()==button5) {
			String location=JOptionPane.showInputDialog("What file do you want to load from?");
			for(int i=tasks.size()-1; i>=0; i--) {
				tasks.remove(i);
			}
			try {
				BufferedReader br=new BufferedReader(new FileReader(location));
				String line = br.readLine();
				while(line != null){
				tasks.add(line);	
				line = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found");
			}
		}
	}
}//Copyright © 2020 Jake Mordan