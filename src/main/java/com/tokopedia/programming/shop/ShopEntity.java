package com.tokopedia.programming.shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.tokopedia.programming.menu.GroceriesMenu;

public class ShopEntity {
	
	Scanner input_scanner = new Scanner(System.in);
	
	public void setCustomerInput() {
		Map<String, Integer> shop_cart = new HashMap<String, Integer>();
		String payment_method = "";
		String item_to_buy = "";
		String member_confirmation = "";
		String shop_confirmation = "";
		int total_item_to_buy = 0;
		boolean shop_action = true;
		boolean member_status = false;
		
		System.out.print("Are you a member? (Yes/No)");
		member_confirmation = input_scanner.next();
		
		if(member_confirmation.equals("Yes"))	{
			member_status = true;
		}
		
		while (shop_action == true) {
			
			System.out.print("Please select your item");
			item_to_buy = input_scanner.next();
			
			System.out.print("Please add total item: (ex: 1, 2, 3)");
			total_item_to_buy = input_scanner.nextInt();
			
			System.out.print("Add more item? (Yes/No)");
			shop_confirmation = input_scanner.next();
			
			shop_cart.put(item_to_buy, total_item_to_buy);
			
			if (shop_confirmation.equals("No")) {
				shop_action = false;
			}
			
		}
		
		System.out.print("Please choose payment method (cash/cc)");
		payment_method = input_scanner.next();
		
		// final confirmation for membership
		if(member_status == false)	{
			System.out.println("You are not a member. Become a member? (Yes/No)");
			System.out.print("Member will get lifetime discount and offer just for $100");
			member_confirmation = input_scanner.next();
			
			if(member_confirmation.equals("Yes"))	{
				member_status = true;
			}
			
		}
		
		setCheckout(shop_cart, payment_method, member_status);
		
	}

	public double setCheckout(Map<String, Integer> shop_cart, String payment_method, boolean member_status) {
		Map<String, String> store_item = new HashMap<String, String>();
		String membership_prompt = "";
		GroceriesMenu menu = new GroceriesMenu();
		double total_payment = 0;
		
		store_item = menu.getFile();
		
		Iterator<Entry<String, Integer>> iterator = shop_cart.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> mapElement = (Map.Entry<String, Integer>) iterator.next();
			System.out.println(mapElement.getKey() + " - " + mapElement.getValue() + " -> total: " + Integer.parseInt(store_item.get(mapElement.getKey())) * mapElement.getValue());
			total_payment = total_payment + Integer.parseInt(store_item.get(mapElement.getKey())) * mapElement.getValue();
		}
		
		if(member_status == false)	{
			System.out.print("Want to get new membership? Only $100! (Yes/No)");
			membership_prompt = input_scanner.next();
			if(membership_prompt.equals("Yes"))	{
				total_payment = total_payment + 100;
				member_status = true;
			}
		}
		
		if(member_status == true)	{
			total_payment = total_payment * 0.9;
		}
		
		if(total_payment > 100)	{
			total_payment = total_payment - 10;
		}
		
		if(payment_method.equals("cc"))	{
			total_payment = total_payment * 1.2;
		}
		
		System.out.println("Shop total: " + total_payment);
		
		
		return total_payment;
		
	}

}
