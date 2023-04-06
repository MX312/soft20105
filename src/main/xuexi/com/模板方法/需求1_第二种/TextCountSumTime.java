package com.模板方法.需求1_第二种;

public class TextCountSumTime {
    public static void main(String[] args) {
        CountProjectTimeTemplate countProjectTimeTemplate = new CountSumTime();
        countProjectTimeTemplate.countProjectTimeMethod();

        CountProjectTimeTemplate countProjectTimeTemplate1 = new CountJJCFBTime();
        countProjectTimeTemplate1.countProjectTimeMethod();
    }
}
