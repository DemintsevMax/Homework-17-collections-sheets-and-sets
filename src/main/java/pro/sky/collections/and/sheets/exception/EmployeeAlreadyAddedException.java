package pro.sky.collections.and.sheets.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String massage) {
        super(massage);
    }
}
