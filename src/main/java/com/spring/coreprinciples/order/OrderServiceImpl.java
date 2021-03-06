package com.spring.coreprinciples.order;

import com.spring.coreprinciples.discount.DiscountPolicy;
import com.spring.coreprinciples.member.Member;
import com.spring.coreprinciples.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  /**
   * 1. 생성자가 1개만 있을 경우 @Autowired 생략 가능
   * 2. lombok 사용시 생성자 생략 가능
   */
/*
  public OrderServiceImpl(MemberRepository memberRepository,
      DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }
*/

  //테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
