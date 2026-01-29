import java.util.ArrayList;
import java.util.List;

public class Student extends person {
    private int studentId;
    private List<Course> enrolledCourses;

    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Enrolled Courses:");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}
