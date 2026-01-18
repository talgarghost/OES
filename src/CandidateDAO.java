import java.sql.*;

public class CandidateDAO {

    // INSERT
    public void addCandidate(String name, String email, String type) {
        String sql = "INSERT INTO candidate (name, email, candidate_type) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, type);
            ps.executeUpdate();

            System.out.println("Candidate added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT
    public void getAllCandidates() {
        String sql = "SELECT * FROM candidate";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email") + " | " +
                                rs.getString("candidate_type")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteCandidate(int id) {
        String sql = "DELETE FROM candidate WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Candidate deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
