package com.qualtop.empleados.api;

import com.qualtop.empleados.model.Employee;
import com.qualtop.empleados.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@CrossOrigin
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(value = "/home")
    public String home() {

        return "Home";
    }

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Employee> findAllEmployees() {

        return employeeService.findAll();
    }

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee saveEmployee(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    @PutMapping(value = "/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.update(employee);
    }

    @DeleteMapping(value = "/delete", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee deleteEmployee(@RequestParam ObjectId id) {

        return employeeService.delete(id);
    }
}
