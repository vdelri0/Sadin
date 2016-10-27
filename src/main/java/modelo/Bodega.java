/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.BodegaDAO;
import java.util.List;
import modelo.vo.datosBasicos.BodegaVO;

/**
 * Realiza el manejo de toda la informacion de las bodegas
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class Bodega {
    public static final BodegaDAO bodegaDao = new BodegaDAO();
    
    /**
     * Envia la informacion de la bodega a la capa DAO para que sea creada
     * @param bodega
     * @return 
     */
    public static boolean crear(BodegaVO bodega){
        return bodegaDao.crear(bodega);
    }
    
    /**
     * Envia la informacion del codigo de la bodega a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return bodegaDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion de la bodega a la capa DAO para que sea editada
     * @param bodega
     * @return 
     */
    public static boolean editar(BodegaVO bodega) {
        return bodegaDao.editar(bodega);
    }
    
    /**
     * Recibe las bodegas existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<BodegaVO> buscarTodo() {
       return bodegaDao.buscarTodo();
    }
    
}
