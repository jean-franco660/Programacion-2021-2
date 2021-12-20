package entidades;

public class Producto extends Venta{
    
    private String producto_id;
    private String producto_nombre;
    private String producto_tipo;
    private String producto_marca;
    private double producto_precio;
    private int producto_stock;  


    public String getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(String producto_id) {
        this.producto_id = producto_id;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public String getProducto_tipo() {
        return producto_tipo;
    }

    public void setProducto_tipo(String producto_tipo) {
        this.producto_tipo = producto_tipo;
    }

    public String getProducto_marca() {
        return producto_marca;
    }

    public void setProducto_marca(String producto_marca) {
        this.producto_marca = producto_marca;
    }

    public double getProducto_precio() {
        return producto_precio;
    }

    public void setProducto_precio(double producto_precio) {
        this.producto_precio = producto_precio;
    }

    public int getProducto_stock() {
        return producto_stock;
    }

    public void setProducto_stock(int producto_stock) {
        this.producto_stock = producto_stock;
    }

   
    
    
}
