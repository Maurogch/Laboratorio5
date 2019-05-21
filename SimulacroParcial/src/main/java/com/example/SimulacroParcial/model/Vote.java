package com.example.SimulacroParcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor

@Entity
public class Vote {
/*    @Id @GeneratedValue
    private Integer id;
    private LocalDateTime datetime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Candidate candidate;

    @PrePersist
    private void setDatetimeNow(){
        if(Objects.isNull(this.datetime)) this.datetime = LocalDateTime.now();
    }
*/}