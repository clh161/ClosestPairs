/**
 * @author Jacob Ho
 */
public class ClosestPairs {
    public static double distance(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }
}
