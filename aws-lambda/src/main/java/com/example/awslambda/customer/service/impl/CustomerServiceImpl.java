package com.example.awslambda.customer.service.impl;

import com.example.awslambda.customer.dto.CustomerDto;
import com.example.awslambda.customer.input.CustomerInput;
import com.example.awslambda.customer.service.CustomerService;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-06
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public List<CustomerDto> listCustomer(String name) {
    CustomerDto customer = new CustomerDto();
    customer.setName("hello" + name);
    return Collections.singletonList(customer);
  }

  @Override
  public void saveCustomer(CustomerInput input) {

  }
}
