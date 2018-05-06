package ar.edu.utn.frba.tsp.ga;

import io.jenetics.*;
import io.jenetics.engine.*;
import io.jenetics.util.ISeq;
import io.jenetics.util.MSeq;
import io.jenetics.util.RandomRegistry;

import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;


public class TravelingSalesman implements Problem<ISeq<double[]>, EnumGene<double[]>, Double> {

    private final ISeq<double[]> _points;

    public TravelingSalesman(ISeq<double[]> points) {
        _points = Objects.requireNonNull(points);
    }

    @Override
    public Codec<ISeq<double[]>, EnumGene<double[]>> codec() {
        return Codecs.ofPermutation(_points);
    }

    @Override
    public Function<ISeq<double[]>, Double> fitness() {
        return p -> IntStream.range(0, p.length()).mapToDouble(i -> {
            final double[] p1 = p.get(i);
            final double[] p2 = p.get((i + 1) % p.size());
            return Math.hypot(p1[0] - p2[0], p1[1] - p2[1]);
        }).sum();
    }

    public static TravelingSalesman of(int stops, double radius) {
        final MSeq<double[]> points = MSeq.ofLength(stops);
        final double delta = 2.0 * Math.PI / stops;
        for (int i = 0; i < stops; ++i) {
            final double alpha = delta * i;
            final double x = Math.cos(alpha) * radius + radius;
            final double y = Math.sin(alpha) * radius + radius;
            points.set(i, new double[]{x, y});
        }

        final Random random = RandomRegistry.getRandom();
        for (int j = points.length() - 1; j > 0; --j) {
            final int i = random.nextInt(j + 1);
            final double[] tmp = points.get(i);
            points.set(i, points.get(j));
            points.set(j, tmp);
        }

        return new TravelingSalesman(points.toISeq());
    }

    public static void main(String[] args) {
        int stops = 20;
        double R = 10;
        double minPathLength = 2.0 * stops * R * Math.sin(Math.PI / stops);

        TravelingSalesman tsm = TravelingSalesman.of(stops, R);
        Engine<EnumGene<double[]>, Double> engine = Engine
                .builder(tsm)
                .optimize(Optimize.MINIMUM)
                .maximalPhenotypeAge(11)
                .populationSize(500)
                .alterers(
                        new SwapMutator<>(0.2),
                        new PartiallyMatchedCrossover<>(0.35))
                .build();

        EvolutionStatistics<Double, ?>
                statistics = EvolutionStatistics.ofNumber();

        Phenotype<EnumGene<double[]>,Double> best =
                engine. stream ( )
                .limit(Limits.bySteadyFitness(25))
                .limit(250)
                .peek(statistics)
                .collect(EvolutionResult.toBestPhenotype());

        System.out.println(statistics) ;
        System.out.println("Known min path length:" + minPathLength ) ;
        System.out.println(" Found min path length: " + best.getFitness()) ;
    }
}
