package com.spring.coreprinciples;

import com.spring.coreprinciples.member.Grade;
import com.spring.coreprinciples.member.Member;
import com.spring.coreprinciples.member.MemberService;
import com.spring.coreprinciples.member.MemberServiceImpl;

public class MemberApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();

    Member memberA = new Member(1L, "memberA", Grade.VIP);
    memberService.join(memberA);

    Member findMember = memberService.findMember(1L);

    System.out.println("memberA = " + memberA.getName());
    System.out.println("findMember = " + findMember.getName());
  }

}
