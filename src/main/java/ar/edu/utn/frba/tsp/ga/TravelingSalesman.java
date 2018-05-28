package ar.edu.utn.frba.tsp.ga;

import ar.edu.utn.frba.tsp.models.Ciudad;
import io.jenetics.*;
import io.jenetics.engine.*;
import io.jenetics.util.ISeq;
import io.jenetics.util.MSeq;
import io.jenetics.util.RandomRegistry;

import java.util.*;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;


public class TravelingSalesman implements Problem<ISeq<Ciudad>, EnumGene<Ciudad>, Double> {

    private final ISeq<Ciudad> _points;
    public List<Double> doubles = new ArrayList<>();

    public TravelingSalesman(ISeq<Ciudad> points) {
        _points = Objects.requireNonNull(points);
    }

    @Override
    public Codec<ISeq<Ciudad>, EnumGene<Ciudad>> codec() {
        return Codecs.ofPermutation(_points);
    }

    @Override
    public Function<ISeq<Ciudad>, Double> fitness() {
        return p -> {
            double sum = IntStream.range(0, p.length()).mapToDouble(i -> {
                final Ciudad c1 = p.get(i);
                final Ciudad c2 = p.get((i + 1) % p.size());
                return Math.hypot(c1.getLatitud() - c2.getLatitud(), c1.getLongitud() - c2.getLongitud());
            }).sum();

            doubles.add(sum);
            return sum;
        };
    }

    public static TravelingSalesman of(List<Ciudad> ciudades) {
        int stops = ciudades.size();
        final MSeq<Ciudad> points = MSeq.ofLength(stops);
        for (int i = 0; i < stops; ++i) {
            points.set(i,ciudades.get(i));
        }

        final Random random = RandomRegistry.getRandom();
        for (int j = points.length() - 1; j > 0; --j) {
            final int i = random.nextInt(j + 1);
            final Ciudad tmp = points.get(i);
            points.set(i, points.get(j));
            points.set(j, tmp);
        }

        return new TravelingSalesman(points.toISeq());
    }

}
