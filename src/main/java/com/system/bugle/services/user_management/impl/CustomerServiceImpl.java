package com.system.bugle.services.user_management.impl;

import com.system.bugle.dto.CustomerDto;
import com.system.bugle.entity.user_management.Customer;
import com.system.bugle.entity.user_management.Department;
import com.system.bugle.repo.user_management.CustomerRepo;
import com.system.bugle.services.user_management.CustomerService;
import com.system.bugle.services.user_management.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final DepartmentService departmentService;

    @Override
    public String saveData(CustomerDto customerDto) {
        Customer customer = new Customer();

        Department department=departmentService.getByIdNoOpt(customerDto.getDepartment());

        customer.setId(customerDto.getId());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerEmail(customerDto.getCustomerEmail());
        customer.setDepartment(department);

        customerRepo.save(customer);

        return null;
    }

    @Override
    public List<Customer> getData() {
        return customerRepo.findAll();
    }
}
