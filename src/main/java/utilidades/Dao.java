/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Maneja todas las operaciones utilitarias que estan relacionadas con clases DAO
 * @author Victor Del Rio Prens
 */
public class Dao {
    
    /**
     * Toma la ruta del archivo sql para acceder a el y desglozarlo en forma de String
     * el cual contiene el Query solicitado.
     * @param path
     * @return 
     */
    public static String retornarQuery(String path){
        String query = "";
        List<String> querys;
        try {
            querys = Files.readAllLines(Paths.get(path));
            for (String linea : querys) {
                query += linea;
            }
        } catch (IOException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return query;
     }
    
}
