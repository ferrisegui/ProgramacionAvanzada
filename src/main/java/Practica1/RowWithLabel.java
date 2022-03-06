package Practica1;

import java.util.List;

public class RowWithLabel extends Row{
    public String label;

    public RowWithLabel(List<Double> data, String label) {

        super(data);
        this.label = label;
    }
    public  String getLabel(){
        return this.label;
    }
    @Override
    public String toString() {
        String cadena = "";
        for(int i = 0; i< super.getData().size(); i++){
            cadena = cadena +" "+ super.getData().get(i).toString();

        }

        cadena += " "+label+" \n";

        return cadena;
    }

}
