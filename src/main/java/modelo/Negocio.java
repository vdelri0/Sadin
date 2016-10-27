/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.NegocioDAO;
import java.util.List;
import modelo.vo.datosBasicos.NegocioVO;

/**
 * Realiza el manejo de toda la informacion de los negocios      
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class Negocio {
    public static final NegocioDAO negocioDao = new NegocioDAO();
    
    /**
     * Envia la informacion del negocio a la capa DAO para que sea creada
     * @param negocio
     * @return 
     */
    public static boolean crear(NegocioVO negocio){
        return negocioDao.crear(negocio);
    }
    
    /**
     * Envia la informacion del codigo del negocio a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return negocioDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion del negocio a la capa DAO para que sea editada
     * @param negocio
     * @return 
     */
    public static boolean editar(NegocioVO negocio) {
        return negocioDao.editar(negocio);
    }
    
    /**
     * Recibe los negocios existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<NegocioVO> buscarTodo() {
       return negocioDao.buscarTodo();
    }
}
