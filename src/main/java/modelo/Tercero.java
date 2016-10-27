/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.TerceroDAO;
import java.util.List;
import modelo.vo.datosBasicos.TerceroVO;

/**
 * Realiza el manejo de toda la informacion de los terceros      
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class Tercero {
    public static final TerceroDAO terceroDao = new TerceroDAO();
    
    /**
     * Envia la informacion del tercero a la capa DAO para que sea creada
     * @param tercero
     * @return 
     */
    public static boolean crear(TerceroVO tercero){
        return terceroDao.crear(tercero);
    }
    
    /**
     * Envia la informacion del codigo del tercero a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return terceroDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion del tercero a la capa DAO para que sea editada
     * @param tercero
     * @return 
     */
    public static boolean editar(TerceroVO tercero) {
        return terceroDao.editar(tercero);
    }
    
    /**
     * Recibe los terceros existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<TerceroVO> buscarTodo() {
       return terceroDao.buscarTodo();
    }
}
