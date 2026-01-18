import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/java_ass3",
                    "postgres",
                    "trnakastikr"
            );

            System.out.println("DB connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // Проверка подключения
            DBConnection.getConnection();
            System.out.println("Connection successful!");

            // CRUD
            CandidateDAO dao = new CandidateDAO();

            // INSERT
            dao.addCandidate("ALI Parhul", "ALI008@mail.com", "ONLINE");

            // SELECT
            dao.getAllCandidates();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
