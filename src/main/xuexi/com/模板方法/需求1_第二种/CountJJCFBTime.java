package com.模板方法.需求1_第二种;

public class CountJJCFBTime extends CountProjectTimeTemplate{
    @Override
    public void code() {
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+"*"+i+"="+(j*i)+" ");
            }
            System.out.println("    ");
        }
    }
}
