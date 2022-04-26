package com.spring.coreprinciples.autowired;

import static org.assertj.core.api.Assertions.assertThat;

import com.spring.coreprinciples.AutoAppConfig;
import com.spring.coreprinciples.discount.DiscountPolicy;
import com.spring.coreprinciples.member.Grade;
import com.spring.coreprinciples.member.Member;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllBeanTest {

  @Test
  public void findAllBean() throws Exception {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,
        DiscountService.class);
    DiscountService discountService = ac.getBean(DiscountService.class);

    Member member = new Member(1L, "userA", Grade.VIP);
    int fixDiscountPrice = discountService.discount(member, 50000, "fixDiscountPolicy");

    assertThat(discountService).isInstanceOf(DiscountService.class);
    assertThat(fixDiscountPrice).isEqualTo(1000);

    int rateDiscountPrice = discountService.discount(member, 50000, "rateDiscountPolicy");
    assertThat(rateDiscountPrice).isEqualTo(5000);
  }

  static class DiscountService {

    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policies;

    public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
      this.policyMap = policyMap;
      this.policies = policies;
      System.out.println("policyMap = " + policyMap);
      System.out.println("policies = " + policies);
    }

    public int discount(Member member, int price, String discountCode) {
      DiscountPolicy discountPolicy = policyMap.get(discountCode);
      System.out.println("discountCode = " + discountCode);
      System.out.println("discountPolicy = " + discountPolicy);

      return discountPolicy.discount(member, price);
    }

  }

}
