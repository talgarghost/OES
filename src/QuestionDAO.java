import java.sql.*;
import java.util.ArrayList;

public class QuestionDAO {

    // CREATE (INSERT)
    public void addQuestion(String quiz, String correctAnswer, double score) {
        String sql = "INSERT INTO question (quiz, correct_answer, score) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, quiz);
            ps.setString(2, correctAnswer);
            ps.setDouble(3, score);
            ps.executeUpdate();

            System.out.println("Question added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (SELECT ALL)
    public ArrayList<Questiom> getAllQuestions() {
        ArrayList<Questiom> questions = new ArrayList<>();
        String sql = "SELECT * FROM question";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Questiom q = new Questiom(
                        rs.getInt("question_id"),
                        rs.getString("quiz"),
                        rs.getString("correct_answer"),
                        rs.getDouble("score")
                );
                questions.add(q);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    // READ (SELECT BY ID)
    public Questiom getQuestionById(int id) {
        String sql = "SELECT * FROM question WHERE question_id = ?";
        Questiom question = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                question = new Questiom(
                        rs.getInt("question_id"),
                        rs.getString("quiz"),
                        rs.getString("correct_answer"),
                        rs.getDouble("score")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    // UPDATE
    public void updateQuestion(int id, String quiz, String correctAnswer, double score) {
        String sql = "UPDATE question SET quiz = ?, correct_answer = ?, score = ? WHERE question_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, quiz);
            ps.setString(2, correctAnswer);
            ps.setDouble(3, score);
            ps.setInt(4, id);
            ps.executeUpdate();

            System.out.println("Question updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteQuestion(int id) {
        String sql = "DELETE FROM question WHERE question_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Question deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
