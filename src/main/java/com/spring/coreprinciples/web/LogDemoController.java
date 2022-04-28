package com.spring.coreprinciples.web;

import com.spring.coreprinciples.common.MyLogger;
import com.spring.coreprinciples.logdemo.LogDemoService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

  private final LogDemoService logDemoService;

  /**
   * Proxy 적용 x
   */
//  private final ObjectProvider<MyLogger> myLoggerProvider;

  /**
   * Proxy 적용 o
   */
  private final MyLogger myLogger;



  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) {
    String requestURL = request.getRequestURL().toString();
//    MyLogger myLogger = myLoggerProvider.getObject();
    System.out.println("myLogger = " + myLogger.getClass());

    myLogger.setRequestURL(requestURL);

    myLogger.log("controller test");

    logDemoService.logic("testId");
    return "OK";
  }

}
