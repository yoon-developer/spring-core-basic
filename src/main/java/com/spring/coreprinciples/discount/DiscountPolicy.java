package com.spring.coreprinciples.discount;

import com.spring.coreprinciples.member.Member;

public interface DiscountPolicy {

  /**
   * @return 할인 대상 금액
   */

  int discount(Member member, int price);

}
