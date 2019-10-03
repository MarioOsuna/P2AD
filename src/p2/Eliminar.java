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
import static p2.Modificar.mostrar;

/**
 *
 * @author Usuario
 */
public class Eliminar {
    
     public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
         Scanner teclado = new Scanner(System.in);
          
          int n;
         
         File fichero=new File("./src/P2/Productos.dat");
         File fichero2=new File("./src/P2/ProductosEliminados.dat");
         
         mostrar(fichero);
         System.out.print("Producto que desea eliminar: "); 
         n=teclado.nextInt();
         Delete(fichero,fichero2, n);
         
         fichero.delete();
         fichero2.renameTo(fichero);
         
     }
     public static void Delete(File fichViejo,File fichNuevo,int op) throws FileNotFoundException, IOException{
        
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
