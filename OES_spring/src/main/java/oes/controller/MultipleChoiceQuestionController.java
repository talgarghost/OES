package oes.controller;

import oes.model.MultipleChoiceQuestion;
import oes.service.MultipleChoiceQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/mc-questions")
public class MultipleChoiceQuestionController {

    private final MultipleChoiceQuestionService service;

    public MultipleChoiceQuestionController(MultipleChoiceQuestionService service) {
        this.service = service;
    }

    @GetMapping
    public ArrayList<MultipleChoiceQuestion> getAllQuestions() {
        return service.getAllQuestions();
    }

    @GetMapping("/{id}")
    public MultipleChoiceQuestion getQuestionById(@PathVariable int id) {
        return service.getQuestionById(id);
    }

    @PostMapping
    public String addQuestion(@RequestBody MultipleChoiceQuestion question) {
        service.addQuestion(question);
        return "MC Question added successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable int id) {
        service.deleteQuestion(id);
        return "MC Question deleted successfully";
    }
}
