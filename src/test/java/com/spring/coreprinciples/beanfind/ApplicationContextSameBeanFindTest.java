package com.spring.coreprinciples.beanfind;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.spring.coreprinciples.discount.DiscountPolicy;
import com.spring.coreprinciples.member.MemberRepository;
import com.spring.coreprinciples.member.MemoryMemberRepository;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
      SameBeanConfig.class);

  @Test
  @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
  public void findBeanByTypeDuplicate() throws Exception {
    //DiscountPolicy discountPolicy = (DiscountPolicy) ac.getBean(MemberRepository.class);
    assertThrows(NoUniqueBeanDefinitionException.class, () -> {
      ac.getBean(MemberRepository.class);
    });

  }

  @Test
  @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
  public void findBeanByName() throws Exception {
    MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
    assertThat(memberRepository).isInstanceOf(MemberRepository.class);

  }

  @Test
  @DisplayName("특정 타입을 모두 조회하기")
  public void findAllBeanByType() throws Exception {
    Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
    for (String key : beansOfType.keySet()) {
      System.out.println("key= " + key + " value=" + beansOfType.get(key));
    }
  }

  @Configuration
  static class SameBeanConfig {

    @Bean
    public MemberRepository memberRepository1() {
      return new MemoryMemberRepository();
    }

    @Bean
    public MemberRepository memberRepository2() {
      return new MemoryMemberRepository();
    }
  }

}
