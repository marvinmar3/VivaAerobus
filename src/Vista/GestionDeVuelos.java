

package Vista;

import Modelo.Conexion;
import Modelo.FormateadorDeFechas;
import Modelo.GestorVuelos;
import Modelo.Limpiable;
import Modelo.Validable;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 import javax.swing.*;

/**
 *
 * @author marvin
 */
public class GestionDeVuelos extends javax.swing.JFrame implements Limpiable, Validable{

    /**
     * Creates new form GestionDeVuelos
     */
    public GestionDeVuelos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    // metodo generico para limpiar campos
    @Override
    public void limpiarCampos(JTextField[] camposTexto, JDateChooser[] camposFecha, JComboBox[] comboBoxes)
    {
       if(camposTexto!=null)
       {
           for(JTextField campo : camposTexto)
           {
               campo.setText("");
           }
       }
       if(camposFecha!= null)
       {
           for(JDateChooser campo : camposFecha)
           {
               campo.setDate(null);
           } 
       }
       if (comboBoxes != null) 
       {
            for (JComboBox combo : comboBoxes) 
            {
                combo.setSelectedIndex(0); // Restaura el JComboBox a la primera opción
            }
        }
       javax.swing.JOptionPane.showMessageDialog(this, "Los campos han sido limpiados.");
    }
    
    private void limpiarCamposElim()
    {
        JTextField[] camposTexto = {fIDElim, fOrigenElim, fDestinoElim, fHoraSalidaElim, fDuracionElim, fPrecioElim};
        JDateChooser[] camposFecha = {jDateChooser5};
        JComboBox[] comboBoxes = {};
        limpiarCampos(camposTexto, camposFecha ,comboBoxes);
    }
    
    private void guardarVuelo()
    {

        String origen = fOrigen.getText().trim();
        String destino = fDestino.getText().trim();
        Date fechaSeleccionada = jDateChooserSalida.getDate();
        String horaSalida = fHoraSalida.getText().trim();
        String duracion = fDuracion.getText().trim();
        String precioTexto = fPrecio.getText().trim();

        //validar que los campos no estén vacíos
        if (origen.isEmpty() || destino.isEmpty() || fechaSeleccionada == null || horaSalida.isEmpty() || duracion.isEmpty() || precioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            // Validar que el precio sea un número válido
            double precio = Double.parseDouble(precioTexto);

            // Formatear la fecha al formato requerido para la base de datos
            String fechaSalida = FormateadorDeFechas.convertirFecha(fechaSeleccionada);

            // Guardar el vuelo utilizando el gestor de vuelos
            GestorVuelos gestorVuelos = new GestorVuelos();
            gestorVuelos.guardarVuelo(origen, destino, fechaSalida, horaSalida, duracion, precio);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Vuelo guardado con éxito.");

            // Limpiar los campos del formulario usando la interfaz
            limpiarCampos(new JTextField[]{fOrigen, fDestino, fHoraSalida, fDuracion, fPrecio}, new JDateChooser[]{jDateChooserSalida}, null);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @Override
    public boolean validarCampos(List<JComponent> campos) {
        for (JComponent campo : campos) {
            if (campo instanceof JTextField) {
                JTextField textField = (JTextField) campo;
                if (textField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
                    return false; // Campo vacío encontrado
                }
            } else if (campo instanceof JDateChooser) {
                JDateChooser dateChooser = (JDateChooser) campo;
                JTextField dateField = (JTextField) dateChooser.getDateEditor().getUiComponent();
                if (dateField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha.", "Error", JOptionPane.WARNING_MESSAGE);
                    return false; // Campo de fecha vacío
                }
            }
        }
        return true; // Todos los campos son válidos
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
        NuevoVuelo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ActualizarVuelo = new javax.swing.JButton();
        EliminarVuelo = new javax.swing.JButton();
        TabbedGestion = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserSalida = new com.toedter.calendar.JDateChooser();
        fOrigen = new javax.swing.JTextField();
        fDestino = new javax.swing.JTextField();
        fHoraSalida = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fPrecio = new javax.swing.JTextField();
        bGuardar = new javax.swing.JButton();
        duracion = new javax.swing.JLabel();
        fDuracion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        limpiarNuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        fOrigen1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fDestino1 = new javax.swing.JTextField();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        fHoraSalida1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        fDuracion1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        fPrecio1 = new javax.swing.JTextField();
        bActualizar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        fID = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        limpiarActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        fIDElim = new javax.swing.JTextField();
        bBuscarElim = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        fOrigenElim = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        fDestinoElim = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        fHoraSalidaElim = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        fDuracionElim = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        fPrecioElim = new javax.swing.JTextField();
        bEliminar = new javax.swing.JButton();
        limpiarEliminar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        bSalir = new java.awt.Button();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        NuevoVuelo.setText("Nuevo Vuelo");
        NuevoVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoVueloActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de Vuelos...");

        ActualizarVuelo.setText("Actualizar Vuelo");
        ActualizarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarVueloActionPerformed(evt);
            }
        });

        EliminarVuelo.setText("Eliminar Vuelo");
        EliminarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarVueloActionPerformed(evt);
            }
        });

        jLabel2.setText("Origen");

        jLabel3.setText("Destino");

        jLabel4.setText("Fecha");

        jLabel5.setText("Hora");

        fOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fOrigenActionPerformed(evt);
            }
        });

        fHoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fHoraSalidaActionPerformed(evt);
            }
        });

        jLabel8.setText("Precio");

        bGuardar.setBackground(new java.awt.Color(0, 153, 51));
        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        duracion.setText("Duracion de Vuelo");

        fDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fDuracionActionPerformed(evt);
            }
        });

        jLabel6.setText("Horas");

        limpiarNuevo.setBackground(new java.awt.Color(102, 102, 102));
        limpiarNuevo.setForeground(new java.awt.Color(255, 255, 255));
        limpiarNuevo.setText("Limpiar");
        limpiarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(duracion)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(bGuardar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(limpiarNuevo)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(fHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fOrigen)
                                .addComponent(fDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(bGuardar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(duracion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(46, 46, 46)
                        .addComponent(limpiarNuevo)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jDateChooserSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        TabbedGestion.addTab("Nuevo Vuelo", jPanel2);

        jLabel9.setText("Origen");

        fOrigen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fOrigen1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha");

        jLabel11.setText("Destino");

        jLabel13.setText("Hora");

        fHoraSalida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fHoraSalida1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Duracion de Vuelo");

        jLabel15.setText("Precio");

        bActualizar.setBackground(new java.awt.Color(0, 153, 51));
        bActualizar.setText("Actualizar");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        jLabel16.setText("ID del Vuelo");

        fID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fIDActionPerformed(evt);
            }
        });

        bBuscar.setBackground(new java.awt.Color(51, 153, 0));
        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        jLabel12.setText("Horas");

        limpiarActualizar.setBackground(new java.awt.Color(102, 102, 102));
        limpiarActualizar.setForeground(new java.awt.Color(255, 255, 255));
        limpiarActualizar.setText("Limpiar");
        limpiarActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(98, 98, 98))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(fID, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bBuscar)
                                .addGap(25, 25, 25)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(120, 120, 120)
                                .addComponent(jLabel13))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fHoraSalida1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(fPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(126, 126, 126)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fDuracion1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addGap(63, 63, 63)
                                .addComponent(bActualizar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(fOrigen1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fDestino1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limpiarActualizar)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fOrigen1)
                            .addComponent(fDestino1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fHoraSalida1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fDuracion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(bActualizar))
                .addGap(79, 79, 79)
                .addComponent(limpiarActualizar)
                .addGap(52, 52, 52))
        );

        TabbedGestion.addTab("Actualizar Vuelo", jPanel3);

        jLabel17.setText("ID del Vuelo");

        bBuscarElim.setBackground(new java.awt.Color(51, 153, 0));
        bBuscarElim.setText("Buscar");
        bBuscarElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarElimActionPerformed(evt);
            }
        });

        jLabel18.setText("Origen");

        jLabel19.setText("Destino");

        jLabel20.setText("Fecha de Salida");

        jLabel21.setText("Hora de Salida");

        fHoraSalidaElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fHoraSalidaElimActionPerformed(evt);
            }
        });

        jLabel22.setText("Duracion de Vuelo");

        jLabel24.setText("Precio");

        bEliminar.setBackground(new java.awt.Color(0, 153, 51));
        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        limpiarEliminar.setBackground(new java.awt.Color(102, 102, 102));
        limpiarEliminar.setForeground(new java.awt.Color(255, 255, 255));
        limpiarEliminar.setText("Limpiar");
        limpiarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarEliminarActionPerformed(evt);
            }
        });

        jLabel23.setText("Horas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(98, 296, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel24))
                                            .addComponent(fPrecioElim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(fDuracionElim, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel23))))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addGap(18, 18, 18)
                                            .addComponent(fIDElim, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bBuscarElim))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fOrigenElim, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel20))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel21)
                                                .addComponent(fDestinoElim, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fHoraSalidaElim, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel19)))))
                                .addGap(0, 28, Short.MAX_VALUE)))
                        .addGap(320, 320, 320))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(bEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpiarEliminar)
                        .addGap(51, 51, 51))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(fIDElim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBuscarElim))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fOrigenElim)
                            .addComponent(fDestinoElim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fHoraSalidaElim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fPrecioElim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fDuracionElim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEliminar)
                    .addComponent(limpiarEliminar))
                .addGap(60, 60, 60))
        );

        TabbedGestion.addTab("Eliminar Vuelo", jPanel4);

        bSalir.setBackground(new java.awt.Color(0, 153, 0));
        bSalir.setLabel("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gestionvuelos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(NuevoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(EliminarVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ActualizarVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addComponent(TabbedGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(NuevoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(ActualizarVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(EliminarVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(TabbedGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
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

    private void NuevoVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoVueloActionPerformed
        TabbedGestion.setSelectedIndex(0);
        
    }//GEN-LAST:event_NuevoVueloActionPerformed

    private void ActualizarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarVueloActionPerformed
        TabbedGestion.setSelectedIndex(1);
    }//GEN-LAST:event_ActualizarVueloActionPerformed

    private void EliminarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarVueloActionPerformed
        TabbedGestion.setSelectedIndex(2);
    }//GEN-LAST:event_EliminarVueloActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        List<JComponent> campos = List.of(
            fOrigen, 
            fDestino, 
            jDateChooserSalida, 
            fHoraSalida, 
            fDuracion, 
            fPrecio
        );

        // Validar los campos antes de guardar
        if (validarCampos(campos)) {
            guardarVuelo(); // Llama al método que guarda el vuelo
        }
        
    }//GEN-LAST:event_bGuardarActionPerformed

    private void fHoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fHoraSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fHoraSalidaActionPerformed

    private void fHoraSalida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fHoraSalida1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fHoraSalida1ActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        
        List<JComponent> campos = List.of(fID, fOrigen1, fDestino1, jDateChooser3, fHoraSalida1, fPrecio1, fDuracion1);
        
        if (!validarCampos(campos)) {
            return;
        }
        
        String idVuelo = fID.getText();
        String origen = fOrigen1.getText();
        Date fechaSalida = jDateChooser3.getDate();
        String destino = fDestino1.getText();
        String horaSalida = fHoraSalida1.getText();
        String precioTexto = fPrecio1.getText();
        String duracionVuelo= fDuracion1.getText();

        try {
        // Convertir la fecha a formato String
        String fechaSalidaStr = FormateadorDeFechas.convertirFecha(fechaSalida);

        // Validar que el precio sea un número
        double precio = Double.parseDouble(precioTexto);

        // Conexión con la base de datos
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(
                 "UPDATE vuelos SET origen = ?, destino = ?, fechaSalida = ?, horaSalida = ?, precio = ?, duracionVuelo = ? WHERE id_vuelo = ?")) {

            // Asignar valores
            pst.setString(1, origen);
            pst.setString(2, destino);
            pst.setString(3, fechaSalidaStr);
            pst.setString(4, horaSalida);
            pst.setDouble(5, precio);
            pst.setString(6, duracionVuelo);
            pst.setString(7, idVuelo);

            // Ejecutar actualización
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Vuelo actualizado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un vuelo con el ID proporcionado.");
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al actualizar el vuelo: " + e.getMessage());
    }
        
    }//GEN-LAST:event_bActualizarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed

        List<JComponent> campos = List.of(fID);

        
        if (!validarCampos(campos)) {
            return;
        }
        
        String idVuelo= fID.getText();
        
        try (Connection con = Conexion.getConnection();
            PreparedStatement pst = con.prepareStatement(
                 "SELECT origen, destino, fechaSalida, horaSalida, precio, duracionVuelo FROM vuelos WHERE id_vuelo = ?")) {

            pst.setString(1, idVuelo);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Rellenar los campos con datos recuperados
                    fOrigen1.setText(rs.getString("origen"));
                    fDestino1.setText(rs.getString("destino"));

                    // Convertir la fecha de la BD a Date
                    Date fechaSalidaDate = rs.getDate("fechaSalida");
                    jDateChooser3.setDate(fechaSalidaDate != null ? fechaSalidaDate : null);

                    fHoraSalida1.setText(rs.getString("horaSalida"));
                    fPrecio1.setText(rs.getString("precio"));
                    fDuracion1.setText(rs.getString("duracionVuelo"));
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un vuelo con el ID ingresado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar el vuelo: " + e.getMessage());
        }  
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bBuscarElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarElimActionPerformed
        
        List<JComponent> campos = List.of(fIDElim);
        
        if (!validarCampos(campos)) {
            return;
        }


        String idVuelo= fIDElim.getText();
        
        try (Connection con = Conexion.getConnection();
         PreparedStatement pst = con.prepareStatement(
             "SELECT origen, destino, fechaSalida, horaSalida, precio, duracionVuelo FROM vuelos WHERE id_vuelo = ?")) {

            pst.setString(1, idVuelo);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Rellenar los campos con datos recuperados
                    fOrigenElim.setText(rs.getString("origen"));
                    fDestinoElim.setText(rs.getString("destino"));

                    // Convertir la fecha de la BD a Date
                    Date fechaSalidaDate = rs.getDate("fechaSalida");
                    jDateChooser5.setDate(fechaSalidaDate != null ? fechaSalidaDate : null);

                    fHoraSalidaElim.setText(rs.getString("horaSalida"));
                    fPrecioElim.setText(rs.getString("precio"));
                    fDuracionElim.setText(rs.getString("duracionVuelo"));
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un vuelo con el ID ingresado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar el vuelo: " + e.getMessage());
        }
    }//GEN-LAST:event_bBuscarElimActionPerformed

    private void fHoraSalidaElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fHoraSalidaElimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fHoraSalidaElimActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        String idVuelo =fIDElim.getText().trim();
        
        if(idVuelo.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor ingrese un id de vuelo para eliminar");
            return;
        }
        
        //confirmar si el usuario quiere eliminar el registro
        int confirmacion= javax.swing.JOptionPane.showConfirmDialog(
        this,
                "¿Estas seguro de que deseas eliminar este vuelo?","Confirmar Eliminación", javax.swing.JOptionPane.YES_NO_OPTION
        );
        
        // si el usuario selecciona si
        if(confirmacion == javax.swing.JOptionPane.YES_OPTION)
        {
            Connection con = null;
            PreparedStatement pst=null;
            
            try
            {
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Vivaerobus?serverTimezone=UTC", "root", "Martinez230");
                String sql="delete from vuelos where id_vuelo = ?";
                pst= con.prepareStatement(sql);
                pst.setString(1, idVuelo);
                
                int rowsAffected = pst.executeUpdate();
                if(rowsAffected>0)
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Vuelo eliminado con éxito.");
                    limpiarCamposElim(); // Limpiar los campos del formulario después de eliminar
                }
                else
                {
                        javax.swing.JOptionPane.showMessageDialog(this, "No se encontró un vuelo con el ID proporcionado");  
                }
            }catch(SQLException e)
            {
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar el vuelo: " + e.getMessage());
            }finally
            {
               try {
                    if (pst != null) pst.close();
                    if (con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } 
            }
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        Sistema frmLogin = new Sistema();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bSalirActionPerformed

    private void fIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fIDActionPerformed

    private void fOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fOrigenActionPerformed

    private void fOrigen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fOrigen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fOrigen1ActionPerformed

    private void fDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fDuracionActionPerformed

    private void limpiarActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActualizarActionPerformed
    JTextField[] camposTexto ={fID, fHoraSalida1, fOrigen1, fDestino1, fDuracion1, fPrecio1};
    JDateChooser[] camposFecha ={jDateChooser3};
    JComboBox[] comboBoxes = {}; // No hay ComboBox en esta pestaña
    limpiarCampos(camposTexto, camposFecha, comboBoxes); 
    
    }//GEN-LAST:event_limpiarActualizarActionPerformed

    private void limpiarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarEliminarActionPerformed

    JTextField[] camposTexto = {fIDElim, fOrigenElim, fDestinoElim, fHoraSalidaElim, fDuracionElim, fPrecioElim};
    JDateChooser[] camposFecha = {jDateChooser5};
    JComboBox[] comboBoxes = {}; // No hay ComboBox en esta pestaña
    limpiarCampos(camposTexto, camposFecha, comboBoxes);
    }//GEN-LAST:event_limpiarEliminarActionPerformed

    private void limpiarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarNuevoActionPerformed
        JTextField[] camposTexto ={fOrigen, fDestino, fDuracion, fPrecio};
        JDateChooser[] camposFecha ={jDateChooserSalida};
        JComboBox[] comboBoxes = {}; // No hay ComboBox en esta pestaña
        limpiarCampos(camposTexto, camposFecha, comboBoxes);
    }//GEN-LAST:event_limpiarNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(GestionDeVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionDeVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionDeVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionDeVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionDeVuelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarVuelo;
    private javax.swing.JButton EliminarVuelo;
    private javax.swing.JButton NuevoVuelo;
    private javax.swing.JTabbedPane TabbedGestion;
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bBuscarElim;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private java.awt.Button bSalir;
    private javax.swing.JLabel duracion;
    private javax.swing.JTextField fDestino;
    private javax.swing.JTextField fDestino1;
    private javax.swing.JTextField fDestinoElim;
    private javax.swing.JTextField fDuracion;
    private javax.swing.JTextField fDuracion1;
    private javax.swing.JTextField fDuracionElim;
    private javax.swing.JTextField fHoraSalida;
    private javax.swing.JTextField fHoraSalida1;
    private javax.swing.JTextField fHoraSalidaElim;
    private javax.swing.JTextField fID;
    private javax.swing.JTextField fIDElim;
    private javax.swing.JTextField fOrigen;
    private javax.swing.JTextField fOrigen1;
    private javax.swing.JTextField fOrigenElim;
    private javax.swing.JTextField fPrecio;
    private javax.swing.JTextField fPrecio1;
    private javax.swing.JTextField fPrecioElim;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooserSalida;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiarActualizar;
    private javax.swing.JButton limpiarEliminar;
    private javax.swing.JButton limpiarNuevo;
    // End of variables declaration//GEN-END:variables
}
