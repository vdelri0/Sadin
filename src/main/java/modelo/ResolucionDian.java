/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.ResolucionDianDAO;
import java.util.List;
import modelo.vo.datosBasicos.ResolucionDianVO;

/**
 * Realiza el manejo de toda la informacion de las resoluciones DIAN     
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class ResolucionDian {
    public static final ResolucionDianDAO resolucionDianDao = new ResolucionDianDAO();
    
    /**
     * Envia la informacion de la resolucion DIAN a la capa DAO para que sea creada
     * @param resolucionDian
     * @return 
     */
    public static boolean crear(ResolucionDianVO resolucionDian){
        return resolucionDianDao.crear(resolucionDian);
    }
    
    /**
     * Envia la informacion del codigo de la resolucion DIAN a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return resolucionDianDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion de la resolucion DIAN a la capa DAO para que sea editada
     * @param resolucionDian
     * @return 
     */
    public static boolean editar(ResolucionDianVO resolucionDian) {
        return resolucionDianDao.editar(resolucionDian);
    }
    
    /**
     * Recibe las resoluciones DIAN existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<ResolucionDianVO> buscarTodo() {
       return resolucionDianDao.buscarTodo();
    }
}
