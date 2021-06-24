/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julio.librerias.pruebas_junit_5;

/**
 *
 * @author julio
 */
public class Calculadora {
    public int valor=0;
    
    public void suma1(){
    
          valor++;
    }     

    
    public int suma(int a, int b) throws Exception {
        int c = a + b;

        if (a > 0 && b > 0 && c < 0) {
            throw new Exception("Desbordamiento");
        }

        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }

        return c;
    }

    public static int cuadrado(int a) {
        
        try { Thread.sleep(200);} catch (Exception e) {  } //esta linea genera un retardo
         
        return a * a;
    }

}
