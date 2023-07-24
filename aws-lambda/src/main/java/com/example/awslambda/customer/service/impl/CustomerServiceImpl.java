package com.example.awslambda.customer.service.impl;

import com.example.awslambda.customer.dto.CustomerDto;
import com.example.awslambda.customer.entity.Customer;
import com.example.awslambda.customer.input.CustomerInput;
import com.example.awslambda.customer.repository.CustomerRepository;
import com.example.awslambda.customer.service.CustomerService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.BeanUtils;
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

  private final CustomerRepository customerRepository;

  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public List<CustomerDto> listCustomer(CustomerInput input) {
    return StreamSupport.stream(customerRepository.findByName(input.getName()).spliterator(), false)
        .map(customer -> {
          CustomerDto customerDto = new CustomerDto();
          BeanUtils.copyProperties(customer, customerDto);
          return customerDto;
        }).collect(Collectors.toList());
  }

  @Override
  public void saveCustomer(CustomerInput input) {
    Customer customer = new Customer();
    BeanUtils.copyProperties(input, customer);
    customerRepository.save(customer);
  }
}
