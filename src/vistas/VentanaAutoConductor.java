/*
 * Ventana  Auto Conductor.
 */
package vistas;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.Conexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import controladores.AsignacionDAO;
import modelo.Asignacion;

/*
 * Clase: ConductoDAO
 * Autor: Juan Pablo Vásquez Vásquez. 
 */
public class VentanaAutoConductor extends javax.swing.JInternalFrame {

    //Variables.
    int contador = 0;
    static ResultSet res;

    public VentanaAutoConductor() {
        initComponents();
        inciarcmboPatente();
        iniciarcmbRutCondutor();
        llenarTabla();
        btnNuevo.setEnabled(true);//Al inciar el programa habilitamos el botón nuevo.
        btnGuardar.setEnabled(false);//Al inciar el programa desabilitamos el botón Guardar.
        btnEliminar.setEnabled(false);//Al inciar el programa desabilitamos el botón Eliminar.
        btnCancelar.setEnabled(false);//Al inciar el programa desabilitamos el botón Eliminar.
    }

    //Creamos un método para Limpiar.
    public void limpiar() {
        txtRut.setText("");//Limpiamos txtRut.
        txtNombre.setText("");//Limpiamos txtNombre.
        txtPatente.setText("");//Limpiamos txtPatente.
        txtFechaAsignacion.setText("");//Limpiamos txtFechaAsignacion.
    }

    //Creamos un método para habilitar las cajas de texto.
    public void habilitar() {
        txtRut.setEnabled(true);//Habilitamos los Txt.
        txtPatente.setEnabled(true);//Habilitamos los Txt.
        txtNombre.setEnabled(true);//Habilitamos los Txt.
    }

    //Creamos un método para Deshabilitar las cajas de texto.
    public void desabilitar() {
        txtRut.setEnabled(false);//desabilitamos los Txt.
        txtPatente.setEnabled(false);//desabilitamos los Txt.
        txtNombre.setEnabled(false);//desabilitamos los Txt. 
    }

    //Creamos un método para Cmbo Patente.
    public void inciarcmboPatente() {
        this.cmbPanteAutomovil.removeAllItems();//Limpiamos cmbPanteAutomovil.
        this.cmbPanteAutomovil.addItem("SELECCIONAR PATENTE");//Agremos un Nombre al cmboPatenteAutomovil.
        try {
            ResultSet rs = null;//Iniciamos el conjunto de resultado.
            Connection con2 = null;//Iniciamos el objeto de la clase conexion.
            Conexion conect2 = new Conexion();//Creamos el objeto de la clase conexion.
            con2 = conect2.getConnection();//llamamos al método de la conexión.
            Statement Sent = con2.createStatement();//Creamos una declaracion en esta conexión.
            rs = Sent.executeQuery("SELECT * FROM automoviles");//Devolvemos la consulta y lo que devuelva queda guardado en rs de todos los registros de la tabla.
            while (rs.next()) {//creamos un while  para recorrer la tabla automoviles.
                this.cmbPanteAutomovil.addItem(rs.getString("Patente"));//cargamos las patentes de la tabla al combobox.
            }
            contador++;//creamos un contador para contar las patentes de la tabla Automoviles.
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Creamos un método para 
    public void iniciarcmbRutCondutor() {
        this.cmbRutConductor.removeAllItems();//Limpiamos cmbPanteAutomovil.
        this.cmbRutConductor.addItem("SELECCIONAR RUT");//Agremos un Nombre al cmbConductor.
        try {
            ResultSet rs = null;//Iniciamos el conjunto de resultado.
            Connection con2 = null;//Iniciamos el objeto de la clase conexion.
            Conexion conect2 = new Conexion();//Creamos el objeto de la clase conexion.
            con2 = conect2.getConnection();//llamamos al método de la conexión.
            Statement Sent = con2.createStatement();//Creamos una declaracion en esta conexión.
            rs = Sent.executeQuery("SELECT * FROM conductores");//Devolvemos la consulta y lo que devuelva queda guardado en rs de todos los registros de la tabla.
            while (rs.next()) {//creamos un while  para recorrer la tabla conductores.
                this.cmbRutConductor.addItem(rs.getString("Rut"));//cargamos el rut de la tabla al combobox.
            }
            contador++;//creamos un contador para contar los rut de la tabla conductores.
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Creamos un método para Llenar tabla.
    public void llenarTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();//Creamos un objeto de la clase table modelo objeto contendor intermedio.
            this.tablaEditar.setModel(modelo);// Enlazamos y Asignamos el modelo creado a la tabla editar  este sera su formato .
            AsignacionDAO asignacionDAO = new AsignacionDAO();//Creamos un Objeto de la clase AsignaciónDAO.
            ResultSet rs = asignacionDAO.listarAsignacion();//Llamos el método listar Asignación y lo que devuela se almacena en el Resulset.
            ResultSetMetaData rsMd = rs.getMetaData();//rsMD tenemos la informacion de los datos y lo guardamos en getMetaData (la información del información).
            int cantidadColumnas = rsMd.getColumnCount();//Obtenemos el número de columnas del Resulset y guardamos la cantidadColumnas en el Int.
            for (int i = 1; i <= cantidadColumnas; i++) {//Recorremos las columnas y las iterando.
                modelo.addColumn(rsMd.getColumnLabel(i));// Método addColumn Cargamos  todas las columas al modelo tomando el titulo de las columnas creando las cabeceras de las filas.
            }//Cerramos el ciclo.
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbPanteAutomovil = new javax.swing.JComboBox<>();
        cmbRutConductor = new javax.swing.JComboBox<>();
        txtRut = new javax.swing.JTextField();
        txtPatente = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtFechaAsignacion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEditar = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Asignación");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Patente Automovil:");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Fecha Asignacion:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Rut Conductor:");

        cmbPanteAutomovil.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        cmbPanteAutomovil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPanteAutomovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPanteAutomovilActionPerformed(evt);
            }
        });

        cmbRutConductor.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        cmbRutConductor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbRutConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRutConductorActionPerformed(evt);
            }
        });

        txtRut.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutActionPerformed(evt);
            }
        });

        txtPatente.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtPatente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatenteActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        txtFechaAsignacion.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtFechaAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaAsignacionActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24))); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/interface.png"))); // NOI18N
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
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/generallyremove_engeneral_13084.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setName("btnEliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(35, 35, 35)
                .addComponent(btnGuardar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPanteAutomovil, 0, 310, Short.MAX_VALUE)
                                    .addComponent(cmbRutConductor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFechaAsignacion))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRut, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(txtPatente)
                                    .addComponent(txtNombre))))
                        .addGap(0, 96, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPanteAutomovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRutConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(438, 438, 438))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 658, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPanteAutomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPanteAutomovilActionPerformed
        try {
            if (this.contador > 0) {
                Connection con2 = null;//Iniciamos el objeto de la clase conexion.
                Conexion conect2 = new Conexion();//Creamos el objeto de la clase conexion.
                con2 = conect2.getConnection();//llamamos al método de la conexión.
                Statement st2 = con2.createStatement();//Creamos una declaracion en esta conexión.
                ResultSet rs1 = st2.executeQuery("select * from automoviles where Patente = '" + this.cmbPanteAutomovil.getSelectedIndex() + "'");
                rs1.next();//creamos un while  para recorrer la tabla Automoviles.
                this.txtPatente.setText(String.valueOf(rs1.getInt("Patente")));
               txtPatente.requestFocus();//Enviamos el foco al txtPatente.
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmbPanteAutomovilActionPerformed

    private void cmbRutConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRutConductorActionPerformed
        try {
            if (this.contador > 0) {
                Connection con2 = null;//Iniciamos el objeto de la clase conexion.
                Conexion conect2 = new Conexion();//Creamos el objeto de la clase conexion.
                con2 = conect2.getConnection();//llamamos al método de la conexión.
                Statement st2 = con2.createStatement();//Creamos una declaracion en esta conexión.
                ResultSet rs1 = st2.executeQuery("select * from conductores where Rut = '" + this.cmbRutConductor.getSelectedIndex() + "'");
                rs1.next();//creamos un while  para recorrer la tabla conductores.
                this.txtRut.setText(String.valueOf(rs1.getInt("Rut"))); //enviamos el rut al txt rut
                this.txtNombre.setText(String.valueOf(rs1.getString("Nombre")));//enviamos el rut al
                txtRut.requestFocus();//Enviamos el foco al txtPatente.
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmbRutConductorActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtRut.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL RUT ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtRut.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        if (txtNombre.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LOS NOMBRES ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtNombre.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        String nombre = txtPatente.getText();
        int rut = Integer.parseInt(txtRut.getText());
        String fecha = txtFechaAsignacion.getText();

        Asignacion asignacion = new Asignacion(nombre, rut, fecha);
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        asignacionDAO.crearAsignacion(asignacion);

        limpiar();//Llamos el al método limpiar.
        llenarTabla();//Llamos el al método llenar tabla.
        desabilitar();//Llamos el al método desabilitar los txt.
        btnNuevo.setEnabled(true);//Al Guardar habilitamos el botón.
        btnGuardar.setEnabled(false);//Al Guardardesbilitamos el botón.
        btnEliminar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnCancelar.setEnabled(false);//Al Guardar desbilitamos el botón.
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        JOptionPane.showMessageDialog(null, "Operación Cancelada", "Información", JOptionPane.INFORMATION_MESSAGE);
        this.limpiar();
        limpiar();//Llamos el al método limpiar.
        llenarTabla();//Llamos el al método llenar tabla.
        desabilitar();//Llamos el al método desabilitar los txt.
        btnNuevo.setEnabled(true);//Al Guardar habilitamos el botón.
        btnGuardar.setEnabled(false);//Al Guardardesbilitamos el botón.
        btnEliminar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnCancelar.setEnabled(false);//Al Guardar desbilitamos el botón.

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtRut.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL RUT ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtRut.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        if (txtPatente.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LOS NOMBRES ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtPatente.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        //Creamos un objeto de clase Asignacion.
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        String patente = txtPatente.getText().toString();
        int a = JOptionPane.showConfirmDialog(null, "Desea eliminar este Automovil", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
        if (a == 0) {
            asignacionDAO.eliminarAsignacion(patente);
            limpiar();
        }
        txtRut.setText("");
        limpiar();//Llamos el al método limpiar.
        llenarTabla();//Llamos el al método llenar tabla.
        btnNuevo.setEnabled(true);//Al Guardar habilitamos el botón.
        btnGuardar.setEnabled(false);//Al Guardardesbilitamos el botón.
        btnEliminar.setEnabled(false);//Al Guardar desbilitamos el botón.
        btnCancelar.setEnabled(false);//Al Guardar desbilitamos el botón.
        desabilitar();//Llamos el al método desabilitar los txt.
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();//LLamos  Método Limpiar.
        habilitar();//Llamos al método habilitar.
        btnNuevo.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        btnGuardar.setEnabled(true);//Al  presionar el botón habilitamos el botón.
        btnEliminar.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        btnCancelar.setEnabled(true);//Al presionar el botó nuevo desabilitamos el botón.
        txtPatente.requestFocus();//Focus en txtRut.
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tablaEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEditarMouseClicked

        int fila = tablaEditar.getSelectedRow();//la varible selecciona un fila y muestra el datos seleccionado.
        String id = tablaEditar.getValueAt(fila, 0).toString();//Obtenemos la Fila de Donde recuperemos la Imagen.
        txtPatente.setText(tablaEditar.getValueAt(fila, 0).toString());//Obtenemos el Patente y lo mostramos en el txtPatente.
        txtRut.setText(tablaEditar.getValueAt(fila, 1).toString());//Obtenemos el rut y lo mostramos en el txtRut.
        txtFechaAsignacion.setText(tablaEditar.getValueAt(fila, 2).toString());//Obtenemos el Fecha Asignacion y lo mostramos en el txtFechaAsignacion.
        //Desabilitamos.
        btnNuevo.setEnabled(false);//Al hacer clic sobre la tabla desbilitamos el botón.
        btnGuardar.setEnabled(false);//Al hacer clic sobre la tabla desbilitamos el botón.
        btnEliminar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        btnCancelar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        habilitar();//Llamos el al metodo habilitar al para los txt.
        //txtRut.setEnabled(false);//Desabilitamos el txtRut.
        txtPatente.requestFocus();//Enviamos el foco al txtPatente.
    }//GEN-LAST:event_tablaEditarMouseClicked

    private void txtPatenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatenteActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtRut.requestFocus();
    }//GEN-LAST:event_txtPatenteActionPerformed

    private void txtRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtFechaAsignacion.requestFocus();
    }//GEN-LAST:event_txtRutActionPerformed

    private void txtFechaAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaAsignacionActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        btnGuardar.doClick();
    }//GEN-LAST:event_txtFechaAsignacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbPanteAutomovil;
    private javax.swing.JComboBox<String> cmbRutConductor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaEditar;
    private javax.swing.JTextField txtFechaAsignacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPatente;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
