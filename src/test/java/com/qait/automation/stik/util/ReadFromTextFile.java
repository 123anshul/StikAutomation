package com.qait.automation.stik.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
 
public class ReadFromTextFile {
	String filePath="data/DirectoryData.txt";
			
	public ReadFromTextFile(String filePath) {
		this.filePath = filePath;
	}

	public String[][] storeValuesInArray() {
		BufferedReader br = null;
		String[][] array = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(filePath));
			
			int rows=0;
			while ((sCurrentLine = br.readLine()) != null) { rows++;}
			br.close();
			
			br  = new BufferedReader(new FileReader(filePath));
			array = new String[rows][5];
			int i=0;
			
			while ((sCurrentLine = br.readLine()) != null) {
				String[] dataArray = sCurrentLine.split("\\|");
				for(int j=0 ;j<dataArray.length;j++){
					array[i][j] = dataArray[j];
				}
				for(int k=dataArray.length;k<=3;k++)
					array[i][k] = "";
				i++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return array;
	}
}