package kz.aldiyar.students.Sprint1.db;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static Long id = 8L;
    static {
        students.add(new Student(1L, "Iliyas", "Zhuanyshev", 88, "B"));
        students.add(new Student(2L, "Serik", "Erikov", 91, "A"));
        students.add(new Student(3L, "Erik", "Serikov", 65, "C"));
        students.add(new Student(4L, "Nurzhan", "Bolatov", 48, "F"));
        students.add(new Student(5L, "Patrick", "Zuckerberg", 100, "A"));
        students.add(new Student(6L, "Sabina", "Assetova", 33, "F"));
        students.add(new Student(7L, "Madina", "Adletova", 77, "B"));
        students.add(new Student(8L, "Karina", "Serzhanova", 51, "D"));
    }
    public static ArrayList<Student> getStudents(){
        return students;
    }
    public static void addStudent(Student student){
        student.setId(id);
        id++;
        students.add(student);
    }

    public static Student getStudent(int id){
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }
}
