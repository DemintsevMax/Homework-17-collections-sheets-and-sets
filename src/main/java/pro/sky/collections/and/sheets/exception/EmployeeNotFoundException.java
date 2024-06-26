package pro.sky.collections.and.sheets.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String massage) {
        super(massage);
    }
}