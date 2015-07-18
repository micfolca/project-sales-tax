package com.model.goods;

import java.math.BigDecimal;

public abstract class Medical extends Product{

	public Medical(String name, boolean imported, int quantity,
			BigDecimal unitCost) {
		super(name, imported, quantity, unitCost);
	}

}
