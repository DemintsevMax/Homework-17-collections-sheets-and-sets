package pro.sky.collections.and.sheets;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.*;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private final Map<String, Employee> employeeMap = new HashMap<>();

    public EmployeeService() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Снежная", "Жанна"));
        employees.add(new Employee("Смирнов", "Сергей"));
        employees.add(new Employee("Иванов", "Иван"));
        employees.add(new Employee("Молев", "Дима"));
        employees.add(new Employee("Мусаев", "Мухаммед Ибрагим оглы"));
        employees.add(new Employee("Снежков", "Алексей"));
        employees.add(new Employee("Кабаева", "Алина"));
        employees.add(new Employee("Медведев", "Дима"));
        employees.add(new Employee("Пушкин", "Александр"));
        employees.add(new Employee("Святая", "Вероника"));
    }

    public void addEmployee(String firstName, String lastName) {
        if (employeeMap.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Хранилище сотрудников переполнено.");
        }
        String key = firstName + " " + lastName;
        if (employeeMap.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Сотрудник " + key + " уже добавлен.");
        }
        employeeMap.put(key, new Employee(firstName, lastName));
    }

    public void removeEmployee(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        Employee removedEmployee = employeeMap.remove(key);
        if (removedEmployee == null) {
            throw new EmployeeNotFoundException("Сотрудник " + key + " не найден.");
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        Employee employee = employeeMap.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник " + key + " не найден.");
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }


    public static class EmployeeNotFoundException extends RuntimeException {
        public EmployeeNotFoundException(String message) {
            super(message);
        }
    }

    public static class EmployeeStorageIsFullException extends RuntimeException {
        public EmployeeStorageIsFullException(String message) {
            super(message);
        }
    }

    public static class EmployeeAlreadyAddedException extends RuntimeException {
        public EmployeeAlreadyAddedException(String message) {
            super(message);
        }
    }
}


