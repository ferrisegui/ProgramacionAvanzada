package Practica1;

import java.util.List;

public class Row {
    private List<Double> data;

    public Row(List<Double> data) {
        this.data = data;
    }

    public List<Double> getData() {
        return data;
    }

    /*private static String limpia(String datosArray){
        datosArray = datosArray.trim();
        if (datosArray != null && datosArray.length() > 0 && datosArray.charAt(datosArray.length() - 1) == ',') {
            datosArray = datosArray.substring(datosArray.length() - 1);
        }
        return datosArray;
    }*/

    @Override
    public String toString() {
        String cadena = "";
        for(int i = 0; i< data.size(); i++){
            cadena = cadena +" "+ data.get(i).toString();

        }
        cadena += "\n";

        return cadena;
    }
}

