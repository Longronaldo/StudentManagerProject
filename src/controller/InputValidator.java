package utils;

import model.Student;

public class InputValidator {

    // Kiểm tra tuổi hợp lệ
    public static boolean isValidAge(int age) {
        return age > 0;  // Tuổi phải là số dương
    }

    // Kiểm tra email hợp lệ (ví dụ đơn giản)
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    // Kiểm tra ID có hợp lệ không (không rỗng)
    public static boolean isValidId(String id) {
        return id != null && !id.trim().isEmpty();
    }

    // Kiểm tra thông tin sinh viên hợp lệ
    public static boolean isValidStudent(Student student) {
        return isValidId(student.getId()) &&
                student.getName() != null && !student.getName().trim().isEmpty() &&
                isValidAge(student.getAge()) &&
                isValidEmail(student.getEmail());
    }
}
