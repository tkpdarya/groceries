package com.tokopedia.programming.menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GroceriesMenu {
	
	private BufferedReader reader;

	public void setWelcomeScreen() {
		Map<String, String> item_store = new HashMap<String, String>();
		
		System.out.println("Welcome to ABC Groceries Store!");
		
		System.out.println("Maybe you want to buy something?");
		System.out.println("----------------");
		
		item_store = getFile();
		
		Iterator<Entry<String, String>> iterator = item_store.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry<String, String> mapElement = (Map.Entry<String, String>) iterator.next();
			System.out.println(mapElement.getKey() + ": $" + mapElement.getValue() + "/kg");
			
		}
		
	}
	
	public Map<String, String> getFile() {
		Map<String, String> item_list = new HashMap<String, String>();
		
		try {
			reader = new BufferedReader(new FileReader("groceries_file.csv"));
			String line;
			
			while ((line = reader.readLine()) != null) {
				String str[] = line.split(",");
				for (int i = 1; i < str.length; i++) {
					String arr[] = str[i].split(":");
					item_list.put(arr[0], arr[1]);
					
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return item_list;
		
	}

}
