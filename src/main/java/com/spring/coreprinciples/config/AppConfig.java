package com.spring.coreprinciples.config;

import com.spring.coreprinciples.discount.DiscountPolicy;
import com.spring.coreprinciples.discount.FixDiscountPolicy;
import com.spring.coreprinciples.discount.RateDiscountPolicy;
import com.spring.coreprinciples.member.MemberRepository;
import com.spring.coreprinciples.member.MemberService;
import com.spring.coreprinciples.member.MemberServiceImpl;
import com.spring.coreprinciples.member.MemoryMemberRepository;
import com.spring.coreprinciples.order.OrderService;
import com.spring.coreprinciples.order.OrderServiceImpl;

public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  private MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  private DiscountPolicy discountPolicy() {
//    return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }

}
