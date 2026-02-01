package oes.model;

import java.util.Objects;

public class Candidate {

    private int studentID;
    private String firstName;
    private String lastName;
    private String email;
    private String accPassword;
    private String groupSchool;
    private double totalScore;

    public Candidate(String firstName,
                     String lastName,
                     String email,
                     String accPassword,
                     String groupSchool,
                     double totalScore) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accPassword = accPassword;
        this.groupSchool = groupSchool;
        this.totalScore = totalScore;
    }

    public Candidate(int studentID,
                     String firstName,
                     String lastName,
                     String email,
                     String groupSchool,
                     double totalScore) {

        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.groupSchool = groupSchool;
        this.totalScore = totalScore;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getAccPassword() {
        return accPassword;
    }

    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }

    public String getGroupSchool() {
        return groupSchool;
    }

    public void setGroupSchool(String groupSchool) {
        this.groupSchool = groupSchool;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return studentID + " " +
                firstName + " " +
                lastName + " " +
                email + " " +
                groupSchool + " " +
                totalScore;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Candidate)) return false;
        Candidate other = (Candidate) obj;
        return studentID == other.studentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }
}
