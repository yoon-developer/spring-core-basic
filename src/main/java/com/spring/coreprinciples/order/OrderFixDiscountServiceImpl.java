package com.spring.coreprinciples.order;

import com.spring.coreprinciples.discount.DiscountPolicy;
import com.spring.coreprinciples.member.Member;
import com.spring.coreprinciples.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderFixDiscountServiceImpl implements OrderFixDiscountService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  public OrderFixDiscountServiceImpl(MemberRepository memberRepository, @Qualifier("fixDiscountPolicy") DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  //테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
