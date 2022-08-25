package com.tokopedia.programming.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.tokopedia.programming.shop.ShopEntity;

public class GroceriesTest {
	
	@Test
	public void testPrintGroceries() {
		
		
	}
	
	@Test
	public void testGroceries()	{
		Map<String, Integer> input_test = new HashMap<String, Integer>();
		input_test.put("Carrot", 1);
		ShopEntity shop = new ShopEntity();
		assertEquals(1.8, shop.setCheckout(input_test, "cash", true));
	}

}
