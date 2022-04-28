package com.spring.coreprinciples.logdemo;

import com.spring.coreprinciples.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

  /**
   * Proxy 적용 x
   */
//  private final ObjectProvider<MyLogger> myLoggerProvider;

  /**
   * Proxy 적용 o
   */
  private final MyLogger myLogger;

  public void logic(String id) {
//    MyLogger myLogger = myLoggerProvider.getObject();
    myLogger.log("service id = " + id);
  }

}
