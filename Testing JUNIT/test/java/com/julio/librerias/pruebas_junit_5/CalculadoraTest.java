/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julio.librerias.pruebas_junit_5;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author julio
 */
public class CalculadoraTest {
    static Calculadora instance2 = new Calculadora();
    
    public CalculadoraTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    @RepeatedTest(10)
    void suma1Test(RepetitionInfo repetitionInfo) {

        instance2.suma1();
        assertEquals(instance2.valor , repetitionInfo.getCurrentRepetition());
    }

    @Test
    @DisplayName("Chequeo el lanzamiento de una Excepción")
    public void testSuma() throws Exception {
        String mensaje = "Desbordamiento";
        
        Throwable expResult = assertThrows( Exception.class,
                              ()-> {
                                   Calculadora instance = new Calculadora();
                                   float res = instance.suma(1, Integer.MAX_VALUE);
                              }
                          );
        
        assertEquals(mensaje , expResult.getMessage());
    }

    @Test
    public void testCuadrado() {
        System.out.println("cuadrado");
        int a = 2;
        int expResult = 4;
        int result = Calculadora.cuadrado(a);
        assertEquals(expResult, result);
        
    }
    @Test
    @Timeout(value=250, unit=TimeUnit.MILLISECONDS)        
    void fallaSiExcede100ms() {
           Calculadora c = new Calculadora();
           int res = c.cuadrado(4);
    }
    
    @ParameterizedTest
    @CsvSource(  {"1,1" , "2,4", "3,9" , "10,100"} )        
    void pruebaMuchosCuadrados( int pe , int re ){
            int a = pe;
            int expected = re;
            System.out.println("---------------------------------------" + pe + "\t" + re);
            Calculadora instance = new Calculadora();
            int result = instance.cuadrado(a);
            assertEquals( expected , result);
    }
    
    public static int[][] datos(){
      return new int[][] { {1,1} , {2,4} , {3,9} };
    }
    @ParameterizedTest
    @MethodSource(value="datos")
    void testCuadradoConMetodo(int[] dato){
            Calculadora instance = new Calculadora();
            
            int a = dato[0];
            int expected = dato[1];
            
            int result = instance.cuadrado(a);
            assertEquals(expected , result);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4} )
    void cuadradoTestConValores(int numero){
        
        int result = Calculadora.cuadrado(numero);
        int expected = (int) Math.pow(numero,2);
        assertTrue( result == expected );
    }        
    
    
    
    
    
    
    
}
