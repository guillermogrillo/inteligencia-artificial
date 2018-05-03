package ar.edu.utn.frba.tsp.services;

import ar.edu.utn.frba.tsp.models.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TSPService {

    @Autowired
    private CiudadService ciudadService;

    public double calcularDistancia(List<Ciudad> ciudades) {
        double acum = 0;
        for (int i = 0; i < ciudades.size()-1; i++) {
            acum = acum + ciudadService.calcularDistancia(ciudades.get(i),ciudades.get(i+1));
        }
        acum = acum + ciudadService.calcularDistancia(ciudades.get(ciudades.size()-1), ciudades.get(0));
        return acum;
    }


}
