package com.spring.coreprinciples.lifecycle;

import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Setter
public class NetworkClient1 implements InitializingBean, DisposableBean {

  private String url;

  public NetworkClient1() {
    System.out.println("생성자 호출, url = " + url);
  }

  //서비스 시작시 호출
  public void connect() {
    System.out.println("connect = " + url);
  }

  public void call(String message) {
    System.out.println("call = " + url + " message = " + message);
  }

  //서비스 종료시 호출
  public void disconnect() {
    System.out.println("close = " + url);
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("NetworkClient1.destroy");
    disconnect();
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("NetworkClient1.afterPropertiesSet");
    connect();
    call("초기화 연결 메시지");
  }
}
