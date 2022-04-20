package com.spring.coreprinciples;

import com.spring.coreprinciples.config.AppConfig;
import com.spring.coreprinciples.member.Grade;
import com.spring.coreprinciples.member.Member;
import com.spring.coreprinciples.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

  public static void main(String[] args) {
//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

    Member memberA = new Member(1L, "memberA", Grade.VIP);
    memberService.join(memberA);

    Member findMember = memberService.findMember(1L);

    System.out.println("memberA = " + memberA.getName());
    System.out.println("findMember = " + findMember.getName());
  }

}
