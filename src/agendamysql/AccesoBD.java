/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
class AccesoBD {
    static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/bd_agenda";

    public static void crearTabla()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
        String query="CREATE TABLE IF NOT EXISTS agenda\n" +
"(\n" +
"nombre varchar(50),\n" +
"    email varchar(50),\n" +
"    telefono varchar(50)\n" +
"    \n" +
");";
                Properties info=new Properties();
                info.setProperty("user", usuario);
                info.setProperty("password",password);
                try {
                    Connection conexion=DriverManager.getConnection(url, info);
                    Statement stmt=conexion.createStatement();
                    stmt.executeUpdate(query);
                    stmt.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void insertarContacto(Contacto c) {
        Properties info=new Properties();
                info.setProperty("user", usuario);
                info.setProperty("password",password);
        try {
            Connection conexion=DriverManager.getConnection(url, info);
            Statement stmt=conexion.createStatement();
            String query="INSERT INTO agenda VALUES('"+c.getNombre()+"', '"+c.getEmail()+"', '"
                    + c.getTelefono()+"')";
            
            stmt.executeUpdate(query);
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static ArrayList<Contacto> listarContactos(String nombre_buscado) {
        //Si nombre buscado está vacío realmente hay que ñistar todos
        ArrayList<Contacto> lista_contactos=new ArrayList();
        Properties info=new Properties();
                info.setProperty("user", usuario);
                info.setProperty("password",password);
        try {
            Connection conexion=DriverManager.getConnection(url, info);
            Statement stmt=conexion.createStatement();
            String query ="SELECT * FROM agenda ";
            if(nombre_buscado.equals(""))
            {}
            else
            {
                query=query+" WHERE nombre LIKE '%"+nombre_buscado+"%'";
            }
            System.out.println("CONSULTA:"+query);
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                String email=rs.getString("email");
                String telefono=rs.getString("telefono");
                Contacto c=new Contacto(nombre, email, telefono);
                lista_contactos.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista_contactos;
    }

    static ArrayList<Contacto> buscarPorNombre(String nombre_buscado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
