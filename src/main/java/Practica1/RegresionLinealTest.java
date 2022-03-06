package Practica1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RegresionLinealTest {

    Table tabla =CSV.readTable("miles_dollars.csv");

    RegresionLineal regresionLineal = new RegresionLineal();

    RegresionLinealTest() throws IOException {
        regresionLineal.train(tabla);

    }


    @Test
    @DisplayName("Alfa correcto")
    void getAlfa() {
        assertEquals(regresionLineal.getAlpha(),1.2553337759690923);

    }
    @Test
    @DisplayName("Alfa incorrecto")
    void getAlfa2() {
        assertNotEquals(regresionLineal.getAlpha(),2.2553337759690923);

    }
    @Test
    @DisplayName("Beta correcto")
    void getBeta() {
        assertEquals(regresionLineal.getBeta(),274.8496866723017);
    }
    @Test
    @DisplayName("Beta incorrecto")
    void getBeta2() {
        assertNotEquals(regresionLineal.getBeta(),374.8496866723017);
    }
}