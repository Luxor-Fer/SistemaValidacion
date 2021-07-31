/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Modelo.*;
import java.awt.Color;
import java.awt.GridLayout;
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
        ArrayList<Usuario_Modelo> ob;

        try {
            Consultas_bd cons = new Consultas_bd();
            ob = cons.consultarUsuarios();
            if(ob.isEmpty()){
                JOptionPane.showMessageDialog(
                    null,
                    "Aviso: " + "No existen usuarios disponibles para validar",
                    "Sin datos ",
                    JOptionPane.OK_CANCEL_OPTION);
            }    
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
            TableColumn m = tabla.getColumnModel().getColumn(0);
            m.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            m.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
            m.setHeaderRenderer(new EditarCabeceraTabla(h));
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
    public void tbUsuarioActivo(JPanel panelP,ArrayList<String> usuarios) {
        int tamaño= usuarios.size();
        if(tamaño>0){
            Consultas_bd bd= new Consultas_bd();
            int i=0;
            while(i<tamaño){
            String cedula=usuarios.get(i).toString();
            Usuario_Modelo us= new Usuario_Modelo();
            us=bd.consultarUsuario(cedula);
            JLabel id = new JLabel("      ID: "+us.getCedula());    
            JLabel nombre = new JLabel("USUARIO: "+us.getNombre()+" "+us.getApellido());    
            JLabel cantActivos = new JLabel("      ACTIVOS: "+us.getCantidadActivos());
            JPanel panelEtiquetas = new JPanel();
            panelEtiquetas.setLayout(new GridLayout(0,2));
            panelEtiquetas.add(id);
            panelEtiquetas.add(nombre);
            panelEtiquetas.add(cantActivos);
            JPanel panel = new JPanel();
            panel.add(panelEtiquetas);
            panelEtiquetas.setBorder(new TitledBorder(new EtchedBorder(), "Datos de Usuario"));
            panelEtiquetas.setBackground(Color.WHITE);
            JTable tabla = new JTable();
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.addColumn("DETALLE");
            modelo.addColumn("OBSERVACION");
            ArrayList<Activo_Modelo> activos=bd.consultarActivosPorUsuario(cedula);
                int j=0;
                int tamAct=activos.size();
                while(j<tamAct){
                    modelo.addRow(new Object[]{activos.get(j).getNombre(), activos.get(j).getObservacion()});
                    j++;
                }
                TableColumnModel modeloColumna = tabla.getColumnModel();
                modeloColumna.getColumn(0).setPreferredWidth(8);
                modeloColumna.getColumn(1).setPreferredWidth(10);
                JTableHeader cabecera= tabla.getTableHeader();
                JPanel panelTabla= new JPanel();
                panelTabla.setBackground(Color.WHITE);
                panelTabla.setBorder(new TitledBorder(new EtchedBorder(), "     Activos a su cargo"));
                panelTabla.setLayout(new GridLayout(0,1));
                panelTabla.add(cabecera);
                panelTabla.add(tabla);
                panel.add(panelTabla);
                panel.setLayout(new GridLayout(0,1));
                panel.setBorder(new TitledBorder(new EtchedBorder(), ""));
                panel.setBackground(Color.CYAN);
                panelP.add(panel);
                i++;
            }
        }
    }

}
