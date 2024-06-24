package pro.sky.collections.and.sheets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName());
        return employee;
    }

    @DeleteMapping("/{firstName}/{lastName}")
    public void removeEmployee(@PathVariable String firstName, @PathVariable String lastName) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/{firstName}/{lastName}")
    public Employee findEmployee(@PathVariable String firstName, @PathVariable String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
