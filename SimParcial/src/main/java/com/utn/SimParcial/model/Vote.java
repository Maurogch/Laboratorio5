package com.utn.SimParcial.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import static java.util.Objects.isNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vote {
    @Id @GeneratedValue
    private Integer id;
    private LocalDateTime datetime;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_candidate", referencedColumnName = "id")
    //@JsonIgnore //don't need this value if theres a list in Candidate
    @JsonBackReference //fill this value if you already have the list filled?
    private Candidate candidate;

    @PrePersist
    private void setDatetimeNow(){
        if(isNull(this.datetime)) this.datetime = LocalDateTime.now();
    }
}