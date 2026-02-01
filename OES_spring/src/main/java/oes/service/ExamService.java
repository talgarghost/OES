package oes.service;

import org.springframework.stereotype.Service;
import oes.database.ExamDAO;
import oes.model.Exam;
import oes.model.Question;

import java.util.ArrayList;

@Service
public class ExamService {

    private final ExamDAO dao;

    public ExamService() {
        this.dao = new ExamDAO();
    }

    public int createExam(int candidateID) {
        return dao.createExam(candidateID);
    }

    public void addQuestionToExam(int examID, int questionID) {
        dao.addQuestionToExam(examID, questionID);
    }

    public Exam getExamById(int examID) {
        return dao.getExamById(examID);
    }

    public void deleteExam(int examID) {
        dao.deleteExam(examID);
    }

    public ArrayList<Question> filterHardQuestions(int examID, int minScore) {
        Exam exam = dao.getExamById(examID);
        if (exam != null) {
            return exam.filterhardScuare(minScore);
        }
        return new ArrayList<>();
    }

    public ArrayList<Question> filterOtherQuestions(int examID, int maxScore) {
        Exam exam = dao.getExamById(examID);
        if (exam != null) {
            return exam.filterotherScuare(maxScore);
        }
        return new ArrayList<>();
    }

    public ArrayList<Question> searchQuestions(int examID, String keywords) {
        Exam exam = dao.getExamById(examID);
        if (exam != null) {
            return exam.searching(keywords);
        }
        return new ArrayList<>();
    }

    public void sortExamQuestions(int examID) {
        Exam exam = dao.getExamById(examID);
        if (exam != null) {
            exam.sortquestion();
        }
    }
}
