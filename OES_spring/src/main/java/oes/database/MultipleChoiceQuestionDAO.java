package oes.database;

import oes.model.MultipleChoiceQuestion;

import java.sql.*;
import java.util.ArrayList;

public class MultipleChoiceQuestionDAO {

    public void addQuestion(MultipleChoiceQuestion q) {

        String questionSql = """
            INSERT INTO question (quiz, correct_answer, score, question_type)
            VALUES (?, ?, ?, 'MC')
            RETURNING question_id
        """;

        String mcSql = """
            INSERT INTO mc_question (question_id, options, correct_option)
            VALUES (?, ?, ?)
        """;

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            int questionId;

            try (PreparedStatement ps = conn.prepareStatement(questionSql)) {
                ps.setString(1, q.getQuiz());
                ps.setString(2, q.getCorrectAnswer());
                ps.setDouble(3, q.getScore());

                ResultSet rs = ps.executeQuery();
                rs.next();
                questionId = rs.getInt("question_id");
            }

            try (PreparedStatement ps = conn.prepareStatement(mcSql)) {
                Array sqlArray = conn.createArrayOf("text", q.getOptions());
                ps.setInt(1, questionId);
                ps.setArray(2, sqlArray);
                ps.setInt(3, q.getCorrectOption());
                ps.executeUpdate();
            }

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MultipleChoiceQuestion getById(int id) {

        String sql = """
            SELECT q.question_id, q.quiz, q.correct_answer, q.score,
                   m.options, m.correct_option
            FROM question q
            JOIN mc_question m ON q.question_id = m.question_id
            WHERE q.question_id = ?
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Array arr = rs.getArray("options");
                String[] options = (String[]) arr.getArray();

                return new MultipleChoiceQuestion(
                        rs.getInt("question_id"),
                        rs.getString("quiz"),
                        rs.getString("correct_answer"),
                        rs.getDouble("score"),
                        options,
                        rs.getInt("correct_option")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<MultipleChoiceQuestion> getAll() {

        ArrayList<MultipleChoiceQuestion> list = new ArrayList<>();

        String sql = """
            SELECT q.question_id, q.quiz, q.correct_answer, q.score,
                   m.options, m.correct_option
            FROM question q
            JOIN mc_question m ON q.question_id = m.question_id
        """;

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Array arr = rs.getArray("options");
                String[] options = (String[]) arr.getArray();

                MultipleChoiceQuestion q = new MultipleChoiceQuestion(
                        rs.getInt("question_id"),
                        rs.getString("quiz"),
                        rs.getString("correct_answer"),
                        rs.getDouble("score"),
                        options,
                        rs.getInt("correct_option")
                );

                list.add(q);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void delete(int questionId) {

        String sql = "DELETE FROM question WHERE question_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, questionId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
