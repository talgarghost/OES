

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
    public Questiom(int questionId, String quiz, String correctAnswer, double score) {
        this.questionId = questionId;
        this.quiz = quiz;
        this.correctAnswer = correctAnswer;
        this.Score = score;
    }
    @Override
    public String toString() {
        return questionId+" "+quiz+" "+correctAnswer+" "+Score;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Questiom)) return false;
        Questiom other = (Questiom) obj;
        return this.getQuiz().equals(other.getQuiz()); // сравниваем только текст
    }

    @Override
    public int hashCode() {
        return getQuiz().hashCode();
    }

}
