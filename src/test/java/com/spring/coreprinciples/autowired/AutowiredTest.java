package com.spring.coreprinciples.autowired;

import com.spring.coreprinciples.member.Member;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

public class AutowiredTest {

  @Test
  public void autowiredOption() throws Exception {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
  }

  static class TestBean {

    /**
     * @Autowired required 옵션의 기본값 true
     */

    @Autowired(required = false)
    public void setNoBean1(Member member) {
      System.out.println("setNoBean1 = " + member);
    }

    //null 호출
    @Autowired
    public void setNoBean2(@Nullable Member member) {
      System.out.println("setNoBean2 = " + member);
    }

    //Optional.empty 호출
    @Autowired
    public void setNoBean3(Optional<Member> member) {
      System.out.println("setNoBean3 = " + member);
    }
  }

}
