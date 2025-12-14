public class Exam {
    private int examID;
    private  Candidate candidate;
    private Questiom questiom;
    public int getExamID(){
        return examID;
    }
    public Candidate getCandidate(){
        return candidate;
    }
    public void setCandidate(Candidate candidate){
        this.candidate=candidate;
    }
    public  Questiom getQuestiom(){
        return questiom;
    }

    public void setQuestiom(Questiom questiom) {
        this.questiom = questiom;
    }

    @Override
    public String toString() {
        return examID+"\n"+ candidate+"\n"+questiom;
    }
}
