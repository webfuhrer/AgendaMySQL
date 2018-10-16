/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamysql;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class AgendaMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       int opcion=EntradaSalida.mostrarMenu();
       AccesoBD.crearTabla();
       while(opcion!=4)
       {
           switch (opcion)
           {
               case 1:
                   //Insertar
                   Contacto c=EntradaSalida.pedirContacto();
                   AccesoBD.insertarContacto(c);//NEW
                   break;
               case 2:
                   //Listar
                   ArrayList<Contacto> lista_contactos=AccesoBD.listarContactos("");//NEW
                   EntradaSalida.mostrarContactos(lista_contactos);
                   break;
               case 3:
                  String nombre_buscado=EntradaSalida.nombreBuscado();
                  ArrayList<Contacto> lista=AccesoBD.listarContactos(nombre_buscado);
                  EntradaSalida.mostrarContactos(lista);
                   
           }
           opcion=EntradaSalida.mostrarMenu();
       }
    }
    
}
