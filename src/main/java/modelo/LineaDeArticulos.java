/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.LineaDeArticulosDAO;
import java.util.List;
import modelo.vo.datosBasicos.LineaDeArticulosVO;

/**
 * Realiza el manejo de toda la informacion de las lineas de articulos
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class LineaDeArticulos {
    public static final LineaDeArticulosDAO lineaDeArticulosDao = new LineaDeArticulosDAO();

    /**
     * Envia la informacion de la linea de articulos a la capa DAO para que sea creada
     * @param lineaDeArticulos
     * @return 
     */
    public static boolean crear(LineaDeArticulosVO lineaDeArticulos) {
        return lineaDeArticulosDao.crear(lineaDeArticulos);
    }

    /**
     * Envia la informacion del codigo de la linea de articulos a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo) {
        return lineaDeArticulosDao.eliminar(codigo);
    }

    /**
     * Envia la informacion de linea de articulos a la capa DAO para que sea editada
     * @param lineaDeArticulos
     * @return 
     */
    public static boolean editar(LineaDeArticulosVO lineaDeArticulos) {
        return lineaDeArticulosDao.editar(lineaDeArticulos);
    }

    /**
     * Recibe las lineas de articulos existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<LineaDeArticulosVO> buscarTodo() {
        return lineaDeArticulosDao.buscarTodo();
    }

}
