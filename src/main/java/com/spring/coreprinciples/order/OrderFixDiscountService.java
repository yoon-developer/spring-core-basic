package com.spring.coreprinciples.order;

public interface OrderFixDiscountService {

  Order createOrder(Long memberId, String itemName, int itemPrice);

}
