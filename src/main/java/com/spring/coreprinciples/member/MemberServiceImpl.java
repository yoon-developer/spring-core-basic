package com.spring.coreprinciples.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  /**
   * 1. 생성자가 1개만 있을 경우 @Autowired 생략 가능
   * 2. lombok 사용시 생성자 생략 가능
   */
/*
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
*/

  //테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
