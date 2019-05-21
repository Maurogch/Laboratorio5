package com.utn.SimParcial.repositories;

import com.utn.SimParcial.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT * FROM Vote WHERE datetime = NOW() - INTERVAL ?1 MINUTE")
    List<Vote> getAllByMinuteInterval(Integer minutes);
}
