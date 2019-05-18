package com.utn.springDemo.repositories;

import com.utn.springDemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Hace la interfaz un repositorio
// Ae extiende ademas JPA, primer generic es del tipo de objeto principal, segundo es el tipo de ID
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
