package com.spring.coreprinciples.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.spring.coreprinciples.config.AppConfig;
import com.spring.coreprinciples.member.MemberService;
import com.spring.coreprinciples.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 이름으로 조회")
  public void findBeanByName() throws Exception {
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }

  @Test
  @DisplayName("이름 없이 타입만으로 조회")
  public void findBeanByType() throws Exception {
    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }

  @Test
  @DisplayName("구체 타입으로 조회")
  public void findBeanByName2() throws Exception {
    MemberServiceImpl memberServiceImpl = ac.getBean("memberService", MemberServiceImpl.class);
    assertThat(memberServiceImpl).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("빈 이름으로 조회X")
  public void findBeanByNameX() throws Exception {
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> ac.getBean("xxxxx", MemberService.class));
  }

}
