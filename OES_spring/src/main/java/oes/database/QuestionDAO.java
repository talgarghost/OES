package oes.database;
import oes.model.Question;
import java.sql.*;
import java.util.ArrayList;

public class QuestionDAO {

    // CREATE (INSERT)
    public void addQuestion(String quiz, String correctAnswer, double score) throws SQLException {
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
    public ArrayList<Question> getAllQuestions() throws SQLException {
        ArrayList<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM question";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Question q = new Question(
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
    public Question getQuestionById(int id) throws SQLException {
        String sql = "SELECT * FROM question WHERE question_id = ?";
        Question question = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                question = new Question(
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
    public void updateQuestion(int id, String quiz, String correctAnswer, double score) throws SQLException {
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

}
