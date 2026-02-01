package oes.database;

import oes.model.Candidate;

import java.sql.*;
import java.util.ArrayList;

public class CandidateDAO {

    // INSERT
    public void addCandidate(String firstName,
                             String lastName,
                             String email,
                             String password,
                             String groupSchool,
                             double total_score) {

        String sql = """
            INSERT INTO candidate 
            (first_name, last_name, email, acc_password, group_school, total_score)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, groupSchool);
            ps.setDouble(6, total_score);

            ps.executeUpdate();
            System.out.println("Candidate added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // SELECT
    public ArrayList<Candidate> getAllCandidates() {

        ArrayList<Candidate> list = new ArrayList<>();
        String sql = "SELECT * FROM candidate";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Candidate c = new Candidate(
                        rs.getInt("studentID"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("group_school"),
                        rs.getDouble("total_score")
                );
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE
    public void deleteCandidate(int studentID) {

        String sql = "DELETE FROM candidate WHERE studentID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentID);
            ps.executeUpdate();
            System.out.println("Candidate deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
