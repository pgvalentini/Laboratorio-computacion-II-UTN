/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julio.librerias.pruebas_junit_5;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author julio
 */
public class Validador {

    public boolean esFechaValida(String dia_s, String mes_s, String anio_s) {
        
        int dia = Integer.valueOf(dia_s);
        int mes = Integer.valueOf(mes_s);
        int anio = Integer.valueOf(anio_s);         
        
        boolean esFechaValida = true;
        try {
            LocalDate.of(anio, mes, dia);
        } catch (DateTimeException e) {
            esFechaValida = false;
        }
        return esFechaValida;
    }

}
