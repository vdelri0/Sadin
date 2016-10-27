/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.FuenteDeIngresosDAO;
import java.util.List;
import modelo.vo.datosBasicos.FuenteDeIngresosVO;

/**
 * Realiza el manejo de toda la informacion de las fuentes de ingresos.      
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class FuenteDeIngresos {
    public static final FuenteDeIngresosDAO fuenteDeIngresosDao = new FuenteDeIngresosDAO();
    
    /**
     * Envia la informacion de la fuente de ingresos a la capa DAO para que sea creada
     * @param fuenteDeIngresos
     * @return 
     */
    public static boolean crear(FuenteDeIngresosVO fuenteDeIngresos){
        return fuenteDeIngresosDao.crear(fuenteDeIngresos);
    }
    
    /**
     * Envia la informacion del codigo de la fuente de ingresos a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return fuenteDeIngresosDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion de la fuente de ingresos a la capa DAO para que sea editada
     * @param fuenteDeIngresos
     * @return 
     */
    public static boolean editar(FuenteDeIngresosVO fuenteDeIngresos) {
        return fuenteDeIngresosDao.editar(fuenteDeIngresos);
    }
    
    /**
     * Recibe las fuentes de ingresos existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<FuenteDeIngresosVO> buscarTodo() {
       return fuenteDeIngresosDao.buscarTodo();
    }
}
