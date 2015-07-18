package com.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.basket.Basket;
import com.model.goods.Book;
import com.model.goods.ChocolateBar;
import com.model.goods.ChocolateBox;
import com.model.goods.MusicCd;
import com.model.goods.Perfume;
import com.model.goods.PillHeadache;
import com.model.goods.Product;
import com.controller.tax.SalesTaxesController;

public class Test {
	private static SalesTaxesController stb = new SalesTaxesController();
	
	public static void main(String[] args)
	{
		
		//input 1
		Product oneBasket1 = new Book("book", false,1, new BigDecimal("12.49"));
		Product twoBasket1 = new MusicCd("Music CD", false, 1, new BigDecimal("14.99"));
		Product threeBasket1 = new ChocolateBar("chocolate bar", false, 1, new BigDecimal("0.85"));
		List<Product> listInput1 = new ArrayList<Product>();
		listInput1.add(oneBasket1);
		listInput1.add(twoBasket1);
		listInput1.add(threeBasket1);
		Basket basket1 = processInput(listInput1);
		
		//input 2
		Product oneBasket2 = new ChocolateBox("imported box of chocolate", true, 1, new BigDecimal("10.00"));
		Product twoBasket2 = new Perfume("imported bottle of perfume", true, 1, new BigDecimal("47.50"));
		List<Product> listInput2 = new ArrayList<Product>();
		listInput2.add(oneBasket2);
		listInput2.add(twoBasket2);
		Basket basket2 =processInput(listInput2);
		
		
		//input 3
		Product oneBasket3 = new Perfume("imported bottle of perfume", true, 1, new BigDecimal("27.99"));
		Product twoBasket3 = new Perfume("bottle of perfume", false, 1, new BigDecimal("18.99"));
		Product threeBasket3 = new PillHeadache("packet of headache pills", false,1, new BigDecimal("9.75"));
		Product fourBasket3 = new ChocolateBox("box of imported chocolates", true, 1, new BigDecimal("11.25"));
		List<Product> listInput3 = new ArrayList<Product>();
		listInput3.add(oneBasket3);
		listInput3.add(twoBasket3);
		listInput3.add(threeBasket3);
		listInput3.add(fourBasket3);
		Basket basket3 =processInput(listInput3);
		
		
		//print all baskets
		stb.printBasket(basket1);
		stb.printBasket(basket2);
		stb.printBasket(basket3);
	}
	
	private static Basket processInput(List<Product> list){
		Basket basket = new Basket();
		basket = stb.calculateBasket(list);
		System.out.println(basket.toString());
		System.out.println("--------");
		
		return basket;
	}
	
}
