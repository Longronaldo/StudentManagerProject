package controller;

import model.Student;
import model.StudentRepository;
import utils.InputValidator;

public class StudentController {
    private StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // Thêm sinh viên
    public boolean addStudent(String id, String name, int age, String email, String major) {
        // Tạo đối tượng Student
        Student student = new Student(id, name, age, email, major);

        // Kiểm tra tính hợp lệ
        if (InputValidator.isValidStudent(student)) {
            repository.addStudent(student);
            return true;  // Thêm thành công
        }
        return false;  // Thêm không thành công (dữ liệu không hợp lệ)
    }

    // Xóa sinh viên
    public boolean removeStudent(String id) {
        return repository.removeStudent(id);
    }

    // Cập nhật sinh viên
    public boolean updateStudent(Student updatedStudent) {
        return repository.updateStudent(updatedStudent);
    }
}
