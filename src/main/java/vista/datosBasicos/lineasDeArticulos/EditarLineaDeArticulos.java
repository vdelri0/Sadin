/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.datosBasicos.lineasDeArticulos;

import controlador.Coordinador;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.vo.datosBasicos.LineaDeArticulosVO;
import utilidades.Constantes;
import utilidades.Formulario;

/**
 *
 * @author Victor Del Rio Prens
 */
public class EditarLineaDeArticulos extends javax.swing.JFrame {
    final String lineaDeArticulosEditada = "la linea de articulos fue editada con exito.";
    final String lineaDeArticulosNoEditada = "Problemas al editar la linea de articulos.";
    Coordinador coordinador;
    List<Object> campos;
    List<Object> botones;
    
    /**
     * Creates new form EditarLineaDeArticulos
     */
    public EditarLineaDeArticulos() {
        initComponents();
        setLocationRelativeTo(null);
        campos = Formulario.obtenerElementos(JTextField.class, getComponents());
        botones = Formulario.obtenerElementos(JButton.class, getComponents());
    }
    
    /**
     * Toma todos los campos que se encuentran dentro del formulario y los retorna
     * @return 
     */
    public LineaDeArticulosVO obtenerLineaDeArticulos(){
        LineaDeArticulosVO lineaDeArticulos = new LineaDeArticulosVO();
        try {
            lineaDeArticulos.setCodigo(Integer.parseInt(campoCodigo.getText()));
            lineaDeArticulos.setDescripcion(campoDescripcion.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, Constantes.codigoValido);
        }
        return lineaDeArticulos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoDescripcion = new javax.swing.JTextField();
        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaCodigo = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        etiquetaDescripcion = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        etiquetaTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        etiquetaTitulo.setText("Editar Linea de Articulos");

        etiquetaCodigo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        etiquetaCodigo.setText("Codigo:");

        campoCodigo.setEditable(false);

        etiquetaDescripcion.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        etiquetaDescripcion.setText("Descripcion:");

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/save_32.png"))); // NOI18N
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
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
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etiquetaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(campoDescripcion))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonGuardar, botonSalir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaCodigo)
                        .addGap(22, 22, 22)
                        .addComponent(etiquetaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonGuardar)
                    .addComponent(botonSalir))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(Formulario.validarCamposVacios(campos)){
            boolean creada = coordinador.editarLineaDeArticulos(obtenerLineaDeArticulos());
            Formulario.limpiarCampos(campos);
            String mensaje = (creada) ? lineaDeArticulosEditada : lineaDeArticulosNoEditada;
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_botonSalirActionPerformed

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public JTextField getCampoCodigo() {
        return campoCodigo;
    }

    public void setCampoCodigo(JTextField campoCodigo) {
        this.campoCodigo = campoCodigo;
    }

    public JTextField getCampoDescripcion() {
        return campoDescripcion;
    }

    public void setCampoDescripcion(JTextField campoDescripcion) {
        this.campoDescripcion = campoDescripcion;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoDescripcion;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaTitulo;
    // End of variables declaration//GEN-END:variables
}