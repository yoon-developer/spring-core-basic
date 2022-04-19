package com.spring.coreprinciples.order;

import com.spring.coreprinciples.config.AppConfig;
import com.spring.coreprinciples.member.Grade;
import com.spring.coreprinciples.member.Member;
import com.spring.coreprinciples.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService;
  OrderService orderService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }

  @Test
  @DisplayName("주문")
  public void createOrder() throws Exception {
    //given
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    //when
    Order order = orderService.createOrder(memberId, "itemA", 10000);

    //then
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }

}
