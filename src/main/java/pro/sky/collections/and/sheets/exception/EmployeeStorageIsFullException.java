package pro.sky.collections.and.sheets.exception;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String massage) {
        super(massage);
    }
}
