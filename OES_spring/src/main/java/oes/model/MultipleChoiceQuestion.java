package oes.model;
public class MultipleChoiceQuestion extends Question {
    private String[] options;
    private int correctOption;

    public MultipleChoiceQuestion(int questionId, String quiz, String correctAnswer, double score,
                                  String[] options, int correctOption) {
        super(questionId, quiz, correctAnswer, score);
        this.options = options;
        this.correctOption = correctOption;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    @Override
    public String toString() {
        String opt = "";
        if (options != null) {
            for (int i = 0; i < options.length; i++) {
                opt += "[" + i + "] " + options[i] + " ";
            }
        }
        return super.toString() + " | Options: " + opt + " | Correct Option: " + correctOption;
    }

}

