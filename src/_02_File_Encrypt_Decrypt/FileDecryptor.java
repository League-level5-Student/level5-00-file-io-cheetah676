package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[]args) {
		try {
			FileReader fr = new FileReader(("src/_02_File_Encrypt_Decrypt/EncryptedFile.txt"));
			int ch =fr.read();
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
			FileReader fR=new FileReader(("src/_02_File_Encrypt_Decrypt/Key.txt"));
			
			
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
