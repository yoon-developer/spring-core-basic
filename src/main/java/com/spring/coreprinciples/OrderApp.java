package com.spring.coreprinciples;

import com.spring.coreprinciples.config.AppConfig;
import com.spring.coreprinciples.member.Grade;
import com.spring.coreprinciples.member.Member;
import com.spring.coreprinciples.member.MemberService;
import com.spring.coreprinciples.order.Order;
import com.spring.coreprinciples.order.OrderFixDiscountService;
import com.spring.coreprinciples.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

  public static void main(String[] args) {
//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();
//    OrderService orderService = appConfig.orderService();

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    MemberService memberService = applicationContext.getBean(MemberService.class);
    OrderService orderService = applicationContext.getBean(OrderService.class);

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order rateDiscountOrder = orderService.createOrder(memberId, "iteamA", 50000);

    System.out.println("rateDiscountOrder = " + rateDiscountOrder);
    System.out.println("rateDiscountOrder.calculatePrice() = " + rateDiscountOrder.calculatePrice());

    OrderFixDiscountService OrderFixDiscountService = applicationContext.getBean(OrderFixDiscountService.class);

    Order fixDiscountorder = OrderFixDiscountService.createOrder(memberId, "iteamA", 50000);

    System.out.println("fixDiscountorder = " + fixDiscountorder);
    System.out.println("fixDiscountorder.calculatePrice() = " + fixDiscountorder.calculatePrice());
  }

}
