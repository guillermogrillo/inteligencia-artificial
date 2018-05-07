package ar.edu.utn.frba.tsp.controllers;

import ar.edu.utn.frba.tsp.models.Ciudad;
import ar.edu.utn.frba.tsp.models.RespuestaTSP;
import ar.edu.utn.frba.tsp.services.CiudadService;
import ar.edu.utn.frba.tsp.services.TSPService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tsp")
public class TSPController {

    Logger LOG = LoggerFactory.getLogger(TSPController.class);

    @Autowired
    private TSPService tspService;

    @PostMapping
    public ResponseEntity<RespuestaTSP> calcular(@RequestBody List<Ciudad> ciudades) {
        RespuestaTSP respuesta = tspService.calcularDistanciaMinima(ciudades);
        ResponseEntity<RespuestaTSP> respuestaHttp = new ResponseEntity<RespuestaTSP>(respuesta, HttpStatus.OK);
        return respuestaHttp;
    }

}
