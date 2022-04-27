package com.spring.coreprinciples.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.Setter;

/**
 * [스프링 빈의 이벤트 라이프사이클]
 * 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
 */
@Setter
public class NetworkClient3 {

  private String url;

  public NetworkClient3() {
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

  @PreDestroy
  public void preDestroy() throws Exception {
    System.out.println("NetworkClient3.preDestroy");
    disconnect();
  }

  @PostConstruct
  public void postConstruct() throws Exception {
    System.out.println("NetworkClient3.postConstruct");
    connect();
    call("초기화 연결 메시지");
  }
}
