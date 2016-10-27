/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.ParametrosIvaDAO;
import java.util.List;
import modelo.vo.datosBasicos.ParametrosIvaVO;

/**
 * Realiza el manejo de toda la informacion de los parametros IVA
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class ParametrosIva {
    public static final ParametrosIvaDAO parametrosIvaDao = new ParametrosIvaDAO();
    
    /**
     * Envia la informacion de los parametros IVA a la capa DAO para que sea creada
     * @param parametrosIva
     * @return 
     */
    public static boolean crear(ParametrosIvaVO parametrosIva){
        return parametrosIvaDao.crear(parametrosIva);
    }
    
    /**
     * Envia la informacion del codigo de los parametros IVA a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return parametrosIvaDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion de los parametros IVA a la capa DAO para que sea editada
     * @param parametrosIva
     * @return 
     */
    public static boolean editar(ParametrosIvaVO parametrosIva) {
        return parametrosIvaDao.editar(parametrosIva);
    }
    
    /**
     * Recibe los parametros IVA existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<ParametrosIvaVO> buscarTodo() {
       return parametrosIvaDao.buscarTodo();
    }
    
}
