package personal.practices.job.baidu;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 要求：
 * 三维空间中有N个点，每个点可能是三种颜色的其中之一，三种颜色分别是红绿蓝，分别用'R', 'G', 'B'表示。
 * 现在要找出三个点，并组成一个三角形，使得这个三角形的面积最大。
 * 但是三角形必须满足：三个点的颜色要么全部相同，要么全部不同。
 * Created by Stubborn on 2017/9/5.
 */
public class MaxTriangle {

    private static DecimalFormat df = new DecimalFormat("###.00000");

    public static void main(String[] args) {
        double maxArea = 0.0d;
        Map<String, List<Point>> colorPointMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] pieces = line.split(" ");
            List<Point> points = colorPointMap.get(pieces[0]);
            if (points == null) {
                points = new ArrayList<>();
                colorPointMap.put(pieces[0], points);
            }
            points.add(new Point(Integer.valueOf(pieces[1]), Integer.valueOf(pieces[2]), Integer.valueOf(pieces[3])));
        }
        scanner.close();
        //同一种颜色
        for (Map.Entry<String, List<Point>> entry : colorPointMap.entrySet()) {
            List<Point> points = entry.getValue();
            if (points.size() < 3) {
                continue;
            } else {
                for (int i = 0; i < points.size(); i++) {
                    for (int j = i + 1; j < points.size(); j++) {
                        for (int k = j + 1; k < points.size(); k++) {
                            Point p1 = points.get(i);
                            Point p2 = points.get(j);
                            Point p3 = points.get(k);
                            double area = getArea(p1, p2, p3);
                            if (area > maxArea) {
                                maxArea = area;
                            }
                        }
                    }
                }
            }
        }

        //不同颜色
        if (colorPointMap.size() < 3) {
            System.out.printf(df.format(maxArea));
        } else {
            List<Point> rPoints = colorPointMap.get("R");
            List<Point> gPoints = colorPointMap.get("G");
            List<Point> bPoints = colorPointMap.get("B");
            for (int i = 0; i < rPoints.size(); i++) {
                for (int j = 0; j < gPoints.size(); j++) {
                    for (int k = 0; k < bPoints.size(); k++) {
                        Point p1 = rPoints.get(i);
                        Point p2 = gPoints.get(j);
                        Point p3 = bPoints.get(k);
                        double area = getArea(p1, p2, p3);
                        if (area > maxArea) {
                            maxArea = area;
                        }
                    }
                }
            }
            System.out.println(df.format(maxArea));
        }
    }

    public static double getArea(Point p1, Point p2, Point p3) {
        double e1 = getEdgeLength(p1, p2);
        double e2 = getEdgeLength(p2, p3);
        double e3 = getEdgeLength(p3, p1);
        if (checkValid(e1, e2, e3)) {
            return calculateArea(e1, e2, e3);
        } else {
            return 0.0f;
        }
    }

    public static double getEdgeLength(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) +
                Math.pow((p1.getY() - p2.getY()), 2) + Math.pow((p1.getZ() - p2.getZ()), 2));
    }

    public static boolean checkValid(double e1, double e2, double e3) {
        if (e1 <= 0 || e2 <= 0 || e3 <= 0) {
            return false;
        }
        boolean b1 = (e1 < e2 + e3);
        boolean b2 = (e2 < e1 + e3);
        boolean b3 = (e3 < e1 + e2);
        return b1 && b2 && b3;
    }

    public static double calculateArea(double e1, double e2, double e3) {
        double p = (e1 + e2 + e3) / 2;
        double area = Math.sqrt(p * (p - e1) * (p - e2) * (p - e3));
        return area;
    }

    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }
}
