package Practica1;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Table tabla =CSV.readTable("miles_dollars.csv");
            Row row2 = tabla.getRowAt(1);
            List<Double> datos2 = row2.getData();
            System.out.println(datos2);
            List<Double> fila = tabla.getColumAt(1);
            System.out.println(fila);


            System.out.println("Tabla With Labels");
            TableWithLabels tablaLabel =CSV.readTableWithLabel("iris.csv");

            System.out.println("Imprimimos la TABLA de LABELS");
            System.out.println(tablaLabel);
            RowWithLabel rowLabel = tablaLabel.getRowAt(1);
            List<Double> datos = rowLabel.getData();
            System.out.println(datos);
            List<Double> fila2 = tablaLabel.getColumAt(1);
            System.out.println(fila2);


            RegresionLineal regresionLineal = new RegresionLineal();
            regresionLineal.train(tabla);
            System.out.println(regresionLineal.getAlpha());
            System.out.println(regresionLineal.getBeta());

            // System.out.println(CSV.readTable("miles_dollars.csv").getRowAt(0));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
