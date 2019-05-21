package com.utn.SimParcial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //Getting error without this when getting by Id
public class Candidate {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    //mappedBy: name of variable with ManyToOne
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidate")
    @ToString.Exclude //was generating an StackOverflow exception when trying to print list, didn't want to print it anyway
    @JsonManagedReference
    private List<Vote> votes;
}


