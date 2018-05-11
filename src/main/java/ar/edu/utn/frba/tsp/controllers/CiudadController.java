package ar.edu.utn.frba.tsp.controllers;

import ar.edu.utn.frba.tsp.models.Ciudad;
import ar.edu.utn.frba.tsp.services.CiudadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    Logger LOG = LoggerFactory.getLogger(CiudadController.class);

    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    public List<Ciudad> getCiudad() {
        return ciudadService.getAllCiudades();
    }

}
