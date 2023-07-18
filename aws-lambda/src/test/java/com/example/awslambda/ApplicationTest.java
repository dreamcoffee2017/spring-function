package com.example.awslambda;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.cloud.function.adapter.aws.FunctionInvoker;

class ApplicationTest {

  public static void main(String[] args) throws IOException {
    ByteArrayInputStream input = new ByteArrayInputStream("{\"code\":\"frank\"}".getBytes());
    new FunctionInvoker().handleRequest(input, System.out, null);
  }
}