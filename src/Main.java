package main;

import model.Student;
import model.StudentRepository;

import controller.StudentController;
import utils.InputValidator;

import view.StudentManagerGUI;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo các đối tượng
        StudentRepository repository = new StudentRepository();
        StudentController controller = new StudentController(repository);

        // Khởi tạo giao diện người dùng (GUI)
        StudentManagerGUI gui = new StudentManagerGUI(controller);

        /*
        // Thêm sinh viên
        boolean success = controller.addStudent("123", "Nguyen A", 20, "a.nguyen@mail.com", "IT");
        System.out.println("Thêm sinh viên thành công: " + success);

        // Thêm sinh viên không hợp lệ
        boolean invalidAdd = controller.addStudent("124", "", 25, "invalid-email", "Math");
        System.out.println("Thêm sinh viên không hợp lệ thành công: " + invalidAdd);

        // In ra danh sách sinh viên
        System.out.println("Danh sách sinh viên:");
        for (Student student : repository.getAllStudents()) {
            System.out.println(student);
        }

        // Xóa sinh viên
        boolean removeSuccess = controller.removeStudent("123");
        System.out.println("Xóa sinh viên thành công: " + removeSuccess); */
    }
}
