import java.sql.SQLException;

public interface UniversityDatabase {
    void connect() throws SQLException;
    void disconnect() throws SQLException;

    void addStudent(Student student) throws SQLException;
    void addCourse(Course course) throws SQLException;

    Student getStudentById(int studentId) throws SQLException;
    Course getCourseById(int courseId) throws SQLException;

    void enrollStudentInCourse(int studentId, int courseId) throws SQLException;
}
