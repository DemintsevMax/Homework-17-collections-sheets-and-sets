package pro.sky.collections.and.sheets.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.collections.and.sheets.Employee;
import pro.sky.collections.and.sheets.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }



    @GetMapping("/{firstName}/{lastName}")
    public Employee findEmployee(@PathVariable String firstName, @PathVariable String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
