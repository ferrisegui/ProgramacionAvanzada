package Practica1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.*;


public class KNN {

    private class DistanciaDatos implements Comparable<DistanciaDatos> {
        double distancia;
        String tipo;

        public DistanciaDatos(double distancia, String tipo) {
            this.distancia = distancia;
            this.tipo = tipo;
        }

        @Override
        public int compareTo(DistanciaDatos o) {
            return Double.compare(distancia, o.getDistancia());
        }

        public double getDistancia() {
            return distancia;
        }

        public String getTipo() {
            return tipo;
        }
    }

    private int knn;
    private Map<List<Double>,String> dataTable;

    public KNN(int knn, HashMap<List<Double>, String> data){
        this.knn = knn;
        this.dataTable = data;
    }

    public void train(TableWithLabels data) {
        for (int i = 0; i < data.getNumFilas(); i++){
            dataTable.put(data.getRowAt(i).getData(),data.getRowAt(i).getLabel());
        }
    }

    public String estimate(List<Double> sample) {
        Double[] sampleArray = sample.toArray(new Double[0]);
        List<DistanciaDatos> distances = addDistancias(sampleArray);
        Collections.sort(distances);
        DistanciaDatos[] vecinos = new DistanciaDatos[knn]; //selectKNearestNeighbors(distances);
        for (int i = 0; i < knn; i++){
            vecinos[i] = distances.get(i);
        }
        Map<String, Integer> repeticiones = new HashMap<>();
        for (DistanciaDatos neighbour: vecinos) {
            if (!repeticiones.containsKey(neighbour.getTipo())){
                repeticiones.put(neighbour.getTipo(), 1);
            }else{
                int numRepeticiones = repeticiones.get(neighbour.getTipo());
                repeticiones.put(neighbour.getTipo(), numRepeticiones + 1);
            }
        }
        List<Map.Entry<String, Integer>> ordenarMap = new LinkedList<>(repeticiones.entrySet());
        Collections.sort(ordenarMap, Map.Entry.comparingByValue());
        return ordenarMap.get(ordenarMap.size()-1).getKey();
    }

    private List<DistanciaDatos> addDistancias(Double[] sample){
        List<DistanciaDatos> distancias = new ArrayList<>();
        for (Map.Entry<List<Double>, String> entry : dataTable.entrySet()){
            Double[] distance = entry.getKey().toArray(new Double[0]);
            distancias.add(new DistanciaDatos(distanciaDeEuclide(distance, sample), entry.getValue()));
        }
        return distancias;
    }

    public static double distanciaDeEuclide(Double[] desde, Double[] hasta){
        double distance = 0;

        for (int i=0;i<desde.length;i++){
            distance += Math.pow(desde[i]-hasta[i],2);
        }

        return Math.sqrt(distance);
    }

    public int getKnn() {
        return knn;
    }

    public void setKnn(int knn) {
        this.knn = knn;
    }

    public Map<List<Double>, String> getDataTable() {
        return dataTable;
    }

    public void setDataTable(Map<List<Double>, String> dataTable) {
        this.dataTable = dataTable;
    }
}
