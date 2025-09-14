package main;

import model.Student;
import model.StudentRepository;
import controller.StudentController;
import view.StudentManagerGUI;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo các đối tượng
        StudentRepository repository = new StudentRepository();
        StudentController controller = new StudentController(repository);
        StudentManagerGUI gui = new StudentManagerGUI(controller);

        repository.loadStudentsFromFile();

        for (Student student : controller.getRepository().getAllStudents()) {
            System.out.println(student);
        }
    }
}
