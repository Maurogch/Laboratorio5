package com.utn.springDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data //Genera los getters,setters y un constructor implicito
@NoArgsConstructor //Constructor vacio
@AllArgsConstructor //Constructor completo
@Entity //Indica a la BD que el objeto va a ser una tabla
public class Person {
    @Id //Indica que el atributo va a ser el ID de la tabla
    @GeneratedValue //Autoincrement
    private Integer id;
    private String name;
    private String lastName;
}
