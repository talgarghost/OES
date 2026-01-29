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
            QuestionDAO qod=new QuestionDAO();
                    qod.addQuestion("what is java", "java is programming language",12.5);
            qod.getAllQuestions();
            // CRUD
            CandidateDAO dao = new CandidateDAO();

            // INSERT
            dao.addCandidate("asik Parhul", "ALI008@mail.com", "ONLINE");

            // SELECT
            dao.getAllCandidates();
            dao.deleteCandidate(2);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
