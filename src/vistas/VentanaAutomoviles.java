/*
 * Ventana Automoviles.
 */
package vistas;

import controladores.AutomovilesDAO;
import modelo.Automoviles;
import com.sun.glass.events.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Clase:  Formulario Automoviles
 * Autor: Juan Pablo Vásquez Vásquez. 
 */
public class VentanaAutomoviles extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaAutomovil
     */
    public VentanaAutomoviles() {
        initComponents();
        llenarTabla();
        desabilitar();//Creamos los Métodos.
        btnNuevo.setEnabled(true);//Al inciar el programa habilitamos el botón nuevo.
        btnGuardar.setEnabled(false);//Al inciar el programa desabilitamos el botón Guardar.
        btnEditar.setEnabled(false);//Al inciar el programa desabilitamos el botón Editar.
        btnEliminar.setEnabled(false);//Al inciar el programa desabilitamos el botón Eliminar.
        btnBuscar.setEnabled(false);//Al inciar el programa desabilitamos el botón Eliminar.
        btnCancelar.setEnabled(false);//Al inciar el programa desabilitamos el botón Eliminar.
    }

    public void limpiar() {
        txtPatente.setText(null);//limpiamos el txt.
        txtMarca.setText(null);//limpiamos el txt.
        txtAnyo.setText(null);//limpiamos el txt.
        txtColor.setText(null);//limpiamos el txt.
        txtCilindrada.setText(null);//limpiamos el txt.
        txtTipoVehiculo.setText(null);//limpiamos el txt.
        
    }
    //Creamos un método para habilitar las cajas de texto.

    public void habilitar() {
        txtMarca.setEnabled(true);//Habilitamos los Txt.
        txtPatente.setEnabled(true);//Habilitamos los Txt.
        txtColor.setEnabled(true);//Habilitamos los Txt.
        txtAnyo.setEnabled(true);//Habilitamos los Txt.
        txtCilindrada.setEnabled(true);//Habilitamos los Txt.
        txtTipoVehiculo.setEnabled(true);//Habilitamos los Txt.
       

    }
    //Creamos un método para Deshabilitar las cajas de texto.

    public void desabilitar() {
        txtMarca.setEnabled(false);//desabilitamos los Txt.
        txtPatente.setEnabled(false);//desabilitamos los Txt.
        txtColor.setEnabled(false);//desabilitamos los Txt.
        txtAnyo.setEnabled(false);//desabilitamos los Txt.
        txtCilindrada.setEnabled(false);//desabilitamos los Txt.
        txtTipoVehiculo.setEnabled(false);//desabilitamos los Txt.
    }

    //Creamos un método para Llenar tabla.
    public void llenarTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();//Creamos un objeto de la clase table model.
            this.tablaEditar.setModel(modelo);// Enlazamos y Asignamos el modelo creado a la tabla editar  este sera su formato.
            AutomovilesDAO automovilesDAO = new AutomovilesDAO();//Creamos un Objeto de la clase AutomovilesDAO.
            ResultSet rs = automovilesDAO.listarAutomoviles();//Llamos el método listarAutomoviles y lo que devuela se almacena en el Resulset.
            ResultSetMetaData rsMd = rs.getMetaData();//rsMD tenemos la informacion de los datos y lo guardamos en getMetaData (la información del información).
            modelo.addColumn("Patente");
            modelo.addColumn("Marca");
            modelo.addColumn("Año");
            modelo.addColumn("Color");
            modelo.addColumn("Cilindrdada");
            modelo.addColumn("Tipo Vehiculo ");
            int cantidadColumnas = rsMd.getColumnCount();//Obtenemos el número de columnas del Resulset y guardamos la cantidadColumnas en el Int.
           // for (int i = 1; i <= cantidadColumnas; i++) {//Recorremos las columnas y las iterando.
               // modelo.addColumn(rsMd.getColumnLabel(i));// Método addColumn Cargamos  todas las columas al modelo tomando el titulo de las columnas creando las cabeceras de las filas.
            //}//Cerramos el ciclo.
            while (rs.next()) {//Creamos una condicion para que le Resulset pueda continuar en al traer información si trae alguna fila se puede continuar.
                Object[] fila = new Object[cantidadColumnas];//Objeto para obtener todo lo que esta en la tabla para el arreglo fila con al cantidad de columnas..
                for (int i = 0; i < cantidadColumnas; i++) {//Recorremos del inicio de la columa hasta ultima fila obtenido los datos.
                    fila[i] = rs.getObject(i + 1);//Agremos una fila al objeto.  
                }
                modelo.addRow(fila);//Agregamos la fila creada y la insertamos en el modelo de esta forma la mostramos en la tabla.
            }//Cuando no queden mas filas sale.
        } catch (Exception ex) {//Motramos el Mensaje genérco de error.
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAutomovil = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPatente = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtCilindrada = new javax.swing.JTextField();
        txtTipoVehiculo = new javax.swing.JTextField();
        txtAnyo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEditar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestión Automovil");

        panelAutomovil.setBackground(new java.awt.Color(0, 204, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Marca:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Anyo:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Patente:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Color:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Cilindrada:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Tipo Vehículo:");

        txtPatente.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtPatente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatenteActionPerformed(evt);
            }
        });

        txtMarca.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        txtColor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });

        txtCilindrada.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtCilindrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCilindradaActionPerformed(evt);
            }
        });

        txtTipoVehiculo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoVehiculoActionPerformed(evt);
            }
        });

        txtAnyo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtAnyo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnyoActionPerformed(evt);
            }
        });

        tablaEditar.setAutoCreateRowSorter(true);
        tablaEditar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        tablaEditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Rut", "Nombre", "Apellido Paterno", "Apellido Materno", "Sexo", "Fecha Nacimiento", "Tipo Licencia"
            }
        ));
        tablaEditar.setRowHeight(30);
        tablaEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEditarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEditar);

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24))); // NOI18N

        btnEditar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/diskette_save_saveas_1514.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/coche.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancel_stop_exit_1583.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1486504830-delete-dustbin-empty-recycle-recycling-remove-trash_81361.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setName("btnEliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/barcode.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new-file_40454.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(31, 31, 31)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(31, 31, 31)
                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout panelAutomovilLayout = new javax.swing.GroupLayout(panelAutomovil);
        panelAutomovil.setLayout(panelAutomovilLayout);
        panelAutomovilLayout.setHorizontalGroup(
            panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutomovilLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAutomovilLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(43, 43, 43)
                .addGroup(panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtColor, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(txtTipoVehiculo)
                    .addComponent(txtPatente)
                    .addComponent(txtMarca)
                    .addComponent(txtAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        panelAutomovilLayout.setVerticalGroup(
            panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutomovilLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAutomovilLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(panelAutomovilLayout.createSequentialGroup()
                        .addGroup(panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelAutomovilLayout.createSequentialGroup()
                                .addGroup(panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(34, 34, 34)
                                .addComponent(txtAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addGroup(panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelAutomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(78, 78, 78)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAutomovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAutomovil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPatenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatenteActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtMarca.requestFocus();
    }//GEN-LAST:event_txtPatenteActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtAnyo.requestFocus();
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtCilindrada.requestFocus();
    }//GEN-LAST:event_txtColorActionPerformed

    private void txtCilindradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCilindradaActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtTipoVehiculo.requestFocus();
    }//GEN-LAST:event_txtCilindradaActionPerformed

    private void txtTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoVehiculoActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        btnGuardar.doClick();
    }//GEN-LAST:event_txtTipoVehiculoActionPerformed

    private void txtAnyoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnyoActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtColor.requestFocus();
    }//GEN-LAST:event_txtAnyoActionPerformed

    private void tablaEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEditarMouseClicked
        // AlumnoDao consulta = new AlumnoDao();
        //int rut = Integer.parseInt(txtRut.getText());
        int fila = tablaEditar.getSelectedRow();//la varible selecciona un fila y muestra el datos seleccionado.
        String id = tablaEditar.getValueAt(fila, 0).toString();//Obtenemos la Fila de Donde recuperemos la Imagen.
        txtPatente.setText(tablaEditar.getValueAt(fila, 0).toString());//Obtenemos el rut y lo mostramos en el txt rut.
        txtMarca.setText(tablaEditar.getValueAt(fila, 1).toString());//Obtenemos el nombre y lo mostramos en el txtNombre.
        txtAnyo.setText(tablaEditar.getValueAt(fila, 2).toString());//Obtenemos el Apellido y  lo mostramos  del  txtApellido.
        txtColor.setText(tablaEditar.getValueAt(fila, 3).toString());//Obtenemos el Apellido y  lo mostramos   del  txtApellido.
        txtCilindrada.setText(tablaEditar.getValueAt(fila, 4).toString());//Obtenemos el  sexo y lo mostramos en txtSexo.
        txtTipoVehiculo.setText(tablaEditar.getValueAt(fila, 5).toString());//Obtenemos la fecha de nacimiento y  lo mostramos al txtFechanacimento.
        btnNuevo.setEnabled(false);//Al hacer clic sobre la tabla desbilitamos el botón.
        btnGuardar.setEnabled(false);//Al hacer clic sobre la tabla desbilitamos el botón.
        btnEditar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        btnEliminar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        btnBuscar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        btnCancelar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        habilitar();//Llamos el al metodo habilitar al para los txt.
        txtPatente.setEnabled(false);
        txtMarca.requestFocus();
    }//GEN-LAST:event_tablaEditarMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (txtPatente.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA PATENTE ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtPatente.requestFocus();//Enviamos el foco a la caja de texto vacia.
        } else if (txtMarca.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA MARCA", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtMarca.requestFocus();//Enviamos el foco a la caja de texto vacia.
        } else if (txtColor.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL COLOR", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtColor.requestFocus();//Enviamos el foco a la caja de texto vacia.
        } else if (txtAnyo.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL AÑO", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtAnyo.requestFocus();//Enviamos el foco a la caja de texto vacia.
        } else if (txtCilindrada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR AL CILINDRADA", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtCilindrada.requestFocus();
        }

        AutomovilesDAO consulta = new AutomovilesDAO();
        String patente = txtPatente.getText().toString();
        String marca = txtMarca.getText().toString();
        int anyo = Integer.parseInt(txtAnyo.getText());
        String color = txtColor.getText().toString();
        int cilindrada = Integer.parseInt(txtCilindrada.getText());
        String tipo_Vehiculo = txtTipoVehiculo.getText().toString();

        Automoviles automoviles = new Automoviles(patente, marca, anyo, color, cilindrada, tipo_Vehiculo);
        consulta.actualizarAutomoviles(automoviles);
        limpiar();
        llenarTabla();//Llamos el al método llenar tabla.
        desabilitar();//Llamos el al método desabilitar los txt.
        btnNuevo.setEnabled(true);//Al Guardar habilitamos el botón.
        btnGuardar.setEnabled(false);//Al Guardardesbilitamos el botón.
        btnEditar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnEliminar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnCancelar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnBuscar.setEnabled(false);//Al Guardar desbilitamos el botón.
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtPatente.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL RUT ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.

        } else {
            txtPatente.requestFocus();//Enviamos el foco a la caja de texto vacia.

        }

        if (txtMarca.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA MARCA ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.

        } else {
            txtMarca.requestFocus();//Enviamos el foco a la caja de texto vacia.

        }
        if (txtColor.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL COLOR!!", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtColor.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        if (txtAnyo.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL Año", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtAnyo.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        if (txtCilindrada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA CILINDRADA!!", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtCilindrada.requestFocus();
        }
        if (txtTipoVehiculo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL TipoVehiculo!!", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtTipoVehiculo.requestFocus();
        }
        String patente = txtPatente.getText().toString();
        String marca = txtMarca.getText().toString();
        int anyo = Integer.parseInt(txtAnyo.getText().toString());
        String color = txtColor.getText().toString();
        int cilindrada = Integer.parseInt(txtCilindrada.getText().toString());
        String tipo_Vehiculo = txtTipoVehiculo.getText().toString();

        Automoviles automoviles = new Automoviles(patente, marca, anyo, color, cilindrada, tipo_Vehiculo);

        AutomovilesDAO automovilesDAO = new AutomovilesDAO();

        automovilesDAO.crearAutomoviles(automoviles);
        limpiar();
        llenarTabla();//Llamos el al método llenar tabla.
        desabilitar();//Llamos el al método desabilitar los txt.
        btnNuevo.setEnabled(true);//Al Guardar habilitamos el botón.
        btnGuardar.setEnabled(false);//Al Guardardesbilitamos el botón.
        btnEditar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnEliminar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnCancelar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnBuscar.setEnabled(false);//Al Guardar desbilitamos el botón.
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        JOptionPane.showMessageDialog(null, "Operación Cancelada", "Información", JOptionPane.INFORMATION_MESSAGE);
        this.limpiar();
        llenarTabla();
        limpiar();
        llenarTabla();//Llamos el al método llenar tabla.
        desabilitar();//Llamos el al método desabilitar los txt.
        btnNuevo.setEnabled(true);//Al Guardar habilitamos el botón.
        btnGuardar.setEnabled(false);//Al Guardardesbilitamos el botón.
        btnEditar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnEliminar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnCancelar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnBuscar.setEnabled(false);//Al Guardar desbilitamos el botón.
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        AutomovilesDAO automovilesDAO = new AutomovilesDAO();
        String patente = txtPatente.getText();
        Automoviles automoviles = new Automoviles();
        automoviles.setPatente(patente);
        int a = JOptionPane.showConfirmDialog(null, "Desea eliminar este Automovil", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
        if (a == 0) {
            automovilesDAO.elminarAutomoviles(patente);
            limpiar();
        }

        txtPatente.setText("");
        limpiar();
        llenarTabla();//Llamos el al método llenar tabla.
        btnNuevo.setEnabled(true);//Al Guardar habilitamos el botón.
        btnGuardar.setEnabled(false);//Al Guardardesbilitamos el botón.
        btnEditar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnEliminar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnCancelar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnBuscar.setEnabled(false);//Al Guardar desbilitamos el botón.
        desabilitar();//Llamos el al método desabilitar los txt.
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        AutomovilesDAO consulta = new AutomovilesDAO();
        String patente = txtPatente.getText().toString();
        ResultSet rs = consulta.buscarAutomoviles(patente);

        try {
            if (rs.next()) {
                txtMarca.setText(rs.getString("Marca"));
                txtAnyo.setText(rs.getString("Anyo"));
                txtColor.setText(rs.getString("Color"));
                txtCilindrada.setText(rs.getString("Cilindrada"));
                txtTipoVehiculo.setText(rs.getString("Tipo"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Rut!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose se puede consultar!");
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();//LLamos  Método Limpiar
        habilitar();//Llamos al método habilitar.
        btnNuevo.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        btnGuardar.setEnabled(true);//Al  presionar el botón habilitamos el botón.
        btnEditar.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        btnEliminar.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        btnCancelar.setEnabled(true);//Al presionar el botó nuevo desabilitamos el botón.
        btnBuscar.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        txtPatente.requestFocus();//Focus en txtRut.
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAutomovil;
    public javax.swing.JTable tablaEditar;
    private javax.swing.JTextField txtAnyo;
    private javax.swing.JTextField txtCilindrada;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPatente;
    private javax.swing.JTextField txtTipoVehiculo;
    // End of variables declaration//GEN-END:variables
}
