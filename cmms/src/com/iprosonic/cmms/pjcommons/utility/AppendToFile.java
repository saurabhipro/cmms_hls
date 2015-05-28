package com.iprosonic.cmms.pjcommons.utility;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class AppendToFile {
	public static void main(String[] args) {
		try {
			String data = " This content will append to the end of the file";

			File file = new File("log.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				
				file.createNewFile();
			}

			// true = append file
			
			FileWriter fileWritter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.close();
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}