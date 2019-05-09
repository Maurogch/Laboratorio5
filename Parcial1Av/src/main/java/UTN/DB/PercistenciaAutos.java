package UTN.DB;

import UTN.model.Auto;
import UTN.model.Marca;
import UTN.model.Titular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class PercistenciaAutos {
    private static final String TABLE_AUTOS = "Autos";
    private static final String TABLE_MARCAS = "Marcas";
    private static final String TABLE_TITULARES = "Titulares";
    private Connection conn = null;
    private PreparedStatement pStmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void setAuto(Auto auto){
        int idMarca = setMarca(auto.getMarca());
        int idAuto;

        try {
            conn = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO " + TABLE_AUTOS + "(modelo, anio, id_marca)" +
                    "values (?,?,?)";
            pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1,auto.getModelo());
            pStmt.setInt(2,auto.getAnio());
            pStmt.setInt(3,idMarca);

            rs = pStmt.getGeneratedKeys();
            rs.next();
            idAuto = rs.getInt(1);

            for(Titular titular : auto.getTitulares()){
                sql = "INSERT INTO " + TABLE_TITULARES + "(id_auto,nombre,apellido,dni)" +
                        "VALUES(?,?,?,?)";
                pStmt = conn.prepareStatement(sql);
                pStmt.setInt(1,idAuto);
                pStmt.setString(2,titular.getNombre());
                pStmt.setString(3,titular.getNombre());
                pStmt.setString(4,titular.getDni());

                pStmt.execute();
            }

            rs.close();
            pStmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Integer setMarca(Marca marca){
        Integer idMarca = null;
        try {
            conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT id FROM " + TABLE_MARCAS +
                    "WHERE marca = ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, marca.getNombreMarca());
            rs = pStmt.executeQuery();
            while(rs.next())
                idMarca = rs.getInt("id");

            if(Objects.isNull(idMarca)){
                sql = "INSERT INTO " + TABLE_MARCAS + "(marca, origen)" +
                        "VALUES(?,?)";
                pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pStmt.setString(1,marca.getNombreMarca());
                pStmt.setString(2,marca.getOrigen());

                pStmt.execute();

                rs = pStmt.getGeneratedKeys();
                rs.next();
                idMarca = rs.getInt(1);
            }

            rs.close();
            pStmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problem with connecting with Database");
        }
        return idMarca;
    }

    public void deleteAuto(int idAuto){
        try{
            conn = ConnectionFactory.getInstance().getConnection();
            String sql = "Delete from " + TABLE_AUTOS + "WHERE id = ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1,idAuto);
            pStmt.execute();

            sql = "Delete from " + TABLE_TITULARES + "WHERE id_auto = ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1,idAuto);
            pStmt.execute();

            pStmt.close();
            conn.close();
        }catch (SQLException ex){
            //
        }
    }

}
