package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data//me genera los setters y getters y constructor implicito
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor completo
@Entity //le indica a una bd que lo de abajo es una tabla

public class Persona {
    @Id @GeneratedValue //le indica que es el id y el generatedValue es el auto_increment
    private Integer id;
    private String nombre;
    private String apellido;
}
