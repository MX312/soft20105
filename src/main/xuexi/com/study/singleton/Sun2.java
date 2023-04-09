package com.study.singleton;

public class Sun2 {
    private static  Sun2 sun;
    private Sun2() {

    }
    public static Sun2 getInstance() {
        if (sun == null) {
            sun = new Sun2();
        }
        return sun;
    }

    public static void main(String[] args) {
        Sun2 sun = Sun2.getInstance();
        System.out.println(sun);
    }
}
