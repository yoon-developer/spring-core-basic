package com.spring.coreprinciples.scan;

import static org.assertj.core.api.Assertions.assertThat;

import com.spring.coreprinciples.AutoAppConfig;
import com.spring.coreprinciples.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  public void basicScan() throws Exception {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    MemberService memberService = ac.getBean(MemberService.class);

    assertThat(memberService).isInstanceOf(MemberService.class);
  }

}
