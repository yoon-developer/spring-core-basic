package com.spring.coreprinciples.xml;

import static org.assertj.core.api.Assertions.assertThat;

import com.spring.coreprinciples.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

  @Test
  public void xmlAppContext() throws Exception {
    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    MemberService memberService = ac.getBean("memberService", MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }
}
