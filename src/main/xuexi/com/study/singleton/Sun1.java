package com.study.singleton;




public class Sun1 {
    private static final Sun1 TNSTANCE = new Sun1();
    private int a = 0;
    private Sun1() { //构造方法

    }
    public static synchronized Sun1 getTnstance(){
        return TNSTANCE;
    }
    public  void methodA(){
        a ++;
        System.out.println("a="+a);
    }
    public static void main(String[] args) {
        Sun1 sun = Sun1.getTnstance();
        Sun1 sun2 = Sun1.getTnstance();
        sun.methodA();
        sun2.methodA();


    }

}
