package com.模板方法.需求1_第二种;

public abstract class CountProjectTimeTemplate {
    public void countProjectTimeMethod()  {
        //时间作差
        Long start = System.currentTimeMillis();

        this.code();

        Long end = System.currentTimeMillis();
        System.out.println("运行时间为"+(end-start));
    }
    public abstract void code();
}
