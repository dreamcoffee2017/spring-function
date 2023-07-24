package com.example.awslambda.customer.service;

import com.example.awslambda.customer.dto.CustomerDto;
import com.example.awslambda.customer.input.CustomerInput;
import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-06
 */
@Validated
public interface CustomerService {

  /**
   * listCustomer
   *
   * @param input param
   * @return dto
   */
  List<CustomerDto> listCustomer(@Valid CustomerInput input);

  /**
   * saveCustomer
   *
   * @param input param
   */
  void saveCustomer(@Valid CustomerInput input);
}
