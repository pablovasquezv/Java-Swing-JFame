/*
 * Formulario Conductor.
 */
package vistas;

import com.sun.glass.events.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controladores.ConductoresDAO;
import modelo.Conductores;
//Para las fechas
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * Clase: Formulario Conductor
 * Autor: Juan Pablo Vásquez Vásquez. 
 */
public class VentanaConductor extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaConductor
     */
    public VentanaConductor() {
        initComponents();
        llenarTabla();
        /*
         String generos[] = new String[3];//LIMITE DE ELEMENTOS
         generos[0] = "Género";
         generos[1] = "Femenino";
         generos[2] = "Masculino";
        
         //USAMOS UN FOR  PARA MOSTRARLOS
         for (String genero : generos) {
         jCBoxSexo.addItem(genero);
         }*/
        desabilitar();//Creamos los Métodos.
        btnNuevo.setEnabled(true);//Al inciar el programa habilitamos el botón nuevo.
        btnGuardar.setEnabled(false);//Al inciar el programa desabilitamos el botón Guardar.
        btnEditar.setEnabled(false);//Al inciar el programa desabilitamos el botón Editar.
        btnEliminar.setEnabled(false);//Al inciar el programa desabilitamos el botón Eliminar.
        btnBuscar.setEnabled(false);//Al inciar el programa desabilitamos el botón Buscar.
        btnCancelar.setEnabled(false);//Al inciar el programa desabilitamos el botón Cancelar.
    }

    //Metodo para llenar JCBoxSexo 
    public void genero() {
        this.jCBoxSexo.addItem("Género");
        this.jCBoxSexo.addItem("Femenino");
        this.jCBoxSexo.addItem("Masculino");
        this.jCBoxSexo.addItem("");
    }

    //Método para limpiar txt
    public void limpiar() {
        txtRut.setText(null);//limpiamos el txt.
        txtNombre.setText(null);//limpiamos el txt.
        txtApellidoPaterno.setText(null);//limpiamos el txt.
        txtApellidoMaterno.setText(null);//limpiamos el txt.
        jCBoxSexo.setSelectedIndex(0);//limpiamos el jCBoxSexo.
        jDCFechaNacimiento.setDate(null);//Limpiamos el JCalendar.
        txtTipoLicencia.setText("");//limpiamosxt.
    }
    //Creamos un método para habilitar las cajas de texto.

    public void habilitar() {
        txtNombre.setEnabled(true);//Habilitamos los Txt.
        txtRut.setEnabled(true);//Habilitamos los Txt.
        txtApellidoMaterno.setEnabled(true);//Habilitamos los Txt.
        txtApellidoPaterno.setEnabled(true);//Habilitamos los Txt.
        jCBoxSexo.setEnabled(true);//Habilitamos los Txt.
        jDCFechaNacimiento.setEnabled(true);//Habilitamos los Txt.
        txtTipoLicencia.setEnabled(true);//Habilitamos los Txt.

    }
    //Creamos un método para Deshabilitar las cajas de texto.

    public void desabilitar() {
        txtNombre.setEnabled(false);//desabilitamos los Txt.
        txtRut.setEnabled(false);//desabilitamos los Txt.
        txtApellidoMaterno.setEnabled(false);//desabilitamos los Txt.
        txtApellidoPaterno.setEnabled(false);//desabilitamos los Txt.
        jCBoxSexo.setEnabled(false);//desabilitamos los comboBoxSexo.
        txtTipoLicencia.setEnabled(false);//Desabilitamos los Txt.
        jDCFechaNacimiento.setEnabled(false);//desabilitamos los Txt.
    }

    //Creamos un método para Llenar tabla.
    public void llenarTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();//Creamos un objeto de la clase table modelo objeto contendor intermedio.
            this.tablaEditar.setModel(modelo);// Enlazamos y Asignamos el modelo creado a la tabla editar  este sera su formato.
            ConductoresDAO conductoresDAO = new ConductoresDAO();//Creamos un Objeto de la clase ConductoresDAO.
            ResultSet rs = conductoresDAO.listarConductores();//Llamos el método listarConductores y lo que devuela se almacena en el Resulset.
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

        panelConductor = new javax.swing.JPanel();
        panelCrear = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEditar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtTipoLicencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jDCFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jCBoxSexo = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestión Conductor");

        panelConductor.setBackground(new java.awt.Color(0, 204, 204));

        panelCrear.setBackground(new java.awt.Color(0, 204, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Apellido Paterno:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Rut:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Apellido Materno:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Fecha Nacimiento:");

        txtRut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellidoMaterno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });

        txtApellidoPaterno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
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
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/DocumentEdit_40924.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new_add_user_16734.png"))); // NOI18N
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
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/diskette_save_saveas_1514.png"))); // NOI18N
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
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnNuevo)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        txtTipoLicencia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtTipoLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoLicenciaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Tipo Licencia:");

        jDCFechaNacimiento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jCBoxSexo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jCBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Género", "Femenino", "Masculino" }));

        javax.swing.GroupLayout panelCrearLayout = new javax.swing.GroupLayout(panelCrear);
        panelCrear.setLayout(panelCrearLayout);
        panelCrearLayout.setHorizontalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelCrearLayout.createSequentialGroup()
                                    .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addGap(43, 43, 43))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(41, 41, 41)))
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(41, 41, 41)))
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDCFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(txtRut)
                                .addComponent(txtNombre)
                                .addComponent(txtApellidoPaterno)
                                .addComponent(txtTipoLicencia))
                            .addComponent(jCBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(206, 206, 206)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelCrearLayout.setVerticalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5))
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jCBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDCFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8))
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout panelConductorLayout = new javax.swing.GroupLayout(panelConductor);
        panelConductor.setLayout(panelConductorLayout);
        panelConductorLayout.setHorizontalGroup(
            panelConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelConductorLayout.setVerticalGroup(
            panelConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtNombre.requestFocus();
    }//GEN-LAST:event_txtRutActionPerformed

    private void tablaEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEditarMouseClicked
        // AlumnoDao consulta = new AlumnoDao();
        //int rut = Integer.parseInt(txtRut.getText());
        int fila = tablaEditar.getSelectedRow();//la varible selecciona un fila y muestra el datos seleccionado.
        String id = tablaEditar.getValueAt(fila, 0).toString();//Obtenemos la Fila de Donde recuperemos la Imagen.
        txtRut.setText(tablaEditar.getValueAt(fila, 0).toString());//Obtenemos el rut y lo mostramos en el txt rut.
        txtNombre.setText(tablaEditar.getValueAt(fila, 1).toString());//Obtenemos el nombre y lo mostramos en el txtNombre.
        txtApellidoPaterno.setText(tablaEditar.getValueAt(fila, 2).toString());//Obtenemos el Apellido y  lo mostramos  del  txtApellido.
        txtApellidoMaterno.setText(tablaEditar.getValueAt(fila, 3).toString());//Obtenemos el Apellido y  lo mostramos   del  txtApellido.
        jCBoxSexo.setSelectedItem(tablaEditar.getValueAt(fila, 4));//Obtenemos el  sexo y lo mostramos en txtSexo.
        //Obtenemos la fecha de nacimiento y lo mostramos dentro jDCFechaNacimiento. 
        String cfecha = String.valueOf(tablaEditar.getValueAt(tablaEditar.getSelectedRow(), 5));
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha;
        try {
            fecha = (java.util.Date) s.parse(cfecha);
            jDCFechaNacimiento.setDate(fecha);
        } catch (ParseException e) {
            System.out.println(" ERROR! " + e);
        }
        txtTipoLicencia.setText(tablaEditar.getValueAt(fila, 6).toString());//Obtenemos el tipo licencia y lo mostramos en el txtTipoLicencia.
        btnNuevo.setEnabled(false);//Al hacer clic sobre la tabla desbilitamos el botón.
        btnGuardar.setEnabled(false);//Al hacer clic sobre la tabla desbilitamos el botón.
        btnEditar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        btnEliminar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        btnBuscar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        btnCancelar.setEnabled(true);//Al hacer clic sobre la tabla habilitamos el botón.
        habilitar();//Llamos el al metodo habilitar al para los txt.
        txtRut.setEnabled(false);
        txtNombre.requestFocus();
    }//GEN-LAST:event_tablaEditarMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ConductoresDAO consulta = new ConductoresDAO();
        int rut = Integer.parseInt(txtRut.getText());
        ResultSet rs = consulta.buscarConductores(rut);
        try {
            if (rs.next()) {
                txtNombre.setText(rs.getString("Nombre"));
                txtApellidoPaterno.setText(rs.getString("Apellido_Paterno"));
                txtApellidoMaterno.setText(rs.getString("Apellido_Materno"));
                jCBoxSexo.setSelectedItem(rs.getString("sexo"));
               // jDCFechaNacimiento.setCalendar(rs.getDate(fecha));
                txtTipoLicencia.setText(rs.getString("Tipo_Licencia"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Rut!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose se puede consultar!");
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (txtRut.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL RUT ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtRut.requestFocus();//Enviamos el foco a la caja de texto vacia.
        } else if (txtNombre.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LOS NOMBRES ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtNombre.requestFocus();//Enviamos el foco a la caja de texto vacia.
        } else if (txtApellidoMaterno.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL APELLIDO MATERNO", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtApellidoMaterno.requestFocus();//Enviamos el foco a la caja de texto vacia.
        } else if (txtApellidoPaterno.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL AEPLLIDO PATERNO", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtApellidoPaterno.requestFocus();//Enviamos el foco a la caja de texto vacia.
        } /**
         * else if (txtSexo.getText().isEmpty()) {
         * JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL SEXO!!",
         * "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja
         * de texto vacia. txtSexo.requestFocus(); }
         */
        else if (txtTipoLicencia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL SEXO!!", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtTipoLicencia.requestFocus();
        }
        ConductoresDAO consulta = new ConductoresDAO();
        int rut = Integer.parseInt(txtRut.getText());
        String nombre = txtNombre.getText();
        String apellido_p = txtApellidoPaterno.getText();
        String apellido_m = txtApellidoMaterno.getText();
        String sexo = ((String) jCBoxSexo.getSelectedItem());
        //otra forma de guardar fechas JCalendar
        String fecha;//Variable de tipo cadena para la fecha
        //Crear un objeto de tipo Date
        Date date = new Date();
        /**
         * Se crea un objeto de simpleDateFormat que crea formato en como se
         * guarda las fechas en la base de datos MySQL
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Posicionar el formato en una variable para poder enviarlo como si fuese un txt
        fecha = simpleDateFormat.format(jDCFechaNacimiento.getDate());
        //Fin de ingresar fechas
        String tipo_Licencia = txtTipoLicencia.getText();

        Conductores conductores = new Conductores(rut, nombre, apellido_p, apellido_m, sexo, fecha, tipo_Licencia);
        consulta.actualizarConductores(conductores);
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
        if (txtRut.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL RUT ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtRut.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        if (txtNombre.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LOS NOMBRES ", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtNombre.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        if (txtApellidoMaterno.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL APELLIDO MATERNO", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtApellidoMaterno.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        if (txtApellidoPaterno.getText().isEmpty()) {//SI la caja de texto esta vacia.
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL AEPLLIDO PATERNO", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtApellidoPaterno.requestFocus();//Enviamos el foco a la caja de texto vacia.
        }
        /*if (jCBoxSexo.getToolTipText().isEmpty()) {
         JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL SEXO!!", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
         jCBoxSexo.requestFocus();
         }*/
        if (txtTipoLicencia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL SEXO!!", "Advertencia", JOptionPane.WARNING_MESSAGE);//Muestra el mensaje caja de texto vacia.
            txtTipoLicencia.requestFocus();
        }
        /**
         * *
         * PRIMERA FORMA DE GUARDA FECHA int dia, mes, anyo;//Extraer del
         * calendario dia =
         * jdFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH); mes =
         * jdFechaNacimiento.getCalendar().get(Calendar.MONTH); anyo =
         * jdFechaNacimiento.getCalendar().get(Calendar.YEAR);
         *
         * String fecha;
         *
         * fecha = anyo + "/" + mes + "/" + dia; Conductores conductorFecha =
         * new Conductores(); conductorFecha.setFecha_Nacimiento(fecha);
         */
        int rut = Integer.parseInt(txtRut.getText());
        String nombre = txtNombre.getText();
        String apellido_p = txtApellidoPaterno.getText();
        String apellido_m = txtApellidoMaterno.getText();
        String sexo = ((String) jCBoxSexo.getSelectedItem());
        //otra forma de guardar fechas JCalendar
        String fecha;//Variable de tipo cadena para la fecha
        //Crear un objeto de tipo Date
        Date date = new Date();
        /**
         * Se crea un objeto de simpleDateFormat que crea formato en como se
         * guarda las fechas en la base de datos MySQL
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Posicionar el formato en una variable para poder enviarlo como si fuese un txt
        fecha = simpleDateFormat.format(jDCFechaNacimiento.getDate());
        //Fin de ingresar fechas
        String tipo_Licencia = txtTipoLicencia.getText();

        Conductores conductores = new Conductores(rut, nombre, apellido_p, apellido_m, sexo, fecha, tipo_Licencia);

        ConductoresDAO conductoresDAO = new ConductoresDAO();

        conductoresDAO.crearConductores(conductores);
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

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtApellidoPaterno.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtApellidoMaterno.requestFocus();
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        jCBoxSexo.requestFocus();
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtTipoLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoLicenciaActionPerformed
        evt.setSource((char) KeyEvent.VK_CLEAR);
        btnGuardar.doClick();
    }//GEN-LAST:event_txtTipoLicenciaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ConductoresDAO conductoresDAO = new ConductoresDAO();
        int rut = Integer.parseInt(txtRut.getText().toString());

        int a = JOptionPane.showConfirmDialog(null, "Desea eliminar este Conductor", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
        if (a == 0) {
            conductoresDAO.eliminarConductor(rut);
            limpiar();
        }
        txtRut.setText("");
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();//LLamos  Método Limpiar
        habilitar();//Llamos al método habilitar.
        btnNuevo.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        btnGuardar.setEnabled(true);//Al  presionar el botón habilitamos el botón.
        btnEditar.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        btnEliminar.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        btnCancelar.setEnabled(true);//Al presionar el botó nuevo desabilitamos el botón.
        btnBuscar.setEnabled(false);//Al presionar el botó nuevo desabilitamos el botón.
        txtRut.requestFocus();//Focus en txtRut.

    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox jCBoxSexo;
    private com.toedter.calendar.JDateChooser jDCFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelConductor;
    private javax.swing.JPanel panelCrear;
    public javax.swing.JTable tablaEditar;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtTipoLicencia;
    // End of variables declaration//GEN-END:variables
}
