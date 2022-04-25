package com.spring.coreprinciples;

import com.spring.coreprinciples.member.MemberRepository;
import com.spring.coreprinciples.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    /**
     * ComponentScan 시작 위치
     */
//    basePackages = "com.spring.coreprinciples.member",
    excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

  /**
   * 수동 빈 등록이 우선권 (수동 빈이 자동 빈을 오버라이딩)
   */
/*
  @Bean(name = "memoryMemberRepository")
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
*/

}
