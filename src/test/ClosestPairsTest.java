import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author Jacob Ho
 */
public class ClosestPairsTest {
    @Test
    public void minDistance() throws Exception {
        int loop = 1000;
        int sampleSize = 1000;
        int range = 10000;
        for (int i = 0; i < loop; i++) {
            ArrayList<Coordinate> coordinates = new ArrayList<>();
            for (int j = 0; j < sampleSize; j++) {
                coordinates.add(randomCoordinate(range));
            }
            assertEquals(coordinates.toString(), ClosestPairs.bruteForceMinDistance(coordinates), ClosestPairs.minDistance(coordinates), 0);
        }

    }

    private static Coordinate randomCoordinate(int range) {
        return new Coordinate(-range + (int) (Math.random() * ((2 * range) + 1)), -range + (int) (Math.random() * ((2 * range) + 1)));
    }

    @Test
    public void distance() throws Exception {
        double approximation = 0.000001;
        assertEquals(0, ClosestPairs.distance(new Coordinate(0, 0), new Coordinate(0, 0)), 0);
        assertEquals(0, ClosestPairs.distance(new Coordinate(1, 0), new Coordinate(0, 0)), 1);
        assertEquals(0, ClosestPairs.distance(new Coordinate(1, 0), new Coordinate(-1, 0)), 2);
        assertEquals(0, ClosestPairs.distance(new Coordinate(0, 1), new Coordinate(0, 0)), 1);
        assertEquals(0, ClosestPairs.distance(new Coordinate(0, 1), new Coordinate(0, -1)), 2);
        assertEquals(0, ClosestPairs.distance(new Coordinate(0, 0), new Coordinate(0, 0)), 0);
        assertEquals(26.400758, ClosestPairs.distance(new Coordinate(-7, -4), new Coordinate(17, 7)), approximation);
        assertEquals(14295664.665037, ClosestPairs.distance(new Coordinate(-8975430, 458937), new Coordinate(957293, -9822456)), approximation);
    }
}