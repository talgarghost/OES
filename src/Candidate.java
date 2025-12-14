public class Candidate {
    private int studentID;
    private String name;
    private String last_name;
    private String group;
    private double totalScore;


    public int getStudentID() {
        return studentID;
    }

    public String getname() {
        return name;
    }

    public void Setname(String name) {
        this.name = name;
    }

    public String getlast_name() {
        return last_name;
    }

    public void stelast_name(String last_name) {
        this.last_name = last_name;
    }

    public String Getgroup() {
        return group;
    }

    public void setgroup(String group) {
        this.group = group;
    }

    public double getTotalScore() {
        return totalScore;
    }
public void setTotalScore(double totalScore){
        this.totalScore=totalScore;
}
    @Override
    public String toString(){
        return studentID +" "+ name+" "+last_name+" "+group+" "+totalScore;
    }

}


