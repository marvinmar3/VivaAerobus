
package Modelo;

import com.toedter.calendar.JDateChooser;
import java.util.List;
import javax.swing.*;


public abstract class BaseFrame extends javax.swing.JFrame implements Validable, Limpiable {
    
    @Override
    public void limpiarCampos(JTextField[] camposTexto, JDateChooser[] camposFecha, JComboBox[] camposCombo)
    {
        if (camposTexto != null) {
            for (JTextField campo : camposTexto) {
                campo.setText(""); // Borra el contenido del campo
            }
        }
        
        if (camposFecha != null) {
            for (JDateChooser campo : camposFecha) {
                campo.setDate(null); // Reinicia la fecha
            }
        }
        
        if (camposCombo != null) {
            for (JComboBox campo : camposCombo) {
                campo.setSelectedIndex(0); // Selecciona el primer elemento
            }
        }
    }
    
    @Override
    public boolean validarCampos(List<JComponent> campos)
    {
        for (JComponent campo : campos) {
            if (campo instanceof JTextField) {
                if (((JTextField) campo).getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
                    return false;
                }
            } else if (campo instanceof JComboBox) {
                if (((JComboBox<?>) campo).getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(this, "Por favor, selecciona una opción.");
                    return false;
                }
            } else if (campo instanceof JDateChooser) {
                if (((JDateChooser) campo).getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha.");
                    return false;
                }
            }
        }
        System.out.println("Validación exitosa en BaseFrame.");
        return true;
    }
}


