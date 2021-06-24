/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Helper {
    
    static Stream<Arguments> mediaValores() {
         Workbook workbook = null;
        int cantidad=0;
        int j = 1;
        ArrayList<Float> valores = new ArrayList();
        float media=0;
        
        try {
            workbook = Workbook.getWorkbook(new File("C:\\Users\\julio\\Documents\\NetBeansProjects\\pruebas5\\src\\test\\resources\\estadisticas.xls"));
            Sheet sheet = workbook.getSheet(0);
           
            //OBTENER LOS VALORES
            Cell cell = sheet.getCell(0, j); //titulos
            while (cell != null  && !cell.getContents().equals("")) {
                cell = null;
                try {
                    cell = sheet.getCell(0, j);
                } catch (Exception e) {
                }
                if (cell != null && !cell.getContents().equals("")) {
                    j++;
                    valores.add(Float.valueOf( cell.getContents().replace(",", ".") ) );
                }
            }
            
            //OBTENER LA SUMA
            cell = sheet.getCell(3,1);
            media = Float.valueOf( cell.getContents().replace(",", ".") );
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }

        cantidad = j;
        j=0;
        float a[] = new float[valores.size()];
        
        for (float v:valores) 
            a[j] = valores.get(j++);
        
        
        return Stream.of(
                arguments(media, a),
                arguments(media, a)
        );
    }
    
    
    static Stream<Arguments> sumatoriaValores() {
        Workbook workbook = null;
        int cantidad=0;
        int j = 1;
        ArrayList<Float> valores = new ArrayList();
        float suma=0;
        
        try {
            workbook = Workbook.getWorkbook(new File("C:\\Users\\julio\\Documents\\NetBeansProjects\\pruebas5\\src\\test\\resources\\estadisticas.xls"));
            Sheet sheet = workbook.getSheet(0);
           
            //OBTENER LOS VALORES
            Cell cell = sheet.getCell(0, j); //titulos
            while (cell != null  && !cell.getContents().equals("")) {
                cell = null;
                try {
                    cell = sheet.getCell(0, j);
                } catch (Exception e) {
                }
                if (cell != null && !cell.getContents().equals("")) {
                    j++;
                    valores.add(Float.valueOf( cell.getContents().replace(",", ".") ) );
                }
            }
            
            //OBTENER LA SUMA
            cell = sheet.getCell(2,1);
            suma = Float.valueOf( cell.getContents() );
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }

        cantidad = j;
        j=0;
        float a[] = new float[valores.size()];
        
        for (float v:valores) 
            a[j] = valores.get(j++);
        
        
        return Stream.of(
                arguments(suma, a)/* Arrays.asList(2.0, 4.0))*/,
                arguments(suma, a)
        );
    }
    
  
    
    static Stream<Arguments> desviacion_tipicaValores() {
        Workbook workbook = null;
        int cantidad=0;
        int j = 1;
        ArrayList<Float> valores = new ArrayList();
        float desv=0;
        
        try {
            workbook = Workbook.getWorkbook(new File("C:\\Users\\julio\\Documents\\NetBeansProjects\\pruebas5\\src\\test\\resources\\estadisticas.xls"));
            Sheet sheet = workbook.getSheet(0);
           
            //OBTENER LOS VALORES
            Cell cell = sheet.getCell(0, j); //titulos
            while (cell != null  && !cell.getContents().equals("")) {
                cell = null;
                try {
                    cell = sheet.getCell(0, j);
                } catch (Exception e) {
                }
                if (cell != null && !cell.getContents().equals("")) {
                    j++;
                    valores.add(Float.valueOf( cell.getContents().replace(",", ".") ) );
                }
            }
            
            //OBTENER LA DESVIACION TIPICA
            cell = sheet.getCell(4,1);
            desv = Float.valueOf( cell.getContents().replace(",", ".") );
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }

        cantidad = j;
        j=0;
        float a[] = new float[valores.size()];
        
        for (float v:valores) 
            a[j] = valores.get(j++);
        
        
        return Stream.of(arguments(desv, a)/* Arrays.asList(2.0, 4.0))*/,
                arguments(desv, a)
        );

    }
}


