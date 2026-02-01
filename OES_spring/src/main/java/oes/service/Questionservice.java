package oes.service;
import java.sql.*;
import java.util.List;

import oes.database.DBConnection;
import oes.database.QuestionDAO;
import oes.model.Question;

public class Questionservice {

    public void addSingleQuestion(Question question) throws SQLException {

        String sql = "INSERT INTO question (quiz, correct_answer, score) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, question.getQuiz());
            ps.setString(2, question.getCorrectAnswer());
            ps.setDouble(3, question.getScore());

            ps.executeUpdate();
        }
    }


    public Question getQuestionById(int id) throws SQLException {

        String sql = "SELECT * FROM question WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Question(
                        rs.getInt("id"),
                        rs.getString("quiz"),
                        rs.getString("correct_answer"),
                        rs.getDouble("score")
                );
            }
            return null;
        }
    }


    public void updateScore(int id, double score) throws SQLException {

        String sql = "UPDATE question SET score = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, score);
            ps.setInt(2, id);

            ps.executeUpdate();
        }
    }
}
