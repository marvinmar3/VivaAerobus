/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.ActualizarUsuario;
import Modelo.BaseFrame;
import Modelo.CrearUsuario;
import Modelo.DesactivarUsuario;
import Modelo.Usuario;
import Modelo.UsuarioAccion;
import Modelo.UsuarioDAO;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author marvin
 */
public class GestionUsuarios extends BaseFrame{

    private DefaultTableModel modelo;
    private final UsuarioDAO dao;
    
    public GestionUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTiposUsuario(); // para los combobox
        
        dao = new UsuarioDAO();
        inicializarTabla();
        mostrarDatos();
    }
    
    private void inicializarTabla() {
        modelo = new DefaultTableModel(
            new Object[]{"ID Usuario", "Nombre", "Apellido", "Email", "Contraseña", "Tipo de Usuario"}, 0);
        jTable1.setModel(modelo);
    }
    
    private void cargarTiposUsuario()
    {
        tipoUs_act.addItem("cliente");
        tipoUs_act.addItem("administrador");
    }
    
    
    private void ejecutarAccion(String accion) {
        UsuarioAccion usuarioAccion;

        switch (accion) {
            case "Crear Usuario":
                usuarioAccion = new CrearUsuario(
                    campoNombre.getText(),
                    campoApellido.getText(),
                    campoEmail.getText(),
                    campoContraseña.getText(),
                    TipoUsuCrear.getSelectedItem().toString()
                );
                usuarioAccion.ejecutar();
                JOptionPane.showMessageDialog(this, "Usuario creado con éxito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos(new JTextField[]{campoNombre, campoApellido, campoEmail, campoContraseña}, null, new JComboBox[]{TipoUsuCrear});
                break;

            case "Actualizar Usuario":
                usuarioAccion = new ActualizarUsuario(
                    Integer.parseInt(id_usu_act.getText()),
                    nombre_act.getText(),
                    apellido_act.getText(),
                    email_act.getText(),
                    contra_act.getText(),
                    tipoUs_act.getSelectedItem().toString()
                );
                usuarioAccion.ejecutar();
                JOptionPane.showMessageDialog(this, "Usuario Actualizado con éxito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                //limpiarCampos(new JTextField[]{campoNombre, campoApellido, campoEmail, campoContraseña}, null, new JComboBox[]{TipoUsuCrear});
                break;

            case "Desactivar Usuario":
                usuarioAccion = new DesactivarUsuario(Integer.parseInt(ID_usu_desact.getText()));
                usuarioAccion.ejecutar();
                JOptionPane.showMessageDialog(this, "El usuario se ha desactivado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos(new JTextField[]{ID_usu_desact, nombre_desact, apellido_desact, email_desact, tipoUsu_desact}, null, new JComboBox[]{});
                break;

            default:
                JOptionPane.showMessageDialog(this, "Acción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        usuarioAccion.ejecutar(); // Ejecuta la acción correspondiente
    }
    
    private void mostrarDatos() 
    {
        modelo.setRowCount(0); // Limpia las filas existentes
        List<Usuario> usuarios = dao.obtenerUsuarios();
        for (Usuario usuario : usuarios) {
            modelo.addRow(new Object[]
            {
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getContraseña(),
                usuario.getTipoUsuario()
            });
        }
    }
    private void buscarUsuarios(String nombre, String apellido, String tipoUsuario) 
    {
        modelo.setRowCount(0); // Limpia las filas existentes
        List<Usuario> usuarios = dao.obtenerUsuarios(nombre, apellido, tipoUsuario);
        for (Usuario usuario : usuarios) {
            modelo.addRow(new Object[]{
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getContraseña(),
                usuario.getTipoUsuario()
            });
        }

        if (modelo.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontraron Usuarios.", "Sin resultados", javax.swing.JOptionPane.INFORMATION_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        GestionUsuarios = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        campoContraseña = new javax.swing.JTextField();
        LimpiarCrear = new javax.swing.JButton();
        GuardarCrear = new javax.swing.JButton();
        TipoUsuCrear = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        id_usu_act = new javax.swing.JTextField();
        B_ActUs = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nombre_act = new javax.swing.JTextField();
        apellido_act = new javax.swing.JTextField();
        email_act = new javax.swing.JTextField();
        tipoUs_act = new javax.swing.JComboBox<>();
        bActualizarUsuario = new javax.swing.JButton();
        bLimpiar_Act = new javax.swing.JButton();
        contra_act = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        ID_usu_desact = new javax.swing.JTextField();
        bucasrUsu_desact = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        nombre_desact = new javax.swing.JTextField();
        apellido_desact = new javax.swing.JTextField();
        email_desact = new javax.swing.JTextField();
        tipoUsu_desact = new javax.swing.JTextField();
        bDesactUsu = new javax.swing.JButton();
        limpiarDesact = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        SalirGestionUsu = new javax.swing.JButton();
        CrearUsuario = new javax.swing.JButton();
        ActualizarUsuario = new javax.swing.JButton();
        DesactUsuario = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        TablaUsu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido Paterno");

        jLabel4.setText("Email");

        jLabel5.setText("Contraseña");

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel6.setText("Ingrese los siguientes datos...");

        LimpiarCrear.setForeground(new java.awt.Color(0, 153, 0));
        LimpiarCrear.setText("Limpiar");
        LimpiarCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarCrearActionPerformed(evt);
            }
        });

        GuardarCrear.setBackground(new java.awt.Color(0, 153, 51));
        GuardarCrear.setText("Guardar Usuario");
        GuardarCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCrearActionPerformed(evt);
            }
        });

        TipoUsuCrear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion...", "cliente", "administrador" }));
        TipoUsuCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoUsuCrearActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo de Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(84, 84, 84)
                                                .addComponent(jLabel4))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel7)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(campoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(TipoUsuCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(GuardarCrear)
                        .addGap(107, 107, 107))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LimpiarCrear)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GuardarCrear)
                    .addComponent(TipoUsuCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(LimpiarCrear)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        GestionUsuarios.addTab("Crear Usuario", jPanel2);

        jLabel8.setText("ID de Usuario");

        id_usu_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_usu_actActionPerformed(evt);
            }
        });

        B_ActUs.setBackground(new java.awt.Color(0, 153, 0));
        B_ActUs.setText("Buscar Usuario");
        B_ActUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ActUsActionPerformed(evt);
            }
        });

        jLabel9.setText("Nombre");

        jLabel10.setText("Apellido Paterno");

        jLabel11.setText("Email");

        jLabel12.setText("Contraseña");

        jLabel13.setText("Tipo de Usuario");

        bActualizarUsuario.setBackground(new java.awt.Color(0, 153, 0));
        bActualizarUsuario.setText("Actualizar Usuario");
        bActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarUsuarioActionPerformed(evt);
            }
        });

        bLimpiar_Act.setForeground(new java.awt.Color(0, 153, 51));
        bLimpiar_Act.setText("Limpiar");
        bLimpiar_Act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiar_ActActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(id_usu_act, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(B_ActUs))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(email_act, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(contra_act, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86)
                                        .addComponent(bActualizarUsuario))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(nombre_act, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(apellido_act, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(tipoUs_act, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bLimpiar_Act)
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(id_usu_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_ActUs))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombre_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apellido_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipoUs_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(email_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contra_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(bActualizarUsuario))))))
                .addGap(46, 46, 46)
                .addComponent(bLimpiar_Act)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        GestionUsuarios.addTab("Actualizar Usuario", jPanel3);

        jLabel14.setText("ID del Usuario");

        bucasrUsu_desact.setBackground(new java.awt.Color(0, 153, 0));
        bucasrUsu_desact.setText("Buscar Usuario");
        bucasrUsu_desact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bucasrUsu_desactActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lantinghei SC", 1, 15)); // NOI18N
        jLabel15.setText("Datos del Usuario...");

        jLabel16.setText("Nombre");

        jLabel17.setText("Apellido Paterno");

        jLabel18.setText("Email");

        jLabel19.setText("Tipo de Usuario");

        apellido_desact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido_desactActionPerformed(evt);
            }
        });

        bDesactUsu.setBackground(new java.awt.Color(0, 153, 51));
        bDesactUsu.setText("Desactivar Usuario");
        bDesactUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesactUsuActionPerformed(evt);
            }
        });

        limpiarDesact.setForeground(new java.awt.Color(0, 153, 51));
        limpiarDesact.setText("Limpiar");
        limpiarDesact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarDesactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ID_usu_desact, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(bucasrUsu_desact))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre_desact, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(apellido_desact, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(131, 131, 131)
                                .addComponent(jLabel19))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(email_desact, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tipoUsu_desact, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(bDesactUsu)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(limpiarDesact)
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ID_usu_desact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bucasrUsu_desact))
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_desact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido_desact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_desact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoUsu_desact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(bDesactUsu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limpiarDesact)
                .addGap(50, 50, 50))
        );

        GestionUsuarios.addTab("Desactivar Usuario", jPanel4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        GestionUsuarios.addTab("Usuarios", jPanel5);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de Usuarios");

        SalirGestionUsu.setBackground(new java.awt.Color(0, 153, 0));
        SalirGestionUsu.setText("Salir");
        SalirGestionUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirGestionUsuActionPerformed(evt);
            }
        });

        CrearUsuario.setText("Crear Usuario");
        CrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearUsuarioActionPerformed(evt);
            }
        });

        ActualizarUsuario.setText("Actualizar Usuario");
        ActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarUsuarioActionPerformed(evt);
            }
        });

        DesactUsuario.setText("Desactivar Usuario");
        DesactUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesactUsuarioActionPerformed(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gestionusuarios.png"))); // NOI18N

        TablaUsu.setText("Usuarios");
        TablaUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TablaUsuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ActualizarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DesactUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TablaUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SalirGestionUsu)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(SalirGestionUsu))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(GestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(CrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DesactUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TablaUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirGestionUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirGestionUsuActionPerformed
        Sistema frmLogin = new Sistema();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SalirGestionUsuActionPerformed

    private void CrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearUsuarioActionPerformed
        GestionUsuarios.setSelectedIndex(0);
    }//GEN-LAST:event_CrearUsuarioActionPerformed

    private void ActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarUsuarioActionPerformed
        GestionUsuarios.setSelectedIndex(1);
    }//GEN-LAST:event_ActualizarUsuarioActionPerformed

    private void DesactUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesactUsuarioActionPerformed
        GestionUsuarios.setSelectedIndex(2);
    }//GEN-LAST:event_DesactUsuarioActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void GuardarCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCrearActionPerformed
        List<JComponent> camposCrear = List.of(
                campoNombre,
                campoApellido,
                campoEmail,
                campoContraseña,
                TipoUsuCrear
        );
        
        if(validarCampos(camposCrear))
        {
            ejecutarAccion("Crear Usuario");
        }
    }//GEN-LAST:event_GuardarCrearActionPerformed

    private void TipoUsuCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoUsuCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoUsuCrearActionPerformed

    private void id_usu_actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_usu_actActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_usu_actActionPerformed

    private void apellido_desactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellido_desactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellido_desactActionPerformed

    private void LimpiarCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarCrearActionPerformed
        JTextField[] camposTexto ={campoNombre, campoApellido, campoEmail, campoContraseña};
        JDateChooser[] camposFecha ={};
        JComboBox[] comboBoxes ={TipoUsuCrear};
        limpiarCampos(camposTexto, camposFecha, comboBoxes);
    }//GEN-LAST:event_LimpiarCrearActionPerformed

    private void bLimpiar_ActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiar_ActActionPerformed
        JTextField[] camposTexto ={id_usu_act, nombre_act, apellido_act, email_act, contra_act};
        JDateChooser[] camposFecha ={};
        JComboBox[] comboBoxes ={tipoUs_act};
        limpiarCampos(camposTexto, camposFecha, comboBoxes);
    }//GEN-LAST:event_bLimpiar_ActActionPerformed

    private void limpiarDesactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarDesactActionPerformed
        JTextField[] camposTexto ={ID_usu_desact, nombre_desact, email_desact, apellido_desact, tipoUsu_desact};
        JDateChooser[] camposFecha ={};
        JComboBox[] comboBoxes ={};
        limpiarCampos(camposTexto, camposFecha, comboBoxes);
    }//GEN-LAST:event_limpiarDesactActionPerformed

    private void bActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarUsuarioActionPerformed
        List<JComponent> camposActualizar= List.of(
                id_usu_act,
                nombre_act,
                apellido_act,
                email_act,
                contra_act,
                tipoUs_act
        );
        
        if(validarCampos(camposActualizar))
        {
            ejecutarAccion("Actualizar Usuario");
        }
    }//GEN-LAST:event_bActualizarUsuarioActionPerformed

    private void bDesactUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDesactUsuActionPerformed
        List<JComponent> camposDesactivar = List.of(ID_usu_desact);
        
        if(validarCampos(camposDesactivar))
        {
            ejecutarAccion("Desactivar Usuario");
        }
    }//GEN-LAST:event_bDesactUsuActionPerformed

    private void B_ActUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ActUsActionPerformed
        String idTexto = id_usu_act.getText().trim(); // Lee el ID del campo

        // Validar que el ID no esté vacío y sea numérico
        if (idTexto.isEmpty() || !idTexto.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un ID de usuario válido.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = Integer.parseInt(idTexto); // Convertir el ID a un número entero
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarPorID(id); // Llama al DAO para buscar el usuario

        if (usuario != null) {
            // Rellenar los campos con los datos del usuario encontrado
            nombre_act.setText(usuario.getNombre());
            apellido_act.setText(usuario.getApellido());
            email_act.setText(usuario.getEmail());
            contra_act.setText(usuario.getContraseña());
            tipoUs_act.setSelectedItem(usuario.getTipoUsuario());
        } else {
            // Mostrar mensaje de error si no se encuentra el usuario
            JOptionPane.showMessageDialog(this, "No se encontró un usuario con el ID proporcionado.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar los campos
            //limpiarCampos(new JTextField[]{nombre_act, apellido_act, email_act, contra_act}, null, new JComboBox[]{tipoUs_act});
        }
    }//GEN-LAST:event_B_ActUsActionPerformed

    private void bucasrUsu_desactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bucasrUsu_desactActionPerformed
        String idTexto = ID_usu_desact.getText().trim();
        
        // validar que el ID no esté vacío y sea numérico
        if (idTexto.isEmpty() || !idTexto.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un ID de usuario válido.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int id = Integer.parseInt(idTexto); // Convertir el ID a número entero
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarPorID(id); // Llama al DAO para buscar el usuario

        if (usuario != null) {
            // Rellenar los campos con los datos del usuario encontrado
            nombre_desact.setText(usuario.getNombre());
            apellido_desact.setText(usuario.getApellido());
            email_desact.setText(usuario.getEmail());
            tipoUsu_desact.setText(usuario.getTipoUsuario());
        } else {
            // Mostrar mensaje si no se encuentra el usuario
            JOptionPane.showMessageDialog(this, "No se encontró un usuario con el ID proporcionado.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            // Limpiar los campos
            limpiarCampos(new JTextField[]{nombre_desact, apellido_desact, email_desact, tipoUsu_desact}, null, null);
        }

        
    }//GEN-LAST:event_bucasrUsu_desactActionPerformed

    private void TablaUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TablaUsuActionPerformed
        GestionUsuarios.setSelectedIndex(3);
    }//GEN-LAST:event_TablaUsuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarUsuario;
    private javax.swing.JButton B_ActUs;
    private javax.swing.JButton CrearUsuario;
    private javax.swing.JButton DesactUsuario;
    private javax.swing.JTabbedPane GestionUsuarios;
    private javax.swing.JButton GuardarCrear;
    private javax.swing.JTextField ID_usu_desact;
    private javax.swing.JButton LimpiarCrear;
    private javax.swing.JButton SalirGestionUsu;
    private javax.swing.JButton TablaUsu;
    private javax.swing.JComboBox<String> TipoUsuCrear;
    private javax.swing.JTextField apellido_act;
    private javax.swing.JTextField apellido_desact;
    private javax.swing.JButton bActualizarUsuario;
    private javax.swing.JButton bDesactUsu;
    private javax.swing.JButton bLimpiar_Act;
    private javax.swing.JButton bucasrUsu_desact;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoContraseña;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField contra_act;
    private javax.swing.JTextField email_act;
    private javax.swing.JTextField email_desact;
    private javax.swing.JTextField id_usu_act;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limpiarDesact;
    private javax.swing.JTextField nombre_act;
    private javax.swing.JTextField nombre_desact;
    private javax.swing.JComboBox<String> tipoUs_act;
    private javax.swing.JTextField tipoUsu_desact;
    // End of variables declaration//GEN-END:variables
}
