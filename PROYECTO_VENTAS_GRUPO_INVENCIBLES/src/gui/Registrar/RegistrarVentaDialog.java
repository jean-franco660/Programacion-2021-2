package gui.Registrar;

import entidades.Producto;
import gui.venta.*;
import entidades.Usuario;
import gui.login.LoginVentas;
import implementacion.implVenta;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistrarVentaDialog extends javax.swing.JFrame {
    Usuario u   = new Usuario();  
    FondoPanel fondo = new FondoPanel();
    Producto p = new Producto();
    DefaultTableModel modelo;
    implVenta ventaDao = new implVenta();
    ArrayList<Producto> listaVentas= new ArrayList<>(50);
    Object ListaDeVentas[] = new Object[10];
    public int contador=0;

    public RegistrarVentaDialog() {
        this.setContentPane(fondo);
        u.setNombreUsuario(LoginVentas.MostrarLabel[0]);
        u.setCategoria(LoginVentas.MostrarLabel[1]);
        
        System.out.println("Dentro de Ventas\n----------------------");
        System.out.println(u.getNombreUsuario());
        System.out.println(u.getCategoria());
        
        initComponents(); 
        ReporteData();
        
        
   
    }

  
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        v_TipoTabla = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        v_tipo = new javax.swing.JTextField();
        v_nombre = new javax.swing.JTextField();
        v_precio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        v_stock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_carritoVentas = new javax.swing.JButton();
        lbl_contador = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Ventas");

        lbl_titulo.setBackground(new java.awt.Color(255, 0, 0));
        lbl_titulo.setFont(new java.awt.Font("Stencil", 1, 40)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("REGISTRAR VENTA");

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REGRESAR");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        v_TipoTabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        v_TipoTabla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "enlatados", "embasados", "bebidas", "abarrotes" }));
        v_TipoTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        v_TipoTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_TipoTablaActionPerformed(evt);
            }
        });

        v_tipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        v_nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        v_precio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        v_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_precioActionPerformed(evt);
            }
        });

        jLabel1.setText("PRODUCTO");

        jLabel2.setText("TIPO");

        jLabel3.setText("PRECIO UNIDAD");

        v_stock.setBackground(new java.awt.Color(51, 255, 204));
        v_stock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        v_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_stockActionPerformed(evt);
            }
        });

        jLabel4.setText("CANTIDAD A VENDER");

        btn_carritoVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_carritoVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/images/carritoVentas3.jpg"))); // NOI18N
        btn_carritoVentas.setText("VENDER");
        btn_carritoVentas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 51)));
        btn_carritoVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_carritoVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carritoVentasActionPerformed(evt);
            }
        });

        lbl_contador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_contador.setText(String.valueOf(contador));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(v_precio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(v_tipo)
                        .addComponent(v_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(v_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_carritoVentas)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_contador, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(v_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(v_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(v_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(v_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbl_contador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_carritoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LISTA PRODUCTOS");

        jMenu1.setText("File");

        jMenuItem6.setText("Editar Usuarios");
        jMenu1.add(jMenuItem6);

        jMenuItem1.setText("Registar Venta");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Reporte Venta");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Registrar producto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Reporte producto");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 703, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(v_TipoTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(v_TipoTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentaDialog vntDialog = new VentaDialog();
        vntDialog.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        int row=tablaProducto.getSelectedRow();
        if (evt.getClickCount()==1) {
            JTable receptor=(JTable)evt.getSource();

            v_nombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            p.setProducto_nombre(v_nombre.getText());

            ventaDao.reporteProductoUnico(p);

            v_nombre.setText(p.getProducto_nombre());
            v_tipo.setText(p.getProducto_tipo());
            v_precio.setText(String.valueOf(p.getProducto_precio()));
          
        }
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void v_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v_precioActionPerformed

    private void v_TipoTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_TipoTablaActionPerformed
        ReporteData();
    }//GEN-LAST:event_v_TipoTablaActionPerformed

    private void btn_carritoVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carritoVentasActionPerformed
          
        Date horaVenta = new Date();
        
        p.setProducto_nombre(v_nombre.getText());       
        ventaDao.reporteProductoUnico(p);       
        
        if(!v_nombre.getText().equals("") && !v_tipo.getText().equals("") && !v_precio.getText().equals("") && !v_stock.getText().equals("")){
            if(v_nombre.getText().equals(p.getProducto_nombre()) && v_precio.getText().equals(String.valueOf(p.getProducto_precio())) && v_tipo.getText().equals(p.getProducto_tipo())){

                p.setProducto_stock(p.getProducto_stock()-(Integer.parseInt(v_stock.getText())));        
                ventaDao.actualizarStock(p);
                System.out.println("--------------------------\n"+p.getProducto_stock());
                p.setVenta_cantidad_vendida(Integer.parseInt(v_stock.getText()));
                p.setVenta_igv_total((p.getProducto_precio()*Integer.parseInt(v_stock.getText()))*0.18);
                p.setVenta_monto_total(p.getProducto_precio()*(Integer.parseInt(v_stock.getText())));
                 p.setVenta_fecha(horaVenta);

                ventaDao.registrarVenta(p);
                contador++;
                lbl_contador.setVisible(false);
                lbl_contador.setVisible(true);
                ReporteData();
                JOptionPane.showMessageDialog(
                    null,
                    "Se registro exitosamente la venta",
                    "Exito",
                    JOptionPane.INFORMATION_MESSAGE);

                System.out.println(p.getVenta_igv_total());         
            }else{
                JOptionPane.showMessageDialog(
                    null,
                    "El producto no existe",
                    "Fallido",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(
                null,
                "Por favor complete los espacios en blanco",
                "Fallido",
                JOptionPane.INFORMATION_MESSAGE);
        }

   
        
 
    }//GEN-LAST:event_btn_carritoVentasActionPerformed

    private void v_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_stockActionPerformed
        LimpiarDatos();
        
        
        
    }//GEN-LAST:event_v_stockActionPerformed
    public void LimpiarDatos(){
        v_nombre.setText("");
        v_tipo.setText("");
        v_precio.setText("");
        v_stock.setText("");
    }
    

    public void ReporteData(){
      Producto p = new Producto();
      p.setProducto_tipo(v_TipoTabla.getSelectedItem().toString());
      modelo = new DefaultTableModel();


      modelo.addColumn("Nombre");
      modelo.addColumn("Tipo");
      modelo.addColumn("Marca");
      modelo.addColumn("Precio");
      modelo.addColumn("Stock");

          for (Producto prod : ventaDao.reporteProducto(p)) {
              Object[] fila = new Object[5];                 
              fila[0] = prod.getProducto_nombre();
              fila[1] = prod.getProducto_tipo();
              fila[2] = prod.getProducto_marca();
              fila[3] = prod.getProducto_precio();
              fila[4] = prod.getProducto_stock();
              modelo.addRow(fila);
          }
      tablaProducto.setModel(modelo);       
    }
  
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarVentaDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_carritoVentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_contador;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JComboBox<String> v_TipoTabla;
    private javax.swing.JTextField v_nombre;
    private javax.swing.JTextField v_precio;
    private javax.swing.JTextField v_stock;
    private javax.swing.JTextField v_tipo;
    // End of variables declaration//GEN-END:variables
    class FondoPanel extends JPanel{
           private Image imagen;

           @Override
           public void paint (Graphics g){
               imagen = new ImageIcon(getClass().getResource("/recursos/images/campus2.jpg")).getImage();
               g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
               setOpaque(false);
               super.paint(g);
           }
       }   
    class FondoMiniPanel extends JPanel{
           private Image imagen;

           @Override
           public void paint (Graphics g){
               imagen = new ImageIcon(getClass().getResource("/recursos/images/fondolabel3.png")).getImage();
               g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
               setOpaque(false);
               super.paint(g);
           }
       } 
     class FondoLabel extends JPanel{
           public Image imagen;

           @Override
           public void paint (Graphics g){
               imagen = new ImageIcon(getClass().getResource("/recursos/images/carritoVentas.jpg")).getImage();
               g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
               setOpaque(false);
               super.paint(g);
           }
       } 

    
}
