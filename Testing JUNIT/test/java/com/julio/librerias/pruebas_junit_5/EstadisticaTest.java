/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julio.librerias.pruebas_junit_5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author julio
 */
public class EstadisticaTest {
    
    public EstadisticaTest() {
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
           
    @ParameterizedTest
    @MethodSource("helpers.Helper#mediaValores")
    void mediaTest( float esp , float vals[] ){
          Estadistica instance = new Estadistica();
          float result = instance.media( vals );
          
          assertEquals( esp, result , 0.05 );
    }
    
    @ParameterizedTest
    @MethodSource("helpers.Helper#sumatoriaValores")
    void sumatoriaTest( float esp , float vals[] ){
           Estadistica instance = new Estadistica();
           float result = instance.sumavals( vals );
           
           assertEquals( esp , result );
    }
    
    @ParameterizedTest
    @MethodSource("helpers.Helper#desviacion_tipicaValores")
    void desviacionTest( float esp , float vals[])
    {
           Estadistica instance = new Estadistica();
           float result = instance.desviacion_tipica( vals );
           
           assertEquals( esp , result , 0.5 );
    
    }
    
}
