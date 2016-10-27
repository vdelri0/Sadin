/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.AgenciaDAO;
import java.util.List;
import modelo.vo.datosBasicos.AgenciaVO;

/**
 * Realiza el manejo de toda la informacion de las agencias
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class Agencia {
    public static final AgenciaDAO agenciaDao = new AgenciaDAO();
    
    /**
     * Envia la informacion de la agencia a la capa DAO para que sea creada
     * @param agencia
     * @return 
     */
    public static boolean crear(AgenciaVO agencia){
        return agenciaDao.crear(agencia);
    }
    
    /**
     * Envia la informacion del codigo de la agencia a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return agenciaDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion de la agencia a la capa DAO para que sea editada
     * @param agencia
     * @return 
     */
    public static boolean editar(AgenciaVO agencia) {
        return agenciaDao.editar(agencia);
    }
    
    /**
     * Recibe las agencias existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<AgenciaVO> buscarTodo() {
       return agenciaDao.buscarTodo();
    }
}
