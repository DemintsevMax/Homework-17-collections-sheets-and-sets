package pro.sky.collections.and.sheets.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.and.sheets.Employee;
import pro.sky.collections.and.sheets.exception.EmployeeAlreadyAddedException;
import pro.sky.collections.and.sheets.exception.EmployeeNotFoundException;
import pro.sky.collections.and.sheets.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {

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


    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            if (employees.size() > MAX_EMPLOYEES) {
                throw new EmployeeStorageIsFullException("Колличество сотрудников превышает допустимое значение!");
            } else if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже существует!");
            } else {
                employees.add(employee);
            }
            return employee;
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Превышено максимальное количество сотрудников!");
            return null;
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Такой сотрудник уже есть!");
            return null;
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            if (employees.contains(employee)) {
                return employee;
            }
            throw new EmployeeNotFoundException(firstName + " " + lastName + "Не найден, введен неизвестный сотрудник");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден!");
        }
        return null;
    }

    public String removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            if (employees.remove(employee)) {
                return "Сотрудник удален !";
            }
            throw new EmployeeNotFoundException(firstName + " " + lastName + "Не найден, введен неизвестный сотрудник");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден!");
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}




