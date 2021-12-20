package Igu;


import Entidades.Persona;
import Implementacion.ImplPersona;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CrudMysqlFrame extends JFrame{
    
JLabel lb_nombres    = new JLabel("Nombres: ");
    JLabel lb_ap_paterno = new JLabel("Ap. Paterno: ");
    JLabel lb_ap_materno = new JLabel("Ap. Materno: ");
    JLabel lb_codigo     = new JLabel("Codigo: ");
    JLabel lb_sexo       = new JLabel("Sexo: ");
    JLabel lb_Usuario    = new JLabel("Usuario: ");
    JLabel lb_Password   = new JLabel("Password: ");
    
    
    JTextField txf_nombres    = new JTextField();
    JTextField txf_ap_paterno = new JTextField();
    JTextField txf_ap_materno = new JTextField();
    JTextField txf_codigo     = new JTextField();
    JTextField txf_sexo       = new JTextField();
    JTextField txf_Usuario    = new JTextField();
    JPasswordField psf_Passeord  = new JPasswordField();
    JRadioButton rdbtonM      = new JRadioButton("Masculino");
    JRadioButton rdbtonF      = new JRadioButton("Femenino");
   
    ImplPersona metodos = new ImplPersona();
    
    public CrudMysqlFrame(){
        
        menu();
    }
        
     public void menu(){
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuFile   = new JMenu();
        JMenu menuMantenimiento = new JMenu();
        JMenu menuReportes = new JMenu();
        
        JMenuItem menuFileExit               = new JMenuItem();
        JMenuItem menuMantenimientoRegistrar = new JMenuItem();
        JMenuItem menuMantenimientoEliminar  = new JMenuItem();
        
        JMenuItem menuReportesGeneral   = new JMenuItem();
        JMenuItem menuReportesDetallado = new JMenuItem();
        
        menuFile.setText("File");
        menuFileExit.setText("Salir");
        
        menuMantenimiento.setText("Crud");
        menuMantenimientoRegistrar.setText("Registrar");
        menuMantenimientoEliminar.setText("Eliminar");
        
        menuReportes.setText("Reportes");        
        menuReportesGeneral.setText("Rep. Global");
        menuReportesDetallado.setText("Rep. Detalle");
        
        menuFile.add(menuFileExit);
        
        menuMantenimiento.add(menuMantenimientoRegistrar);
        menuMantenimiento.add(menuMantenimientoEliminar);
        
        menuReportes.add(menuReportesGeneral);
        menuReportes.add(menuReportesDetallado);
        
        menuBar.add(menuFile);
        menuBar.add(menuMantenimiento);
        menuBar.add(menuReportes);
        
        setTitle("PRACTICA CRUD VECTOR");
        setJMenuBar(menuBar);
        setSize(new Dimension(650, 700));
        
        menuFileExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        menuReportesGeneral.addActionListener((ActionEvent e) -> {
            String columnas[] = {"Nombres","Ap. Paterno","Ap. Materno","Codigo"};
            Object filas[][] = new Object[metodos.reportePersonas().size()][4];
            
            /*     Vector nuevoVector = metodos.reportePersonas();
            for(int i =0; i<nuevoVector.size();i++){
            Persona v = (Persona)metodos.reportePersonas().get(i);
            filas[i][0]=v.getNombre();
            filas[i][1]=v.getAp_paterno();
            filas[i][2]=v.getAp_materno();
            filas[i][3]=v.getCodigo();
            }*/
            
            JTable tabla= new JTable(filas, columnas);
            JScrollPane tabla1= new JScrollPane(tabla);
            
            JPanel reporte= new JPanel();
            reporte.add(tabla1);
            
            Object  msg[]={reporte};
            JOptionPane.showMessageDialog(null, msg, "Reporte", JOptionPane.QUESTION_MESSAGE);
        });
        
        
        
        menuMantenimientoRegistrar.addActionListener((ActionEvent e) -> {
            JPanel pan1 = new JPanel(new GridLayout(1,2));
            pan1.add(lb_nombres);
            pan1.add(txf_nombres);
            
            JPanel pan2 = new JPanel(new GridLayout(1,2));
            pan2.add(lb_ap_paterno);
            pan2.add(txf_ap_paterno);
            
            JPanel pan3 = new JPanel(new GridLayout(1,2));
            pan3.add(lb_ap_materno);
            pan3.add(txf_ap_materno);
            
            JPanel pan4 = new JPanel(new GridLayout(1,2));
            pan4.add(lb_codigo);
            pan4.add(txf_codigo);
            
            ButtonGroup bgsexo =new ButtonGroup();
            bgsexo.add(rdbtonM);
            bgsexo.add(rdbtonF);
            
            JPanel pan5 = new JPanel(new GridLayout(1,2));
            pan5.add(lb_sexo);
            pan5.add(rdbtonM);
            pan5.add(rdbtonF);
            
            JPanel pan6 = new JPanel(new GridLayout(1,3));
            pan6.add(lb_Usuario);
            pan6.add(txf_Usuario);
            
            JPanel pan7 = new JPanel(new GridLayout(1,2));
            pan7.add(lb_Password);
            pan7.add(psf_Passeord);
            
            Object msg []= {pan1, pan2, pan3, pan4, pan5, pan6, pan7};
            
            if(JOptionPane.showOptionDialog(null, msg,"Registrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){
                
                Persona dp= new Persona();
                dp.setNombre(txf_nombres.getText());
                dp.setAp_paterno(txf_ap_paterno.getText());
                dp.setAp_materno(txf_ap_materno.getText());
                dp.setCodigo(txf_codigo.getText());
                dp.setSexo(txf_sexo.getText());
                dp.setUsuario(txf_Usuario.getText());
                dp.setPassword(psf_Passeord.getText());
                
                if(rdbtonM.isSelected()==true){
                    dp.setSexo("M");
                }
                if(rdbtonM.isSelected()==true){
                    dp.setSexo("F");
                }
                
                
                if(!txf_nombres.getText().equals("")|| !txf_ap_paterno.getText().equals("") || !txf_ap_materno.getText().equals("") || !txf_codigo.getText().equals("") || !txf_Usuario.getText().equals("") || !psf_Passeord.getText().equals("")){
                    metodos.registrarPersona(dp);
                    txf_nombres.setText("");
                    txf_ap_paterno.setText("");
                    txf_ap_materno.setText("");
                    txf_Usuario.setText("");
                    psf_Passeord.setText("");
                    txf_codigo.setText("");
                    
                    
                    
                    JOptionPane.showMessageDialog(
                            null,
                            "Se Registro con Exito",
                            "Registro",
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(
                            null,
                            "No Se Registro con Exito",
                            "ERROR",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                
                
                
                
            }
        });
        
        
    }
}

