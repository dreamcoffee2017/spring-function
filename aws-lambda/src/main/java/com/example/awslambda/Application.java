package com.example.awslambda;

import com.example.awslambda.customer.dto.CustomerDto;
import com.example.awslambda.customer.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.function.Function;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  private final CustomerService customerService;

  public Application(CustomerService customerService) {
    this.customerService = customerService;
  }

  public static void main(String[] args) {
    // only for boot generate the metadata info
  }

  @Bean
  public Function<String, String> lambda() {
    System.out.println("call lambda");
    return (value) -> {
      try {
        JsonNode jsonNode = new ObjectMapper().readTree(value);
        String code = jsonNode.get("code").asText();
        List<CustomerDto> customers = customerService.listCustomer(code);
        return customers.toString();
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    };
  }
}
