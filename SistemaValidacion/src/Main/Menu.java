/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import Iconos.MenuItem;
import Interfaz.IValidacion_crea;
import Modelo.Usuario;
import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class Menu extends javax.swing.JFrame {

        /*ImageIcon iconPersona = new ImageIcon(getClass().getResource("/Iconos/user.png"));
        ImageIcon iconConfiguracion = new ImageIcon(getClass().getResource("/Iconos/setting.png"));
        ImageIcon iconProducto = new ImageIcon(getClass().getResource("/Iconos/Producto.png"));
        ImageIcon iconCompra= new ImageIcon(getClass().getResource("/Iconos/compra.png"));
        ImageIcon iconVenta= new ImageIcon(getClass().getResource("/Iconos/Ventas.png"));
        ImageIcon iconReporte= new ImageIcon(getClass().getResource("/Iconos/Reporte.png"));
        ImageIcon iconSubMenu = new ImageIcon(getClass().getResource("/Iconos/subMenu.png"));
        ImageIcon iconNext = new ImageIcon(getClass().getResource("/Iconos/next.png"));*/
    
        MenuItem mpVlidaciones;
        MenuItem mpBodegasProductos;
        MenuItem mpPersonas;
        MenuItem mpCompras;
        MenuItem mpVentas;
        MenuItem mpReportes;
        
        
        MenuItem smParametrosAcceso;
        MenuItem smAccesos;
        MenuItem smParametrosPersona;
        MenuItem smParametrosProducto;
        MenuItem smParametrosComprobante;
        MenuItem smParametrosRetencion;
        
        MenuItem opPerfil;
        MenuItem opPuntoEmision;
        MenuItem opUsuario;
        MenuItem opAsignacion;
        MenuItem opTipoIdentificacion;
        MenuItem opTipoContribuyente;
        MenuItem opCategoria;
        MenuItem opTipoIVA;
        MenuItem opTipoComprobante;
        MenuItem opFormaPago;
        MenuItem opTipoRetencion;
        MenuItem opConceptoRetencion;
        MenuItem opProducto;
        MenuItem opBodega;
        MenuItem opPersona;
        MenuItem opCompra;
        MenuItem opRetencion;
        MenuItem opVenta;
        
        MenuItem rpUltimaCompra;
        MenuItem rpUltimaRetencion;
        MenuItem rpCierreCaja;
        MenuItem rpUltimaVenta;
        MenuItem rpListaCompras;
        MenuItem rpListaVentas;
        MenuItem rpListaRetenciones;
        MenuItem rpF101;
        MenuItem rpF103;
        MenuItem rpF104;
        MenuItem rpKardex;
        
        MenuItem cxAccesoExcel;
        
        String s3= "       ♦";//sangriaOpcionNivel2
        String s2=" •";//sangriaOpcionNivel1
        String s1=">>>";//sangriaSubmenu
        
        Usuario us;
        
    public Menu() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
    }   
     public void execute() {
        addMenu(cargarMenuValidaciones());
       
    }
    public void cargarLogin(Usuario usu){
        this.us=usu;
        this.lbUsuario.setText(us.getNombre());
        this.lbPerfil.setText(us.getCorreo());
    }
    
    public MenuItem cargarMenuValidaciones(){ 
      return mpVlidaciones = new MenuItem(null, "Gestor de Validacion", null, cargarSmParametrosValidaciones(),cargarSmReportesValidaciones());        
    }  
    
    
    public MenuItem cargarSmParametrosValidaciones(){
        return smParametrosAcceso = new MenuItem(null, s1+"Crear/Editar/Eliminar", null, cargarOpCrearValidacion(),cargarOpEditarValidacion(), cargarOpEliminarValidacion());
    }
    public MenuItem cargarSmReportesValidaciones(){
        return smParametrosAcceso = new MenuItem(null, s1+"Reportes", null,cargarOpListaValidaciones());
    }
    

    public MenuItem cargarOpCrearValidacion(){
         return opPerfil = new MenuItem(null, s3+"Crear Proceso", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                IValidacion_crea vt=new IValidacion_crea();
                //vt.cargarGestor(gestor);
                jtpVentanas.removeAll();
                jtpVentanas.add(vt);
                vt.cargarUsuario(us);
                vt.show();
                jtpVentanas.repaint();
               
            }
        });
    }
    public MenuItem cargarOpEditarValidacion(){
         return opPerfil = new MenuItem(null, s3+"Editar Proceso", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /*VPerfil vt=new VPerfil();
                vt.cargarGestor(gestor);
                jtpVentanas.removeAll();
                jtpVentanas.add(vt);
                vt.show();
                jtpVentanas.repaint();
               */ 
            }
        });
    }
    public MenuItem cargarOpEliminarValidacion(){
         return opPerfil = new MenuItem(null, s3+"Eliminar Proceso", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /*VPerfil vt=new VPerfil();
                vt.cargarGestor(gestor);
                jtpVentanas.removeAll();
                jtpVentanas.add(vt);
                vt.show();
                jtpVentanas.repaint();
               */ 
            }
        });
    }
    public MenuItem cargarOpListaValidaciones(){
         return opPerfil = new MenuItem(null, s3+"Proceso de Validacion", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /*VPerfil vt=new VPerfil();
                vt.cargarGestor(gestor);
                jtpVentanas.removeAll();
                jtpVentanas.add(vt);
                vt.show();
                jtpVentanas.repaint();
               */ 
            }
        });
    }
    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length;i++ ) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabecera = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelCuerpo = new javax.swing.JPanel();
        jtpVentanas = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCabecera.setBackground(new java.awt.Color(0, 153, 153));
        panelCabecera.setPreferredSize(new java.awt.Dimension(561, 50));

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Sistema de Validacion de Activos Fijos");

        jLabel1.setText("Usuario:");

        jLabel2.setText("Correo:");

        lbUsuario.setText("jLabel3");

        lbPerfil.setText("jLabel3");

        javax.swing.GroupLayout panelCabeceraLayout = new javax.swing.GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(lbPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCabeceraLayout.createSequentialGroup()
                        .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPerfil)))
                    .addGroup(panelCabeceraLayout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(panelCabecera, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(115, 120, 230));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 384));

        jScrollPane1.setBorder(null);

        menus.setBackground(new java.awt.Color(255, 255, 255));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));
        panelCuerpo.setLayout(new java.awt.BorderLayout());

        jtpVentanas.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jtpVentanas.setAutoscrolls(true);
        jtpVentanas.setInheritsPopupMenu(true);
        panelCuerpo.add(jtpVentanas, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCuerpo, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(871, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jtpVentanas;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelCabecera;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
