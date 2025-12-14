public class Questiom {
    private int questionId;
    private String quiz;
    private String correctAnswer;
    private double Score;

    public int getQuestionId() {
        return questionId;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public double getScore() {
        return Score;
    }
    public void setScore(double Score){
        this.Score=Score;}


    public String toString() {
        return questionId+" "+quiz+" "+correctAnswer+" "+Score;
    }
}
