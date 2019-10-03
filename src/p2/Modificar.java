/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Modificar {
    
     public static void  main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
          Scanner teclado = new Scanner(System.in);
          
          int n,op;
            String texto;
            double precio;
         File fichero=new File("./src/P2/Productos.dat");
         File fichero2=new File("./src/P2/ProductosModificados.dat");
         
         System.out.print("Elige qué cambiar, 1-Nombre, 2-Precio, 3-Ambos: ");
         n=teclado.nextInt();
         
         switch(n){          
                 
             case 1:
                   
                 mostrar(fichero);
                 System.out.print("Producto a cambiar: ");                 
                 op=teclado.nextInt();
                 System.out.print("Nuevo nombre del producto: ");
                 texto=teclado.next();
                 
                 
                 Cambiarnombre(fichero,fichero2,texto,op);
                 
                
                 fichero.delete();
                 fichero2.renameTo(fichero);
                 break;
             case 2:
                 
                mostrar(fichero);
                 System.out.print("Producto a cambiar: ");                 
                 op=teclado.nextInt();
                 System.out.print("Nuevo Precio del producto: ");
                 precio=teclado.nextDouble();               
                 
                 Cambiarprecio( fichero,fichero2, precio, op);
                fichero.delete();
                 fichero2.renameTo(fichero);
                 break;
             case 3:
                 
                mostrar(fichero);
                 System.out.print("Producto a cambiar: ");                 
                 op=teclado.nextInt();
                 System.out.print("Nuevo nombre del producto: ");
                 texto=teclado.next();
                 System.out.print("Nuevo Precio del producto: ");
                 precio=teclado.nextDouble();               
                 
                
                 Ambos( fichero,fichero2, precio,texto, op);
                 fichero.delete();
                 fichero2.renameTo(fichero);
                 break;
             default:
                 System.out.println("Opción no reconocida");
                 break;
         }
     }
     public static void Cambiarnombre(File fichViejo,File fichNuevo,String nombre,int op) throws FileNotFoundException, IOException{
          
        
        DataInputStream dataIS = new DataInputStream(new FileInputStream(fichViejo));
        DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichNuevo));
        String n;  int e,cont=0;    double a;
        
        try{
            while(true){
                e=dataIS.readInt();
                n=dataIS.readUTF();                
                a=dataIS.readDouble();
                if(op==e)
                {
                                              
                    dataOS.writeInt(e);
                    dataOS.writeUTF(nombre);
                    dataOS.writeDouble(a);    
                    cont++;
                }
                else
                {
                dataOS.writeInt(e);
                dataOS.writeUTF(n);
                dataOS.writeDouble(a);
                }
                
              
                
            }
        }catch(EOFException eo){}
        
         
        dataIS.close();
        dataOS.close();
        
         if(cont==0)
         {
             System.out.println("No existe un producto con ese código");       
         }
         else
         {
           mostrar(fichNuevo);   
         }
         
               
               
     }
     public static void Cambiarprecio(File fichViejo,File fichNuevo,double precio,int op) throws FileNotFoundException, IOException{
          DataInputStream dataIS = new DataInputStream(new FileInputStream(fichViejo));
        DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichNuevo));
        String n;  int e,cont=0;    double a;
        
        try{
            while(true){
                e=dataIS.readInt();
                n=dataIS.readUTF();                
                a=dataIS.readDouble();
                if(op==e)
                {
                                               
                    dataOS.writeInt(e);
                    dataOS.writeUTF(n);
                    dataOS.writeDouble(precio);   
                    cont++;
                }
                else
                {
                dataOS.writeInt(e);
                dataOS.writeUTF(n);
                dataOS.writeDouble(a);
                }
                
              
             
            }
        }catch(EOFException eo){}
        
         
        dataIS.close();
        dataOS.close();
        
         if(cont==0)
         {
             System.out.println("No existe un producto con ese código");       
         }
         else
         {
           mostrar(fichNuevo);   
         }
     }
     public static void Ambos(File fichViejo,File fichNuevo,double precio,String nombre,int op) throws FileNotFoundException, IOException{
          DataInputStream dataIS = new DataInputStream(new FileInputStream(fichViejo));
        DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichNuevo));
        String n;  int e,cont=0;    double a;
        
        try{
            while(true){
                e=dataIS.readInt();
                n=dataIS.readUTF();                
                a=dataIS.readDouble();
                if(op==e)
                {
                                               
                    dataOS.writeInt(e);
                    dataOS.writeUTF(nombre);
                    dataOS.writeDouble(precio); 
                    cont++;
                }
                else
                {
                dataOS.writeInt(e);
                dataOS.writeUTF(n);
                dataOS.writeDouble(a);
                }           
              
                
            }
           
        }catch(EOFException eo){}
        
         
        dataIS.close();
        dataOS.close();
        
         if(cont==0)
         {
             System.out.println("No existe un producto con ese código");       
         }
         else
         {
           mostrar(fichNuevo);   
         }
     }
     public static void mostrar(File fichero) throws FileNotFoundException, IOException
     {
          DataInputStream dataIS = new DataInputStream(new FileInputStream(fichero));
        String n;
        int e;
        double a;
        System.out.println("");
        System.out.println("Código \t Producto \t Precio");
        try{
            while(true){
                e=dataIS.readInt();
                n=dataIS.readUTF();                
                a=dataIS.readDouble();
                
                System.out.println(e+"\t "+n+"\t "+a+"\n");
                
            }
        }catch(EOFException eo){}
        
        
        dataIS.close();
     }
}
