import java.sql.*;

public class UniversityDatabaseImpl implements UniversityDatabase {

    private Connection connection;

    private final String URL = "jdbc:postgresql://localhost:5432/university";
    private final String USER = "postgres";
    private final String PASSWORD = "trnakastikr";

    @Override
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Database connected");
    }

    @Override
    public void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("Database disconnected");
        }
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, student.getStudentId());
        ps.setString(2, student.getName());
        ps.setInt(3, student.getAge());
        ps.executeUpdate();
    }

    @Override
    public void addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO courses VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, course.getCourseId());
        ps.setString(2, course.getCourseName());
        ps.executeUpdate();
    }

    @Override
    public Student getStudentById(int studentId) throws SQLException {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, studentId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Student(
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getInt("student_id")
            );
        }
        return null;
    }

    @Override
    public Course getCourseById(int courseId) throws SQLException {
        String sql = "SELECT * FROM courses WHERE course_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, courseId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_name")
            );
        }
        return null;
    }

    @Override
    public void enrollStudentInCourse(int studentId, int courseId) throws SQLException {
        String sql = "INSERT INTO enrollments VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, studentId);
        ps.setInt(2, courseId);
        ps.executeUpdate();
    }
}
