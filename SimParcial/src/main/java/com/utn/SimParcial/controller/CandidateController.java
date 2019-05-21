package com.utn.SimParcial.controller;

import com.utn.SimParcial.model.Candidate;
import com.utn.SimParcial.model.Vote;
import com.utn.SimParcial.repositories.CandidateRepository;
import com.utn.SimParcial.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/Candidate")
@RestController
public class CandidateController {
    private static final String PERSON_NOT_FOUND = "No existe la persona con el id: %s";
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private VoteRepository voteRepository;

    @PostMapping("")
    public void add(@RequestBody Candidate candidate){
        candidateRepository.save(candidate);
    }

    @GetMapping("")
    public List<Candidate> getAll(){
        return candidateRepository.findAll();
    }

    @GetMapping("/{id}")
    public Candidate getById(@PathVariable("id") Integer id){
        return candidateRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND,id)));
    }

    @PostMapping("/votes/{idCandidato}")
    public void voteCandidate(@PathVariable("idCandidato") Integer id){
        Vote vote = new Vote();
        vote.setCandidate(getById(id));
        voteRepository.save(vote);
    }

    @GetMapping("/votes")
    public Map<Candidate,Integer> getVotes(){
        List<Vote> votes = voteRepository.findAll();
        Map<Candidate, Integer> map = new HashMap<>();

        for(Vote vote : votes) {
            Integer count = map.get(vote.getCandidate());
            map.put(vote.getCandidate(), (Objects.isNull(count)) ? 1 : count + 1 );
        }

        return map;
    }

    //Easier method
    @GetMapping("/votes2")
    public Map<Candidate,Integer> getVotes2(){
        List<Candidate> candidates = candidateRepository.findAll();
        Map<Candidate, Integer> map = new HashMap<>();

        candidates.forEach(c -> map.put(c, c.getVotes().size()));
        return map;
    }

    @Scheduled(cron = "*/5 * * * *") //cron, every five minutes everyday
    public void deleteVotes(){
        voteRepository.getAllByMinuteInterval(5).forEach(vote -> voteRepository.delete(vote));
    }
}
