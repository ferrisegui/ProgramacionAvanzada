import Practica1.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
        Table tabla = CSV.readTable("miles_dollars.csv");
        Row row2 = tabla.getRowAt(1);
        List<Double> fila = row2.getData();
        List<Double> columna = tabla.getColumAt(1);


        TableWithLabels tablaLabel =CSV.readTableWithLabel("iris.csv");
        RowWithLabel rowLabel = tablaLabel.getRowAt(1);
        List<Double> filaLabel = rowLabel.getData();
        List<Double> columnaLabel = tablaLabel.getColumAt(1);

    TableTest() throws IOException {
    }



        // System.out.println(CSV.readTable("miles_dollars.csv").getRowAt(0));

    @Test
    @DisplayName("Test de filas iguales")
    void getRowAt() {
        List<Double> listTest= new ArrayList<>();
        Double[] vector = {1345.0, 2405.0};
        for (int i = 0; i< vector.length; i++){
            listTest.add(vector[i]);
        }

        assertEquals(fila, listTest);
    }
    @Test
    @DisplayName("Test de filas diferentes")
    void getRowAt2() {
        List<Double> listTest= new ArrayList<>();
        Double[] vector = {1345.0, 240.0};
        for (int i = 0; i< vector.length; i++){
            listTest.add(vector[i]);
        }

        assertNotEquals(fila, listTest);
    }
    @Test
    @DisplayName("Test de filas Label iguales")
    void getRowAt3() {
        List<Double> listTest= new ArrayList<>();
        Double[] vector = {4.9, 3.0, 1.4, 0.2};
        for (int i = 0; i< vector.length; i++){
            listTest.add(vector[i]);
        }

        assertEquals(filaLabel, listTest);
    }
    @Test
    @DisplayName("Test de filas labels diferentes")
    void getRowAt4() {
        List<Double> listTest= new ArrayList<>();
        Double[] vector = {4.9, 3.0, 1.4, 0.1};
        for (int i = 0; i< vector.length; i++){
            listTest.add(vector[i]);
        }

        assertNotEquals(filaLabel, listTest);
    }
    @Test
    @DisplayName("Test de columna iguales")
    void getColAt() {
        List<Double> listTest= new ArrayList<>();
        Double[] vector = {1802.0, 2405.0, 2005.0, 2511.0, 2332.0,
                2305.0, 3016.0, 3385.0, 3090.0, 3694.0, 3371.0, 3998.0,
                3555.0, 4692.0, 4244.0, 5298.0, 4801.0, 5147.0, 5738.0, 6420.0, 6059.0, 6426.0, 6321.0, 7026.0, 6964.0};
        for (int i = 0; i< vector.length; i++){
            listTest.add(vector[i]);
        }

        assertEquals(columna, listTest);
    }
    @Test
    @DisplayName("Test de columna diferentes")
    void geColAt2() {
        List<Double> listTest= new ArrayList<>();
        Double[] vector = {1812.0, 2405.0, 2005.0, 2511.0, 2332.0, 2305.0,
                3016.0, 3385.0, 3090.0, 3694.0, 3371.0, 3998.0, 3555.0,
                4692.0, 4244.0, 5298.0, 4801.0, 5147.0, 5738.0, 6420.0,
                6059.0, 6426.0, 6321.0, 7026.0, 6964.0};
        for (int i = 0; i< vector.length; i++){
            listTest.add(vector[i]);
        }

        assertNotEquals(columna, listTest);
    }
    @Test
    @DisplayName("Test de columna Labels iguales")
    void getColAt3() {
        List<Double> listTest= new ArrayList<>();
        Double[] vector = {3.5, 3.0, 3.2, 3.1, 3.6, 3.9, 3.4, 3.4, 2.9, 3.1, 3.7, 3.4, 3.0, 3.0, 4.0, 4.4, 3.9, 3.5, 3.8, 3.8, 3.4, 3.7,
                3.6, 3.3, 3.4, 3.0, 3.4, 3.5, 3.4, 3.2, 3.1, 3.4, 4.1, 4.2, 3.1, 3.2, 3.5, 3.1, 3.0, 3.4, 3.5, 2.3, 3.2, 3.5, 3.8, 3.0,
                3.8, 3.2, 3.7, 3.3, 3.2, 3.2, 3.1, 2.3, 2.8, 2.8, 3.3, 2.4, 2.9, 2.7, 2.0, 3.0, 2.2, 2.9, 2.9, 3.1, 3.0, 2.7, 2.2, 2.5,
                3.2, 2.8, 2.5, 2.8, 2.9, 3.0, 2.8, 3.0, 2.9, 2.6, 2.4, 2.4, 2.7, 2.7, 3.0, 3.4, 3.1, 2.3, 3.0, 2.5, 2.6, 3.0, 2.6, 2.3,
                2.7, 3.0, 2.9, 2.9, 2.5, 2.8, 3.3, 2.7, 3.0, 2.9, 3.0, 3.0, 2.5, 2.9, 2.5, 3.6, 3.2, 2.7, 3.0, 2.5, 2.8, 3.2, 3.0, 3.8,
                2.6, 2.2, 3.2, 2.8, 2.8, 2.7, 3.3, 3.2,
                2.8, 3.0, 2.8, 3.0, 2.8, 3.8, 2.8, 2.8, 2.6, 3.0, 3.4, 3.1, 3.0, 3.1, 3.1, 3.1, 2.7, 3.2, 3.3, 3.0, 2.5, 3.0, 3.4, 3.0};
        for (int i = 0; i< vector.length; i++){
            listTest.add(vector[i]);
        }

        assertEquals(columnaLabel, listTest);
    }
    @Test
    @DisplayName("Test de columna de Labels diferentes")
    void geColAt4() {
        List<Double> listTest= new ArrayList<>();
        Double[] vector = {1812.0, 2405.0, 2005.0, 2511.0, 2332.0, 2305.0,
                3016.0, 3385.0, 3090.0, 3694.0, 3371.0, 3998.0, 3555.0,
                4692.0, 4244.0, 5298.0, 4801.0, 5147.0, 5738.0, 6420.0,
                6059.0, 6426.0, 6321.0, 7026.0, 6964.0};
        for (int i = 0; i< vector.length; i++){
            listTest.add(vector[i]);
        }

        assertNotEquals(columnaLabel, listTest);
    }

   
}