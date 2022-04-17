package com.spring.coreprinciples.order;

import com.spring.coreprinciples.discount.DiscountPolicy;
import com.spring.coreprinciples.discount.FixDiscountPolicy;
import com.spring.coreprinciples.member.Member;
import com.spring.coreprinciples.member.MemberRepository;
import com.spring.coreprinciples.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
