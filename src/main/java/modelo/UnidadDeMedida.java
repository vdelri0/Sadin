/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.UnidadDeMedidaDAO;
import java.util.List;
import modelo.vo.datosBasicos.UnidadDeMedidaVO;

/**
 * Realiza el manejo de toda la informacion de las unidades de medida      
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class UnidadDeMedida {
    public static final UnidadDeMedidaDAO unidadDeMedidaDao = new UnidadDeMedidaDAO();
    
    /**
     * Envia la informacion de la unidad de medida a la capa DAO para que sea creada
     * @param unidadDeMedida
     * @return 
     */
    public static boolean crear(UnidadDeMedidaVO unidadDeMedida){
        return unidadDeMedidaDao.crear(unidadDeMedida);
    }
    
    /**
     * Envia la informacion del codigo de la unidad de medida a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return unidadDeMedidaDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion de la unidad de medida a la capa DAO para que sea editada
     * @param unidadDeMedida
     * @return 
     */
    public static boolean editar(UnidadDeMedidaVO unidadDeMedida) {
        return unidadDeMedidaDao.editar(unidadDeMedida);
    }
    
    /**
     * Recibe las unidades de medida existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<UnidadDeMedidaVO> buscarTodo() {
       return unidadDeMedidaDao.buscarTodo();
    }
}
