package Practica1;

import java.util.List;

public class KNN {
    private Double alpha;
    private Double beta;

    public KNN(){
        alpha = 0.0;
        beta = 0.0;
    }

    public void train(Table tabla){
        double numerador = 0.0;
        double denominador = 0.0;
        Double mediaX = 0.0;
        Double mediaY = 0.0;
        List<Double> lisX = tabla.getColumAt(0);
        List<Double> listY = tabla.getColumAt(1);

        for (Double datosX: tabla.getColumAt(0)){
            mediaX+=datosX;
        }
        mediaX = mediaX/tabla.getNumFilas();

        for (Double datosY: tabla.getColumAt(1)){
            mediaY+=datosY;
        }
        mediaY = mediaY/tabla.getNumFilas();

        for (int i =0; i < tabla.getNumFilas(); i++){
            numerador += (lisX.get(i)-mediaX) * (listY.get(i)-mediaY);
            denominador += Math.pow((lisX.get(i)-mediaX),2);


        }
        alpha = numerador / denominador;
        beta = mediaY - alpha*mediaX;
    }

    public Double estimate(Double sample){
        return alpha * sample + beta;
    }

    public Double getAlpha() {
        return alpha;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }

    @Override
    public String toString() {
        return "RegresionLineal{" +
                "alpha=" + alpha +
                ", beta=" + beta +
                '}';
    }
}
