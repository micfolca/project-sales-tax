package com.engine.tax;

import java.math.BigDecimal;

import com.model.goods.Book;
import com.model.goods.Food;
import com.model.goods.Medical;
import com.model.goods.Product;

public class TaxEngine {
	
	private double rateBasicTax = 0.1;
	private double rateImportTax = 0.05;

	
	public TaxEngine() {}
	
	
	/**
	 * Calculate sales tax for a product
	 * 
	 */
	
	public void calculateTax(Product product) {		
		BigDecimal totCost = product.getTotalCost();
		BigDecimal totalTax = BigDecimal.ZERO;
		if(!(product instanceof Food)
				&& !(product instanceof Book) && !(product instanceof Medical))
			totalTax = BigDecimal.valueOf(rateBasicTax);
		
		if(product.isImported())
			totalTax = totalTax.add(BigDecimal.valueOf(rateImportTax));
		
		if(totalTax.compareTo(BigDecimal.ZERO) != 0) {
			BigDecimal taxPrice = totCost.multiply(totalTax);
			double roundTaxPrice = roundValue(taxPrice.doubleValue());
			totCost = totCost.add(BigDecimal.valueOf(roundTaxPrice));
			totCost = totCost.setScale(2, BigDecimal.ROUND_UP);
			product.setTotalCost(totCost);
		}
		//update percentuage sales tax 
		product.setPercTax(totalTax);
		//calculate value sales tax
		calculateProductSalesTax(product);
	}
	
	
	/**
	 * Calculate the sales tax for a product
	 * 
	 */
	private void calculateProductSalesTax(Product product){
		BigDecimal n = BigDecimal.ZERO;
		//check if is food, book, or medical product
		if(!(product instanceof Food)
				&& !(product instanceof Book) && !(product instanceof Medical))	
			n = n.add(BigDecimal.valueOf(rateBasicTax));
		
		//check if is imported
		if(product.isImported())
			n = n.add(BigDecimal.valueOf(rateImportTax));
		
		BigDecimal salesTax = new BigDecimal(0);
		if(n.compareTo(BigDecimal.ZERO) != 0) {
			salesTax = product.getUnitCost().multiply(n);
			double taxRoundedRound = roundValue(salesTax.doubleValue());
			product.setSalesTax(BigDecimal.valueOf(taxRoundedRound));
		}else
			product.setSalesTax(salesTax);
	}

	
	/**
	 * return a rounded value up to the nearest 0.05
	 */
	public static double roundValue(double value) {
		double roundResult=0;
		try{
		BigDecimal roundDataBigDecimal = 
				BigDecimal.valueOf(value).setScale(1, BigDecimal.ROUND_HALF_UP);
		double roundDataDouble = Math.round(value*20.0)/20.0;
		double roundDelta = roundDataBigDecimal.doubleValue() - roundDataDouble;
		roundResult = roundDataDouble;
		if(roundDelta>0)
			roundResult = roundDataBigDecimal.doubleValue(); 
		}catch(Exception e){
			System.out.println("Error "+e.getMessage());
		}
       	return roundResult;
    }
}
