/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Consumo_WS.Consultas_bd;
import Modelo.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USUARIO
 */
public class CargarTab {

    public void tbUsuario(JTable tabla) {
        ArrayList<Empleado> ob;
        
        try {
            Consultas_bd cons = new Consultas_bd();
            ob = cons.consultarEmpleados();
            if (ob.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Aviso: " + "No existen usuarios disponibles para validar",
                        "Sin datos ",
                        JOptionPane.OK_CANCEL_OPTION);
            }
//Datos de Tabla
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.addColumn("SELECCIONAR");
            modelo.addColumn("ID");
            modelo.addColumn("USUARIO");
            modelo.addColumn("N° ACTIVOS");
            int tamaño = ob.size();
            int i = 0;
            while (i < tamaño) {
                modelo.addRow(new Object[]{Boolean.FALSE, ob.get(i).getCedula(), ob.get(i).getNombre()
                    + " " + ob.get(i).getApellido(), ob.get(i).getCantidadActivos()});
                i++;
            }
            TableColumnModel modeloColumna = tabla.getColumnModel();
            TableColumn m = tabla.getColumnModel().getColumn(0);
            m.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            m.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
            modeloColumna.getColumn(0).setPreferredWidth(200);
            modeloColumna.getColumn(1).setPreferredWidth(250);
            modeloColumna.getColumn(2).setPreferredWidth(315);
            modeloColumna.getColumn(3).setPreferredWidth(100);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + "No se puede conectar a la base de datos",
                    "Error Base de Datos ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tbUsuarioActivo(JTable tabla, JTable tbUsuario) {
        tabla.removeAll();
        int i = 0;
        int tamañoTb = tbUsuario.getRowCount();
        if (tamañoTb > 0) {
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("ID Custodio");
            modelo.addColumn("Nombre Custodio");
            while (i < tamañoTb) {
                boolean resp = (boolean) tbUsuario.getValueAt(i, 0);
                if (resp) {
                    Consultas_bd cs = new Consultas_bd();
                    ArrayList<Activo> ob = cs.consultarActivosPorUsuario(String.valueOf(tbUsuario.getValueAt(i, 1)));
                    int tamaño = ob.size();
                    int j = 0;
                    while (j<tamaño) {
                        modelo.addRow(new Object[]{ob.get(j).getCodigo(),
                             ob.get(j).getNombre(),
                             ob.get(j).getUsuario().getCedula(),
                             ob.get(j).getUsuario().getApellido() + " " + ob.get(j).getUsuario().getNombre()});
                        j++;
                    }

                }
                i++;
            }
        }
    }
    public void tbValidaciones(JTable tabla, String estado) {
        ArrayList<Validacion> ob;
        
        try {
            Consultas_bd cons = new Consultas_bd();
            ob = cons.consultarValidaciones(estado);
            System.out.println(ob.toString());
            if (ob.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Aviso: " + "No existen usuarios disponibles para validar",
                        "Sin datos ",
                        JOptionPane.OK_CANCEL_OPTION);
            }
//Datos de Tabla
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Fecha de Creación");
            modelo.addColumn("N° Empleados");
            modelo.addColumn("N° Activos");
            int tamaño = ob.size();
            int i = 0;
            while (i < tamaño) {
                modelo.addRow(new Object[]{ob.get(i).getId(), ob.get(i).getNombre()
                        ,ob.get(i).getDescripcion()
                        , new SimpleDateFormat("yyyy/MM/dd").format(ob.get(i).getFechaCreacion())
                        , ob.get(i).cantidadEmpleados()
                        , ob.get(i).cantidadActivos()});
                i++;
            }
            TableColumnModel modeloColumna = tabla.getColumnModel();
            modeloColumna.getColumn(0).setPreferredWidth(10);
            modeloColumna.getColumn(1).setPreferredWidth(200);
            modeloColumna.getColumn(2).setPreferredWidth(300);
            modeloColumna.getColumn(3).setPreferredWidth(100);
            modeloColumna.getColumn(4).setPreferredWidth(75);
            modeloColumna.getColumn(5).setPreferredWidth(75);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + "No se puede conectar a la base de datos",
                    "Error Base de Datos ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public void tbEmpValidaciones(JTable tabla, int idVal) {
        ArrayList<EmpleadoValidacion> ob;
        
        try {
            Consultas_bd cons = new Consultas_bd();
            ob = cons.consultarEmpleadosValByIdVal(idVal);
            System.out.println(ob.toString());
            if (ob.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Aviso: " + "No existen usuarios disponibles para validar",
                        "Sin datos ",
                        JOptionPane.OK_CANCEL_OPTION);
            }
//Datos de Tabla
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.addColumn("Cedula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("N° Activos");
            modelo.addColumn("");
            int tamaño = ob.size();
            int i = 0;
            while (i < tamaño) {
                modelo.addRow(new Object[]{ob.get(i).getIdEmpleado().getCedula()
                        , ob.get(i).getIdEmpleado().getNombre()
                        , ob.get(i).getIdEmpleado().getApellido()
                        , ob.get(i).cantidadActivos()
                        , ob.get(i).getId()});
                i++;
            }
            TableColumnModel modeloColumna = tabla.getColumnModel();
            modeloColumna.getColumn(0).setPreferredWidth(100);
            modeloColumna.getColumn(1).setPreferredWidth(100);
            modeloColumna.getColumn(2).setPreferredWidth(100);
            modeloColumna.getColumn(3).setPreferredWidth(100);
            modeloColumna.getColumn(4).setPreferredWidth(1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + "No se puede conectar a la base de datos",
                    "Error Base de Datos ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
