package edu.utn.autos.repository;

import edu.utn.autos.exception.AutoNotFoundException;
import edu.utn.autos.model.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoRepository extends BaseRepository {


    @Autowired
    public AutoRepository(@Qualifier("con2") Connection con) {
        super(con);
    }


    public List<Auto> getAutos(Integer modelo) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from autos where modelo = ?");
        ps.setInt(1, modelo);
        ResultSet rs = ps.executeQuery();
        List<Auto> list = new ArrayList<Auto>();
        while (rs.next()) {
            list.add(getAuto(rs));
        }
        return list;

    }

    public Auto getAuto(Integer id) throws AutoNotFoundException {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from autos where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getAuto(rs);
            } else {
                throw new AutoNotFoundException(null);
            }
        } catch (SQLException e) {
            throw new AutoNotFoundException(e);
        }
    }

    public Auto addAuto(Auto auto) throws Exception {

        PreparedStatement ps = connection.prepareStatement("insert into autos (modelo, patente, id_titular) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, auto.getModelo());
        ps.setString(2, auto.getPatente());
        ps.setInt(3, auto.getIdTitular());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            auto.setId(rs.getInt(1));
        } else {
            throw new Exception("No se agrego el auto");
        }
        return auto;
    }


    private Auto getAuto(ResultSet rs) throws SQLException {
        return Auto.builder().id(rs.getInt("id")).modelo(rs.getInt("modelo"))
                .patente(rs.getString("patente"))
                .idTitular(rs.getInt("id_titular"))
                .build();
    }

}
