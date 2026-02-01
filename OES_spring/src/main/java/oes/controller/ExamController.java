package oes.controller;

import oes.model.Exam;
import oes.model.Question;
import oes.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @PostMapping
    public int createExam(@RequestParam int candidateID) {
        return service.createExam(candidateID);
    }

    @PostMapping("/{examID}/questions")
    public String addQuestionToExam(@PathVariable int examID, @RequestParam int questionID) {
        service.addQuestionToExam(examID, questionID);
        return "Question added to exam";
    }

    @GetMapping("/{examID}")
    public Exam getExamById(@PathVariable int examID) {
        return service.getExamById(examID);
    }

    @DeleteMapping("/{examID}")
    public String deleteExam(@PathVariable int examID) {
        service.deleteExam(examID);
        return "Exam deleted";
    }

    @GetMapping("/{examID}/questions/filter-hard")
    public ArrayList<Question> filterHardQuestions(@PathVariable int examID, @RequestParam int minScore) {
        return service.filterHardQuestions(examID, minScore);
    }

    @GetMapping("/{examID}/questions/filter-other")
    public ArrayList<Question> filterOtherQuestions(@PathVariable int examID, @RequestParam int maxScore) {
        return service.filterOtherQuestions(examID, maxScore);
    }

    @GetMapping("/{examID}/questions/search")
    public ArrayList<Question> searchQuestions(@PathVariable int examID, @RequestParam String keywords) {
        return service.searchQuestions(examID, keywords);
    }
}