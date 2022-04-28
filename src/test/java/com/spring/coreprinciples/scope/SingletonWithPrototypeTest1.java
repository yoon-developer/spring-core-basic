package com.spring.coreprinciples.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

  @Test
  void prototypeFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        ClientSingletonBean.class, PrototypeBean.class);

    ClientSingletonBean clientSingletonBean1 = ac.getBean(ClientSingletonBean.class);
    int count1 = clientSingletonBean1.logic();

    assertThat(count1).isEqualTo(1);

    ClientSingletonBean clientSingletonBean2 = ac.getBean(ClientSingletonBean.class);
    int count2 = clientSingletonBean2.logic();

    assertThat(count2).isEqualTo(2);
  }

  static class ClientSingletonBean {

    private final PrototypeBean prototypeBean;

    @Autowired
    public ClientSingletonBean(PrototypeBean prototypeBean) {
      this.prototypeBean = prototypeBean;
    }

    public int logic() {
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
