/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Fray
 */
public class Venta {
    
    private int venta_cantidad_vendida;
    private double venta_igv_total;
    private double venta_monto_total;
    Date venta_fecha;

    public int getVenta_cantidad_vendida() {
        return venta_cantidad_vendida;
    }

    public void setVenta_cantidad_vendida(int venta_cantidad_vendida) {
        this.venta_cantidad_vendida = venta_cantidad_vendida;
    }

    public double getVenta_igv_total() {
        return venta_igv_total;
    }

    public void setVenta_igv_total(double venta_igv_total) {
        this.venta_igv_total = venta_igv_total;
    }

    public double getVenta_monto_total() {
        return venta_monto_total;
    }

    public void setVenta_monto_total(double venta_monto_total) {
        this.venta_monto_total = venta_monto_total;
    }

    public Date getVenta_fecha() {
        return venta_fecha;
    }

    public void setVenta_fecha(Date venta_fecha) {
        this.venta_fecha = venta_fecha;
    }

    
  
    
}
