/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.ArticuloDAO;
import java.util.List;
import modelo.vo.datosBasicos.ArticuloVO;

/**
 * Realiza el manejo de toda la informacion de los articulos      
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class Articulo {
     public static final ArticuloDAO articuloDao = new ArticuloDAO();
    
    /**
     * Envia la informacion del articulo a la capa DAO para que sea creada
     * @param articulo
     * @return 
     */
    public static boolean crear(ArticuloVO articulo){
        return articuloDao.crear(articulo);
    }
    
    /**
     * Envia la informacion del codigo del articulo a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return articuloDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion del articulo a la capa DAO para que sea editada
     * @param articulo
     * @return 
     */
    public static boolean editar(ArticuloVO articulo) {
        return articuloDao.editar(articulo);
    }
    
    /**
     * Recibe los articulos existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<ArticuloVO> buscarTodo() {
       return articuloDao.buscarTodo();
    }
    
}
