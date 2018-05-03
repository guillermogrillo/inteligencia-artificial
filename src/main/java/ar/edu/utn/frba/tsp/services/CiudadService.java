package ar.edu.utn.frba.tsp.services;

import ar.edu.utn.frba.tsp.models.Ciudad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CiudadService {

    public List<Ciudad> getCiudades() {
        /*List<String> ciudades = new ArrayList<>();
        for (Ciudad ciudad: Ciudad.values()) {
            ciudades.add(Ciudad.valueOf(ciudad.name()).toString());
        }
        return ciudades;*/
        return Arrays.asList(Ciudad.values());
    }

    public double calcularDistancia(Ciudad unaCiudad, Ciudad otraCiudad) {
        return unaCiudad.distancia(otraCiudad);
    }


}
