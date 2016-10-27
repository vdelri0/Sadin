/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.datosBasicos.teceros;

import controlador.Coordinador;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.vo.datosBasicos.EmpresaVO;
import modelo.vo.datosBasicos.TerceroVO;
import utilidades.Formulario;
import vista.datosBasicos.ForcedListSelectionModel;

/**
 *
 * @author Victor Del Rio Prens
 */
public class Terceros extends javax.swing.JFrame {
    private final String noHayTerceros = "Actualmente no existen terceros dentro de la base de datos.";
    private final String ningunTerceroSeleccionado = "Por favor seleccione un tercero.";
    private final String terceroEliminado = "El tercero fue eliminado con exito.";
    private final String terceroNoEliminado = "Existe un problema al tratar de eliminar el tercero.";
    private final String confirmacionEliminar = "¿Desea eliminar este tercero?";
    Coordinador coordinador;
    DefaultTableModel model;
    
    /**
     * Creates new form Terceros
     */
    public Terceros() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tablaTerceros.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tablaTerceros.setDefaultRenderer(String.class, centerRenderer);
        tablaTerceros.setDefaultRenderer(Integer.class, centerRenderer);
        tablaTerceros.setSelectionModel(new ForcedListSelectionModel());
    }
    
    /**
     * Permite crear una fila dentro de la tabla
     * @param cedula
     * @param nombre
     * @param direccion
     * @param telefonos 
     * @param codigoEmpresa 
     * @param empresa 
     * @param fechaNacimiento 
     * @param email 
     * @param celular 
     */
    public void crearFila(int cedula, String nombre, String direccion, String telefonos, int codigoEmpresa, String empresa, String fechaNacimiento, String email, String celular){
        model.addRow(new Object[]{cedula, nombre, direccion, telefonos, codigoEmpresa, empresa, fechaNacimiento, email, celular});
    }
    
    /**
     * Toma el ultimo tercero seleccionado dentro de la tabla y lo retorna
     * @return 
     */
    public TerceroVO obtenerTerceroSeleccionado(){
        TerceroVO terceroSeleccionado = null;
        EmpresaVO empresa = null;
        int index = tablaTerceros.getSelectedRow();
        if(index != -1){
            TableModel tableModel = tablaTerceros.getModel();
            terceroSeleccionado = new TerceroVO();
            empresa = new EmpresaVO();
            terceroSeleccionado.setCedula(Integer.parseInt(tableModel.getValueAt(index, 0).toString()));
            terceroSeleccionado.setNombre(tableModel.getValueAt(index, 1).toString());
            terceroSeleccionado.setDireccion(tableModel.getValueAt(index, 2).toString());
            terceroSeleccionado.setTelefonos(tableModel.getValueAt(index, 3).toString());
            empresa.setCodigo(Integer.parseInt(tableModel.getValueAt(index, 4).toString()));
            empresa.setNombre(tableModel.getValueAt(index, 5).toString());
            terceroSeleccionado.setEmpresa(empresa);
            terceroSeleccionado.setFechaNacimiento(Date.valueOf(tableModel.getValueAt(index, 6).toString()));
            terceroSeleccionado.setEmail(tableModel.getValueAt(index, 7).toString());
            terceroSeleccionado.setCelular(tableModel.getValueAt(index, 8).toString());
        } else {
            JOptionPane.showMessageDialog(null, ningunTerceroSeleccionado);
        }
        return terceroSeleccionado;
    }
    
    /**
     * Toma todos los terceros que se encuentran dentro de la base de datos y 
     * los ingresa en la tabla
     */
    public void llenarTabla(){
        Formulario.eliminarTodasLasFilas(model);
        List<TerceroVO> terceros = coordinador.buscarTodosLosTerceros();
        if(!terceros.isEmpty()){
            for (TerceroVO tercero : terceros) {
                crearFila(tercero.getCedula(), tercero.getNombre(), tercero.getDireccion(), tercero.getTelefonos(), tercero.getEmpresa().getCodigo(), tercero.getEmpresa().getNombre(), tercero.getFechaNacimiento().toString(), tercero.getEmail(), tercero.getCelular());
            }
        } else {
            JOptionPane.showMessageDialog(null, noHayTerceros);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonEditar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        campoBusqueda = new javax.swing.JTextField();
        botonRefrescarTabla = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTerceros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/pencil_32.png"))); // NOI18N
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/plus_32.png"))); // NOI18N
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        campoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoBusquedaKeyPressed(evt);
            }
        });

        botonRefrescarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRefrescarTablaActionPerformed(evt);
            }
        });

        tablaTerceros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Direccion", "Telefonos", "Codigo Empresa", "Empresa", "Fecha Nacimiento", "Email", "Celular"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTerceros);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Terceros");

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/delete_32.png"))); // NOI18N
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/home_32.png"))); // NOI18N
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonRefrescarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(364, 364, 364))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonAgregar, botonEditar, botonEliminar, botonRefrescarTabla, botonSalir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonSalir)
                    .addComponent(botonEditar)
                    .addComponent(botonEliminar)
                    .addComponent(botonAgregar)
                    .addComponent(botonRefrescarTabla))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botonAgregar, botonEditar, botonEliminar, botonRefrescarTabla, botonSalir});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        int fila = tablaTerceros.convertRowIndexToModel(tablaTerceros.getSelectedRow());
        if(fila != -1){
            TableModel modelo = tablaTerceros.getModel();
            EditarTercero editarTercero = new EditarTercero();
            editarTercero.setVisible(true);
            editarTercero.setCoordinador(coordinador);
            editarTercero.getCampoCedula().setText(modelo.getValueAt(fila, 0).toString());
            editarTercero.getCampoNombre().setText(modelo.getValueAt(fila, 1).toString());
            editarTercero.getCampoDireccion().setText(modelo.getValueAt(fila, 2).toString());
            editarTercero.getCampoTelefonos().setText(modelo.getValueAt(fila, 3).toString());
        } else {
            JOptionPane.showMessageDialog(null, ningunTerceroSeleccionado);
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        CrearTercero crearBodega = new CrearTercero();
        crearBodega.setVisible(true);
        crearBodega.setCoordinador(coordinador);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void campoBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBusquedaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tablaTerceros.getModel());
            tablaTerceros.setRowSorter(rowSorter);
            String text = campoBusqueda.getText();
            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }
    }//GEN-LAST:event_campoBusquedaKeyPressed

    private void botonRefrescarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRefrescarTablaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_botonRefrescarTablaActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        TerceroVO tercero = obtenerTerceroSeleccionado();
        if(tercero != null){
            int confirmacion = JOptionPane.showConfirmDialog(null, confirmacionEliminar);
            if(JOptionPane.YES_OPTION == confirmacion){
                boolean eliminada = coordinador.eliminarTercero(tercero.getCedula());
                if(eliminada){
                    int fila = tablaTerceros.convertRowIndexToModel(tablaTerceros.getSelectedRow());
                    model = (DefaultTableModel)tablaTerceros.getModel();
                    model.removeRow(fila);
                    JOptionPane.showMessageDialog(null, terceroEliminado);
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, terceroNoEliminado);
                }
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_botonSalirActionPerformed

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonRefrescarTabla;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTerceros;
    // End of variables declaration//GEN-END:variables
}
