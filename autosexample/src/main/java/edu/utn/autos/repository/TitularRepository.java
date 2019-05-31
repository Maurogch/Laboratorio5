package edu.utn.autos.repository;

import edu.utn.autos.exception.TitularNotFoundException;
import edu.utn.autos.model.Titular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class TitularRepository extends BaseRepository  {

    @Autowired
    public TitularRepository(Connection con) {
        super(con);
    }

    public Titular getTitular(int idTitular) throws TitularNotFoundException {
        return null;
    }
}
