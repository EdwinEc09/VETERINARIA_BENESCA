/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package conexion;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author APRENDIZ SENA
 */
public interface Interfaz {

    public boolean mostrar_usuario(int id, String correo, String usuario, String contraseña);

    public boolean registrar_usuario(int id, String correo, String usuario, String contraseña);

    public boolean acceder_usuario(String usuario, String contraseña);

    public boolean Agendar_cita(int id, String nombrem, String especie, String enfermedad, String fecha);

    public boolean eliminar_citas(int id) ;
    
    public boolean buscar_cita (int id);
    
    public boolean medicamentos (int id);
    
    
   // public ArrayList<citas> consulcita ();
    
    
}
