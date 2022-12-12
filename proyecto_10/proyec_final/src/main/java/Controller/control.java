/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import View.*;
import com.mysql.cj.CoreSession;
import conexion.Cruplogin;
import java.awt.event.ActionEvent;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.html.CSS;
import javax.xml.crypto.Data;
import view.agendar1;
import view.clientes;
import view.consultarcita;
import view.medicamentoss;

public class control implements ActionListener {

    primera_inicio principal;

    clientes cliente = new clientes();
    agendar1 agendas = new agendar1();
    consultarcita consulta_cita = new consultarcita();
    medicamentoss medicamento = new medicamentoss();
    segunda_registro registro = new segunda_registro();
    Cruplogin login = new Cruplogin();
    
    
    
    //ArrayList<citas>  consulcita ;
    

    private int idusuario = 0;
    private String usuario = null;
    private String contraseña = null;
    private String correo = null;

    //
    private int idcitas = 0;
    private String nombrem = null;
    private String especie;
    private String enfermedad;
    private String fecha = null;

    //
    private int ideliminar = 0;

    //
    private int idconsul = 0;
    
    private int idmedi = 0;
    
    
    
    

    public control(primera_inicio principal) {
        this.principal = principal;
        this.iniciar();
        this.cliente.agendarcitas.addActionListener(this);
        this.cliente.consultarcitas.addActionListener(this);

        this.principal.registrarse.addActionListener(this);
        this.registro.ya_tengo.addActionListener(this);
        this.principal.mostrar.addActionListener(this);
        this.cliente.medicamentos.addActionListener(this);
        this.cliente.volvercliente.addActionListener(this);
        this.principal.ingresar.addActionListener(this);
        this.registro.registrarse.addActionListener(this);
        this.agendas.guardarcitas.addActionListener(this);
        this.consulta_cita.mostracita.addActionListener(this);
        this.consulta_cita.cancelarcita.addActionListener(this);
        this.medicamento.mostra.addActionListener(this);

    }

    public void iniciar() {
        this.principal.setVisible(true);
        this.principal.setLocationRelativeTo(null);
        this.registro.setLocationRelativeTo(null);
        this.cliente.setLocationRelativeTo(null);
        
        
    

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * *
         * son 3 botones botones de pprimera de registro estan todos listos
         */
        //tercero
        if (e.getSource() == this.principal.registrarse) {
            registro.setVisible(true);
            principal.dispose();

        }
        //segundo
        //boton que filtra el ingreso
        if (e.getSource() == this.principal.ingresar) {
            usuario = this.principal.usuario.getText();
            contraseña = this.principal.contraseña.getText();
            this.eliminar();
            boolean respuesta = login.acceder_usuario(usuario, contraseña);
            if (respuesta == true) {
                cliente.setVisible(true);
                principal.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "no esta registrado");
            }
            //tercero
            //boton que muestra los usuarios registrados
        } else if (principal.mostrar == e.getSource()) {
            
            boolean respuestas = login.mostrar_usuario(idusuario, correo, usuario, contraseña);
            if (respuestas == true) {
                JOptionPane.showMessageDialog(null, "si");
            } else {
                JOptionPane.showMessageDialog(null, "no");
            }
        }
        /**
         * son 2 botones botones de segunda de registro estan todos listo
         */
        // primero
        if (e.getSource() == this.registro.ya_tengo) {
            principal.setVisible(true);
            registro.dispose();

            //segundo boton
        } else if (e.getSource() == this.registro.registrarse) {
            idusuario = Integer.parseInt(this.registro.identificacion.getText());
            correo = this.registro.correo.getText();
            usuario = this.registro.usuario.getText();
            contraseña = this.registro.contrasena.getText();
            this.eliminar();
            boolean regis = login.registrar_usuario(idusuario, correo, usuario, contraseña);
            if (regis) {
                JOptionPane.showMessageDialog(null, "registrado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "no se ha registrado");
            }
        }

        /**
         * SON 5 BOTONES Y ESTA INCOMPLETOS BOTONES DE CLIENTE1
         */
        // PRIMERO
        if (e.getSource() == this.cliente.agendarcitas) {
            this.cliente.tablacliente.add(agendas);
            agendas.show();
            // SEGUNDO
        } else if (this.cliente.consultarcitas == e.getSource()) {
            this.cliente.tablacliente.add(consulta_cita);
            consulta_cita.show();
            //TERCERO
        } else if (e.getSource() == this.cliente.medicamentos) {
            this.cliente.tablacliente.add(medicamento);
            medicamento.show();

          
        }if (e.getSource() == this.cliente.volvercliente) {
            principal.setVisible(true);
            cliente.dispose();
        }
          /**
             * *
             * 1 BOTON BOTON DE AGENDAR1 esta todo
             */
        if (e.getSource() == this.agendas.guardarcitas) {
            idcitas = Integer.parseInt(this.agendas.idcitas.getText());
            nombrem = this.agendas.nombreanimal.getText();
            especie = this.agendas.razaanimal.getText();
            enfermedad = this.agendas.enfermadad.getText();
            fecha = this.agendas.fechadecita.getText();
            this.eliminar();
            login.Agendar_cita(idcitas, nombrem, especie, enfermedad, fecha);
            JOptionPane.showMessageDialog(null,"CITA GUARDADA");
            
        }
        /**
         * *
         * todos los botones listos 3 botones botones consultar citas
         */
        //primero
        if (e.getSource() == this.consulta_cita.mostracita) {
            idconsul = Integer.parseInt(this.consulta_cita.jTidcita.getText());
            this.eliminar();
            boolean buscar = login.buscar_cita(idconsul);
            if (buscar == true) {
               
            } else {
                JOptionPane.showMessageDialog(null, "NO HAY CITA CON ESE ID");
            }

        }
        //segundo
        //eliminar citas
        if (e.getSource() == this.consulta_cita.cancelarcita) {
            ideliminar = Integer.parseInt(this.consulta_cita.jTidcita.getText());
           
             int s=JOptionPane.showOptionDialog(null, "ESTAS SEGURO? ", 
                         "cancelar cita" , 
                         JOptionPane.YES_NO_CANCEL_OPTION, 
                         JOptionPane.QUESTION_MESSAGE, 
                         null,    
                         new Object[] { "SI", "NO", "CANCELAR"},
                       
                         "SO"); 
        if (s==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"SU CITA A SIDO BORRADA");
             boolean eli = login.eliminar_citas(ideliminar);
        } 
        if (s==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"SU CITA NO A SIDO BORRADA");
        }        
        if (s==JOptionPane.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null,"AUN ESTA SU CITA");
        }
        }
            
            if (e.getSource() == this.medicamento.mostra){
            idmedi = Integer.parseInt(this.medicamento.id_a_buscar.getText());
            this.eliminar();
            boolean buscar = login.medicamentos(idmedi);
          
          
        }
       
           
        }
     /*
    public boolean  mostrar_cita(){
        for (int i = 0; i < login.consulcita().size(); i++) {
            consulta_cita.consulcitass.setValueAt(Cruplogin.consulcita().get(i).getId(), i, 0);
            consulta_cita.consulcitass.setValueAt(Cruplogin.consulcita().get(i).getnombre_mascota(), i, 1);
            consulta_cita.consulcitass.setValueAt(Cruplogin.consulcita().get(i).getespecie(), i, 2);
            consulta_cita.consulcitass.setValueAt(Cruplogin.consulcita().get(i).getemfermedad(), i, 3);
            consulta_cita.consulcitass.setValueAt(Cruplogin.consulcita().get(i).getfecha(), i, 4);
            
            
        }
    }

*/
    
    public void eliminar (){
        this.principal.contraseña.setText("");
        this.principal.usuario.setText("");
        this.registro.contrasena.setText("");
        this.registro.correo.setText("");
        this.registro.identificacion.setText("");
        this.registro.usuario.setText("");
        this.agendas.enfermadad.setText("");
        this.agendas.fechadecita.setText("");
        this.agendas.guardarcitas.setText("");
        this.agendas.idcitas.setText("");
        this.agendas.nombreanimal.setText("");
        this.agendas.razaanimal.setText("");
        this.medicamento.id_a_buscar.setText("");
        this.consulta_cita.jTidcita.setText("");
        

}
}