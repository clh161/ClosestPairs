import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jacob Ho
 */
public class ClosestPairs {

    public static double minDistance(List<Coordinate> coordinates) {
        return minDistance(coordinates, true);
    }

    private static double minDistance(List<Coordinate> coordinates, boolean sortX) {
        if (coordinates.size() < 3)
            return bruteForceMinDistance(coordinates);
        else {
            if (sortX)
                coordinates.sort(new XComparator());
            int mid = coordinates.size() / 2;
            List<Coordinate> coordinates1 = coordinates.subList(0, mid);
            List<Coordinate> coordinates2 = coordinates.subList(mid, coordinates.size());
            double d1 = minDistance(coordinates1, false);
            double d2 = minDistance(coordinates2, false);
            double minD = Math.min(d1, d2);
            ArrayList<Coordinate> strips = new ArrayList<>();
            for (Coordinate coordinate : coordinates)
                if (Math.abs(coordinates.get(mid).x - coordinate.x) < minD)
                    strips.add(coordinate);
            strips.sort(new YComparator());
            for (int i = 0; i < strips.size(); i++) {
                for (int j = i + 1; j < strips.size() && strips.get(j).y - strips.get(i).y < minD; j++) {
                    double d = distance(strips.get(i), strips.get(j));
                    if (d < minD)
                        minD = d;
                }
            }
            return minD;
        }
    }

    public static double bruteForceMinDistance(List<Coordinate> coordinates) {
        double min = Float.MAX_VALUE;
        for (int i = 0; i < coordinates.size(); i++) {
            for (int j = i + 1; j < coordinates.size(); j++) {
                Coordinate a = coordinates.get(i);
                Coordinate b = coordinates.get(j);
                double distance = distance(a, b);
                if (distance < min)
                    min = distance;
            }
        }
        return min;
    }

    public static double distance(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }

    private static class XComparator implements Comparator<Coordinate> {

        @Override
        public int compare(Coordinate o1, Coordinate o2) {
            if (o1.x < o2.x)
                return -1;
            if (o1.x > o2.x)
                return 1;
            return 0;
        }
    }

    private static class YComparator implements Comparator<Coordinate> {

        @Override
        public int compare(Coordinate o1, Coordinate o2) {
            if (o1.y < o2.y)
                return -1;
            if (o1.y > o2.y)
                return 1;
            return 0;
        }
    }
}
