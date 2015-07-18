package com.model.goods;

import java.math.BigDecimal;

public abstract class Food extends Product{

	public Food(String name, boolean imported, int quantity, BigDecimal unitCost) {
		super(name, imported, quantity, unitCost);
	}

}
