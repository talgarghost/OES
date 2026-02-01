package oes.database;
import oes.model.Candidate;
import oes.model.Exam;
import oes.model.Question;

import java.sql.*;

public class ExamDAO {

    public int createExam(int candidateID) {

        String sql = """
            INSERT INTO exam (candidate_id)
            VALUES (?)
            RETURNING exam_id
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, candidateID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("exam_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void addQuestionToExam(int examID, int questionID) {

        String sql = """
            INSERT INTO exam_question (exam_id, question_id)
            VALUES (?, ?)
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, examID);
            ps.setInt(2, questionID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Exam getExamById(int examID) {

        String examSql = """
            SELECT e.exam_id, c.studentID, c.first_name, c.last_name,
                   c.email, c.group_school, c.total_score
            FROM exam e
            JOIN candidate c ON e.candidate_id = c.studentID
            WHERE e.exam_id = ?
        """;

        String questionSql = """
            SELECT q.question_id, q.quiz, q.correct_answer, q.score
            FROM question q
            JOIN exam_question eq ON q.question_id = eq.question_id
            WHERE eq.exam_id = ?
        """;

        try (Connection conn = DBConnection.getConnection()) {

            Candidate candidate = null;
            Exam exam = null;

            try (PreparedStatement ps = conn.prepareStatement(examSql)) {
                ps.setInt(1, examID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    candidate = new Candidate(
                            rs.getInt("studentID"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("group_school"),
                            rs.getDouble("total_score")
                    );
                    exam = new Exam(examID, candidate);
                }
            }

            if (exam == null) return null;

            try (PreparedStatement ps = conn.prepareStatement(questionSql)) {
                ps.setInt(1, examID);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Question q = new Question(
                            rs.getInt("question_id"),
                            rs.getString("quiz"),
                            rs.getString("correct_answer"),
                            rs.getDouble("score")
                    );
                    exam.addquations(q);
                }
            }

            return exam;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteExam(int examID) {

        String deleteExamQuestions = "DELETE FROM exam_question WHERE exam_id = ?";
        String deleteExam = "DELETE FROM exam WHERE exam_id = ?";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            try (PreparedStatement ps1 = conn.prepareStatement(deleteExamQuestions);
                 PreparedStatement ps2 = conn.prepareStatement(deleteExam)) {

                ps1.setInt(1, examID);
                ps1.executeUpdate();

                ps2.setInt(1, examID);
                ps2.executeUpdate();

                conn.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

