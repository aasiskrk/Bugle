package com.system.bugle.services.user_management;

import com.system.bugle.dto.CustomerDto;
import com.system.bugle.entity.user_management.Customer;

import java.util.List;

public interface CustomerService {
    String saveData(CustomerDto customerDto);

    List<Customer> getData();
}
