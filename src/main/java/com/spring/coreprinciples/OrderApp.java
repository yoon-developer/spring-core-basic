package com.spring.coreprinciples;

import com.spring.coreprinciples.config.AppConfig;
import com.spring.coreprinciples.member.Grade;
import com.spring.coreprinciples.member.Member;
import com.spring.coreprinciples.member.MemberService;
import com.spring.coreprinciples.order.Order;
import com.spring.coreprinciples.order.OrderService;

public class OrderApp {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();

    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "iteamA", 50000);

    System.out.println("order = " + order);
    System.out.println("order.calculatePrice() = " + order.calculatePrice());
  }

}
