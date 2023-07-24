package com.example.awslambda;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetEnvironmentVariable;
import org.springframework.cloud.function.adapter.aws.FunctionInvoker;

class ApplicationTest {

  @Test
  @SetEnvironmentVariable(key = "spring_cloud_function_definition", value = "listLambda")
  void listLambda() throws IOException {
    ByteArrayInputStream input = new ByteArrayInputStream(
        "{\"input\":{\"name\":\"frank\"}}".getBytes());
    new FunctionInvoker().handleRequest(input, System.out, null);
  }

  @Test
  @SetEnvironmentVariable(key = "spring_cloud_function_definition", value = "saveLambda")
  void saveLambda() throws IOException {
    ByteArrayInputStream input = new ByteArrayInputStream(
        "{\"input\":{\"name\":\"frank\",\"email\":\"hello@example.com\"}}".getBytes());
    new FunctionInvoker().handleRequest(input, System.out, null);
  }
}