/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utn.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author pfino
 */
public class AppConfig {
    
    static AppConfig instance = new AppConfig();
    Properties config;
    
    private AppConfig()  {
        try {
            config = new Properties();
            config.load(new FileInputStream("./conf/app.properties"));
        } catch (IOException ex) {
            System.out.println("Error al cargar los datos de configuraion");
            System.exit(-1);
        }
    }
    
    
    public String getConfiguration(String key) {
        return this.config.getProperty(key);
    }
    
    
    public static AppConfig getInstance(){
        return instance;
    }
    
    
    
    
}
