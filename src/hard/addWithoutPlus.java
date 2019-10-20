package hard;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class addWithoutPlus {

    public static void main(String[] args){

        test();

//        System.out.println(add(1001, 1100));
//        System.out.println(add(1001, -1100));
//        System.out.println(add(-9, 11));
//        System.out.println(add(1001, 11001110));
//        System.out.println(add(1011, 110001));

    }

    public static int add(int a, int b){

        while(b != 0){

            System.out.println(Integer.toBinaryString(a));
            System.out.println(Integer.toBinaryString(b));

            int res = a ^ b;

            int add = (a & b) << 1;

            a = res;

            b = add;
        }

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));


        return a;
    }

    public static void test(){



        Timestamp ts = Timestamp.valueOf("2019-07-10 10:39:36.191");


        System.out.println(ts);

        System.out.println(convertFromTZtoToTZ(ts, TimeZone.getDefault(),
                TimeZone.getTimeZone("UTC")));
//        System.out.println(convertFromTZtoToTZ(ts, TimeZone.getDefault(),
//                TimeZone.getTimeZone("GMT-8")));
//        System.out.println(convertFromTZtoToTZ(ts, TimeZone.getDefault(),
//                TimeZone.getDefault()));
//
//        Date d = new Date(ts.getTime());
//
//        System.out.println(ts);
//
//        System.out.println(convertFromTZtoToTZ(d, TimeZone.getDefault(),
//                TimeZone.getTimeZone("UTC")));
//        System.out.println(convertFromTZtoToTZ(d, TimeZone.getDefault(),
//                TimeZone.getTimeZone("GMT-8")));
//        System.out.println(convertFromTZtoToTZ(d, TimeZone.getDefault(),
//                TimeZone.getDefault()));

    }


    public NestedInteger deserialize(String s) {

        char[] cs = s.toCharArray();

        Stack<NestedInteger> stack = new Stack<>();

        int value = 0;
        int sign = 1;

        NestedInteger cur = new NestedInteger();

        for(int i = 0; i < cs.length; i++){

            if (cs[i] == '-'){
                sign = -1;
            }else if (cs[i] == ','){

                stack.peek().add(cur);
                cur = new NestedInteger();

            } else if (cs[i] == '['){

                stack.push(new NestedInteger());

            } else if( cs[i] == ']') {

                NestedInteger pre = stack.pop();

                if(pre.getList() != null){
                    pre.add(cur);
                    cur = pre;
                }


            }else{

                while(cs[i] >= '0' && cs[i] <= '9'){
                    value = value * 10 + cs[i] - '0';

                }

                cur.setInteger(sign * value);
                sign = 1;
                value = 0;
            }
        }
        return cur;
}

    public static Date convertFromTZtoToTZ(Date date, TimeZone fromTimeZone, TimeZone toTimeZone) {

        // Get a Calendar instance
        Calendar calendar = Calendar.getInstance();

        // Set the calendar's time with the given date
        calendar.setTimeZone(fromTimeZone);
        calendar.setTime(date);

        System.out.println(calendar.getTime());

        // Convert the date from FROMTimeZone to UTC
        calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);


        System.out.println(calendar.getTime());

        // If fromTimeZone is in Day Light Saving Time already, adjust.
        if (fromTimeZone.inDaylightTime(calendar.getTime())) {
            calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() * -1);

            System.out.println(calendar.getTime());
        }

        // Convert the above UTC to TOTimeZone
        calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());

        System.out.println(calendar.getTime());

        // If toTimeZone is in Day Light Saving Time already, adjust.
        if (toTimeZone.inDaylightTime(calendar.getTime())) {

            calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());

            System.out.println(calendar.getTime());
        }

        return calendar.getTime();

    }
}
