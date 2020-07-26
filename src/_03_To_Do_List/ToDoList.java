package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	String[] tasks;
	int taskNum=0;
	public static void main(String[] args) {
ToDoList tdl=new ToDoList();
tdl.run();
	}
	void run() {
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
			tasks[taskNum]=newTask;
			System.out.println(tasks[taskNum]);
			taskNum++;
		}
	}
}
