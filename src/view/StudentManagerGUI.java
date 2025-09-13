package view;

import controller.StudentController;
import model.Student;
import model.StudentRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagerGUI {
    private JFrame frame;
    private JTextField idField, nameField, ageField, emailField, majorField;
    private JTextArea studentListArea;
    private StudentController controller;

    public StudentManagerGUI(StudentController controller) {
        this.controller = controller;

        // Khởi tạo JFrame
        frame = new JFrame("Quản lý Sinh Viên");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel nhập liệu
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Tên:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Tuổi:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Chuyên ngành:"));
        majorField = new JTextField();
        inputPanel.add(majorField);

        // Nút thêm sinh viên
        JButton addButton = new JButton("Thêm sinh viên");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String email = emailField.getText();
                String major = majorField.getText();

                boolean success = controller.addStudent(id, name, age, email, major);
                if (success) {
                    JOptionPane.showMessageDialog(frame, "Thêm sinh viên thành công!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Dữ liệu không hợp lệ!");
                }
            }
        });

        // Thêm nút vào panel
        inputPanel.add(addButton);

        // Hiển thị danh sách sinh viên
        studentListArea = new JTextArea();
        studentListArea.setEditable(false);

        // Panel hiển thị danh sách sinh viên
        JScrollPane scrollPane = new JScrollPane(studentListArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Hiển thị panel nhập liệu
        frame.add(inputPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    // Cập nhật danh sách sinh viên trong giao diện
    public void updateStudentList(StudentRepository repository) {
        studentListArea.setText("");
        for (Student student : repository.getAllStudents()) {
            studentListArea.append(student.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        // Khởi tạo các đối tượng
        StudentRepository repository = new StudentRepository();
        StudentController controller = new StudentController(repository);

        // Khởi tạo giao diện người dùng
        StudentManagerGUI gui = new StudentManagerGUI(controller);
    }
}
