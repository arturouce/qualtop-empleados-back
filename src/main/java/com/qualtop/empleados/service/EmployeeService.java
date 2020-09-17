package com.qualtop.empleados.service;

import com.qualtop.empleados.model.Employee;
import org.bson.types.ObjectId;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee delete(ObjectId id);
    Employee update(Employee employee);
    Employee save(Employee employee);

}
