/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Modelo.*;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USUARIO
 */
public class CargarTab {

    public void tbUsuario(JTable tabla) {
        ArrayList<Usuario_Modelo> ob;

        try {
            Consultas_bd cons = new Consultas_bd();
            ob = cons.consultarUsuarios();
            //Datos de Tabla
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.addColumn("TODO");
            modelo.addColumn("ID");
            modelo.addColumn("USUARIO");
            modelo.addColumn("ACTIVOS");
            int tamaño = ob.size();
            int i = 0;

            while (i < tamaño) {
                modelo.addRow(new Object[]{Boolean.FALSE, ob.get(i).getCedula(), ob.get(i).getNombre()
                    + " " + ob.get(i).getApellido(), ob.get(i).getCantidadActivos()});
                i++;
            }
            TableColumnModel modeloColumna = tabla.getColumnModel();
            //modeloColumna.getColumn(0).setCellEditor(new DefaultCellEditor());
            JCheckBox h = new JCheckBox();
            h.setText("TODO");
            h.setSelected(false);
            h.setEnabled(true);
            h.enable();
            TableColumn m = tabla.getColumnModel().getColumn(0);
            m.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            m.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
            m.setHeaderRenderer(tabla.getDefaultRenderer(Boolean.class));
            m.setHeaderValue(Boolean.FALSE);
            modeloColumna.getColumn(0).setPreferredWidth(315);
            modeloColumna.getColumn(1).setPreferredWidth(315);
            modeloColumna.getColumn(2).setPreferredWidth(315);
            modeloColumna.getColumn(3).setPreferredWidth(315);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + "No se puede conectar a la base de datos",
                    "Error Base de Datos ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
