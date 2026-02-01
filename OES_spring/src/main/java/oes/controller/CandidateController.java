package oes.controller;

import oes.model.Candidate;
import oes.service.Candidateservice;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final Candidateservice candidateService;

    // Конструктор для внедрения сервиса через Spring
    public CandidateController(Candidateservice candidateService) {
        this.candidateService = candidateService;
    }


    @GetMapping
    public ArrayList<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }


    @PostMapping
    public String addCandidate(@RequestBody Candidate candidate) {
        candidateService.addCandidate(candidate);
        return "Candidate added successfully";
    }


    @DeleteMapping("/{id}")
    public String deleteCandidate(@PathVariable int id) {
        candidateService.deleteCandidate(id);
        return "Candidate deleted successfully";
    }
}
