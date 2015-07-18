package com.controller.tax;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter.BigDecimalLayoutForm;
import java.util.Iterator;
import java.util.List;

import com.engine.tax.TaxEngine;
import com.model.basket.Basket;
import com.model.goods.Product;

public class SalesTaxesController {
	
	private TaxEngine taxEngine = null;
	
	/** 
	 * constructor 
	 * 
	 * */
	public SalesTaxesController() { 
		taxEngine = new TaxEngine();
	}


	/** 
	 * 
	 * calculate basket output 
	 * 
	 * */
	public Basket calculateBasket(List<Product> list){
		Basket basket = new Basket();
		BigDecimal salexTaxBasket = new BigDecimal(0);
		BigDecimal totalCostBasket = new BigDecimal(0);
		
		if (list == null) 
		      throw new IllegalArgumentException("list null");
		try{
			for (Iterator<Product> iterator = list.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				if(product != null) {
					processProduct(product);
					salexTaxBasket = salexTaxBasket.add(product.getSalesTax());
					totalCostBasket = totalCostBasket.add(product.getTotalCost());
				}
			}
			basket.setListProduct(list);
			basket.setSalesTax(salexTaxBasket);
			basket.setTotalCost(totalCostBasket);
		}catch(Exception e){
			System.out.println("Error "+e.getMessage());
		}
			return basket;
	}
	
	/** 
	 * 
	 * process each Product 
	 * 
	 * */
	private void processProduct(Product product) {
		try{
			taxEngine.calculateTax(product);
		}catch(Exception e){
			System.out.println("Error "+e.getMessage());
		}
	}
	

	/**
	 * print the Basket
	 * 
	 */
	public void printBasket(Basket basket){
		NumberFormat nf = new DecimalFormat("##.##");
		System.out.println("Basket output");
		for (Iterator<Product> iterator = basket.getListProduct().iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			System.out.println("\t"+nf.format(product.getQuantity())+" "+product.getName()+" "
								 +nf.format(product.getTotalCost()));
		}
		System.out.println("Sales Taxes: "+basket.getSalesTax());
		System.out.println("Total: "+basket.getTotalCost());
		System.out.println("--------");
	}
}
