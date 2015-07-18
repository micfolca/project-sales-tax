package com.model.goods;

import java.math.BigDecimal;

public abstract class Product {

	private String name;
	private boolean imported;
	
	//quantity of a product
	private double quantity;
	
	//percentuage of sales tax 
	private BigDecimal percTax;
	
	//value of sales tax
	private BigDecimal salesTax;
	
	//price of a single product without tax 
	private BigDecimal unitCost;
	
	//price of the product (include sales tax)
	private BigDecimal totalCost;
	
	//price of the product (without sales tax)
	private BigDecimal initialCost;
	
	
	//constructor	
	public Product(String name, boolean imported, int quantity, BigDecimal unitCost) {
		this.name = name;
		this.imported = imported;
		this.quantity = quantity;
		this.unitCost = unitCost;	
		//calculate TotalCost
		this.totalCost = unitCost.multiply(new BigDecimal(quantity));
		this.initialCost=totalCost;
	
	}

	/*get & set*/
	public String getName() {
		return name;
	}
	public BigDecimal getInitialCost() {
		return initialCost;
	}

	public void setInitialCost(BigDecimal initialCost) {
		this.initialCost = initialCost;
	}

	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public BigDecimal getPercTax() {
		return percTax;
	}
	public void setPercTax(BigDecimal percTax) {
		this.percTax = percTax;
	}
	public BigDecimal getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(BigDecimal salesTax) {
		this.salesTax = salesTax;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", imported=" + imported  
				+ ", quantity=" + quantity + ", percTax=" + percTax
				+ ", salesTax=" + salesTax + ", unitCost=" + unitCost
				+ ", totalCost=" + totalCost + "]";
	}
	
	
}
