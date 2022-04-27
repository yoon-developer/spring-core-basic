package com.spring.coreprinciples.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

  @Test
  public void lifeCycleTest1() throws Exception {
    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(
        LifeCycleConfig1.class);

    NetworkClient1 client  = ac.getBean(NetworkClient1.class);
    //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
    ac.close();
  }

  @Test
  public void lifeCycleTest2() throws Exception {
    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(
        LifeCycleConfig2.class);

    NetworkClient2 client  = ac.getBean(NetworkClient2.class);
    ac.close();
  }

  @Test
  public void lifeCycleTest3() throws Exception {
    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(
        LifeCycleConfig3.class);

    NetworkClient3 client  = ac.getBean(NetworkClient3.class);
    ac.close();
  }

  /**
   * 초기화, 소멸 메서드의 이름을 변경 X
   * 외부 라이브러리에는 적용 X
   */
  @Configuration
  static class LifeCycleConfig1 {
    @Bean
    public NetworkClient1 networkClient() {
      NetworkClient1 networkClient = new NetworkClient1();
      networkClient.setUrl("http://yoon-spring.dev");
      return networkClient;
    }
  }

  /**
   * 초기화, 소멸 메서드의 이름을 변경 O
   * 외부 라이브러리에는 적용 O
   */
  @Configuration
  static class LifeCycleConfig2 {
    @Bean(initMethod = "init", destroyMethod = "close")
    public NetworkClient2 networkClient() {
      NetworkClient2 networkClient = new NetworkClient2();
      networkClient.setUrl("http://yoon-spring.dev");
      return networkClient;
    }
  }

  /**
   * 초기화, 소멸 메서드의 이름을 변경 O
   * 외부 라이브러리에는 적용 X
   */
  @Configuration
  static class LifeCycleConfig3 {
    @Bean
    public NetworkClient3 networkClient() {
      NetworkClient3 networkClient = new NetworkClient3();
      networkClient.setUrl("http://yoon-spring.dev");
      return networkClient;
    }
  }
}
