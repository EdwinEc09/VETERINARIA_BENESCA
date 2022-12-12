/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package expo.proyec_final;

import View.primera_inicio;
import Controller.control;

public class Pricipal {

    public static void main(String[] args) {
        primera_inicio pricipal = new primera_inicio();
        control s = new control(pricipal);
        s.iniciar();

    }
}
