package changyonglei;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Datelei {
    public static void main(String[] args) throws Exception{
        //import java.util.Date;日期类
        //import java.text.SimpleDateFormat; 日期转换类
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       //日期转String
        String sdate = simpleDateFormat.format(date);
        System.out.println(sdate);
        //String 转日期
        Date idate = simpleDateFormat.parse(sdate);
        System.out.println(idate);


    }
}
