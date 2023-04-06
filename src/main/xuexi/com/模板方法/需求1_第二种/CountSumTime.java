package com.模板方法.需求1_第二种;

public class CountSumTime extends CountProjectTimeTemplate{
    @Override
    public void code() {
        int sum = 0;
        for (int i = 0; i <=1000000; i++) {
            sum += i;
        }
        System.out.println( sum);
    }
}
