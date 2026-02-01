package oes.service;

import org.springframework.stereotype.Service;
import oes.database.MultipleChoiceQuestionDAO;
import oes.model.MultipleChoiceQuestion;

import java.util.ArrayList;

@Service
public class MultipleChoiceQuestionService {

    private final MultipleChoiceQuestionDAO dao;

    public MultipleChoiceQuestionService() {
        this.dao = new MultipleChoiceQuestionDAO();
    }


    public void addQuestion(MultipleChoiceQuestion question) {
        dao.addQuestion(question);
    }


    public MultipleChoiceQuestion getQuestionById(int id) {
        return dao.getById(id);
    }

    public ArrayList<MultipleChoiceQuestion> getAllQuestions() {
        return dao.getAll();
    }


    public void deleteQuestion(int id) {
        dao.delete(id);
    }
}
