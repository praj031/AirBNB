package com.project.AirBNB.AirBNB.strategy;

import com.project.AirBNB.AirBNB.entity.Inventory;

import java.math.BigDecimal;
public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
