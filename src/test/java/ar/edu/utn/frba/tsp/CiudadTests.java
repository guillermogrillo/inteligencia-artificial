package ar.edu.utn.frba.tsp;

import ar.edu.utn.frba.tsp.models.Ciudad;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CiudadTests {

    @Test
    public void testDistanciaEntreCiudadesDistintas() {

        //Dada la ciudad1 y ciudad2
        Ciudad ciudad1 = Ciudad.BUENOS_AIRES;
        Ciudad ciudad2 = Ciudad.MADRID;
        Assert.assertTrue(ciudad1.distancia(ciudad2) == 92.8317170550456);
    }

    @Test
    public void testDistanciaEntreUnaCiudadConsigoMisma() {
        Ciudad ciudad1 = Ciudad.BUENOS_AIRES;
        Assert.assertTrue(ciudad1.distancia(ciudad1) == 0);
    }

}
