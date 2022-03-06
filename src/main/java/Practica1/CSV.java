package Practica1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSV {

    public static Table readTable(String csv) throws IOException {

        Table tabla = null;
        try {
            File myObj = new File(csv);
            Scanner myReader = new Scanner(myObj);
            String header = myReader.nextLine();
            String[] info = header.split(",");
            int ncol = info.length;
            //Separar por comas, genero Vector String
            List<String> headers = new ArrayList<String>();
            for (int i = 0; i < ncol; i++) {
                headers.add(info[i]);


            }

            List<Row> filas = new ArrayList<Row>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] fila = data.split(",");
               // List<Double> filaDouble = new ArrayList<Double>();
                List<Double> filaDouble = new ArrayList<>();
                for (int i = 0; i < fila.length; i++) {
                    filaDouble.add(Double.parseDouble(fila[i]));

                }
                filas.add(new Row(filaDouble));
            }
            myReader.close();
            tabla = new Table(headers, filas);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return tabla;
    }
    public static TableWithLabels readTableWithLabel(String csv) throws IOException {

        TableWithLabels tabla = null;
        try {
            File myObj = new File(csv);
            Scanner myReader = new Scanner(myObj);
            String header = myReader.nextLine();
            String[] info = header.split(",");
            int ncol = info.length;
            //Separar por comas, genero Vector String
            List<String> headers = new ArrayList<String>();
            for (int i = 0; i < ncol; i++) {
                headers.add(info[i]);


            }

            List<Row> filas = new ArrayList<>();
            List<String> etiquetas = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] fila = data.split(",");
                // List<Double> filaDouble = new ArrayList<Double>();
                List<Double> filaDouble = new ArrayList<>();
                etiquetas.add(fila[fila.length-1]);
                for (int i = 0; i < fila.length -1; i++) {
                    filaDouble.add(Double.parseDouble(fila[i]));

                }
                filas.add(new Row(filaDouble));
            }
            myReader.close();
            tabla = new TableWithLabels(headers, filas,etiquetas);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return tabla;
    }
}


