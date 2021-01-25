/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9.src.main.java.tallernotas;

import static java.awt.Color.green;
import static java.awt.Color.red;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author ZASALAS
 */
public class Validacion {

    private TitledBorder dato_requerido;
    private String nombrearchivo = "";
    private OperacionArchivo guardar_log;
    private Border correcto;

    Border validacionLongitudContenido(String dato, String nombre) {

        if (dato.trim().isEmpty()) {
            correcto = BorderFactory.createLineBorder(green, 1);
            dato_requerido = BorderFactory.createTitledBorder(correcto, "Valido" + nombre);
        } else {
            Border incorrecto = BorderFactory.createLineBorder(red, 1);
            dato_requerido = BorderFactory.createTitledBorder(incorrecto, "Es Invalido: " + nombre);
        }

        return dato_requerido;
    }

    Border validación_numeros(String dato, String nombre) {
        try {
            if (Integer.parseInt(dato.trim()) >= 0) {
                Border correcto = BorderFactory.createLineBorder(green, 1);
                dato_requerido = BorderFactory.createTitledBorder(correcto, "Valido" + nombre);
            } else {
                Border incorrecto = BorderFactory.createLineBorder(red, 1);
                dato_requerido = BorderFactory.createTitledBorder(incorrecto, "Es Invalido: " + nombre);
            }
        } catch (Exception e) {
            Border incorrecto = BorderFactory.createLineBorder(red, 1);
            dato_requerido = BorderFactory.createTitledBorder(incorrecto, "Es Invalido: " + nombre);
            System.out.println("error: " + e.getMessage());
            try {
                String mens = "" + e.getMessage();

                nombrearchivo = "ErrorLog" + "";

                guardar_log.crear_archivo_plano(nombrearchivo, mens);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(FormularioEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        return dato_requerido;
    }
}
