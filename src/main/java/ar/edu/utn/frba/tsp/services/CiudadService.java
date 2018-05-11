package ar.edu.utn.frba.tsp.services;

import ar.edu.utn.frba.tsp.models.Ciudad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CiudadService {

    public List<Ciudad> getCiudades(List<String> nombres) {
        List<Ciudad> ciudades = new ArrayList<>();
        for (String nombre: nombres) {
            ciudades.add(Ciudad.valueOf(nombre));
        }
        return ciudades;
    }

    public double calcularDistancia(Ciudad unaCiudad, Ciudad otraCiudad) {
        return unaCiudad.distancia(otraCiudad);
    }

    public List<Ciudad> getAllCiudades(){
        return Arrays.asList(Ciudad.values());
    }


}
