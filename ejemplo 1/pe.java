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
    

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double calcularTotal() {
        return precio * cantidad;
    }
    
    public void mostrarInfo() {
        System.out.println("\nProducto: " + nombre);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total: $" + calcularTotal());
    }
}

class Inventario {
    private Producto[] productos;
    private int contador;
    
    public Inventario(int capacidad) {
        productos = new Producto[capacidad];
        contador = 0;
    }
    
    public void agregarProducto(Producto producto) {
        if (contador < productos.length) {
            productos[contador] = producto;
            contador++;
        } else {
            System.out.println("Inventario lleno, no se puede agregar más productos");
        }
    }
    
    public void mostrarInventario() {
        System.out.println("\n=== RESUMEN DE INVENTARIO ===");
        for (int i = 0; i < contador; i++) {
            productos[i].mostrarInfo();
        }
    }
    
    public double calcularTotalGeneral() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += productos[i].calcularTotal();
        }
        return total;
    }
    
    public Producto buscarProducto(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getNombre().equalsIgnoreCase(nombre)) {
                return productos[i];
            }
        }
        return null;
    }
}

public class TiendaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE INVENTARIO ===");
        System.out.print("Ingrese la cantidad de productos a registrar: ");
        int cantidadProductos = sc.nextInt();
        sc.nextLine(); 
        
        Inventario inventario = new Inventario(cantidadProductos);
        
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("\nProducto #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Precio: ");
            double precio = sc.nextDouble();
            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine(); 
            
            Producto producto = new Producto(nombre, precio, cantidad);
            inventario.agregarProducto(producto);
        }
        
        inventario.mostrarInventario();
        System.out.println("\nTOTAL GENERAL DEL INVENTARIO: $" + inventario.calcularTotalGeneral());
        
        System.out.print("\n¿Desea buscar un producto? (s/n): ");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreBuscar = sc.nextLine();
            Producto encontrado = inventario.buscarProducto(nombreBuscar);
            if (encontrado != null) {
                System.out.println("Producto encontrado:");
                encontrado.mostrarInfo();
            } else {
                System.out.println("Producto no encontrado");
            }
        }
        
        sc.close();
    }
}