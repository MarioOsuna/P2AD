/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Modificar {
    
     public static void main() throws IOException{
          Scanner teclado = new Scanner(System.in);
          
          int n,op;
          String nombre;
         File fichero=new File("./src/P2/Productos.dat");
         
         System.out.print("Elige qué cambiar, 1-Nombre, 2-Precio, 3-Ambos: ");
         n=teclado.nextInt();
         
         switch(n){          
                 
             case 1:
                 
                 System.out.print("Producto a cambiar: ");                 
                 op=teclado.nextInt();
                 System.out.print("Nuevo nombre del producto: ");
                 nombre=teclado.nextLine();
                 
                 nombre(fichero,nombre,op);
                 break;
             case 2:
                 
                /* System.out.print("Producto a cambiar: ");
                 op=teclado.nextInt();
                 precio(fichero);*/
                 break;
             case 3:
                 
                 /*System.out.print("Producto a cambiar: ");
                 op=teclado.nextInt();
                 nombre(fichero);
                 precio(fichero);*/
                 break;
             default:
                 System.out.println("Opción no reconocida");
                 break;
         }
     }
     public static void nombre(File fichero,String nombre,int op) throws FileNotFoundException, IOException{
         
         DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichero));
                for(int i=0;i<dataOS.hashCode();i++)
                {         
                    
                    dataOS.writeUTF(nombre);
                   
                }
                dataOS.close();
     }
     public static void precio(File fichero){
         
     }
     public static void mostrar(File fichero){
         
     }
}
