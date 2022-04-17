package com.spring.coreprinciples;

import com.spring.coreprinciples.member.Grade;
import com.spring.coreprinciples.member.Member;
import com.spring.coreprinciples.member.MemberService;
import com.spring.coreprinciples.member.MemberServiceImpl;
import com.spring.coreprinciples.order.Order;
import com.spring.coreprinciples.order.OrderService;
import com.spring.coreprinciples.order.OrderServiceImpl;

public class OrderApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "iteamA", 1000);

    System.out.println("order = " + order);
  }

}
