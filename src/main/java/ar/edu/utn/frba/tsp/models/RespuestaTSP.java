package ar.edu.utn.frba.tsp.models;

import java.util.List;

public class RespuestaTSP {

    private List<Ciudad> ciudades;
    private double distancia;

    public RespuestaTSP(List<Ciudad> ciudades, double distancia) {
        this.ciudades = ciudades;
        this.distancia = distancia;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
