import java.util.Scanner ;
2
3 public class TiendaEstructurada {
4 public static void main ( String [] args ) {
5 Scanner sc = new Scanner ( System.in ) ;
6
7 System.out.print (" Ingrese el nombre del producto : ") ;
8 String nombre = sc.nextLine () ;
9
10 System.out.print (" Ingrese el precio unitario : ") ;
11 double precio = sc.nextDouble () ;
12
13 System.out.print (" Ingrese la cantidad : ") ;
14 int cantidad = sc.nextInt () ;
15
16 double total = calcularTotal ( precio , cantidad ) ;
17
18 mostrarResumen ( nombre , precio , cantidad , total ) ;
19 }
20
21 public static double calcularTotal ( double precio , int cantidad ) {
22 return precio * cantidad ;
23 }
24
25 public static void mostrarResumen ( String nombre , double precio , int
cantidad,double total ) {
26 System.out.println ("\n=== RESUMEN DE PRODUCTO === ") ;
27 System.out.println (" Producto : " + nombre ) ;
28 System.out.println (" Precio unitario : $" + precio ) ;
29 System.out.println (" Cantidad : " + cantidad ) ;
30 System.out.println (" Total : $" + total ) ;
31 }
32 }
