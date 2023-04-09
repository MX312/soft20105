package changyonglei;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Datelei {
    public static void main(String[] args) throws Exception{
        //import java.util.Date;日期类 通常用于日期类的计算 Date中华存储的是距离一个历史节点(1970年)的毫秒数
        //import java.text.SimpleDateFormat; 日期转换类
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       //日期转String
        String sdate = simpleDateFormat.format(date);
        System.out.println(sdate);
        //String 转日期
        Date idate = simpleDateFormat.parse(sdate);
        System.out.println(idate);

        //计算日期
        long time = date.getTime();
        long date2 =(time+(12L*24*60*60*1000));
        System.out.println("今天是"+simpleDateFormat.format(time));
        String formatdate = simpleDateFormat.format(date2);
        System.out.println(formatdate);

    }
}
