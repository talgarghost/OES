package oes.controller;

import oes.model.Question;
import oes.service.Questionservice;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@RequestMapping("/api/questions")
public class Questioncontroller {
    private final Questionservice service=new Questionservice();
    @PostMapping
    public String addquiz(@RequestBody Question question) throws SQLException{
        service.addSingleQuestion(question);
        return  "look question";
    }
    @GetMapping("/{id}")
    public  Question get(@PathVariable int id) throws SQLException{
            return service.getQuestionById(id);
    }
}
