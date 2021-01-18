/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9.src.main.java.tallernotas;

import java.io.IOException;

/**
 *
 * @author ZASALAS
 */
public class Operar {
    
    
    double PromedioEstudiante(double nota_1, double nota_2, double nota_3) throws IOException {
        double promedio = 0;
        try {
            promedio = (nota_1 + nota_2 + nota_3) / 3;
        } catch (Exception exxx) {
            String mens = "" + exxx;

////////            guardar_log.crear_archivo_plano("ErrorLog", mens);
        }

        return promedio;
    }
}
