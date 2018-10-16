/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamysql;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mañanas
 */
class EntradaSalida {
static Scanner sc=new Scanner(System.in);
    static Contacto pedirContacto() {
        System.out.println("Escriba el nombre:");
        String nombre=sc.nextLine();
        System.out.println("Escriba el email");
        String email=sc.nextLine();
        System.out.println("Escriba el teléfono");
        String telefono=sc.nextLine();
        Contacto c=new Contacto(nombre, email, telefono);
        return c;
    }

    static ArrayList<Contacto> listarContactos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static int mostrarMenu()
    {
        System.out.println("1-Insertar contacto");
        System.out.println("2-Listar contactos");
        System.out.println("3-Buscar contacto por nombre");
        System.out.println("4-SALIR");
        int opcion=sc.nextInt();
        sc.nextLine();
        return opcion;
    }
static void mostrarContactos(ArrayList<Contacto> lista_contactos) {
        for (int i=0; i<lista_contactos.size(); i++)
        {
           Contacto c= lista_contactos.get(i);
            System.out.println("CONTACTO: "+c.getNombre()+
                    " "+c.getTelefono()+" "+c.getEmail());
        }
    }

    static String nombreBuscado() {
        System.out.println("Introduzca el nombre a buscar");
        String nombre=sc.nextLine();
        return nombre;
                
                }
}
