package ar.edu.utn.frba.tsp.services;

import ar.edu.utn.frba.tsp.ga.TravelingSalesman;
import ar.edu.utn.frba.tsp.models.Ciudad;
import ar.edu.utn.frba.tsp.models.RespuestaTSP;
import io.jenetics.*;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.engine.EvolutionStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TSPService {

    private static Logger LOGGER = LoggerFactory.getLogger(TSPService.class);

    public RespuestaTSP calcularDistanciaMinima(List<Ciudad> ciudades) {

        TravelingSalesman tsm = TravelingSalesman.of(ciudades);
        Engine<EnumGene<Ciudad>, Double> engine = Engine
                .builder(tsm)
                .optimize(Optimize.MINIMUM)
                .populationSize(20)
                .alterers(
                        new SwapMutator<>(0.2),
                        new PartiallyMatchedCrossover<>(0.35))
                .build();

        EvolutionStatistics<Double, ?>
                statistics = EvolutionStatistics.ofNumber();

        Phenotype<EnumGene<Ciudad>,Double> best =
                engine. stream ( )
                        //.limit(Limits.bySteadyFitness(80))
                        .limit(40000)
                        .peek(statistics)
                        .collect(EvolutionResult.toBestPhenotype());

        LOGGER.info("Estadísticas:"+statistics);
        LOGGER.info("Minimo: " + best.getFitness());
        LOGGER.info("Orden: "+ best.getGenotype().toString());

        List<Ciudad> orden = new ArrayList<>();

        Iterator<EnumGene<Ciudad>> iterator = best.getGenotype().getChromosome().iterator();
        while(iterator.hasNext()){
            EnumGene<Ciudad> next = iterator.next();
            orden.add(next.getAllele());
        }



        String content = tsm.doubles.toString();
        try {
            Files.write(Paths.get("output.txt"), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        RespuestaTSP respuestaTSP = new RespuestaTSP(orden,best.getFitness());
        return respuestaTSP;
    }

}
