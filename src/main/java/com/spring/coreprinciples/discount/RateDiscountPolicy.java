package com.spring.coreprinciples.discount;

import com.spring.coreprinciples.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

  @Override
  public int discount(Member member, int price) {
    return 0;
  }
}
