package com.model.goods;

import java.math.BigDecimal;

public class Book extends Product{

	public Book(String name, boolean imported, int quantity, BigDecimal unitCost) {
		super(name, imported, quantity, unitCost);
	}
}
