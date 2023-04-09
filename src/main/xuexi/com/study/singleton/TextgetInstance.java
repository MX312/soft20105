package com.study.singleton;

public class TextgetInstance {
    public static void main(String[] args) {
//        Boss boss1 = Boss.getInstance();
//        Boss boss2 = Boss.getInstance();
//        System.out.println(boss1);
//        System.out.println(boss2);


        Boss2 boss2_1 = Boss2.getInstance();

        Boss2 boss2_2 = Boss2.getInstance();
        System.out.println(boss2_1);
        System.out.println(boss2_2);



    }
}
