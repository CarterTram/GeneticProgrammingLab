import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeneticProgramUnitTest {

    @Test
    public void testValidateChromosome() {
        LineChromosome chromosome = new LineChromosome();
        assertFalse(chromosome.validateChromosome());
        chromosome.bits[5]=1;
        chromosome.bits[10] = 1;
        chromosome.bits[15]=1;
        chromosome.bits[19]=1;
        chromosome.bits[20] = 1;
        chromosome.bits[27]=1;
        chromosome.bits[44]=1;

        assertTrue(chromosome.validateChromosome());
    }

    @Test
    public void testGetFitness() {
        ArrayList<int[]> points = new ArrayList<>();
        points.add(new int[]{2, 4});
        points.add(new int[]{3, 6});
        points.add(new int[]{5, 10});
        points.add(new int[]{7, 14});
        points.add(new int[]{9, 18});

        LineChromosome chromosome = new LineChromosome(points);

        // Test Case 1
        chromosome.bits = new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0};
        assertEquals(0.2524340611597263, chromosome.getFitness(), 0.000001);

        // Test Case 2
        chromosome.bits = new int[]{1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0};
        assertEquals(0.0883098977583219, chromosome.getFitness(), 0.000001);

        // Test Case 3
        chromosome.bits = new int[]{1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        assertEquals(0.08292536102693430, chromosome.getFitness(), 0.000001);

        // Test Case 4
        chromosome.bits = new int[]{1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        assertEquals(Double.NaN, chromosome.getFitness(), 0.000001);

        // Test Case 5
        chromosome.bits = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        assertEquals(0.07850542892013953, chromosome.getFitness(), 0.000001);
            
        }

}


