import java.util.Objects;

public class Candidate {

    private int studentID;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String group;
    private double totalScore;

    public Candidate(int studentID, String name, String lastName,
                     String email, String password, String group, double totalScore) {
        this.studentID = studentID;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.group = group;
        this.totalScore = totalScore;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return studentID + " " + name + " " + lastName + " " +email+" "+password+" "+ group + " " + totalScore;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Candidate)) return false;
        Candidate other = (Candidate) obj;
        return studentID == other.studentID &&
                Objects.equals(name, other.name) &&
                Objects.equals(lastName, other.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, name, lastName);
    }
}
