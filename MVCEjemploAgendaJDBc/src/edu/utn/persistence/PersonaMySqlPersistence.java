/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.persistence;

import edu.utn.model.Persona;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pfino
 */
public class PersonaMySqlPersistence {

    Connection conexion;
    Properties queries;
    static PersonaMySqlPersistence instance;
    
    
    public static PersonaMySqlPersistence getInstance() {
        if (instance == null) {
            instance = new PersonaMySqlPersistence();
        }
        return instance;
    }

    private PersonaMySqlPersistence() {
        try {
            
            queries = new Properties();
            queries.load(new FileInputStream("./conf/queries.properties"));
            
            Class.forName("com.mysql.jdbc.Driver");
            // Se establece la conexiÃ³n con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            
            // Se crea la base de datos y la tabla si no existe
            Statement st = conexion.createStatement();
            st.execute("CREATE DATABASE /*!32312 IF NOT EXISTS*/`utn` /*!40100 DEFAULT CHARACTER SET latin1 */;");
            st.execute("" 
                    + "CREATE TABLE IF NOT EXISTS `utn`.`personas` ("
                    + "  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,"
                    + "  `nombre` varchar(50) DEFAULT NULL,"
                    + "  `apellido` varchar(50) DEFAULT NULL,"
                    + "  `direccion` varchar(50) DEFAULT NULL,"
                    + "  `ciudad` varchar(50) DEFAULT NULL,"
                    + "  `pais` varchar(50) DEFAULT NULL,"
                    + "  PRIMARY KEY (`id`)"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            conexion.close();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/utn", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void modificarPersona(Persona p)  {
        try {
            String sql = queries.getProperty("query.modificarPersona");
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, p.getNombre());
            st.setString(2, p.getApellido());
            st.setString(3, p.getDireccion());
            st.setString(4, p.getCiudad());
            st.setString(5, p.getPais());
            st.setInt(6, p.getId());
            st.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
    public void agregarPersona(Persona p)  {
        try {
            String sql = queries.getProperty("query.agregarPersona");
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, p.getNombre());
            st.setString(2, p.getApellido());
            st.setString(3, p.getDireccion());
            st.setString(4, p.getCiudad());
            st.setString(5, p.getPais());
            st.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void eliminarPersona(int idPersona) {
        try {
            String sql = queries.getProperty("query.eliminarPersona");
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, idPersona);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public List<Persona> listarPersonas() {
        try {
            String sql = queries.getProperty("query.listarPersonas");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Persona> lista = new ArrayList<Persona>();
            while (rs.next()) {
                Persona p = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("ciudad"), rs.getString("pais"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
   public Persona getPersona(int id) {
      try {
            String sql = queries.getProperty("query.listarPersonas");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Persona p = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("ciudad"), rs.getString("pais"));
                return p;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
