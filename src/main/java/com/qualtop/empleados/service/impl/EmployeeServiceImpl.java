package com.qualtop.empleados.service.impl;

import com.qualtop.empleados.model.Employee;
import com.qualtop.empleados.repository.EmployeeRepository;
import com.qualtop.empleados.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {

        return Optional
                .of(employeeRepository.findAll())
                .orElseThrow(InternalError::new);
    }

    @Override
    public Employee delete(final ObjectId id) {

        final Employee employee = new Employee().setId(id);

        try {

            employeeRepository.delete(employee);
            return employee;

        } catch (Exception e) {

            throw new InternalError(e);
        }
    }

    @Override
    public Employee update(final Employee employee) {

        return Optional
                .of(employeeRepository.save(employee))
                .orElseThrow(InternalError::new);
    }

    @Override
    public Employee save(final Employee employee) {

        return Optional
                .of(employeeRepository.save(employee))
                .orElseThrow(InternalError::new);
    }
}
