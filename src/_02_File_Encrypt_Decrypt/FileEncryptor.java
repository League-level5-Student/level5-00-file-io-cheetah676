package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
	String encryptedMessage="";
	String message=JOptionPane.showInputDialog("Give me a secret message. No punctutation, capitals, or numbers are allowed");
	String stringKey=JOptionPane.showInputDialog("What is your shift key?");
	int key=Integer.parseInt(stringKey);
	char letterArray[]=new char [27];
	letterArray[0]=' ';
	letterArray[1]='a';
	letterArray[2]='b';
	letterArray[3]='c';
	letterArray[4]='d';
	letterArray[5]='e';
	letterArray[6]='f';
	letterArray[7]='g';
	letterArray[8]='h';
	letterArray[9]='i';
	letterArray[10]='j';
	letterArray[11]='k';
	letterArray[12]='l';
	letterArray[13]='m';
	letterArray[14]='n';
	letterArray[15]='o';
	letterArray[16]='p';
	letterArray[17]='q';
	letterArray[18]='r';
	letterArray[19]='s';
	letterArray[20]='t';
	letterArray[21]='u';
	letterArray[22]='v';
	letterArray[23]='w';
	letterArray[24]='x';
	letterArray[25]='y';
	letterArray[26]='z';
	System.out.println(message);
	System.out.println(key);
	for(int i=0; i<message.length(); i++) {
		for(int j=0; j<letterArray.length; j++) {
			if(message.charAt(i)==letterArray[j]) {
				if(j+key>26) {
					int extra=j+key-26;
					encryptedMessage+=letterArray[extra];
				}
				else {
				encryptedMessage+=letterArray[j+key];
				}
				break;
			}
		}
	}
	try {
		FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/EncryptedFile.txt");
		fw.write("\n" +encryptedMessage);
		System.out.println(encryptedMessage);
		fw.close();
		FileWriter fw2=new FileWriter("src/_02_File_Encrypt_Decrypt/Key.txt");
		String s=""+key;
		fw2.write(s);
		fw2.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}//Copyright © 2020 Jake Mordan