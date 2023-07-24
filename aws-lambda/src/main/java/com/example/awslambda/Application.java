package com.example.awslambda;

import com.example.awslambda.customer.input.CustomerInput;
import com.example.awslambda.customer.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Function;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDynamoDBRepositories
public class Application {

  private final CustomerService customerService;

  public Application(CustomerService customerService) {
    this.customerService = customerService;
  }

  public static void main(String[] args) {
    // only for boot generate the metadata info
  }

  @Bean
  public Function<String, String> listLambda() {
    return value -> {
      try {
        CustomerInput input = buildInput(value);
        return customerService.listCustomer(input).toString();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }

  @Bean
  public Function<String, String> saveLambda() {
    return value -> {
      try {
        CustomerInput input = buildInput(value);
        customerService.saveCustomer(input);
        return "ok";
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }

  private CustomerInput buildInput(String value) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(value);
    return objectMapper.convertValue(jsonNode.get("input"), CustomerInput.class);
  }
}
