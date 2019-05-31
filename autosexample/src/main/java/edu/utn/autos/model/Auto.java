package edu.utn.autos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Auto {

    int id;
    int modelo;
    String patente;
    int idTitular;
    Titular titular;

}
