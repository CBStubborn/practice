package personal.practices.job.mllh;


import java.io.BufferedInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Stubborn on 2017/9/23.
 */
public class OutPutDayOfYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNextLine()) {
            try {
                dayOfYear(scanner.nextLine());
            } catch (ParseException e) {

            }
        }
        scanner.close();
    }

    private static void dayOfYear(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        Date date = sdf.parse(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
    }
}
