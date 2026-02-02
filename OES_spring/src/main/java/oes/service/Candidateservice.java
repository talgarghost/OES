package oes.service;

import org.springframework.stereotype.Service;
import oes.database.CandidateDAO;
import oes.model.Candidate;
import java.util.ArrayList;

@Service
public class Candidateservice {

    private final CandidateDAO candidateDAO;

    public Candidateservice() {
        this.candidateDAO = new CandidateDAO();
    }


    public void addCandidate(Candidate candidate) {
        candidateDAO.addCandidate(
                candidate.getFirstName(),
                candidate.getLastName(),
                candidate.getEmail(),
                candidate.getAccPassword(),
                candidate.getGroupSchool(),
                candidate.getTotalScore()
        );
    }


    public ArrayList<Candidate> getAllCandidates() {
        return candidateDAO.getAllCandidates();
    }
    public interface CandidateService {
        Candidate getCandidateById(int studentID);
    }
    public Candidate getCandidateById(int studentID) {
        ArrayList<Candidate> list = candidateDAO.getAllCandidates();
        for (Candidate c : list) {
            if (c.getStudentID() == studentID) {
                return c;
            }
        }
        return null;
    }
    public void deleteCandidate(int studentID) {
        candidateDAO.deleteCandidate(studentID);
    }
}
