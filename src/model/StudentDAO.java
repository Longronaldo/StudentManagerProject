package model;

import java.io.*;
import java.util.*;

public class StudentDAO {
    private static final String FILE_PATH = "students.csv"; // Đường dẫn file để lưu dữ liệu

    // Lưu danh sách sinh viên vào file CSV
    public void saveStudents(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            // Ghi từng sinh viên vào file
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();  // Thêm một dòng mới cho mỗi sinh viên
            }
            System.out.println("Dữ liệu đã được lưu vào file.");
        } catch (IOException e) {
            e.printStackTrace();  // In ra lỗi nếu có vấn đề khi ghi file
        }
    }

    // Đọc danh sách sinh viên từ file CSV
    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");  // Phân tách các trường bằng dấu phẩy

                // Kiểm tra dữ liệu trước khi sử dụng
                if (data.length < 5) {
                    System.out.println("Dữ liệu không đầy đủ cho dòng: " + line);
                    continue;  // Bỏ qua dòng không hợp lệ
                }

                String id = data[0].trim();  // id là String
                String name = data[1].trim();
                int age = 0;
                try {
                    age = Integer.parseInt(data[2].trim());  // Cố gắng chuyển tuổi thành int
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu không hợp lệ cho tuổi: " + data[2]);
                    continue;  // Bỏ qua dòng này nếu tuổi không hợp lệ
                }

                String email = data[3].trim();
                String major = data[4].trim();

                // Tạo đối tượng Student và thêm vào danh sách
                students.add(new Student(name, id, age, email, major));
            }
        } catch (IOException e) {
            e.printStackTrace();  // In lỗi nếu có vấn đề khi đọc file
        }
        return students;
    }

}
