public class TrueFalseQuestion extends Questiom {
    private boolean correctValue;

    public TrueFalseQuestion(int questionId, String quiz, String correctAnswer, double score,
                             boolean correctValue) {
        super(questionId, quiz, correctAnswer, score);
        this.correctValue = correctValue;
    }

    public boolean getCorrectValue() {
        return correctValue;
    }

    @Override
    public String toString() {
        return super.toString() + " | Correct: " + correctValue;
    }
}
