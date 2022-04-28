package com.spring.coreprinciples.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeProviderTest {

  @Test
  void providerTest() {
    AnnotationConfigApplicationContext ac = new
        AnnotationConfigApplicationContext(ClientSingletonBean.class, PrototypeBean.class);

    ClientSingletonBean clientBean1 = ac.getBean(ClientSingletonBean.class);
    int count1 = clientBean1.logic();

    assertThat(count1).isEqualTo(1);

    ClientSingletonBean clientBean2 = ac.getBean(ClientSingletonBean.class);
    int count2 = clientBean2.logic();

    assertThat(count2).isEqualTo(1);
  }

  static class ClientSingletonBean {
    /**
     * [ObjectProvider]
     * - 라이브러리 필요 x
     * - 스프링 의존적
     * [Provider] - JSR-330
     * - 라이브러리 필요 O
     */
//    @Autowired
//    private ObjectProvider<PrototypeBean> prototypeBeanObjectProvider;
    @Autowired
    private Provider<PrototypeBean> provider;


    public int logic() {
//      PrototypeBean prototypeBean = prototypeBeanObjectProvider.getObject();
      PrototypeBean prototypeBean = provider.get();
      prototypeBean.addCount();
      int count = prototypeBean.getCount();
      return count;
    }

    @PostConstruct
    public void init() {
      System.out.println("ClientBean.init " + this);
    }

    @PreDestroy
    public void destroy() {
      System.out.println("ClientBean.destroy");
    }
  }

  @Scope("prototype")
  @Getter
  static class PrototypeBean {

    private int count = 0;

    public void addCount() {
      count++;
    }

    @PostConstruct
    public void init() {
      System.out.println("PrototypeBean.init " + this);
    }

    @PreDestroy
    public void destroy() {
      System.out.println("PrototypeBean.destroy");
    }
  }
}
