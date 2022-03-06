package Practica1;

import java.util.LinkedList;
import java.util.List;

public class TableWithLabels  extends Table{
    List<String> etiquetas;

    public TableWithLabels(List<String> headers, List<Row> data,List<String> etiquetas) {
        super(headers,data);
        this.etiquetas = etiquetas;
    }

    public RowWithLabel getRowAt(int rowNumber) {
        Row fila = super.getRowAt(rowNumber);
        RowWithLabel filaE = new RowWithLabel(fila.getData(),etiquetas.get(rowNumber));
        return filaE;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < super.getHeaders().size(); i++) {
            cadena = cadena+" "+super.getHeaders().get(i);
        }
        cadena += "\n";

        for (int i=0; i< super.getRows().size(); i++){
            cadena += getRowAt(i).toString();

        }

        return cadena;
    }
}
