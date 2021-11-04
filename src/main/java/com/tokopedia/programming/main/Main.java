package com.tokopedia.programming.main;

import com.tokopedia.programming.menu.GroceriesMenu;
import com.tokopedia.programming.shop.ShopEntity;


/*
 * Created by: Arya
 * SlackID: arya_prmn
 * 
 * 
 * 
 * */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GroceriesMenu menu = new GroceriesMenu();
		ShopEntity shop = new ShopEntity();
		
		menu.setWelcomeScreen();
		
		shop.setCustomerInput();
		

	}

}
