package com.模板方法.需求1_第一种;

public class CountProjectTime {
    //统计代码执行的时间
    public void countProjectTimeMethod() {
        //时间作差
        Double start = Double.valueOf(System.currentTimeMillis());

        code();

        Double end = Double.valueOf(System.currentTimeMillis());
        System.out.println("运行时间为"+(end-start));
    }
    public void code() {
        //累加和
        int sum = 0;
        for (int i = 0; i <=100; i++) {
            sum += i;
        }
        System.out.println( sum);
    }

}
