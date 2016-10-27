/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.PuntoDeVentaDAO;
import java.util.List;
import modelo.vo.datosBasicos.PuntoDeVentaVO;

/**
 * Realiza el manejo de toda la informacion de los puntos de venta      
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class PuntoDeVenta {
    public static final PuntoDeVentaDAO puntoDeVentaDao = new PuntoDeVentaDAO();
    
    /**
     * Envia la informacion del punto de venta a la capa DAO para que sea creada
     * @param puntoDeVenta
     * @return 
     */
    public static boolean crear(PuntoDeVentaVO puntoDeVenta){
        return puntoDeVentaDao.crear(puntoDeVenta);
    }
    
    /**
     * Envia la informacion del codigo del punto de venta a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return puntoDeVentaDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion del punto de venta a la capa DAO para que sea editada
     * @param puntoDeVenta
     * @return 
     */
    public static boolean editar(PuntoDeVentaVO puntoDeVenta) {
        return puntoDeVentaDao.editar(puntoDeVenta);
    }
    
    /**
     * Recibe los puntos de venta existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<PuntoDeVentaVO> buscarTodo() {
       return puntoDeVentaDao.buscarTodo();
    }
}
