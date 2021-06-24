/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexcel;

/**
 *
 * @author Pablo Valentini
 */

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Number;

public class ConExcel {

    private static final String UBICACION_ARCHIVO = "D:\\MI_ARCHIVO_DE_EXCEL.xls";

    public static void main(String[] args) {

        //1. CREAR UN ARCHIVO DE EXCEL
        WritableWorkbook miLibro = null;
        try {

            miLibro = Workbook.createWorkbook(new File(UBICACION_ARCHIVO));

            // CREAR UNA HOJA
            WritableSheet hojaExcel = miLibro.createSheet("hoja 1", 0);

            // AGREGAR ALGO A LA HOJA
            Label label = new Label(0, 0, "Test");
            hojaExcel.addCell(label);                   //AGREGAMOS EL Label A LA HOJA

            Number numero = new Number(0, 1, 1);
            hojaExcel.addCell(numero);

            label = new Label(1, 0, "Resultado");
            hojaExcel.addCell(label);

            label = new Label(1, 1, "Paso");
            hojaExcel.addCell(label);

            numero = new Number(0, 2, 2);
            hojaExcel.addCell(numero);

            label = new Label(1, 2, "Paso 2");
            hojaExcel.addCell(label);

            miLibro.write();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (miLibro != null) {
                try {
                    miLibro.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    
}
