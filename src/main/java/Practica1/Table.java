package Practica1;
import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<String> headers;
    private List<Row>data;

    public Table(List<String> headers, List<Row> data) {
        this.headers =headers;
        this.data = data;
    }

    public Row getRowAt(int rowNumber){
        return data.get(rowNumber);
                //rowNumber).getData();

    }
    public List<String> getHeaders(){
        return this.headers;
    }
    public List<Row> getRows(){
        return this.data;
    }
    public List<Double> getColumAt(int columnNumber){
        int sizeColumn = data.size();
        List<Double> columna = new ArrayList<>();
        for (int i = 0; i < sizeColumn; i++) {
            List<Double> ndatos = getRowAt(i).getData();
            columna.add(ndatos.get(columnNumber));
        }
        return columna;
    }
    public List<Row> getData(){
        return this.data;
    }
    public int getNumFilas(){
        return data.size();
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < headers.size(); i++) {
            cadena = cadena+" "+headers.get(i);
        }
        cadena += "\n";

        for (int i=0; i< data.size(); i++){
            cadena = cadena+data.get(i).toString();

        }

        return cadena;
    }

}


    
    

