package model;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> studentList;

    public StudentRepository() {
        studentList = new ArrayList<>();
    }

    // Thêm sinh viên
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Xóa sinh viên theo ID
    public boolean removeStudent(String id) {
        return studentList.removeIf(s -> s.getId().equalsIgnoreCase(id));
    }

    // Tìm sinh viên theo ID
    public Student findById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // Cập nhật thông tin sinh viên
    public boolean updateStudent(Student updatedStudent) {
        for (int i = 0; i < studentList.size(); i++) {
            Student current = studentList.get(i);
            if (current.getId().equalsIgnoreCase(updatedStudent.getId())) {
                studentList.set(i, updatedStudent);
                return true;
            }
        }
        return false;
    }

    // Lấy danh sách tất cả sinh viên
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList); // Tránh trả về danh sách gốc
    }
}
