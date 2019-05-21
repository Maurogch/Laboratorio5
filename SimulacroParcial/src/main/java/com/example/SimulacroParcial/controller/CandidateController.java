package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.model.Candidate;
import com.example.SimulacroParcial.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Candidate")
@RestController
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    /*@Autowired
    private VoteRepository voteRepository;*/

    @PostMapping("")
    public void setCandidate(@RequestBody Candidate c){
        candidateRepository.save(c);
    }

    /*@GetMapping("")
    public List<Candidate> getAll(){
        return candidateRepository.findAll();
    }

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathParam("id") Integer id){
        return candidateRepository.getOne(id);
    }

    @PostMapping("/votes/{idCandidato}")
    public void voteByCandidateId(@PathParam("idCandidato") Integer id){
        /*old code
        Candidate c = candidateRepository.getOne(id);
        c.setVotes(c.getVotes() + 1);
         */
        /*Vote vote = new Vote();
        vote.setCandidate(candidateRepository.getOne(id));
        voteRepository.save(vote);

    }

    @GetMapping("/votes")
    public Map<Candidate, Integer> getCandidatesWithVotes(){
        List<Candidate> candidates = candidateRepository.findAll();
        Map<Candidate, Integer> map = new HashMap<>();
        candidates.forEach(c -> map.put(c,c.getVotes()));
        return map;
    }*/


}
