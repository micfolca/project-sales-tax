package com.model.basket;

import java.math.BigDecimal;
import java.util.List;

import com.model.goods.Product;

public class Basket {

	private List<Product> listProduct;
	private BigDecimal salesTax;
	private BigDecimal totalCost;
	
	
	/**
	 * constructor
	 * 
	 * */
	public Basket(){ }
	
		
	public Basket(List<Product> listProduct){
		this.listProduct = listProduct;
	}
	
	/**
	 * 
	 * get & set 
	 * 
	 * */
	public List<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	public BigDecimal getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(BigDecimal salesTax) {
		this.salesTax = salesTax;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}


	@Override
	public String toString() {
		return "Basket [listProduct=" + listProduct + ", salesTax=" + salesTax
				+ ", totalCost=" + totalCost + "]";
	}
	
	
	
}
