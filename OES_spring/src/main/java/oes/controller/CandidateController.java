package oes.controller;

import oes.model.Candidate;
import oes.service.Candidateservice;
import oes.database.CandidateDAO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final Candidateservice candidateService;

    public CandidateController(Candidateservice candidateService) { this.candidateService = candidateService;
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
    @GetMapping("/{id}")
    public  Candidate getByID(@PathVariable int id){
        return candidateService.getCandidateById(id);
    }

}
