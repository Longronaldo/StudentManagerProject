package model;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> studentList;
    private StudentDAO studentDAO;

    public StudentRepository() {
        studentList = new ArrayList<>();
        studentDAO = new StudentDAO(); // Khởi tạo StudentDAO để làm việc với file
    }

    // Thêm sinh viên
    public void addStudent(Student student) {
        studentList.add(student);
        saveStudentsToFile();  // Lưu vào file sau khi thêm sinh viên
    }

    // Xóa sinh viên theo ID
    public boolean removeStudent(String id) {
        boolean removed = studentList.removeIf(s -> s.getId().equalsIgnoreCase(id));
        if (removed) {
            saveStudentsToFile();  // Lưu lại danh sách vào file sau khi xóa
        }
        return removed;
    }

    // Trong StudentRepository.java
    public boolean updateStudent(Student updatedStudent) {
        for (int i = 0; i < studentList.size(); i++) {
            Student current = studentList.get(i);
            if (current.getId().equalsIgnoreCase(updatedStudent.getId())) {
                studentList.set(i, updatedStudent);  // Cập nhật sinh viên trong danh sách
                return true;
            }
        }
        return false;
    }

    // Lấy danh sách tất cả sinh viên
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList); // Tránh trả về danh sách gốc
    }

    // Lưu danh sách sinh viên vào file
    public void saveStudentsToFile() {
        studentDAO.saveStudents(studentList);  // Ghi dữ liệu vào file
    }

    // Tải danh sách sinh viên từ file
    public void loadStudentsFromFile() {
        studentList = studentDAO.loadStudents();  // Đọc dữ liệu từ file
    }
}
