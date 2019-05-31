package edu.utn.autos.service;


import edu.utn.autos.exception.AutoNotFoundException;
import edu.utn.autos.exception.TitularNotFoundException;
import edu.utn.autos.model.Auto;
import edu.utn.autos.model.Titular;
import edu.utn.autos.repository.AutoRepository;
import edu.utn.autos.repository.TitularRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Data
@Service
public class AutoService {
    private final AutoRepository autoRepository;
    private final TitularRepository titularRepository;

    @Autowired
    public AutoService(AutoRepository repository, TitularRepository titularRepository) {
        this.autoRepository = repository;
        this.titularRepository = titularRepository;
    }


    public List<Auto> getAutos(Integer modelo) throws SQLException {
        return autoRepository.getAutos(modelo);
    }

    public Auto getAuto(Integer id) throws AutoNotFoundException, TitularNotFoundException {
        return autoRepository.getAuto(id);
    }
    public Auto addAuto(Auto auto) throws Exception {
         return autoRepository.addAuto(auto);
    }


}
