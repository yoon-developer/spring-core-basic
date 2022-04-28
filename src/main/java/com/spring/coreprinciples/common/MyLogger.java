package com.spring.coreprinciples.common;

import static org.springframework.web.util.TagUtils.SCOPE_REQUEST;

import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * request: HTTP 요청 하나가 들어오고 나갈 때 까지 유지되는 스코프, 각각의 HTTP 요청마다 별도의 빈 인스턴스가 생성되고, 관리된다.
 * session: HTTP Session과 동일한 생명주기를 가지는 스코프
 * application: 서블릿 컨텍스트( ServletContext )와 동일한 생명주기를 가지는 스코프
 * websocket: 웹 소켓과 동일한 생명주기를 가지는 스코프
 */
@Component
//@Scope(value = SCOPE_REQUEST)
@Scope(value = SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Setter
public class MyLogger {

  private String uuid;
  private String requestURL;

  public void log(String message) {
    System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
  }

  @PostConstruct
  public void init() {
    uuid = UUID.randomUUID().toString();
    System.out.println("[" + uuid + "] request scope bean create:" + this);
  }

  @PreDestroy
  public void close() {
    System.out.println("[" + uuid + "] request scope bean close:" + this);
  }

}
