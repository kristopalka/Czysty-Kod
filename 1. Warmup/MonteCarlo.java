package exercises;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/** TODO
 * Jako rozgrzewkę, spróbuj pobawić się tym kodem.
 * Zrozum jego działanie, a następnie zepsuj go w taki sposób, aby był jak najmniej czytelny, ale wciąż działał
 * (testowanie czy kod działa jest również częścią zadania)
 */

public class MonteCarlo {
    private int numberOfPoints;
    private int numberOfPointsInsideCircle;
    private ArrayList<Point2D> drawnPoints;


    public MonteCarlo(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public double getPI() {
        fillDrawnPointsList();
        countPointsInsideCircle();
        return calculatePI();
    }

    private void fillDrawnPointsList() {
        drawnPoints = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            Point2D drawnPoint = drawnPoint();
            drawnPoints.add(drawnPoint);
        }
    }

    private Point2D drawnPoint() {
        double x = Math.random(); // returns number greater than or equal to 0 and less than 1
        double y = Math.random();
        return new Point2D.Double(x, y);
    }

    private void countPointsInsideCircle() {
        numberOfPointsInsideCircle = 0;
        for (Point2D point : drawnPoints) {
            if (isInsideCircle(point))
                numberOfPointsInsideCircle++;
        }
    }

    private boolean isInsideCircle(Point2D point) {
        return point.getX() * point.getX() + point.getY() * point.getY() <= 1;
    }

    private double calculatePI() {
        // constant 4 must be double to multiply correctly
        return  4.0 * numberOfPointsInsideCircle / numberOfPoints;
    }

}