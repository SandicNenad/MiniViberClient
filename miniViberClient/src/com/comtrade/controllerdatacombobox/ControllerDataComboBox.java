package com.comtrade.controllerdatacombobox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.comtrade.constant.Constant;

public class ControllerDataComboBox {
	public static ControllerDataComboBox instance = null;
	private Map<String, List<String>> hmOfCountries = new TreeMap<>();
	
	public static ControllerDataComboBox getInstance() {
		if(instance == null) {
			instance = new ControllerDataComboBox();
		}
		return instance;
	}
	
	private ControllerDataComboBox() {
		readDataFromFile();
	}

	private void readDataFromFile() {
		File f = new File(Constant.COUNTRIESANDTOWNS);
		Scanner sc = null;
		try {
			sc = new Scanner(f);
			int max=0;
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] array = line.split(";");
				String key = null;
				List<String> value = new ArrayList<>();
				
				for (int i=0; i<array.length; i++) {
					if (array[i].length()>max) {
						max =array[i].length();
					}
					if (i==0) {
						key = array[i];
					}else {
						value.add(array[i]);
					}
				}
				
				hmOfCountries.put(key, value);
			}
			System.out.println(max+" je najveci broj karaktera");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}

	public Map<String, List<String>> getHmOfCountries() {
		return hmOfCountries;
	}
	
	
}
