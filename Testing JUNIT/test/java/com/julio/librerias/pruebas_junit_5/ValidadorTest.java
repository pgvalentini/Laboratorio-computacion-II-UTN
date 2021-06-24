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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 *
 * @author julio
 */
public class ValidadorTest {
    
    public ValidadorTest() {
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
    @DisplayName("Con este test chequeamos fechas" )
    @CsvFileSource(resources = "/datos.csv", numLinesToSkip=1)
    void esFechaValida( String dia, String mes, String anio, String expected ){
             Validador instance = new Validador();
             boolean result = instance.esFechaValida(dia, mes, anio);
             
             assertEquals( Boolean.valueOf( expected ) , result );
    
    }
    
}
