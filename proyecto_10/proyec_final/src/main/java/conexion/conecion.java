/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author APRENDIZ SENA
 */
abstract public class conecion {
    public static final String URL = "jdbc:mysql://localhost:3306/proyecto";
    public static final String USER = "root";
    public static final String CLAVE = "";

    public Connection getConexion() {
        Connection bn = null;

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            bn = DriverManager.getConnection(URL, USER, CLAVE);

        } catch (SQLException e) {
            System.out.println("ERROR" + e.getMessage());
        } catch (ClassNotFoundException x) {
            Logger.getLogger(conecion.class.getName()).log(Level.SEVERE, null, x);
        }
        return bn;
    
}
    
}
