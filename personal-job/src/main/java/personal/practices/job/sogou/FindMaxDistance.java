package personal.practices.job.sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stubborn on 2017/9/8.
 */
public class FindMaxDistance {

    public static void main(String[] args) {
        double maxDistance = 0.0d;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            List<List<Double>> allArea = new ArrayList<>();
            List<Double> area_1 = new ArrayList<>();
            List<Double> area_2 = new ArrayList<>();
            List<Double> area_3 = new ArrayList<>();
            List<Double> area_4 = new ArrayList<>();
            int numbers = Integer.valueOf(bufferedReader.readLine());
            for (int i = 0; i < numbers; i++) {
                double point = Double.valueOf(bufferedReader.readLine());
                if (point > 0.0d && point <= 90.0d) {
                    area_1.add(point);
                    allArea.add(area_1);
                } else if (point > 90.0d && point <= 180.0d) {
                    area_2.add(point);
                    allArea.add(area_2);
                } else if (point > 180.0d && point <= 270.0d) {
                    area_3.add(point);
                    allArea.add(area_3);
                } else if (point > 270.0d && point <= 360.0d) {
                    area_4.add(point);
                    allArea.add(area_4);
                }
            }
            if (allArea.size() > 1) {
                for (int i = 0; i < allArea.size(); i++) {
                    for (int j = i + 1; j < allArea.size(); j++) {
                        List<Double> areaPoints_1 = allArea.get(i);
                        List<Double> areaPoints_2 = allArea.get(j);
                        for (int m = 0; m < areaPoints_1.size(); m++) {
                            for (int n = 0; n < areaPoints_2.size(); n++) {
                                double distance = Math.abs(areaPoints_2.get(n) - areaPoints_1.get(m));
                                if (distance > 180.0d) {
                                    distance = 360.0 - distance;
                                }
                                if (distance > maxDistance) {
                                    maxDistance = distance;
                                }
                            }
                        }
                    }
                }
            } else {
                List<Double> areaPoints = allArea.get(0);
                if (areaPoints.size() != 0) {
                    double minPoint = areaPoints.get(0);
                    double maxPoint = areaPoints.get(areaPoints.size() - 1);
                    maxDistance = maxPoint - minPoint;
                }
            }
            DecimalFormat format = new DecimalFormat("#.00000000");
            System.out.println(format.format(maxDistance));
        } catch (IOException e) {

        }
    }
}
