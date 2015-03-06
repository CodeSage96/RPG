package com.sage.rpg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Saving {
	
	public static String SAVE_0 = System.getProperty("user.home") + "\\save0.properties";
	public static String SAVE_1 = System.getProperty("user.home") + "\\save1.properties";
	public static String SAVE_2 = System.getProperty("user.home") + "\\save2.properties";
	
	public static String currentSave;
	
	public static void saveKey(String saveFile, String key, String value) {
		
		Properties props = new Properties();
		
		try {
			
			props.load(new FileInputStream(saveFile));
			props.setProperty(key, value);
			
			File file = new File(saveFile);
			FileOutputStream output = new FileOutputStream(file);
			
			props.store(output, null);
			
			output.close();
				
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static String loadKey(String saveFile, String key) {
		
		Properties props = new Properties();
			
		try {
			
			FileInputStream saveFileLocation = new FileInputStream(saveFile);
			
			props.load(saveFileLocation);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return props.getProperty(key);
	}
	
	public static boolean available(String saveFile) {
		
		Properties props = new Properties();
		
		try {
			
			File file = new File(saveFile);
			
			if (!file.isFile()) {
				
				file.createNewFile();
			}
			
			FileInputStream saveFileLocation = new FileInputStream(saveFile);
			
			props.load(saveFileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (props.size() > 0)
			return false;
		else
			return true;
	}
	
	public static void deleteSave(String saveFile) {
		
		Properties props = new Properties();
		
		try {
			
			FileInputStream saveFileLocation = new FileInputStream(saveFile);
			
			props.load(saveFileLocation);
			props.clear();
			
			File file = new File(saveFile);
			FileOutputStream output = new FileOutputStream(file);
			
			props.store(output, null);
			
			output.close();
				
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
