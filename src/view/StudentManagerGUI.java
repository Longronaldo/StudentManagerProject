/*
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
                addStudent();  // Gọi phương thức thêm sinh viên
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

    // Phương thức thêm sinh viên
    private void addStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String email = emailField.getText();
        String major = majorField.getText();

        boolean success = controller.addStudent(id, name, age, email, major);
        if (success) {
            JOptionPane.showMessageDialog(frame, "Thêm sinh viên thành công!");
            updateStudentList();  // Cập nhật danh sách sinh viên sau khi thêm
        } else {
            JOptionPane.showMessageDialog(frame, "Dữ liệu không hợp lệ!");
        }
    }

    // Cập nhật danh sách sinh viên trong giao diện
    private void updateStudentList() {
        studentListArea.setText("");  // Xóa danh sách cũ
        for (Student student : controller.getRepository().getAllStudents()) {
            studentListArea.append(student.toString() + "\n");  // Thêm sinh viên vào danh sách
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
*/
package view;

import controller.StudentController;
import model.Student;
import model.StudentRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagerGUI {
    private JFrame frame;
    private JTextField idField, nameField, ageField, emailField, majorField;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private StudentController controller;

    public StudentManagerGUI(StudentController controller) {
        this.controller = controller;

        // Khởi tạo JFrame
        frame = new JFrame("Quản lý Sinh Viên");
        frame.setSize(600, 400);
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
                addStudent();  // Gọi phương thức thêm sinh viên
            }
        });
        inputPanel.add(addButton);

        // Nút xóa sinh viên
        JButton removeButton = new JButton("Xóa sinh viên");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent();  // Gọi phương thức xóa sinh viên
            }
        });
        inputPanel.add(removeButton);

        // Cài đặt bảng hiển thị danh sách sinh viên
        String[] columns = {"ID", "Tên", "Tuổi", "Email", "Chuyên ngành"};
        tableModel = new DefaultTableModel(columns, 0);
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Hiển thị panel nhập liệu
        frame.add(inputPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    // Phương thức thêm sinh viên
    private void addStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String email = emailField.getText();
        String major = majorField.getText();

        boolean success = controller.addStudent(id, name, age, email, major);
        if (success) {
            JOptionPane.showMessageDialog(frame, "Thêm sinh viên thành công!");
            updateStudentList();  // Cập nhật danh sách sinh viên sau khi thêm
        } else {
            JOptionPane.showMessageDialog(frame, "Dữ liệu không hợp lệ!");
        }
    }

    // Cập nhật danh sách sinh viên trong giao diện
    private void updateStudentList() {
        // Làm mới bảng
        tableModel.setRowCount(0);
        for (Student student : controller.getRepository().getAllStudents()) {
            // Thêm sinh viên vào bảng
            tableModel.addRow(new Object[]{student.getId(), student.getName(), student.getAge(), student.getEmail(), student.getMajor()});
        }
    }

    // Phương thức xóa sinh viên
    private void removeStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow != -1) {
            String studentId = (String) tableModel.getValueAt(selectedRow, 0);
            boolean success = controller.removeStudent(studentId);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Xóa sinh viên thành công!");
                updateStudentList();  // Cập nhật danh sách sau khi xóa
            } else {
                JOptionPane.showMessageDialog(frame, "Không tìm thấy sinh viên!");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Vui lòng chọn sinh viên cần xóa.");
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
