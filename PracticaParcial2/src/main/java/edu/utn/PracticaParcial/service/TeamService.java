package edu.utn.PracticaParcial.service;

import edu.utn.PracticaParcial.model.PlayersPerTeamDTO;
import edu.utn.PracticaParcial.repository.PlayersPerTeamRepository;
import edu.utn.PracticaParcial.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayersPerTeamRepository playersPerTeamRepository;

    @Async("Executor")
    public CompletableFuture<List<PlayersPerTeamDTO>> getAllWithPlayerQuantity(){
        List<PlayersPerTeamDTO> list = playersPerTeamRepository.getTeamsWithPlayerQuantity();
        return CompletableFuture.completedFuture(list);
    }
}
