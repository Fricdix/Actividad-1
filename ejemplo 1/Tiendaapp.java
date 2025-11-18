import java.util.Scanner;

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public double calcularTotal() {
        return this.precio * this.cantidad;
    }
    
    public void mostrarInfo() {
        System.out.println("\n--- Información del Producto ---");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio unitario: $" + this.precio);
        System.out.println("Cantidad: " + this.cantidad);
        System.out.println("Total: $" + this.calcularTotal());
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
}

public class TiendaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE REGISTRO DE PRODUCTOS ===");

        Producto[] productos = new Producto[2];
        double totalGeneral = 0;
        
        for (int i = 0; i < 2; i++) {
            System.out.println("\nRegistrando Producto #" + (i + 1));
            
            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();
            
            System.out.print("Ingrese el precio: ");
            double precio = sc.nextDouble();
            
            System.out.print("Ingrese la cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine(); 
            
            productos[i] = new Producto(nombre, precio, cantidad);
        }
        
        System.out.println("\n=== RESUMEN GENERAL ===");
        for (int i = 0; i < productos.length; i++) {
            productos[i].mostrarInfo();
            totalGeneral += productos[i].calcularTotal();
        }
        
        System.out.println("\n=== TOTAL GENERAL ===");
        System.out.println("Total de la tienda: $" + totalGeneral);
        
        sc.close();
    }
}