package oes.model;
import java.util.ArrayList;

public class Exam {
    private int examID;
    private  Candidate candidate;
    private ArrayList<Question> questions;

    public Exam(int examID, Candidate candidate) {
        this.examID = examID;
        this.candidate = candidate;
        this.questions = new ArrayList<>();
    }
    public int getExamID(){
        return examID;
    }
    public Candidate getCandidate(){
        return candidate;
    }
    public void setCandidate(Candidate candidate){
        this.candidate=candidate;
    }
    public ArrayList<Question> getQuestions(){
        return questions;
    }
    public void addquations(Question quations){
        questions.add(quations);
    }
    public ArrayList<Question> filterhardScuare(int minScore){
        ArrayList<Question> hardquestion= new ArrayList<>();
        for (Question q : questions) {
            if (q.getScore() > minScore) {
                hardquestion.add(q);
            }

        }
        return hardquestion;
    }
    public ArrayList<Question> filterotherScuare(int maxScore) {
        ArrayList<Question> otherquestion = new ArrayList<>();
        for (Question q : questions) {
            if (q.getScore() <= maxScore) {
                otherquestion.add(q);
            }

        }
        return otherquestion;
    }
    public ArrayList<Question> searching(String keywords){
        ArrayList<Question> search=new ArrayList<>();
        for(Question q :questions){
            if (q.getQuiz().toLowerCase().contains(keywords.toLowerCase())){
                search.add(q);
            }
        }return search;
    }

    public void  sortquestion(){
        questions.sort((q1, q2) -> Double.compare(q2.getScore(),q1.getScore()));
    }

    @Override
    public String toString() {
        String  result= examID+"\n"+ candidate;
        for (Question q : questions) {
            result += q + "\n";
        }
        return result;
    }

    @Override
    public boolean equals(Object t) {
        if(this==t) return true;
        if (!(t instanceof Exam ))return false;
        Exam other=(Exam) t;
        return this.examID== other.examID;}
    @Override
    public int hashCode(){
        return Integer.hashCode(examID);
    }
}

