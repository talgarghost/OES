import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Candidate studen1=new Candidate();
        studen1.Setname("Ali");
        studen1.stelast_name("Parhul");
        studen1.setgroup("SE-2511");
        studen1.setTotalScore(75.68);
        Questiom quiz1=new Questiom();
        quiz1.setQuiz("what is java");
        quiz1.setCorrectAnswer("Java is program language");
        quiz1.setScore(10.12);
        Exam exam1=new Exam();
        exam1.setCandidate(studen1);
        exam1.setQuestiom(quiz1);
        System.out.println(exam1.toString());
}

}